package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
