package com.uce.edu.veterinaria.repository.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "duenio")
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_duenio")
    @SequenceGenerator(name = "seq_duenio", sequenceName = "seq_duenio", allocationSize = 1)
    @Column(name = "duen_id")
    private Integer id;
    @Column(name = "duen_cedula")
    private String cedula;
    @Column(name = "duen_nombre")
    private String nombre;
    @Column(name = "duen_apellido")
    private String apellido;
    @Column(name = "duen_direccion")
    private String direccion;
    @Column(name = "duen_telefono")
    private String telefono;
    @Column(name = "duen_email")
    private String email;
    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mascota> mascotas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public String toString() {
        return "Duenio{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", mascotas=" + mascotas +
                '}';
    }
}
