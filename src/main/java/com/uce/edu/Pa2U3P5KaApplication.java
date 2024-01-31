package com.uce.edu;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Pa2U3P5KaApplication implements CommandLineRunner {
    @Autowired
    private IFacturaService iFacturaService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U3P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>UPDATE");
        int registrosAfectados = this.iFacturaService.actualizarFechas(
                LocalDateTime.of(2020, 1, 15, 12, 50),
                LocalDateTime.of(2024, 10, 10, 12, 50));

        System.out.println("Cantidad de registros actualizados: " + registrosAfectados);

        System.out.println(">>>UPDATE");
        int registrosEliminados = this.iFacturaService.borrarPorNumero("0001-02500");
        System.out.println("Cantidad de registros eliminados: " + registrosEliminados);


//        this.iFacturaService.borrar(1);

        // DTO: Data Transfer Object
        System.out.println(">>>DTO");
        List<FacturaDTO> lista = this.iFacturaService.buscarFacturasDTO();
        lista.forEach(System.out::println);

    }
}
