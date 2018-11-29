package pl.coderslab.services;

import pl.coderslab.entities.Doctor;

import java.util.List;

public interface DoctorService {

    void save(Doctor doctor);

    void update(Doctor doctor);

    Doctor find(Long id);

    Doctor findWithOthers(Long id);

    Doctor findByEmail(String email);

    void delete(Long id);

    List<Doctor> findAll();
}
