package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entities.Doctor;
import pl.coderslab.repositories.DoctorRepository;

import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor find(Long id) {
        return doctorRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.delete(id);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
