package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Diagnosis;
import pl.coderslab.entities.Patient;

import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByEmail(String email);

}
