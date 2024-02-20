package com.uce.edu.funcional;

public class MetodosReferenciados {
    public String obtenerId() {
        String cedula = "44345435345";
        cedula = cedula + "Referenciado";
        return cedula;
    }

    public void procesar(String cadena) {
        System.out.println(cadena);
    }

    public boolean evaluar(String cadena) {
        return "Kevin".contains(cadena);
    }

    public boolean evaluar(Integer numero) {
        return 8 == numero;
    }

    public Ciudadano cambiar(Empleado empleado) {
        Ciudadano ciud = new Ciudadano();
        String nombre = empleado.getNombreCompleto().split(" ")[0];
        String apellido = empleado.getNombreCompleto().split(" ")[1];
        ciud.setNombre(nombre);
        ciud.setApellido(apellido);
        ciud.setProvincia("chimborazo");

        return ciud;
    }

    public Empleado procesar(Empleado empl) {
        empl.setNombreCompleto(empl.getNombreCompleto() + " " + empl.getPais());
        empl.setPais(empl.getPais() + " de nacimiento");
        return empl;
    }
}
