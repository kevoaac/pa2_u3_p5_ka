package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaService {
    Factura buscarPorNumero(String numero);

    void guardar(Factura factura);
}
