package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Diagnosis;


public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
