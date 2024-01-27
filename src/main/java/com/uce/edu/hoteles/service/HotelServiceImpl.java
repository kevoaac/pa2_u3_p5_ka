package com.uce.edu.hoteles.service;

import com.uce.edu.hoteles.repository.IHotelRepository;
import com.uce.edu.hoteles.repository.modelo.Habitacion;
import com.uce.edu.hoteles.repository.modelo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {
    @Autowired
    private IHotelRepository iHotelRepository;

    @Override
    public void guardar(Hotel hotel) {
        this.iHotelRepository.insertar(hotel);
    }

    @Override
    public Hotel buscar(Integer id) {
        return this.iHotelRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Hotel ciudadano) {
        this.iHotelRepository.actualizar(ciudadano);
    }

    @Override
    public void eliminar(Integer id) {
        this.iHotelRepository.eliminar(id);
    }

    @Override
    public List<Hotel> listar() {
        return this.iHotelRepository.listar();
    }

    @Override
    public Hotel buscarPorNombre(String nombre) {
        return this.iHotelRepository.seleccionarPorNombre(nombre);
    }

    @Override
    public List<Habitacion> buscarHabitacionesPorNombreHotel(String nombre) {
        return this.iHotelRepository.seleccionarHabitacionesPorNombreHotel(nombre);
    }

    @Override
    public List<Hotel> buscarPorNumeroHabitaciones(Integer numeroHabitaciones) {
        return this.iHotelRepository.seleccionarPorNumeroHabitaciones(numeroHabitaciones);
    }

    @Override
    public List<Hotel> buscarPorNombreInnerJoin(String nombre) {
        return this.iHotelRepository.seleccionarPorNombreInnerJoin(nombre);
    }

    @Override
    public List<Hotel> buscarPorDireccionLeftJoin(String direccion) {
        return this.iHotelRepository.seleccionarPorDireccionLeftJoin(direccion);
    }

    @Override
    public List<Hotel> buscarPorClaseRightJoin(String clase) {
        return this.iHotelRepository.seleccionarPorClaseRightJoin(clase);
    }

    @Override
    public List<Hotel> buscarDesdeInicialDeNombreFullJoin(String inicialDeNombre) {
        return this.iHotelRepository.seleccionarDesdeInicialDeNombreFullJoin(inicialDeNombre);
    }
}
