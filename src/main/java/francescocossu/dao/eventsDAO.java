package francescocossu.dao;

import francescocossu.entities.Evento;
import francescocossu.entities.Genere;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class eventsDAO {

    private final EntityManager em;

    public eventsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(evento);

        transaction.commit();

    }

    public Evento getById(String id) {
        return em.find(Evento.class, UUID.fromString(id));
    }

    public void delete(long id) {
        Evento found = getById(String.valueOf(id));
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
    }

    public List<Evento> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE e.inStreaming = :inStreaming", Evento.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Evento> getConcertiPerGenere(Genere genere) {
        TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE e.genere = :genere", Evento.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<Evento> getPartiteVinteInCasa() {
        TypedQuery<Evento> query = em.createNamedQuery("getPartiteVinteInCasa", Evento.class);
        return query.getResultList();
    }

    public List<Evento> getPartiteVinteInTrasferta() {
        TypedQuery<Evento> query = em.createNamedQuery("getPartiteVinteInTrasferta", Evento.class);
        return query.getResultList();
    }
}
