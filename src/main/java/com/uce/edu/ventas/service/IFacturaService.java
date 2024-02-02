package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IFacturaService {
    Factura buscarPorNumero(String numero);

    void guardar(Factura factura);

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
