/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argPrograma.bazar.controller;

import com.argPrograma.bazar.model.Contenido;
import com.argPrograma.bazar.service.IContenidoService;
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
public class ContenidoController {
    
    @Autowired
    private IContenidoService interContenido;
    
    @GetMapping ("/contenido/traer")
    public List<Contenido> getConenidos(){
        return interContenido.getContenidos();
    }
    
    @PostMapping ("/contenido/crear")
    public String createContenido(@RequestBody Contenido contenido){
        interContenido.saveContenido(contenido);
        
        return "Contenido creado";
    }
    
    @DeleteMapping ("/contenido/eliminar/{id}")
    public String deleteContenido(@PathVariable Long id){
        interContenido.deleteContenido(id);
        
        return "Contenido eliminado";
    }
    
    @PutMapping ("/contenido/editar/{id}")
    public Contenido editContenido(@PathVariable Long id,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String texto,
            @RequestParam(required = false) String url_imagen
            ){
        Contenido c = interContenido.findContenido(id);
        
        c.setTitulo(titulo);
        c.setTexto(texto);
        c.setUrlImagen(url_imagen);
        
        interContenido.saveContenido(c);
        
        return c;
    }
    
    public List<Contenido> getBySeccionId(Long id){
        return interContenido.getBySeccionId(id);
    }
}
