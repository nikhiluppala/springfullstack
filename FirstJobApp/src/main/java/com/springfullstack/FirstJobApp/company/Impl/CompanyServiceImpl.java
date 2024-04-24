package com.springfullstack.FirstJobApp.company.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springfullstack.FirstJobApp.company.Company;
import com.springfullstack.FirstJobApp.company.CompanyRepo;
import com.springfullstack.FirstJobApp.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepo companyRepo;
	
	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepo.findAll();
	}

	@Override
	public boolean updateCompany(Long id,Company company) {
		Optional<Company> companyOptinal = companyRepo.findById(id);
		if(companyOptinal.isPresent()) {
			Company updatedCompany = companyOptinal.get();
			updatedCompany.setDescription(company.getDescription());
			updatedCompany.setCompanyName(company.getCompanyName());
			updatedCompany.setJobs(company.getJobs());
			companyRepo.save(updatedCompany);
			return true;
		}
		return false;
	}

	@Override
	public void createCompany(Company company) {
		companyRepo.save(company);
		
	}

	@Override
	public boolean deleteCompany(Long id) {
		if(companyRepo.existsById(id)) {
			companyRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Company getCompanyById(Long id) {
		
		if(companyRepo.existsById(id)) {
			return companyRepo.findById(id).get();
			
		}
		return null;
	}

}
