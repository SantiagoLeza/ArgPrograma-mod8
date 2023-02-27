/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argPrograma.bazar.controller;

import com.argPrograma.bazar.dto.UsuarioDTO;
import com.argPrograma.bazar.model.Usuario;
import com.argPrograma.bazar.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santi
 */
@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuarioService interUsuario;
    
    @Autowired
    private SeccionController secController;
    
    @GetMapping ("/usuarios/traer")
    public List<Usuario> getUsuarios(){
        return interUsuario.getUsuarios();
    }
    
    @PostMapping ("/usuarios/crear")
    public String createUsuario(@RequestBody Usuario u){
        interUsuario.saveUsuario(u);
        
        return "Usuario creado";
    }
    
    @DeleteMapping ("/usuarios/borrar/{id}")
    public String deleteUsuario(@PathVariable Long id){
        interUsuario.deleteUsuario(id);
        
        return "Usuario eliminado";
    }
    
    @PutMapping ("/usuarios/editar/{id}")
    public Usuario editUsuario(@PathVariable Long id,
            @RequestParam (name="nombre", required = false) String nombre,
            @RequestParam (name="apellido", required = false) String apellido,
            @RequestParam (name="mail", required = false) String mail,
            @RequestParam (name="contrasenia", required = false) String contrasenia,
            @RequestParam (name="ciudad", required = false) String ciudad,
            @RequestParam (name="pais", required = false) String pais,
            @RequestParam (name="url_imagen", required = false) String url_imagen
            ){
        
        Usuario user = interUsuario.findUsuario(id);
        
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setMail(mail);
        user.setContrasenia(contrasenia);
        user.setCiudad(ciudad);
        user.setPais(pais);
        user.setUrlImagen(url_imagen);
        
        interUsuario.saveUsuario(user);
        
        return user;
    }
    
    @GetMapping ("/usuarios/traer/{id}")
    public UsuarioDTO getUsuario(@PathVariable Long id){
        Usuario u = interUsuario.findUsuario(id);
        
        UsuarioDTO userDTO = new UsuarioDTO(
                u.getNombre(), 
                u.getApellido(), 
                u.getMail(), 
                u.getCiudad(), 
                u.getPais(), 
                u.getUrlImagen(), 
                secController.getSeccionPorIdUsuario(u.getIdUsuario())
        );
        
        return userDTO;
    }
}
