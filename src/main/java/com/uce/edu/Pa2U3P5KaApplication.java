package com.uce.edu;

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
    private IFacturaService iFacturaService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U3P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n>>>INNER JOIN");
        List<Factura> lista = this.iFacturaService.buscarFacturasInnerJoin();
        lista.forEach(System.out::println);

        System.out.println("\n>>>RIGHT JOIN");
        List<Factura> lista2 = this.iFacturaService.buscarFacturasRightJoin();
        lista2.forEach(fact -> System.out.println(fact.getNumero()));

        System.out.println("\n>>>LEFT JOIN");
        List<Factura> lista3 = this.iFacturaService.buscarFacturasLeftJoin();
        lista3.forEach(fact -> System.out.println(fact.getNumero()));

        System.out.println("\n>>>FULL JOIN");
        List<Factura> lista4 = this.iFacturaService.buscarFacturasFullJoin();
        lista4.forEach(fact -> {
            System.out.println(fact);
            fact.getDetallesFactura().forEach(System.out::println);
        });

    }
}
