package com.uce.edu;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IClienteService;
import com.uce.edu.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;

@SpringBootApplication
public class Pa2U3P5KaApplication implements CommandLineRunner {
    @Autowired
    private IFacturaService iFacturaService;
    @Autowired
    private IClienteService iClienteService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U3P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        this.iFacturaService.pruebaSupport();
//        this.iFacturaService.pruebaNever();
    }
}
