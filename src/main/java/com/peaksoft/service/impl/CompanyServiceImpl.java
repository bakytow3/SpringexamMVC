package com.peaksoft.service.impl;

import com.peaksoft.model.Company;
import com.peaksoft.repository.CompanyRepository;
import com.peaksoft.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }



//    @Override
//    public void saveCompany(Company company) {
//companyRepository.saveCompany(company);
//    }

    @Override
    public void updateCompany(Company company) {
companyRepository.updateCompany(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.getAllCompany();
    }

    @Override
    public Company getByIdCompany(Long id) {
        return companyRepository.getByIdCompany(id);
    }

    @Override
    public void deleteByIdCompany(Long id) {
companyRepository.deleteByIdCompany(id);
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.addCompany(company);
    }
}
