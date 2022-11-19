package com.peaksoft.repository.impl;

import com.peaksoft.model.Company;
import com.peaksoft.repository.CompanyRepository;
import com.peaksoft.model.Company;
import com.peaksoft.repository.CompanyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CompanyImpl implements CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public void saveCompany(Company company) {
//        entityManager.persist(company);
//        System.out.println("Company save successfully " + company);
//    }

    @Override
    public void updateCompany(Company company) {
        entityManager.merge(company);
        System.out.println("Company update successfully " + company);

    }

    @Override
    public List<Company> getAllCompany() {
        return entityManager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public Company getByIdCompany(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void deleteByIdCompany(Long id) {
        entityManager.remove(entityManager.find(Company.class, id));
    }

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);
    }
}

