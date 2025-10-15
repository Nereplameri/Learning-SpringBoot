package com.alperenavci.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenavci.dto.DtoHome;
import com.alperenavci.dto.DtoRoom;
import com.alperenavci.entites.Home;
import com.alperenavci.entites.Room;
import com.alperenavci.repository.HomeRepository;
import com.alperenavci.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService{
	
	@Autowired
	private HomeRepository homeRepository;

	@Override
	public DtoHome findHomeById(Long id) {
		Optional<Home> optional = homeRepository.findById(id);
		DtoHome dtoHome = new DtoHome();
		List<DtoRoom> listDtoRoom = new ArrayList<>();
		
		// DB 'den boş gelirse kontrol
		if(optional.isEmpty()) {
			return null;
		}
		
		// Database -> Entity açılımı 
		Home dbHome = optional.get();
		List<Room> dbRoom = dbHome.getRoom();
		
		// home.getRoom(): List<Room> döner.
		// dtoHome.rooms: List<DtoRoom> tutar.
		// -----------------Çıkarım:
		// Listedeki her elemanı DtoRoom 'a -
		// çevirip List<DtoRoom> 'a atıyoruz
		for (Room iroom : dbRoom) {
			DtoRoom dtoRoom = new DtoRoom();
			
			BeanUtils.copyProperties(iroom, dtoRoom);
			listDtoRoom.add(dtoRoom);
		}
		
		// home 'yi dtoHome 'ye çeviriyoruz.
		// dtoHome 'nin List<DtoHome> 'sini el ile atıyoruz.
		BeanUtils.copyProperties(dbHome, dtoHome);
		dtoHome.setRooms(listDtoRoom);
		
		return dtoHome; // return DtoHome
	}
}