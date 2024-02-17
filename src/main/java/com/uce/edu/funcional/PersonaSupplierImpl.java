package com.uce.edu.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String> {

    @Override
    public String getId() {
        String cedula = "44345435345";
        cedula = cedula + "provincia";
        return cedula;
    }
}
