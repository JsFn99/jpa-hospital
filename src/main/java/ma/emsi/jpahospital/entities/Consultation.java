package ma.emsi.jpahospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Consultation {
    // Attributes
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateConsultation;
    private String motif;
    private String diagnostic;
    private String traitement;
    @OneToOne
    private Rendezvous rendezvous;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
