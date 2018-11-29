package pl.coderslab.services;

import pl.coderslab.entities.Patient;

import java.util.List;

public interface PatientService {

    void save(Patient patient);

    void update(Patient patient);

    Patient find(Long id);

    Patient findWithOthers(Long id);

    Patient findByEmail(String email);

    void delete(Long id);

    List<Patient> findAll();
}
