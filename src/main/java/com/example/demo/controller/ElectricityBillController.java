package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/elec")
public class ElectricityBillController {
	
	@Autowired
	private ElectricityRepo elecrepo;
	
	//get all elecBills
	@GetMapping("")
	public List<ElectricityBill> getAllBills(){
		return elecrepo.findAll();
	}
	
	//create bill rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addbill")
	public ElectricityBill createBill(@RequestBody ElectricityBill bill) {
		return elecrepo.save(bill);
	}
	
	// get bill by id rest api
		@GetMapping("get/{electId}")
		public ResponseEntity<ElectricityBill> getBillById(@PathVariable Long electId) {
			ElectricityBill bill = elecrepo.findById(electId)
					.orElseThrow(() -> new ResourceNotFoundException("Bill does not exist"));
			return ResponseEntity.ok(bill);
		}
		
	//update bill by id rest api
		@PutMapping("/update/{electId}")
		public ResponseEntity<ElectricityBill> updateBill(@PathVariable Long electId, 
				@RequestBody ElectricityBill electricityBill){
			ElectricityBill bill = elecrepo.findById(electId)
					.orElseThrow(() -> new ResourceNotFoundException("Bill does not exist with id :"));
			
			bill.setAmount(electricityBill.getAmount());
			bill.setDescription(electricityBill.getDescription());
			bill.setBilldate(electricityBill.getBilldate());
			
			ElectricityBill updateBill = elecrepo.save(bill);
			return ResponseEntity.ok(updateBill);
		}
		
		// delete bill rest api
		@DeleteMapping("/delete/{electId}")
		public ResponseEntity<Map<String, Boolean>> deleteBill(@PathVariable Long electId){
			ElectricityBill bill = elecrepo.findById(electId)
					.orElseThrow(() -> new ResourceNotFoundException("Bill does not exist"));
			
			elecrepo.delete(bill);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		
		
		
	

}
