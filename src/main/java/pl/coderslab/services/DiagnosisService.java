package pl.coderslab.services;

import pl.coderslab.entities.Diagnosis;

import java.util.List;

public interface DiagnosisService {

    void save(Diagnosis diagnosis);

    void update(Diagnosis diagnosis);

    Diagnosis find(Long id);

    void delete(Long id);

    List<Diagnosis> findAll();
}
