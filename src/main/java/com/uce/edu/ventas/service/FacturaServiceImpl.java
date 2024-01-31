package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public void actualizar(Factura factura) {
        this.iFacturaRepository.actualizar(factura);
    }

    @Override
    public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
        return this.iFacturaRepository.actualizarFechas(fechaNueva, fechaActual);
    }

    @Override
    public void borrar(Integer id) {
        this.iFacturaRepository.eliminar(id);
    }

    @Override
    public int borrarPorNumero(String numero) {
        return this.iFacturaRepository.eliminarPorNumero(numero);
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

    @Override
    public List<FacturaDTO> buscarFacturasDTO() {
        return this.iFacturaRepository.seleccionarFacturasDTO();
    }
}
