package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.repository.modelo.Factura;

import java.time.LocalDateTime;
import java.util.List;

public interface IFacturaService {
    Factura buscarPorNumero(String numero);

    void guardar(Factura factura, Cliente cliente);
    void prueba();
    void pruebaSupport();
    void pruebaNever();

    void actualizar(Factura factura);

    int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);

    void borrar(Integer id);

    int borrarPorNumero(String numero);

    List<Factura> buscarFacturasInnerJoin();

    List<Factura> buscarFacturasRightJoin();

    List<Factura> buscarFacturasLeftJoin();

    List<Factura> buscarFacturasFullJoin();

    List<Factura> buscarFacturasWhereJoin();

    List<Factura> buscarFacturasFetchJoin();

    // DTO
    List<FacturaDTO> buscarFacturasDTO();

}
