package com.uce.edu.ventas.repository;

import com.uce.edu.ventas.repository.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Cliente cliente) {
        this.entityManager.persist(cliente);
    }
}
