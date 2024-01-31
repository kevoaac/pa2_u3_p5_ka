package com.uce.edu.hoteles.repository;

import com.uce.edu.hoteles.repository.modelo.Habitacion;
import com.uce.edu.hoteles.repository.modelo.Hotel;

import java.util.List;

public interface IHotelRepository {
    public Hotel seleccionar(Integer id);
    public void insertar(Hotel hotel);
    public void actualizar(Hotel hotel);
    public void eliminar(Integer id);
    public List<Hotel> listar();
    public Hotel seleccionarPorNombre(String nombre);
    public List<Habitacion> seleccionarHabitacionesPorNombreHotel(String nombre);
    public List<Hotel> seleccionarPorNumeroHabitaciones(Integer numeroHabitaciones);

    // JOIN TYPES
    public List<Hotel> seleccionarPorNombreInnerJoin(String nombre);
    public List<Hotel> seleccionarPorDireccionLeftJoin(String direccion);
    public List<Hotel> seleccionarPorClaseRightJoin(String clase);
    public List<Hotel> seleccionarDesdeInicialDeNombreFullJoin(String inicialDeNombre);
}
