package com.gmail.itchyscratchy159.services;

import com.gmail.itchyscratchy159.entities.Company;
import com.gmail.itchyscratchy159.entities.User;
import com.gmail.itchyscratchy159.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Value("${upload.path}")
    private String uploadPath;

    public void addCompany(User user, String name, String description, Integer coast, MultipartFile file, Model model) throws IOException {
        Company company = new Company ( name, description, coast, user );

        if ( file != null && ! file.getOriginalFilename ( ).isEmpty ( ) ) {
            File uploadDir = new File ( uploadPath );
            if ( ! uploadDir.exists ( ) ) {
                uploadDir.mkdir ( );
            }
            String uuidFile = UUID.randomUUID ( ).toString ( );
            String resultFilename = uuidFile + "." + file.getOriginalFilename ( );
            file.transferTo ( new File ( uploadPath + "/" + resultFilename ) );
            company.setFilename ( resultFilename );
        }

        companyRepository.save ( company );
        Iterable<Company> companies = companyRepository.findByDescription ( description );
        model.addAttribute ( "companies", companies );
    }
}
