/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argPrograma.bazar.service;

import com.argPrograma.bazar.model.Usuario;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IUsuarioService {
    
    public List<Usuario> getUsuarios();
    
    public void saveUsuario(Usuario usuario);
    
    public void deleteUsuario(Long id);
    
    public Usuario findUsuario(Long id);
}
