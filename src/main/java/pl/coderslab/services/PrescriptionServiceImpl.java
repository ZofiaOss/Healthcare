package pl.coderslab.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entities.Patient;
import pl.coderslab.entities.Prescription;
import pl.coderslab.repositories.PrescriptionRepository;

import java.util.List;

@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public void save(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    @Override
    public void update(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription find(Long id) {
        return prescriptionRepository.getOne(id);
    }

    @Override
    public Prescription findWithOthers(Long id) {
        Prescription prescription = find(id);
        Hibernate.initialize(prescription.getPatient());
        Hibernate.initialize(prescription.getDoctor());
        return prescription;
    }

    @Override
    public void delete(Long id) {
        prescriptionRepository.delete(id);

    }

    @Override
    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

    @Override
    public List<Prescription> findByPatient(Patient patient) {
        return prescriptionRepository.findByPatient(patient);
    }
}
