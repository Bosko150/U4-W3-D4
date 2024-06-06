package francescocossu.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Partecipazione {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "eventi_id")
    private Evento evento;
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @Enumerated(EnumType.STRING)
    private Stato stato;


    public Partecipazione() {
    }

    public Partecipazione(Evento evento, Persona persona, Stato stato) {
        this.evento = evento;
        this.persona = persona;
        this.stato = stato;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public UUID getId() {
        return id;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}
