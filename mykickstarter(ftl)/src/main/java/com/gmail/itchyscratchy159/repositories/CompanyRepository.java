package com.gmail.itchyscratchy159.repositories;

import com.gmail.itchyscratchy159.entities.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    List<Company> findByDescription(String description);
}
