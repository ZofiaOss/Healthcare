package pl.coderslab.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DIAGNOSES")
public class Diagnosis {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1000)
    private String name;

    @ManyToOne
    private Patient patient;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
