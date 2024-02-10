package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.modelo.Cliente;

public interface IClienteService {
    void guardar(Cliente cliente);
    void pruebaSupports();
    void pruebaNever();
}
