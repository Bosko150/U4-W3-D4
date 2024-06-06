package francescocossu;

import francescocossu.dao.eventsDAO;
import francescocossu.dao.locationDAO;
import francescocossu.dao.partecipazioneDAO;
import francescocossu.dao.personaDAO;
import francescocossu.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Date;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        eventsDAO sd = new eventsDAO(em);
        locationDAO ld = new locationDAO(em);
        partecipazioneDAO pd = new partecipazioneDAO(em);
        personaDAO pr = new personaDAO(em);

        Location locationFromDB = ld.getById("755139bf-ede5-43e5-ad78-ccf398e7cf7d");
        Location locationFromDB2 = ld.getById("bd1424be-1f84-46a0-bd41-c0637ab9054a");
        Location locationFromDB3 = ld.getById("d13448d9-9d04-42a5-9a13-f68a9e24a942");
        Persona personaFromDB = pr.getById("497ff457-a130-455b-b187-4861efbce24c");
        Evento eventoFromDB = sd.getById("7fc73f46-8c1f-4230-b206-e6fbafd5742b");

        Location location1 = new Location("location 1", "citta 1");
        Location location2 = new Location("location 2", "citta 2");
        Location location3 = new Location("location 3", "citta 3");


        /*ld.save(location1);
        ld.save(location2);
        ld.save(location3);*/

        Persona persona1 = new Persona("nome", "cognome", "email@email.com", Date.valueOf("1995-06-21").toLocalDate(), SessoPersona.M);
        Persona persona2 = new Persona("nome2", "cognome2", "email@email.com", Date.valueOf("1997-06-21").toLocalDate(), SessoPersona.M);
        Persona persona3 = new Persona("nome3", "cognome3", "email@email.com", Date.valueOf("1999-06-21").toLocalDate(), SessoPersona.F);


        /*pr.save(persona1);
        pr.save(persona2);
        pr.save(persona3);*/


        Evento evento1 = new Evento("evento 1", Date.valueOf("2024-06-21").toLocalDate(), "descrizione 1", 500, TipoEvento.PUBBLICO, locationFromDB);
        Evento evento2 = new Evento("evento 2", Date.valueOf("2024-06-22").toLocalDate(), "descrizione 2", 200, TipoEvento.PUBBLICO, locationFromDB2);
        Evento evento3 = new Evento("evento 3", Date.valueOf("2024-06-23").toLocalDate(), "descrizione 3", 100, TipoEvento.PRIVATO, locationFromDB3);


        /*sd.save(evento3);
        sd.save(evento2);
        sd.save(evento1);*/

        Partecipazione partecipazione1 = new Partecipazione(eventoFromDB, personaFromDB, Stato.CONFERMATO);

        //pd.save(partecipazione1);


        Concerto concerto1 = new Concerto("concerto 1", Date.valueOf("2024-06-21").toLocalDate(), "descrizione 1", 500, TipoEvento.PUBBLICO, locationFromDB, Genere.ROCK, false);
        Concerto concerto2 = new Concerto("concerto 2", Date.valueOf("2024-06-22").toLocalDate(), "descrizione 2", 200, TipoEvento.PUBBLICO, locationFromDB2, Genere.CLASSICO, true);
        Concerto concerto3 = new Concerto("concerto 3", Date.valueOf("2024-06-23").toLocalDate(), "descrizione 3", 100, TipoEvento.PRIVATO, locationFromDB3, Genere.POP, true);

        /*sd.save(concerto3);
        sd.save(concerto2);
        sd.save(concerto1);*/


        System.out.println("Concerti in streaming:");
        sd.getConcertiInStreaming(true).forEach(System.out::println);

        System.out.println("Concerti ROCK:");
        sd.getConcertiPerGenere(Genere.ROCK).forEach(System.out::println);


        em.close();
        emf.close();
    }
}
