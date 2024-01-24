package com.uce.edu.ventas.repository.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
    private Integer id;
    private String numero;
    private String fecha;
}
