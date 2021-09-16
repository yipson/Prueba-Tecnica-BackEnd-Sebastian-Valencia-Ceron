package com.techMahindra.prueba.service;

import com.techMahindra.prueba.models.Mesa;

import java.util.List;

public interface MesaService {

    List<Mesa> getMesas();

    void save(Mesa mesa);

    List<Mesa> getMesasDisponibles();
}
