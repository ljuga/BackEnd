package com.Portfolio.Portfolio.Controller;

import com.Portfolio.Portfolio.Dto.DtoSobreMi;
import com.Portfolio.Portfolio.Entity.SobreMi;
import com.Portfolio.Portfolio.Security.Controller.Mensaje;
import com.Portfolio.Portfolio.Service.SSobreMi;
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
@RequestMapping("/sobremi")
@CrossOrigin(origins = {"https://portfolio-jerel.web.app","http://localhost:4200"})
public class CSobreMi {
    
    @Autowired
    SSobreMi sSobreMi;

    @GetMapping("/lista")
    public ResponseEntity<List<SobreMi>> list() {
        List<SobreMi> list = sSobreMi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<SobreMi> getById(@PathVariable("id") int id) {
        if (!sSobreMi.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        SobreMi sobreMi = sSobreMi.getOne(id).get();
        return new ResponseEntity(sobreMi, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSobreMi dtoSmi) {
        if (StringUtils.isBlank(dtoSmi.getSobreMi())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sSobreMi.existBySobreMi(dtoSmi.getSobreMi())) {
            return new ResponseEntity(new Mensaje("SobreMi ya Existe"), HttpStatus.BAD_REQUEST);

        }

        SobreMi sobreMi = new SobreMi(dtoSmi.getSobreMi(), dtoSmi.getSobreMiT());
        sSobreMi.save(sobreMi);

        return new ResponseEntity(new Mensaje("SobreMi Agregada"), HttpStatus.OK);
    }
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSobreMi dtoSmi) {
        //validamos si existe el id
        if (!sSobreMi.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        //validamos si existe el nombre
        if (sSobreMi.existBySobreMi(dtoSmi.getSobreMi()) && sSobreMi.getByNombreE(dtoSmi.getSobreMi()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese SobreMi ya existe"), HttpStatus.BAD_REQUEST);
        }

        //no puede estar vacio
        if (StringUtils.isBlank(dtoSmi.getSobreMi())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        SobreMi sobreMi = sSobreMi.getOne(id).get();
        sobreMi.setSobreMi(dtoSmi.getSobreMi());
        sobreMi.setSobreMiT(dtoSmi.getSobreMiT());


        sSobreMi.save(sobreMi);

        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSobreMi.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sSobreMi.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

    }
}
