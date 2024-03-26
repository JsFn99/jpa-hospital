package ma.emsi.jpahospital.web;

import ma.emsi.jpahospital.entities.Patient;
import ma.emsi.jpahospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/listPatients")
    public List<Patient> listPatients() {
        return patientRepository.findAll();
    }
}
