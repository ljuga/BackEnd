package com.Portfolio.Portfolio.Controller;

import com.Portfolio.Portfolio.Dto.DtoPersona;
import com.Portfolio.Portfolio.Entity.Persona;
import com.Portfolio.Portfolio.Security.Controller.Mensaje;
import com.Portfolio.Portfolio.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = {"https://portfolio-jerel.web.app","http://localhost:4200"})
public class PersonaController {

    @Autowired
    ImpPersonaService sPersona;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!sPersona.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

     @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPers) {
        if (StringUtils.isBlank(dtoPers.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sPersona.existByNombre(dtoPers.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa Persona ya Existe"), HttpStatus.BAD_REQUEST);

        }

        Persona persona = new Persona(dtoPers.getNombre(), dtoPers.getApellido(), dtoPers.getImg());
        sPersona.save(persona);

        return new ResponseEntity(new Mensaje("Persona Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPers) {
        //validamos si existe el id
        if (!sPersona.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        //validamos si existe el nombre
        if (sPersona.existByNombre(dtoPers.getNombre()) && sPersona.getByNombre(dtoPers.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Persona ya existe"), HttpStatus.BAD_REQUEST);
        }

        //no puede estar vacio  
        if (StringUtils.isBlank(dtoPers.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = sPersona.getOne(id).get();
        persona.setNombre(dtoPers.getNombre());
        persona.setApellido(dtoPers.getApellido());
        persona.setImg(dtoPers.getImg());

        sPersona.save(persona);

        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sPersona.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sPersona.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);

    }*/
}
