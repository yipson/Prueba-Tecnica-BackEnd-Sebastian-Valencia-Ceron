package com.techMahindra.prueba.service;

import com.techMahindra.prueba.dao.MesaDao;
import com.techMahindra.prueba.models.Mesa;
import com.techMahindra.prueba.models.Ruleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MesaServiceImp implements MesaService{

    @Autowired
    MesaDao mesaDao;

    @Autowired
    EntityManager entityManager;


    //Retorna Todas las mesas
    @Override
    public List<Mesa> getMesas() {
        return (List<Mesa>) mesaDao.findAll();
    }


    //Inserta Mesa a la base de datos
    @Override
    public Mesa save(Mesa mesa) {
        mesa.setDisponible(new Character('T'));
        return mesaDao.save(mesa);
    }


    //Retorna las mesas que tienen disponibilidad de juego
    @Override
    public List<Mesa> getMesasDisponibles() {
        Character disponible = 'T';
        String query = "FROM Mesa WHERE disponible = :disponible";
        List<Mesa> mesas = entityManager.createQuery(query)
                .setParameter("disponible", disponible)
                .getResultList();

        return mesas;
    }

    //Busca la mesa por id y la retorna
    @Override
    public Optional<Mesa> getMesaById(Long id){
        return mesaDao.findById(id);
    }


    //Generar resultado aleatorio de la ruleta
    @Override
    public Ruleta getResultado(){
        Random random = new Random();
        int numero = random.nextInt(35)+1;

        String color = "";
        Ruleta resultado = new Ruleta();

        if(numero%2 == 0 || numero==0){
            color = "Rojo";
        } else {
            color = "Negro";
        }

        resultado.setNumero(numero);
        resultado.setColor(color);

        return resultado;
    }


}
