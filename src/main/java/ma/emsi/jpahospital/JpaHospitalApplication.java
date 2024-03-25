package ma.emsi.jpahospital;

import ma.emsi.jpahospital.entities.*;
import ma.emsi.jpahospital.repositories.MedecinRepository;
import ma.emsi.jpahospital.repositories.PatientRepository;
import ma.emsi.jpahospital.repositories.RendezVousRepository;
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
	CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository) {
		return args -> {
			Stream.of("Anas", "Brahim", "kamal").forEach(prenom -> {
				Patient patient = new Patient();
				patient.setNom("BENKIRANE");
				patient.setPrenom(prenom);
				patient.setDateNaissance(new Date());
				patient.setSexe("M");
				patient.setMalade(true);
				patientRepository.save(patient);
				patientRepository.findAll().forEach(p -> {System.out.println(p.getNom());});
			});
			Stream.of("Said", "Hajar", "Sara").forEach(prenom -> {
				Medecin medecin = new Medecin();
				medecin.setNom("Tazi");
				medecin.setPrenom(prenom);
				medecin.setSpecialite(Math.random()>0.5?"Neurologue":"Dentiste");
				medecin.setEmail(prenom+"@gmail.com");
				medecinRepository.save(medecin);
				medecinRepository.findAll().forEach(m -> {System.out.println(m.getNom());});
			});
			Patient patient=patientRepository.findById(1L).orElse(null);
			Patient patient1=patientRepository.findPatientByNom("Anas");

			Medecin medecin = medecinRepository.findById(1L).orElse(null);
			Medecin medecin1=medecinRepository.findMedecinByNom("Said");

			Rendezvous rendezvous = new Rendezvous();
			rendezvous.setDate(new Date().toString());
			rendezvous.setHeure("10:00");
			rendezvous.setPatient(patient);
			rendezvous.setMedecin(medecin);
			rendezvous.setStatus(StatusRDV.CONFIRMED);
			rendezVousRepository.save(rendezvous);

			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date().toString());
		};
}
}
