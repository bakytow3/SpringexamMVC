package com.peaksoft.api;


import com.peaksoft.model.Company;
import com.peaksoft.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CompanyController {
private final CompanyService companyService;
@Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping("/allCompanies")
    private String getCompanies(Model model){
        List<Company>companyList=companyService.getAllCompany();
        model.addAttribute("companies",companyList);
        return "/company";
    }
    @GetMapping("/addCompany")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
        return "/addCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.addCompany(company);
        return "redirect:/allCompanies";
    }

    @GetMapping("updateCompany")
    public String updateCompany(@RequestParam("companyId") Long id, Model model) {
        Company company = companyService.getByIdCompany(id);
        model.addAttribute("company", company);
        return "/updateCompany";
    }

    @PostMapping("/saveUpdateCompany")
    public String saveUpdateCompany(@ModelAttribute("company") Company company) {
        companyService.updateCompany(company);
        return "redirect:/allCompanies";
    }

    @RequestMapping("/deleteCompany")
    public String deleteCompany(@RequestParam("companyId") Long id,Model model) {
       companyService.deleteByIdCompany(id);
        return "redirect:/allCompanies";
    }
}
