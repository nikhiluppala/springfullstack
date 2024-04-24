package com.springfullstack.FirstJobApp.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companySerive;
	
	@GetMapping
	public ResponseEntity<List<Company>> getCompanies(){
		return new ResponseEntity<>(companySerive.getAllCompanies(),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public  ResponseEntity<String> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
		//TODO: process PUT request
		boolean updated = companySerive.updateCompany(id, company);
		if(updated) return ResponseEntity.ok("Company updated successfully");
		
		return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);	
	}
	
	@PostMapping
	public  ResponseEntity<String> createCompany(@RequestBody Company company) {
		companySerive.createCompany(company);
		
		return new ResponseEntity<>("Company created successfully",HttpStatus.OK);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id){
		boolean deleted = companySerive.deleteCompany(id);
		if(deleted) return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
		
		return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
	}
	
}
