package francescocossu.entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "città")
    private String città;


    @Column(name = "eventi")
    @OneToMany(mappedBy = "location")
    private List<Evento> listaEventi;

    public Location() {
    }

    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;
    }

    public UUID getId() {
        return id;
    }

    public List<Evento> getListaEventi() {
        return listaEventi;
    }

    public void setListaEventi(List<Evento> listaEventi) {
        this.listaEventi = listaEventi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                '}';
    }

}
