package com.uce.edu.hoteles.service;

import com.uce.edu.hoteles.repository.modelo.Habitacion;
import com.uce.edu.hoteles.repository.modelo.Hotel;

import java.util.List;

public interface IHotelService {
    public Hotel buscar(Integer id);

    public void guardar(Hotel hotel);

    public void actualizar(Hotel hotel);

    public void eliminar(Integer id);

    public List<Hotel> listar();

    public Hotel buscarPorNombre(String nombre);

    public List<Habitacion> buscarHabitacionesPorNombreHotel(String nombre);

    public List<Hotel> buscarPorNumeroHabitaciones(Integer numeroHabitaciones);

    // JOIN TYPES
    public List<Hotel> buscarPorNombreInnerJoin(String nombre);

    public List<Hotel> buscarPorDireccionLeftJoin(String direccion);

    public List<Hotel> buscarPorClaseRightJoin(String clase);

    public List<Hotel> buscarDesdeInicialDeNombreFullJoin(String inicialDeNombre);
}
