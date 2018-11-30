package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Diagnosis;
import pl.coderslab.entities.Patient;
import pl.coderslab.entities.Prescription;

import java.util.List;


public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

}
