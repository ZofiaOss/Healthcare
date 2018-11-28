package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entities.Patient;
import pl.coderslab.services.PatientService;

public class PatientConverter implements Converter<String, Patient> {

    @Autowired
    private PatientService patientService;

    @Override
    public Patient convert(String s) {
        Long id = Long.parseLong(s);
        return patientService.find(id);
    }
}