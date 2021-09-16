package com.techMahindra.prueba.controllers;

import com.techMahindra.prueba.dao.MesaDao;
import com.techMahindra.prueba.models.Mesa;
import com.techMahindra.prueba.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("api_mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    //Retorna listado de Mesas
    @RequestMapping(value="/api_mesa/listado")
    public List<Mesa> getMesas(){
        return (List<Mesa>) mesaService.getMesas();
    }

    //Inserta mesa, retorna mesa insertada
    @PostMapping(value = "/api_mesa/create")
    public void createMesa(@RequestBody Mesa mesa){
        mesaService.save(mesa);
    }

    @RequestMapping(value="/mesas/disponibles")
    public List<Mesa> getMesasDisponibles(){
        return (List<Mesa>) mesaService.getMesasDisponibles();
    }

}
