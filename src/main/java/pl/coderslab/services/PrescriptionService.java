package pl.coderslab.services;

import pl.coderslab.entities.Diagnosis;
import pl.coderslab.entities.Prescription;

import java.util.List;

public interface PrescriptionService {


    void save(Prescription prescription);

    void update(Prescription prescription);

    Prescription find(Long id);

    void delete(Long id);

    List<Prescription> findAll();
}
