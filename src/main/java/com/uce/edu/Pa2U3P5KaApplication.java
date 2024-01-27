package com.uce.edu;

import com.uce.edu.hoteles.repository.modelo.Habitacion;
import com.uce.edu.hoteles.repository.modelo.Hotel;
import com.uce.edu.hoteles.service.IHotelService;
import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Pa2U3P5KaApplication implements CommandLineRunner {
    // Join Types en Jakarta Persistence
    // 1) JOIN
    //  1.1 INNER JOIN
    //  1.2 OUTHER JOIN
    //      1.2.1 LEFT
    //      1.2.2 RIGHT
    //      1.2.3 FULL
    // 2) JOIN WHERE
    // 3) FETCH JOIN
    @Autowired
    private IHotelService iHotelService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U3P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Realizar un ejemplo de los siguientes tipos de join's:
        // INNER
        // LEFT
        // RIGHT
        // FULL

        System.out.println("\n>>>INNER JOIN");
        List<Hotel> lista = this.iHotelService.buscarPorNombreInnerJoin("Nueva Luna");
        lista.forEach(hotel -> {
            System.out.println(hotel);
            hotel.getHabitaciones().forEach(habitacion -> System.out.println(habitacion.getNumero()));
        });

        System.out.println("\n>>>LEFT JOIN");
        List<Hotel> lista2 = this.iHotelService.buscarPorDireccionLeftJoin("Plaza central");
        lista2.forEach(System.out::println);

        System.out.println("\n>>>RIGHT JOIN");
        List<Hotel> lista3 = this.iHotelService.buscarPorClaseRightJoin("vip");
        lista3.forEach(hotel -> {
            System.out.println(hotel);
            hotel.getHabitaciones().forEach(habitacion -> System.out.println(habitacion.getNumero()));
        });

        System.out.println("\n>>>FULL JOIN");
        List<Hotel> lista4 = this.iHotelService.buscarDesdeInicialDeNombreFullJoin("L");
        lista4.forEach(System.out::println);

    }
}
