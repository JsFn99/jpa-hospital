package ma.emsi.jpahospital.repositories;
import ma.emsi.jpahospital.entities.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<Rendezvous, Long> {
}
