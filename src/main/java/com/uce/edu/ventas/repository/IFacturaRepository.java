package com.uce.edu.ventas.repository;

import com.uce.edu.ventas.repository.modelo.Factura;

import java.util.List;

public interface IFacturaRepository {
    Factura seleccionarPorNumero(String numero);

    void insertar(Factura factura);

    List<Factura> seleccionarFacturasInnerJoin();

    List<Factura> seleccionarFacturasRightJoin();

    List<Factura> seleccionarFacturasLeftJoin();

    List<Factura> seleccionarFacturasFullJoin();


}
