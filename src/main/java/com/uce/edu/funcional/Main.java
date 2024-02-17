package com.uce.edu.funcional;

import jakarta.persistence.criteria.CriteriaBuilder;

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

        IPersonaSupplier<String> supplierLambda2 = () -> "466456563"+"pais";
        System.out.println(supplierLambda2.getId());

        IPersonaSupplier<Integer> supplierLambda3 = () -> {
            Integer valor1 = Integer.valueOf(100);
            valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
            return valor1;
        };
        System.out.println(supplierLambda3.getId());

        // Métodos referenciados

        //  2. Consummer -----------------------------------------------------
        System.out.println(">>CONSUMER");
        //  Clases
        System.out.println(" >Clases");

        IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
        consumerClase.accept("Profesor");

        //  Lambdas
        System.out.println(" >Lambdas");

        IPersonaConsumer<String> consummerLambda = (cadenaStr) -> {
            System.out.println("Actualizando: " + cadenaStr );
            System.out.println(cadenaStr + "Actializado");
        };
        consummerLambda.accept("Alumno");


        //  2. Consummer ------------------------------------------------------
        System.out.println(">>PREDICATE");

        //  Lambdas
        System.out.println(" >Lambdas");

        IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
        boolean esIgual = predicateLambda.evaluar(7);
        System.out.println("El valor es igual: " + esIgual);

        IPersonaPredicate<String> predicateLambda2 = letra -> "Kevin".contains(letra);
        System.out.println( "Contienen letra: " + predicateLambda2.evaluar("z"));

    }
}
