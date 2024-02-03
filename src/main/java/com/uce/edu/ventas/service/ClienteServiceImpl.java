package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED) // T2  REQUIRES_NEW Forma parte de otra transacción
    public void guardar(Cliente cliente) {
        try {
            this.iClienteRepository.insertar(cliente);
        } catch (Exception e) {

        }
    }
}
