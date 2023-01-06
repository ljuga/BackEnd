package com.Portfolio.Portfolio.Controller;

import com.Portfolio.Portfolio.Dto.DtoHySB;
import com.Portfolio.Portfolio.Entity.HySB;
import com.Portfolio.Portfolio.Security.Controller.Mensaje;
import com.Portfolio.Portfolio.Service.SHySB;
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
@RequestMapping("/skillB")
@CrossOrigin(origins = {"https://portfolio-jerel.web.app","http://localhost:4200"})
public class CHySB {

    @Autowired
    SHySB sHySB;

    @GetMapping("/lista")
    public ResponseEntity<List<HySB>> list() {
        List<HySB> list = sHySB.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<HySB> getById(@PathVariable("id") int id) {
        if (!sHySB.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        HySB hysB = sHySB.getOne(id).get();
        return new ResponseEntity(hysB, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHySB.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sHySB.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHySB dtohysB) {
        if (StringUtils.isBlank(dtohysB.getNombreB())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sHySB.existByNombreB(dtohysB.getNombreB())) {
            return new ResponseEntity(new Mensaje("Esa Skill ya Existe"), HttpStatus.BAD_REQUEST);

        }

        HySB hysB = new HySB(dtohysB.getNombreB(), dtohysB.getPorcentajeB(), dtohysB.getColorB());
        sHySB.save(hysB);

        return new ResponseEntity(new Mensaje("Skill Agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHySB dtohysB) {
        //validamos si existe el id
        if (!sHySB.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        //validamos si existe el nombre
        if (sHySB.existByNombreB(dtohysB.getNombreB()) && sHySB.getByNombreB(dtohysB.getNombreB()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        //no puede estar vacio
        if (StringUtils.isBlank(dtohysB.getNombreB())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        HySB hysB = sHySB.getOne(id).get();
        hysB.setNombreB(dtohysB.getNombreB());
        hysB.setPorcentajeB(dtohysB.getPorcentajeB());
        hysB.setColorB(dtohysB.getColorB());

        sHySB.save(hysB);

        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }

}
