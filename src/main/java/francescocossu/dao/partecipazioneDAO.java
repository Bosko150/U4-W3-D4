package francescocossu.dao;

import francescocossu.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class partecipazioneDAO {

    private EntityManager em;

    public partecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("partecipazione salvata correttamente");
    }

    public Partecipazione getById(String id) {
        return em.find(Partecipazione.class, UUID.fromString(id));
    }

    public void findAndDeleteById(String id) {
        Partecipazione locationTrovata = getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(locationTrovata);
        transaction.commit();
        System.out.println("partecipazione con id " + id + " eliminata correttamente");
    }
}
