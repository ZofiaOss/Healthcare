package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
