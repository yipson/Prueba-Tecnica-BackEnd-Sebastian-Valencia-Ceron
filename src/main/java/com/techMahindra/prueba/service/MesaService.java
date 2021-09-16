package com.techMahindra.prueba.service;

import com.techMahindra.prueba.models.Mesa;
import com.techMahindra.prueba.models.Ruleta;

import java.util.List;
import java.util.Optional;

public interface MesaService {

    List<Mesa> getMesas();

    Mesa save(Mesa mesa);

    List<Mesa> getMesasDisponibles();

    Optional<Mesa> getMesaById(Long id);

    Ruleta getResultado();


}
