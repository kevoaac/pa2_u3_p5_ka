package com.uce.edu.veterinaria.service;

import com.uce.edu.veterinaria.repository.modelo.Duenio;

import java.util.List;

public interface IDuenioService {
    List<Duenio> buscarDuenioInnerJoin();

    List<Duenio> buscarDueniosPorCodigoProvinciaInnerJoin(String codigoProvincia);

    List<Duenio> buscarDueniosRightJoin();

    List<Duenio> buscarDueniosPorApellidoRightJoin(String apellido);

    List<Duenio> buscarDueniosLeftJoin();

    List<Duenio> buscarDueniosPorTipoDominioCorreoLeftJoin(String dominioCorreo);

    List<Duenio> buscarDueniosFullJoin();

    List<Duenio> buscarDueniosLimitNFullJoin(Integer limiteDeResultados);

    List<Duenio> buscarDueniosFetchJoin();

    List<Duenio> buscarDueniosPorCedulaYEspecieMascota(String cedula, String especieMascota);
}
