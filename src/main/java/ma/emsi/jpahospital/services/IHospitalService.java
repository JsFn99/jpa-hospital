package ma.emsi.jpahospital.services;

import ma.emsi.jpahospital.entities.Consultation;
import ma.emsi.jpahospital.entities.Medecin;
import ma.emsi.jpahospital.entities.Patient;
import ma.emsi.jpahospital.entities.Rendezvous;

public interface IHospitalService {
    public Patient savePatient(Patient patient);
    public Medecin saveMedecin(Medecin medecin);
    public Rendezvous saveRendezvous(Rendezvous rendezvous);
    public Consultation saveConsultation(Consultation consultation);
}
