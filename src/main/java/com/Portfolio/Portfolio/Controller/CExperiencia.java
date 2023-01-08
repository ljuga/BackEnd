package com.Portfolio.Portfolio.Controller;

import com.Portfolio.Portfolio.Dto.DtoExperiencia;
import com.Portfolio.Portfolio.Entity.Experiencia;
import com.Portfolio.Portfolio.Security.Controller.Mensaje;
import com.Portfolio.Portfolio.Service.SExperiencia;
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
@RequestMapping("/explab")
@CrossOrigin(origins = {"https://portfolio-jerel.web.app","http://localhost:4200"})
public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sExperiencia.existByNombreE(dtoExp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa Experiencia ya Existe"), HttpStatus.BAD_REQUEST);

        }

        Experiencia experiencia = new Experiencia(dtoExp.getNombreE(), dtoExp.getNombreE2(), dtoExp.getDescripcionE(), dtoExp.getImgE());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExp) {
        //validamos si existe el id
        if (!sExperiencia.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        //validamos si existe el nombre
        if (sExperiencia.existByNombreE(dtoExp.getNombreE()) && sExperiencia.getByNombreE(dtoExp.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        //no puede estar vacio  
        if (StringUtils.isBlank(dtoExp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoExp.getNombreE());
        experiencia.setNombreE2(dtoExp.getNombreE2());
        experiencia.setDescripcionE(dtoExp.getDescripcionE());
        experiencia.setImgE(dtoExp.getImgE());

        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

    }
}
