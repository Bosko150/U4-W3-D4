package francescocossu.dao;

import francescocossu.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class personaDAO {
    private EntityManager em;

    public personaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("persona salvata correttamente");
    }

    public Persona getById(String id) {
        return em.find(Persona.class, UUID.fromString(id));
    }

    public void findAndDeleteById(String id) {
        Persona locationTrovata = getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(locationTrovata);
        transaction.commit();
        System.out.println("Location con id " + id + " eliminata correttamente");
    }
}
