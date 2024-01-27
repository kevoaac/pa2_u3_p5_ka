package com.uce.edu.hoteles.repository;

import com.uce.edu.hoteles.repository.modelo.Habitacion;
import com.uce.edu.hoteles.repository.modelo.Hotel;
import com.uce.edu.ventas.repository.modelo.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Hotel seleccionar(Integer id) {
        return this.entityManager.find(Hotel.class, id);
    }

    @Override
    public void insertar(Hotel hotel) {
        this.entityManager.persist(hotel);
    }

    @Override
    public void actualizar(Hotel hotel) {
        this.entityManager.merge(hotel);
    }

    @Override
    public void eliminar(Integer id) {
        Hotel hotel = this.seleccionar(id);
        this.entityManager.remove(hotel);
    }

    @Override
    public List<Hotel> listar() {
        TypedQuery<Hotel> query1 = entityManager.createQuery("SELECT h FROM Hotel h", Hotel.class);
        return query1.getResultList();
    }

    @Override
    public Hotel seleccionarPorNombre(String nombre) {
        TypedQuery<Hotel> query2 = entityManager.createQuery("SELECT h FROM Hotel h WHERE h.nombre = :nombre", Hotel.class);
        query2.setParameter("nombre", nombre);
        return query2.getSingleResult();
    }

    @Override
    public List<Habitacion> seleccionarHabitacionesPorNombreHotel(String nombre) {
        Hotel hotel = this.seleccionarPorNombre(nombre);
        Integer hotelId = hotel.getId();

        TypedQuery<Habitacion> query3 = entityManager.createQuery("SELECT h FROM Habitacion h WHERE h.hotel.id = :hotelId", Habitacion.class);
        query3.setParameter("hotelId", hotelId);

        return query3.getResultList();
    }

    @Override
    public List<Hotel> seleccionarPorNumeroHabitaciones(Integer numeroHabitaciones) {
        TypedQuery<Hotel> query5 = entityManager.createQuery("SELECT h FROM Hotel h WHERE SIZE(h.habitaciones) > :n", Hotel.class);
        query5.setParameter("n", numeroHabitaciones);

        return query5.getResultList();
    }

    // JOIN TYPES
    @Override
    public List<Hotel> seleccionarPorNombreInnerJoin(String nombre) {
        // SQL: SELECT * FROM hotel h INNER JOIN habitacion a ON h.hote_id = a.habi_id_hotel  WHERE h.hote_nombre = 'Nueva Luna'
        // JPQL: SELECT h FROM Hotel h INNER JOIN h.habitaciones WHERE h.nombre = :nombre

        TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones WHERE h.nombre = :nombre", Hotel.class);
        myQuery.setParameter("nombre", nombre);

        myQuery.getResultList().forEach(fact -> fact.getHabitaciones().size());
        return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarPorDireccionLeftJoin(String direccion) {
        // SQL: SELECT * FROM hotel h LEFT JOIN habitacion a ON h.hote_id = a.habi_id_hotel  WHERE h.hote_direccion = 'Plaza central'
        // JPQL: SELECT h FROM Hotel h LEFT JOIN h.habitaciones WHERE h.direccion = :direccion

        TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones WHERE h.direccion = :direccion", Hotel.class);
        myQuery.setParameter("direccion", direccion);

        myQuery.getResultList().forEach(fact -> fact.getHabitaciones().size());
        return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarPorClaseRightJoin(String clase) {
        // SQL: SELECT * FROM hotel h RIGHT JOIN habitacion a ON h.hote_id = a.habi_id_hotel  WHERE a.habi_clase = 'vip'
        // JPQL: SELECT h FROM Hotel h RIGHT JOIN h.habitaciones a WHERE a.clase = :clase

        TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones a WHERE a.clase = :clase", Hotel.class);
        myQuery.setParameter("clase", clase);

        myQuery.getResultList().forEach(fact -> fact.getHabitaciones().size());
        return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarDesdeInicialDeNombreFullJoin(String inicialDeNombre) {
        // SQL: SELECT * FROM hotel h FULL JOIN habitacion a ON h.hote_id = a.habi_id_hotel WHERE h.hote_nombre > 'L'
        // JPQL: SELECT h FROM Hotel h FULL JOIN h.habitaciones WHERE h.inicialDeNombre > :inicialDeNombre

        TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones WHERE h.nombre > :inicialDeNombre", Hotel.class);
        myQuery.setParameter("inicialDeNombre", inicialDeNombre);

        myQuery.getResultList().forEach(fact -> fact.getHabitaciones().size());
        return myQuery.getResultList();
    }
}
