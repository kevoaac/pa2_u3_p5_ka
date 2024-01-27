package com.uce.edu.hoteles.repository;

import com.uce.edu.hoteles.repository.modelo.Habitacion;

import java.util.List;

public interface IHabitacionRepository {
    public Habitacion seleccionar(Integer id);

    public void insertar(Habitacion habitacion);

    public void actualizar(Habitacion habitacion);

    public void eliminar(Integer id);

    public List<Habitacion> seleccionarPorClase(String clase);
}
