package com.springexp.main;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {

    Patient findByusername(String username);
    
}
