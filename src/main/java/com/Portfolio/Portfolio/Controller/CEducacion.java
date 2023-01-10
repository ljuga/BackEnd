package com.Portfolio.Portfolio.Controller;

import com.Portfolio.Portfolio.Dto.DtoEducacion;
import com.Portfolio.Portfolio.Entity.Educacion;
import com.Portfolio.Portfolio.Security.Controller.Mensaje;
import com.Portfolio.Portfolio.Service.SEducacion;
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
@RequestMapping("/edu")
@CrossOrigin(origins = {"https://portfolio-jerel.web.app", "http://localhost:4200"})
public class CEducacion {

    @Autowired
    SEducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!sEducacion.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreED())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sEducacion.existByNombreED(dtoExp.getNombreED())) {
            return new ResponseEntity(new Mensaje("Esa Educacion ya Existe"), HttpStatus.BAD_REQUEST);

        }

        Educacion educacion = new Educacion(dtoExp.getNombreED(), dtoExp.getNombreED2(), dtoExp.getDescripcionED(), dtoExp.getImgED());
        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion Agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoExp) {
        //validamos si existe el id
        if (!sEducacion.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        //validamos si existe el nombre
        if (sEducacion.existByNombreED(dtoExp.getNombreED()) && sEducacion.getByNombreED(dtoExp.getNombreED()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Educacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        //no puede estar vacio  
        if (StringUtils.isBlank(dtoExp.getNombreED())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreED(dtoExp.getNombreED());
        educacion.setNombreED2(dtoExp.getNombreED2());
        educacion.setDescripcionED(dtoExp.getDescripcionED());
        educacion.setImgED(dtoExp.getImgED());

        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);

    }
}
