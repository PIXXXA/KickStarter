package com.gmail.itchyscratchy159.repositories;

import com.gmail.itchyscratchy159.entities.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    Company findByDescription(String description);

}
