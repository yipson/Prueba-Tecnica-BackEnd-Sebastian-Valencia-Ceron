package com.techMahindra.prueba.dao;

import com.techMahindra.prueba.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol, Long> {
}
