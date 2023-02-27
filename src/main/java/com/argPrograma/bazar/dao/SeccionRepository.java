/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argPrograma.bazar.dao;

import com.argPrograma.bazar.model.Seccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santi
 */
@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Long> {
    
    @Query(value = "SELECT * from seccion as s WHERE s.id_usuario=?1", nativeQuery = true)
    List<Seccion> getByUserId(Long id);
}
