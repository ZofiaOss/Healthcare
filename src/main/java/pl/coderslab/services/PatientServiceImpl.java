package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entities.Patient;
import pl.coderslab.repositories.PatientRepository;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void update(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient find(Long id) {
        return patientRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        patientRepository.delete(id);

    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
