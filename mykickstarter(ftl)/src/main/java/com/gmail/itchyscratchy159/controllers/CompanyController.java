package com.gmail.itchyscratchy159.controllers;

import com.gmail.itchyscratchy159.entities.Company;
import com.gmail.itchyscratchy159.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;



    @GetMapping("/startup")
    public String main() {
        return "startup";
    }

    @PostMapping("/startup")
    public String add(
            @RequestParam (required = false) Integer coast,
            @RequestParam (required = false) String description,
            @RequestParam (required = false) String name,

            Model model)  {

        Company company = new Company( name, description,coast);

        companyRepository.save(company);

        company = companyRepository.findByDescription(description);

        model.addAttribute("company", company);

        return "startup";
    }

}
