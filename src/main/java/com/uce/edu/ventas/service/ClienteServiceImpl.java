package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW) // T2  REQUIRES_NEW Forma parte de otra transacción
    // begin
    public void guardar(Cliente cliente) {
        // El método anterior no se debe enterar que este método tiene errores (en el caso de que esta transacción falle)

//        try {// Para que no afecte a la transacción anterior debemos tratar posibles erorr aquí
        this.iClienteRepository.insertar(cliente);
//        } catch (RuntimeException e) {
//        System.out.println("Error");
//        }
    }// commit // Aqui da el error cuando lanza la excepción

}
