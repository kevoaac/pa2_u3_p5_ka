package com.uce.edu.veterinaria.repository;

import com.uce.edu.veterinaria.repository.modelo.Mascota;

public interface IMascotaRepository {
    Mascota seleccionarPorTelefonoPlaca(String telefonoPlaca);
}
