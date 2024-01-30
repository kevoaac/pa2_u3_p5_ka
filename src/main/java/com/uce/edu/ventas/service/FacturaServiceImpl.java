package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Factura> buscarFacturasInnerJoin() {
        return this.iFacturaRepository.seleccionarFacturasInnerJoin();
    }

    @Override
    public List<Factura> buscarFacturasRightJoin() {
        return this.iFacturaRepository.seleccionarFacturasRightJoin();
    }

    @Override
    public List<Factura> buscarFacturasLeftJoin() {
        return this.iFacturaRepository.seleccionarFacturasLeftJoin();
    }

    @Override
    public List<Factura> buscarFacturasFullJoin() {
        return this.iFacturaRepository.seleccionarFacturasFullJoin();
    }

    @Override
    public List<Factura> buscarFacturasWhereJoin() {
        return this.iFacturaRepository.seleccionarFacturasWhereJoin();
    }

    @Override
    public List<Factura> buscarFacturasFetchJoin() {
        return this.iFacturaRepository.seleccionarFacturasFetchJoin();
    }
}
