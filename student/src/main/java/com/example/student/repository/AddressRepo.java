package com.example.student.repository;

import com.example.student.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This repository interface extends JpaRepository for managing Address entities.
// It provides data access methods to perform CRUD (Create, Read, Update, Delete) operations on Address objects in the database.
@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
}
