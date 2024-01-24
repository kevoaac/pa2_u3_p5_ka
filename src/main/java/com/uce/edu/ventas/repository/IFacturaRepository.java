package com.uce.edu.ventas.repository;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaRepository {
    Factura seleccionarPorNumero(String numero);

    void insertar(Factura factura);
}
