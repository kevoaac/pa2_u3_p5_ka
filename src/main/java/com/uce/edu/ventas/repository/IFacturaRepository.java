package com.uce.edu.ventas.repository;

import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.repository.modelo.Factura;

import java.time.LocalDateTime;
import java.util.List;

public interface IFacturaRepository {
    Factura seleccionarPorNumero(String numero);

    void insertar(Factura factura);
    List<Factura> seleccionarTodos();

    void actualizar(Factura factura);

    int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);

    void eliminar(Integer id);

    int eliminarPorNumero(String numero);

    List<Factura> seleccionarFacturasInnerJoin();

    List<Factura> seleccionarFacturasRightJoin();

    List<Factura> seleccionarFacturasLeftJoin();

    List<Factura> seleccionarFacturasFullJoin();

    List<Factura> seleccionarFacturasWhereJoin();

    List<Factura> seleccionarFacturasFetchJoin();

    // DTO
    List<FacturaDTO> seleccionarFacturasDTO();


}
