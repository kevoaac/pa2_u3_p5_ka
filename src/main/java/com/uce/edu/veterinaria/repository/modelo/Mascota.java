package com.uce.edu.veterinaria.repository.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mascota")
    @SequenceGenerator(name = "seq_mascota", sequenceName = "seq_mascota", allocationSize = 1)
    @Column(name = "masc_id")
    private Integer id;
    @Column(name = "masc_telefono_placa")
    private String telefonoPlaca;

    @Column(name = "masc_nombre")
    private String nombre;

    @Column(name = "masc_especie")
    private String especie;

    @Column(name = "masc_edad")
    private Integer edad;

    @Column(name = "masc_color")
    private String color;

    @Column(name = "masc_peso")
    private Double peso;
    @Column(name = "masc_vacunas")
    private List<String> vacunas;

    @Column(name = "masc_chip")
    private Boolean chip;
    @ManyToOne
    @JoinColumn(name = "masc_id_duenio")
    private Duenio duenio;

    // GET Y SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List<String> vacunas) {
        this.vacunas = vacunas;
    }

    public Boolean getChip() {
        return chip;
    }

    public void setChip(Boolean chip) {
        this.chip = chip;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setTipo(String especie) {
        this.especie = especie;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", telefonoPlaca='" + telefonoPlaca + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", color='" + color + '\'' +
                ", peso=" + peso +
                ", vacunas=" + vacunas +
                ", chip=" + chip +
//                ", duenio=" + duenio +
                '}';
    }
}
