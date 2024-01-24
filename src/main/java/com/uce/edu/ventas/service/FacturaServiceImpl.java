package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements IFacturaService {
    @Autowired
    private IFacturaRepository iFacturaRepository;

    @Override
    public Factura buscarPorNumero(String numero) {
        return this.iFacturaRepository.seleccionarPorNumero(numero);
    }

    @Override
    public void guardar(Factura factura) {
        this.iFacturaRepository.insertar(factura);
    }
}
