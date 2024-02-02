package com.uce.edu.veterinaria.repository;

import com.uce.edu.veterinaria.repository.modelo.Mascota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MascotaRepositoryImpl implements IMascotaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Mascota seleccionarPorTelefonoPlaca(String telefonoPlaca) {
        TypedQuery<Mascota> myQuery = this.entityManager.createQuery("SELECT m FROM Mascota m WHERE telefonoPlaca = :telefonoPlaca", Mascota.class);
        myQuery.setParameter("telefonoPlaca", telefonoPlaca);

        return myQuery.getSingleResult();
    }
}
