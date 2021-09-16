package com.techMahindra.prueba.service;

import com.techMahindra.prueba.dao.MesaDao;
import com.techMahindra.prueba.models.Mesa;
import com.techMahindra.prueba.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class MesaServiceImp implements MesaService{

    @Autowired
    MesaDao mesaDao;

    @Autowired
    EntityManager entityManager;


    @Override
    public List<Mesa> getMesas() {
        return (List<Mesa>) mesaDao.findAll();
    }

    @Override
    public void save(Mesa mesa) {
        mesaDao.save(mesa);
    }

    @Override
    public List<Mesa> getMesasDisponibles() {
        Character disponible = 'T';
        String query = "FROM Mesa WHERE disponible = :disponible";
        List<Mesa> mesas = entityManager.createQuery(query)
                .setParameter("disponible", disponible)
                .getResultList();

        return mesas;
    }
}
