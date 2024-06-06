package francescocossu.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;


@Entity
@DiscriminatorValue("GaraDiAtletica")
public class GaraDiAtletica extends Evento {
    @OneToMany
    @JoinColumn(name = "gara_id")
    private Set<Persona> atleti;
    @OneToOne
    private Persona atletaVincente;


    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, long numeroMassimoPartecipanti, TipoEvento tipoEvento, Location location, Set<Persona> atleti, Persona atletaVincente) {
        super(titolo, dataEvento, descrizione, numeroMassimoPartecipanti, tipoEvento, location);
        this.atleti = atleti;
        this.atletaVincente = atletaVincente;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getAtletaVincente() {
        return atletaVincente;
    }

    public void setAtletaVincente(Persona atletaVincente) {
        this.atletaVincente = atletaVincente;
    }
}
