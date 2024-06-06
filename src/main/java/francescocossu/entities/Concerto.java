package francescocossu.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;


@Entity
@DiscriminatorValue("Concerto")
public class Concerto extends Evento {
    @Enumerated(EnumType.STRING)
    private Genere genere;
    private boolean inStreaming;


    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, long numeroMassimoPartecipanti, TipoEvento tipoEvento, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, numeroMassimoPartecipanti, tipoEvento, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
