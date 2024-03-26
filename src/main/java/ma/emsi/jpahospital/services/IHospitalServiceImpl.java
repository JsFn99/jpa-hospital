package ma.emsi.jpahospital.services;

import jakarta.transaction.Transactional;
import ma.emsi.jpahospital.entities.Consultation;
import ma.emsi.jpahospital.entities.Medecin;
import ma.emsi.jpahospital.entities.Patient;
import ma.emsi.jpahospital.entities.Rendezvous;
import ma.emsi.jpahospital.repositories.ConsultationRepository;
import ma.emsi.jpahospital.repositories.MedecinRepository;
import ma.emsi.jpahospital.repositories.PatientRepository;
import ma.emsi.jpahospital.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezvousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezvousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezvousRepository = rendezvousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Rendezvous saveRendezvous(Rendezvous rendezvous) {
        return rendezvousRepository.save(rendezvous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
