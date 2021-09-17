package com.techMahindra.prueba.dao;

import com.techMahindra.prueba.domains.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaDao extends JpaRepository<Mesa, Long> {
}
