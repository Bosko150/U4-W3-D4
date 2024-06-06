package francescocossu.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")


@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT e FROM Evento e WHERE e.squadraVincente = e.squadraCasa")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT e FROM Evento e WHERE e.squadraVincente = e.squadraOspite")
public class Evento {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "numero_massimo_partecipanti")
    private long numeroMassimoPartecipanti;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @Column(name = "partecipazioni")
    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> listaPartecipazioni;


    public Evento() {
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, long numeroMassimoPartecipanti, TipoEvento tipoEvento, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.tipoEvento = tipoEvento;
        this.location = location;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public long getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(long numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", tipoEvento=" + tipoEvento +
                ", location=" + location +
                ", listaPartecipazioni=" + listaPartecipazioni +
                '}';
    }
}


