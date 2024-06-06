package francescocossu.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("PartitaDiCalcio")
public class PartitaDiCalcio extends Evento {
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int golSquadraCasa;
    private int golSquadraOspite;


    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, long numeroMassimoPartecipanti, TipoEvento tipoEvento, Location location, String squadraDiCasa, String squadraOspite, int golSquadraCasa, int golSquadraOspite) {
        super(titolo, dataEvento, descrizione, numeroMassimoPartecipanti, tipoEvento, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = determinaSquadraVincente();
        this.golSquadraCasa = golSquadraCasa;
        this.golSquadraOspite = golSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    @org.jetbrains.annotations.Nullable
    @org.jetbrains.annotations.Contract(pure = true)
    private String determinaSquadraVincente() {
        if (golSquadraCasa > golSquadraOspite) {
            return squadraDiCasa;
        } else if (golSquadraCasa < golSquadraOspite) {
            return squadraOspite;
        } else {
            return null;
        }
    }
}
