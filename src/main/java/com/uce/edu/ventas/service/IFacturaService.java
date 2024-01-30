package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.modelo.Factura;

import java.util.List;

public interface IFacturaService {
    Factura buscarPorNumero(String numero);

    void guardar(Factura factura);

    List<Factura> buscarFacturasInnerJoin();

    List<Factura> buscarFacturasRightJoin();

    List<Factura> buscarFacturasLeftJoin();

    List<Factura> buscarFacturasFullJoin();

    List<Factura> buscarFacturasWhereJoin();

    List<Factura> buscarFacturasFetchJoin();

}
