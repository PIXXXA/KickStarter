package com.gmail.itchyscratchy159.controllers;

import com.gmail.itchyscratchy159.entities.User;
import com.gmail.itchyscratchy159.repositories.CompanyRepository;
import com.gmail.itchyscratchy159.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/startup")
    public String main() {
        return "startup";
    }

    @PostMapping("/startup")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false) Integer coast,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String name,
            @RequestParam("file") MultipartFile file,
            Model model) throws IOException {

        companyService.addCompany ( user, name, description, coast, file, model );
        return "startup";
    }
}