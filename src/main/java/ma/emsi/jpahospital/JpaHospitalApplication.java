package ma.emsi.jpahospital;

import ma.emsi.jpahospital.entities.Patient;
import ma.emsi.jpahospital.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository) {
		return args -> {
			Stream.of("Anas", "Brahim", "kamal").forEach(prenom -> {
				Patient patient = new Patient();
				patient.setNom("BENKIRANE");
				patient.setPrenom(prenom);
				patient.setDateNaissance(new Date());
				patient.setSexe("M");
				patient.setMalade(true);
				patientRepository.save(patient);
				patientRepository.findAll().forEach(p -> {
					System.out.println(p.getNom());
			});
			});
};
}
}
