package com.techMahindra.prueba.controllers;

import com.techMahindra.prueba.models.Mesa;
import com.techMahindra.prueba.models.Ruleta;
import com.techMahindra.prueba.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("api_mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    //Retorna listado de Mesas PATH: localhost:8080/api_mesa/listado
    @RequestMapping(value="/api_mesa/listado")
    public List<Mesa> getMesas(){
        return (List<Mesa>) mesaService.getMesas();
    }

    //Inserta mesa, retorna mesa insertada PATH: localhost:8080/api_mesa/create
    @PostMapping(value = "/api_mesa/create")
    public void createMesa(@RequestBody Mesa mesa){
        mesaService.save(mesa);
    }

    //Retorna listado de mesas disponibles para jugar PATH: localhost:8080/mesas/disponibles
    @RequestMapping(value="/mesas/disponibles", method = RequestMethod.GET)
    public List<Mesa> getMesasDisponibles(){
        return (List<Mesa>) mesaService.getMesasDisponibles();
    }


    //Retorna la mesa enviada por id PATH: localhost:8080/mesa_actual/{id}
    //{id} -> reemplazar por id de la tabla de mesas
    @RequestMapping(value="/mesa_actual/{id}", method = RequestMethod.GET)
    public Optional<Mesa> getMesaById(@PathVariable Long id){
        return mesaService.getMesaById(id);
    }


    //Retorna la apuesta aleatoria PATH: localhost:8080//generar_resultado
    @RequestMapping(value="/generar_resultado", method = RequestMethod.POST)
    public Ruleta getResultado(){
        return mesaService.getResultado();
    }


    //Actualiza el registro de mesa al haber culminado el juego
    //Metodo en revision
    @RequestMapping(value="/guardar_resultado/{idUsuario}", method = RequestMethod.POST)
    public void updateMesa(@RequestBody Mesa mesa,  @PathVariable Long idUsuario){
        mesaService.save(mesa);
    }

}
