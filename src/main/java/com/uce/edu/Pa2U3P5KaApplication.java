package com.uce.edu;

import com.uce.edu.veterinaria.repository.modelo.Duenio;
import com.uce.edu.veterinaria.service.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Pa2U3P5KaApplication implements CommandLineRunner {
    @Autowired
    private IDuenioService iDuenioService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U3P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Realizar 2 ejemplos de los siguientes tipos de JOIN:
        //INNER JOIN
        //RIGTH JOIN
        //LEFT JOIN
        //FULL JOIN
        //FETCH JOIN

        System.out.println("\n>>> INNER JOIN");
        List<Duenio> l1 = this.iDuenioService.buscarDuenioInnerJoin();
        l1.forEach(System.out::println);

        System.out.println("    >Buscar por Cod Provincia");
        List<Duenio> l2 = this.iDuenioService.buscarDueniosPorCodigoProvinciaInnerJoin("19");
        l2.forEach(System.out::println);


        System.out.println("\n>>> RIGHT JOIN");
        List<Duenio> l3 = this.iDuenioService.buscarDueniosRightJoin();
        l3.forEach(System.out::println);

        System.out.println("    >Buscar por apellido");
        List<Duenio> l4 = this.iDuenioService.buscarDueniosPorApellidoRightJoin("Paez");
        l4.forEach(System.out::println);


        System.out.println("\n>>> LEFT JOIN");
        List<Duenio> l5 = this.iDuenioService.buscarDueniosLeftJoin();
        l5.forEach(System.out::println);

        System.out.println("    >Buscar por dominio de correo");
        List<Duenio> l6 = this.iDuenioService.buscarDueniosPorTipoDominioCorreoLeftJoin("@outlook.com");
        l6.forEach(System.out::println);


        System.out.println("\n>>> FULL JOIN");
        List<Duenio> l7 = this.iDuenioService.buscarDueniosFullJoin();
        l7.forEach(System.out::println);

        System.out.println("    >Buscar con limite de resultados");
        List<Duenio> l8 = this.iDuenioService.buscarDueniosLimitNFullJoin(2);
        l8.forEach(System.out::println);


        System.out.println("\n>>> JOIN FETCH");
        List<Duenio> l9 = this.iDuenioService.buscarDueniosFetchJoin();
        l9.forEach(System.out::println);

        System.out.println("    >Buscar por Cedula Duenio y especie Mascota");
        List<Duenio> l10 = this.iDuenioService.buscarDueniosPorCedulaYEspecieMascota("191901", "Perro");
        l10.forEach(duenio -> {
            System.out.println(duenio);
            duenio.getMascotas().forEach(System.out::println);
        });

    }
}
