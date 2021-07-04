package com.springexp.main;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements UserDetailsService {

    @Autowired
    private PatientRepository repository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Patient> o = Optional.of(this.repository.findByusername(username));

        if(!o.isPresent()){
            throw new UsernameNotFoundException("The patient does not exists!");
        }

        return new PatientDetails(o.get());
    }

    public void registerPatient(Patient patient){
        patient.setPassword(encoder.encode(patient.getPassword()));
        this.repository.save(patient);
    }
   
    
}
