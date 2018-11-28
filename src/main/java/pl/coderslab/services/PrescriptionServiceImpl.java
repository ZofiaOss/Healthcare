package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public void delete(Long id) {
        prescriptionRepository.delete(id);

    }

    @Override
    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }
}
