/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argPrograma.bazar.dao;

import com.argPrograma.bazar.model.Contenido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santi
 */
@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
    
    @Query(value = "SELECT * from contenido as c WHERE c.id_seccion=?1", nativeQuery = true)
    public List<Contenido> getBySeccionId(Long id);
}
