/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Portfolio.Controller;

import com.Portfolio.Portfolio.Dto.DtoProyectos;
import com.Portfolio.Portfolio.Entity.Proyectos;
import com.Portfolio.Portfolio.Entity.SobreMi;
import com.Portfolio.Portfolio.Security.Controller.Mensaje;
import com.Portfolio.Portfolio.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proylab")
@CrossOrigin(origins = {"https://portfolio-jerel.web.app","http://localhost:4200"})

public class CProyectos {
    
    @Autowired
    SProyectos sProyectos;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<SobreMi>> list() {
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!sProyectos.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoproy) {
        if (StringUtils.isBlank(dtoproy.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sProyectos.existByNombreP(dtoproy.getNombreP())) {
            return new ResponseEntity(new Mensaje("SobreMi ya Existe"), HttpStatus.BAD_REQUEST);

        }

        Proyectos proyectos = new Proyectos(dtoproy.getNombreP(), dtoproy.getNombrePT(), dtoproy.getDescripcionP(), dtoproy.getNombreL());
        sProyectos.save(proyectos);

        return new ResponseEntity(new Mensaje("SobreMi Agregada"), HttpStatus.OK);
    }
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoproy) {
        //validamos si existe el id
        if (!sProyectos.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        //validamos si existe el nombre
        if (sProyectos.existByNombreP(dtoproy.getNombreP()) && sProyectos.getByNombreP(dtoproy.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese SobreMi ya existe"), HttpStatus.BAD_REQUEST);
        }

        //no puede estar vacio
        if (StringUtils.isBlank(dtoproy.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyecto = sProyectos.getOne(id).get();
        proyecto.setNombreP(dtoproy.getNombreP());
        proyecto.setNombrePT(dtoproy.getNombrePT());
        proyecto.setDescripcionP(dtoproy.getDescripcionP());
        proyecto.setNombreL(dtoproy.getNombreL());


        sProyectos.save(proyecto);

        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

    }
}
