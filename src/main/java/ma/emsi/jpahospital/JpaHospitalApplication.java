package ma.emsi.jpahospital;

import ma.emsi.jpahospital.entities.*;
import ma.emsi.jpahospital.repositories.ConsultationRepository;
import ma.emsi.jpahospital.repositories.MedecinRepository;
import ma.emsi.jpahospital.repositories.PatientRepository;
import ma.emsi.jpahospital.repositories.RendezVousRepository;
import ma.emsi.jpahospital.services.IHospitalService;
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
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository) {
		return args -> {
			Stream.of("Anas", "Brahim", "kamal").forEach(prenom -> {
				Patient patient = new Patient();
				patient.setNom("BENKIRANE");
				patient.setPrenom(prenom);
				patient.setDateNaissance(new Date());
				patient.setSexe("M");
				patient.setMalade(true);
				hospitalService.savePatient(patient);
			});
			Stream.of("Said", "Hajar", "Sara").forEach(prenom -> {
				Medecin medecin = new Medecin();
				medecin.setNom("Tazi");
				medecin.setPrenom(prenom);
				medecin.setSpecialite(Math.random()>0.5?"Neurologue":"Dentiste");
				medecin.setEmail(prenom+"@gmail.com");
				hospitalService.saveMedecin(medecin);
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

			Rendezvous rendezvous1 = rendezVousRepository.findById(1L).orElse(null);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date().toString());
			consultation.setMotif("Consultation de routine");
			consultation.setDiagnostic("RAS");
			consultation.setTraitement("Doliprane");
			consultation.setRendezvous(rendezvous1);
			hospitalService.saveConsultation(consultation);
		};
}
}
