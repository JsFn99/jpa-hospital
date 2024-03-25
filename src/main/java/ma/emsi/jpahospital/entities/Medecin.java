package ma.emsi.jpahospital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Medecin {
    // Attributes
    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String specialite;
    private String email;
    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
    private Collection<Rendezvous> rendezvous;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
