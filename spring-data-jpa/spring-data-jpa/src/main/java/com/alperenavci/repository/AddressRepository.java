package com.alperenavci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alperenavci.entites.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
}
