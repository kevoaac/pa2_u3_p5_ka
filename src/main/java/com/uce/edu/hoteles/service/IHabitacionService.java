package com.uce.edu.hoteles.service;

import com.uce.edu.hoteles.repository.modelo.Habitacion;

import java.util.List;

public interface IHabitacionService {
    public Habitacion buscar(Integer id);
    public void guardar(Habitacion habitacion);
    public void actualizar(Habitacion habitacion);
    public void eliminar(Integer id);
    public List<Habitacion> buscarPorClase(String clase);

}
