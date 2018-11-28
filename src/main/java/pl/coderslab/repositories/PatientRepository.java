package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {
}
