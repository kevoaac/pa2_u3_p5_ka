package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    @Async
    public void guardar(Cliente cliente) {
        System.out.println("Nombre Hilo: " + Thread.currentThread().getName());

        this.iClienteRepository.insertar(cliente);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }// commit // Aqui da el error cuando lanza la excepción

    @Override
    @Transactional(value = Transactional.TxType.SUPPORTS)
    public void pruebaSupports() {
        System.out.println("Este es un ClienteServiceImpl método supports");
        System.out.println("Existe transacción en metodo pruebaSupport() -> " + TransactionSynchronizationManager.isActualTransactionActive());

    }

    @Override
    @Transactional(value = Transactional.TxType.NEVER)
    public void pruebaNever() {
        System.out.println("Este es un ClienteServiceImpl método Never");
        System.out.println("Existe transacción en metodo pruebaSupport() -> " + TransactionSynchronizationManager.isActualTransactionActive());
    }

}
