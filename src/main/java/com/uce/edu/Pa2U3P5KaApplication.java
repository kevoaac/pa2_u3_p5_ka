package com.uce.edu;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IClienteService;
import com.uce.edu.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableAsync
public class Pa2U3P5KaApplication implements CommandLineRunner {
    @Autowired
    private IClienteService iClienteService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U3P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Nombre Hilo: " + Thread.currentThread().getName());

        long tiempoInicial = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente();
            cliente.setNombre("CN " + i);
            cliente.setApellido("CA " + i);
            this.iClienteService.guardar(cliente);
        }
        long tiempoFinal = System.currentTimeMillis();


        System.out.println("Tiempo transcurrido en seg: " + (tiempoFinal - tiempoInicial)); // 101 Seg

        // PROGRAMACIÓN EN PARALELO/ MULTIHILO-------------------------------------------------------------------

        // MONOHILO

//        System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
//        long tiempoInicial = System.currentTimeMillis();
//
//        List<Cliente> listaCliente = new ArrayList<>();
//
//        for (int i = 1; i <= 100; i++) {
//            Cliente cliente = new Cliente();
//            cliente.setNombre("CN " + i);
//            cliente.setApellido("CA " + i);
//
//            listaCliente.add(cliente);
//        }
//
//        listaCliente.stream().forEach(cliente -> this.iClienteService.guardar(cliente));
//
//        long tiempoFinal = System.currentTimeMillis();
//        System.out.println("Tiempo transcurrido en seg: " + (tiempoFinal - tiempoInicial) / 1000); // 101 Seg

        // MULTIHILO

//        System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
//        long tiempoInicial = System.currentTimeMillis();
//
//        List<Cliente> listaCliente = new ArrayList<>();
//
//        for (int i = 1; i <= 100; i++) {
//            Cliente cliente = new Cliente();
//            cliente.setNombre("CN " + i);
//            cliente.setApellido("CA " + i);
//
//            listaCliente.add(cliente);
//        }
//
//        listaCliente.parallelStream().forEach(cliente -> this.iClienteService.guardar(cliente));
//
//        long tiempoFinal = System.currentTimeMillis();
//        System.out.println("Tiempo transcurrido en seg: " + (tiempoFinal - tiempoInicial) / 1000); // 10 Seg
//
    }
}
