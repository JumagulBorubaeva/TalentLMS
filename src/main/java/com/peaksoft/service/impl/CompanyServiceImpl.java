package com.peaksoft.service.impl;

import com.peaksoft.dao.CompanyDAO;
import com.peaksoft.entity.Company;
import com.peaksoft.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDAO companyDAO;

    @Autowired
    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    @Override
    public void addCompany(Company company) {
    companyDAO.addCompany(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyDAO.getCompanyById(id);
    }

    @Override
    public void updateCompany(Company company,Long id) {
    companyDAO.updateCompany(company,id);
    }

    @Override
    public void deleteCompany(Company company) {
     companyDAO.deleteCompany(company);
    }
}
