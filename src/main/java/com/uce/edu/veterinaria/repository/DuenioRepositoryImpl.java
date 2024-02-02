package com.uce.edu.veterinaria.repository;

import com.uce.edu.veterinaria.repository.modelo.Duenio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class DuenioRepositoryImpl implements IDuenioRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Duenio> seleccionarDuenioInnerJoin() {
        TypedQuery<Duenio> myQuery = this.entityManager.createQuery("SELECT d FROM Duenio d INNER JOIN d.mascotas", Duenio.class);

        List<Duenio> lista = myQuery.getResultList();
        lista.forEach(duenio -> {
            duenio.getMascotas().size();
        });

        return lista;
    }

    @Override
    public List<Duenio> seleccionarDueniosPorCodigoProvinciaInnerJoin(String codigoProvincia) {
        TypedQuery<Duenio> myQuery = this.entityManager.createQuery("SELECT d FROM Duenio d INNER JOIN d.mascotas WHERE d.cedula LIKE CONCAT(:codigoProvincia, '%')", Duenio.class);
        myQuery.setParameter("codigoProvincia", codigoProvincia);

        List<Duenio> lista = myQuery.getResultList();
        lista.forEach(duenio -> {
            duenio.getMascotas().size();
        });

        return lista;
    }

    @Override
    public List<Duenio> seleccionarDueniosRightJoin() {
        TypedQuery<Duenio> myQuery = this.entityManager.createQuery("SELECT d FROM Duenio d RIGHT JOIN d.mascotas", Duenio.class);

        List<Duenio> lista = myQuery.getResultList();
        lista.forEach(duenio -> {
            duenio.getMascotas().size();
        });

        return lista;
    }

    @Override
    public List<Duenio> seleccionarDueniosPorApellidoRightJoin(String apellido) {
        TypedQuery<Duenio> myQuery = this.entityManager.createQuery("SELECT d FROM Duenio d RIGHT JOIN d.mascotas WHERE d.apellido = :apellido", Duenio.class);
        myQuery.setParameter("apellido", apellido);

        List<Duenio> lista = myQuery.getResultList();
        lista.forEach(duenio -> {
            duenio.getMascotas().size();
        });

        return lista;
    }

    @Override
    public List<Duenio> seleccionarDueniosLeftJoin() {
        TypedQuery<Duenio> myQuery = this.entityManager.createQuery("SELECT d FROM Duenio d LEFT JOIN d.mascotas", Duenio.class);

        List<Duenio> lista = myQuery.getResultList();
        lista.forEach(duenio -> {
            duenio.getMascotas().size();
        });

        return lista;
    }

    @Override
    public List<Duenio> seleccionarDueniosPorTipoDominioCorreoLeftJoin(String dominioCorreo) {
        TypedQuery<Duenio> myQuery = this.entityManager.createQuery("SELECT d FROM Duenio d INNER JOIN d.mascotas WHERE d.email LIKE CONCAT('%', :dominioCorreo)", Duenio.class);
        myQuery.setParameter("dominioCorreo", dominioCorreo);

        List<Duenio> lista = myQuery.getResultList();
        lista.forEach(duenio -> {
            duenio.getMascotas().size();
        });

        return lista;
    }

    @Override
    public List<Duenio> seleccionarDueniosFullJoin() {
        TypedQuery<Duenio> myQuery = this.entityManager.createQuery("SELECT d FROM Duenio d FULL JOIN d.mascotas", Duenio.class);

        List<Duenio> lista = myQuery.getResultList();
        lista.forEach(duenio -> {
            duenio.getMascotas().size();
        });

        return lista;
    }

    @Override
    public List<Duenio> seleccionarDueniosLimitNFullJoin(Integer limiteDeResultados) {
        TypedQuery<Duenio> myQuery = this.entityManager.createQuery("SELECT d FROM Duenio d FULL JOIN d.mascotas ", Duenio.class);

        myQuery.setMaxResults(limiteDeResultados);

        List<Duenio> lista = myQuery.getResultList();
        lista.forEach(duenio -> {
            duenio.getMascotas().size();
        });

        return lista;
    }

    @Override
    public List<Duenio> seleccionarDueniosFetchJoin() {
        TypedQuery<Duenio> myQuery = this.entityManager.createQuery("SELECT d FROM Duenio d JOIN FETCH d.mascotas", Duenio.class);

        List<Duenio> lista = myQuery.getResultList();
        lista.forEach(duenio -> {
            duenio.getMascotas().size();
        });

        return lista;
    }

    @Override
    public List<Duenio> seleccionarDueniosPorCedulaYEspecieMascota(String cedula, String especieMascota) {
        TypedQuery<Duenio> myQuery = this.entityManager.createQuery("SELECT d FROM Duenio d JOIN FETCH d.mascotas m WHERE d.cedula = :cedula AND m.especie = :especieMascota", Duenio.class);
        myQuery.setParameter("cedula", cedula);
        myQuery.setParameter("especieMascota", especieMascota);


        List<Duenio> lista = myQuery.getResultList();
        lista.forEach(duenio -> {
            duenio.getMascotas().size();
        });

        return lista;
    }
}
