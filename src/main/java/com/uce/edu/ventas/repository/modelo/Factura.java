package com.uce.edu.ventas.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_factura")
    @SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura", allocationSize = 1)
    @Column(name = "fact_id")
    private Integer id;
    @Column(name = "fact_numero")
    private String numero;
    @Column(name = "fact_fecha")
    private LocalDateTime fecha;
    @Column(name = "fact_cedula")
    private String cedula;
    @Transient
    private BigDecimal valorIVA;
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleFactura> detallesFactura;
    // SET Y GET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public BigDecimal getValorIVA() {
        return valorIVA;
    }

    public void setValorIVA(BigDecimal valorIVA) {
        this.valorIVA = valorIVA;
    }

    public List<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", fecha=" + fecha +
                ", cedula='" + cedula + '\'' +
                ", detallesFactura=" + detallesFactura +
                '}';
    }
}
