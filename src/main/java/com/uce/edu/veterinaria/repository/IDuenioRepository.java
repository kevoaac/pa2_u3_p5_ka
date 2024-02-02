package com.uce.edu.veterinaria.repository;

import com.uce.edu.veterinaria.repository.modelo.Duenio;

import java.util.List;

public interface IDuenioRepository {
    List<Duenio> seleccionarDuenioInnerJoin();

    List<Duenio> seleccionarDueniosPorCodigoProvinciaInnerJoin(String codigoProvincia);

    List<Duenio> seleccionarDueniosRightJoin();

    List<Duenio> seleccionarDueniosPorApellidoRightJoin(String apellido);

    List<Duenio> seleccionarDueniosLeftJoin();

    List<Duenio> seleccionarDueniosPorTipoDominioCorreoLeftJoin(String dominioCorreo);

    List<Duenio> seleccionarDueniosFullJoin();

    List<Duenio> seleccionarDueniosLimitNFullJoin(Integer limiteDeResultados);

    List<Duenio> seleccionarDueniosFetchJoin();

    List<Duenio> seleccionarDueniosPorCedulaYEspecieMascota(String cedula, String especieMascota);


}
