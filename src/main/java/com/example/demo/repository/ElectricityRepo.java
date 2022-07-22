package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ElectricityBill;

public interface ElectricityRepo extends JpaRepository<ElectricityBill, Long> {

}
