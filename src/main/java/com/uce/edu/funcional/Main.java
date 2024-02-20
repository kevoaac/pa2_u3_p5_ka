package com.uce.edu.funcional;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 1. Supplier
        System.out.println(">>SUPPLIER");

        //  Clases
        System.out.println(" >Clases");

        IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
        String id = supplierClase.getId();
        System.out.println(id);

        //  Lambdas
        System.out.println(" >Lambdas");

        IPersonaSupplier<String> supplierLambda = () -> {
            String cedula = "44345435345";
            cedula = cedula + "cantón";
            return cedula;
        };
        System.out.println(supplierLambda.getId());

        IPersonaSupplier<String> supplierLambda2 = () -> "466456563" + "pais";
        System.out.println(supplierLambda2.getId());

        IPersonaSupplier<Integer> supplierLambda3 = () -> {
            Integer valor1 = Integer.valueOf(100);
            valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
            return valor1;
        };
        System.out.println(supplierLambda3.getId());

        // Métodos referenciados
        // métodos que no importa que no implemente la interfaz, basta con que tengan un método que CUMPLA LA INTERFAZ
        System.out.println(" >Métodos Referenciados");
        MetodosReferenciados met = new MetodosReferenciados();
        IPersonaSupplier<String> supplierLambda4 = met::obtenerId;
        System.out.println(supplierLambda4.getId()); // usa getId y no obtenerId() porque lo que se pasa es el cuerpo del metodo

        //  2. Consummer -----------------------------------------------------
        System.out.println("\n>>CONSUMER");
        //  Clases
        System.out.println(" >Clases");

        IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
        consumerClase.accept("Profesor");

        //  Lambdas
        System.out.println(" >Lambdas");

        IPersonaConsumer<String> consummerLambda = (cadenaStr) -> {
            System.out.println("Actualizando: " + cadenaStr);
            System.out.println(cadenaStr + "Actializado");
        };
        consummerLambda.accept("Alumno");

        // Métodos referenciados
        System.out.println(" >Métodos Referenciados");

        IPersonaConsumer<String> consumer2 = met::procesar;
        consumer2.accept("Kevin Referenciado");

        //  3. Predicate ------------------------------------------------------
        System.out.println("\n>>PREDICATE");

        //  Lambdas
        System.out.println(" >Lambdas");

        IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
        boolean esIgual = predicateLambda.evaluar(7);
        System.out.println("El valor es igual: " + esIgual);

        IPersonaPredicate<String> predicateLambda2 = letra -> "Kevin".contains(letra);
        System.out.println("Contienen letra: " + predicateLambda2.evaluar("z"));

        // Métodos referenciados
        System.out.println(" >Métodos Referenciados");

        IPersonaPredicate<String> predicate2 = met::evaluar;
        System.out.println(predicate2.evaluar("X"));

        IPersonaPredicate<Integer> predicate3 = met::evaluar;
        System.out.println(predicate3.evaluar(8));

        //  4. Function ------------------------------------------------------
        System.out.println("\n>>FUNCTION");

        //  Lambdas
        System.out.println(" >Lambdas");
        //<TipoDeRetorno, TipoDeParametro>
        IPersonaFunction<String, Integer> funcionLambda = numero -> {
            numero = numero + Integer.valueOf(10);
            String numeroString = numero.toString().concat("-Valor");
            return numeroString;
        };

        System.out.println(funcionLambda.aplicar(7));

        IPersonaFunction<Empleado, Ciudadano> funcionLambda1 = ciudadano -> {
            Empleado empl = new Empleado();
            empl.setNombreCompleto(ciudadano.getNombre() + ciudadano.getApellido());
            if (ciudadano.getProvincia().compareTo("pichincha") == 0) {
                empl.setPais("Ecuador");
            }
            return empl;
        };
        Ciudadano ciud = new Ciudadano();
        ciud.setApellido("Andrade");
        ciud.setNombre("Kevin");
        ciud.setProvincia("pichincha");

        Empleado empl = funcionLambda1.aplicar(ciud);

        System.out.println(empl);

        // Métodos referenciados
        System.out.println(" >Métodos Referenciados");
        Empleado emp2 = new Empleado();
        emp2.setNombreCompleto("Daniel Tobar");
        emp2.setPais("Ecuador");

        IPersonaFunction<Ciudadano, Empleado> function2 = met::cambiar;
        System.out.println(function2.aplicar(emp2));

        //  5. Unary Operator ------------------------------------------------------
        System.out.println("\n>>UNARY OPERATOR");

        //  Lambdas
        System.out.println(" >Lambdas");
        IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero * 2);

        System.out.println(unaryOperatorLambda.aplicar(14));
        // Extendiendo de Function

        IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero -> numero + (numero * 2);
        System.out.println(unaryOperatorLambda2.aplicar(14));

        // Métodos referenciados
        System.out.println(" >Métodos Referenciados");
        IPersonaUnaryOperatorFunction<Empleado> unary3 = met::procesar;
        Empleado empl3 = unary3.aplicar(emp2);
        System.out.println(empl3);

        // LIBRERIAS JAVA
        System.out.println(">>>Implementación de interfaces funcionales mediante librerías java-----");

        //  1. Supplier
        System.out.println("\n >Supplier Java");
        // Stream: Una representación/colección de elementos con funcionalidades que permiten trabajar con programación funcional
        Stream<String> lista = Stream.generate(() -> "466456563" + "pais").limit(20);
        lista.forEach(cadena -> System.out.println(cadena));

        // 2. Consummer
        System.out.println("\n >Consummer Java");

        List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 45, 23);
        listaNumeros.forEach(numero -> {
            System.out.println("Se inserta");
            System.out.println(numero);
        });

//        for (Integer numero: lista2){
//            System.out.println("Se inserta");
//            System.out.println(numero);
//        }

        // 3. Predicate
        System.out.println("\n >Predicate Java");
        // filter() recibe una IMPLEMENTACION de una Interfaz Predicate
        Stream<Integer> listaFiltrada = listaNumeros.stream().filter(numero -> numero >= 6);

        listaFiltrada.forEach(System.out::println);

        // 4. Function
        System.out.println("\n >Function Java");
        Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
            numero = numero * 100 / 50;
            return "Num: " + numero;
        });

        listaCambiada.forEach(cadena -> System.out.println(cadena));


        Ciudadano ciud01 = new Ciudadano();
        ciud01.setApellido("Andrade");
        ciud01.setNombre("Kevin");
        ciud01.setProvincia("pichincha");
        Ciudadano ciud02 = new Ciudadano();
        ciud02.setApellido("Terán");
        ciud02.setNombre("Daniel");
        ciud02.setProvincia("pichincha");
        Ciudadano ciud03 = new Ciudadano();
        ciud03.setApellido("Jacome");
        ciud03.setNombre("Liliana");
        ciud03.setProvincia("pichincha");

        List<Ciudadano> listaCiudadano = Arrays.asList(ciud01, ciud02, ciud03);

        Stream<Empleado> listaEmpleado = listaCiudadano.stream().map(ciudadano -> {
            Empleado empl01 = new Empleado();
            empl01.setNombreCompleto(ciudadano.getNombre() + ciudadano.getApellido());
            if (ciudadano.getProvincia().compareTo("pichincha") == 0) {
                empl01.setPais("Ecuador");
            }
            return empl01;
        });

        listaEmpleado.forEach(empleado -> {
            System.out.println(empleado);
        });

        // 5. Unary Operator
        System.out.println("\n >UnaryOperator Java");
        Stream<Integer> listaNumero2 = listaNumeros.stream().map(numero -> {
            numero = numero * 100 / 50;
            return numero;
        });

        listaNumero2.forEach(numero -> System.out.println(numero));

    }
}
