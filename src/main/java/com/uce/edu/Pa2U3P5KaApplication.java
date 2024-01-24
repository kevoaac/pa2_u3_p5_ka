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
    @Autowired
    private IFacturaService iFacturaService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U3P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Factura fac = new Factura();
        fac.setCedula("456456");
        fac.setFecha(LocalDateTime.now());
        fac.setNumero("0001-02569");

        DetalleFactura det1 = new DetalleFactura();
        det1.setCantidad(4);
        det1.setCodigoBarras("45764567");
        det1.setNombreProducto("Cocacola");
        det1.setFactura(fac);

        DetalleFactura det2 = new DetalleFactura();
        det2.setCantidad(2);
        det2.setCodigoBarras("54343434");
        det2.setNombreProducto("Leche Vita");
        det2.setFactura(fac);

        fac.setDetallesFactura(List.of(det1, det2));

        // this.iFacturaService.guardar(fac);

        Factura factura = this.iFacturaService.buscarPorNumero("0001-02569");
        System.out.println(factura);

        factura.getDetallesFactura().forEach(System.out::println);

    }
}
