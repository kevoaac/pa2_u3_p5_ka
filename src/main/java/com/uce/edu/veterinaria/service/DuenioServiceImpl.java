package com.uce.edu.veterinaria.service;

import com.uce.edu.veterinaria.repository.IDuenioRepository;
import com.uce.edu.veterinaria.repository.modelo.Duenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioServiceImpl implements IDuenioService {
    @Autowired
    private IDuenioRepository iDuenioRepository;

    @Override
    public List<Duenio> buscarDuenioInnerJoin() {
        return this.iDuenioRepository.seleccionarDuenioInnerJoin();
    }

    @Override
    public List<Duenio> buscarDueniosPorCodigoProvinciaInnerJoin(String codigoProvincia) {
        return this.iDuenioRepository.seleccionarDueniosPorCodigoProvinciaInnerJoin(codigoProvincia);
    }

    @Override
    public List<Duenio> buscarDueniosRightJoin() {
        return this.iDuenioRepository.seleccionarDueniosRightJoin();
    }

    @Override
    public List<Duenio> buscarDueniosPorApellidoRightJoin(String apellido) {
        return this.iDuenioRepository.seleccionarDueniosPorApellidoRightJoin(apellido);
    }

    @Override
    public List<Duenio> buscarDueniosLeftJoin() {
        return this.iDuenioRepository.seleccionarDueniosLeftJoin();
    }

    @Override
    public List<Duenio> buscarDueniosPorTipoDominioCorreoLeftJoin(String dominioCorreo) {
        return this.iDuenioRepository.seleccionarDueniosPorTipoDominioCorreoLeftJoin(dominioCorreo);
    }

    @Override
    public List<Duenio> buscarDueniosFullJoin() {
        return this.iDuenioRepository.seleccionarDueniosFullJoin();
    }

    @Override
    public List<Duenio> buscarDueniosLimitNFullJoin(Integer limiteDeResultados) {
        return this.iDuenioRepository.seleccionarDueniosLimitNFullJoin(limiteDeResultados);
    }

    @Override
    public List<Duenio> buscarDueniosFetchJoin() {
        return this.iDuenioRepository.seleccionarDueniosFetchJoin();
    }

    @Override
    public List<Duenio> buscarDueniosPorCedulaYEspecieMascota(String cedula, String especieMascota) {
        return this.iDuenioRepository.seleccionarDueniosPorCedulaYEspecieMascota(cedula, especieMascota);
    }
}
