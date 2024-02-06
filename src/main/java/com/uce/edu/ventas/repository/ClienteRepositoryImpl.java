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
    @Transactional(value = Transactional.TxType.REQUIRED) // T1
    public void insertar(Cliente cliente) {
        System.out.println("Antes de ejecutar en la base");
        this.entityManager.persist(cliente);
        System.out.println("Después de ejecutar en la base");
    }
}
