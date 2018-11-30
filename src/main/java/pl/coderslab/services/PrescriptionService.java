package pl.coderslab.services;

import pl.coderslab.entities.Diagnosis;
import pl.coderslab.entities.Patient;
import pl.coderslab.entities.Prescription;

import java.util.List;

public interface PrescriptionService {


    void save(Prescription prescription);

    void update(Prescription prescription);

    Prescription find(Long id);

    Prescription findWithOthers(Long id);

    void delete(Long id);

    List<Prescription> findAll();

    List<Prescription> findByPatient(Patient patient);
}
