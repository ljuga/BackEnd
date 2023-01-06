package com.Portfolio.Portfolio.Controller;

import com.Portfolio.Portfolio.Dto.DtoHyS;
import com.Portfolio.Portfolio.Entity.HyS;
import com.Portfolio.Portfolio.Security.Controller.Mensaje;
import com.Portfolio.Portfolio.Service.SHyS;
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
@RequestMapping("/skill")
@CrossOrigin(origins = {"https://portfolio-jerel.web.app","http://localhost:4200"})
public class CHyS {

    @Autowired
    SHyS sHyS;

    @GetMapping("/lista")
    public ResponseEntity<List<HyS>> list() {
        List<HyS> list = sHyS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<HyS> getById(@PathVariable("id") int id) {
        if (!sHyS.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        HyS hys = sHyS.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHyS.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sHyS.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHyS dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sHyS.existByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa Skill ya Existe"), HttpStatus.BAD_REQUEST);

        }

        HyS hys = new HyS(dtohys.getNombre(), dtohys.getPorcentaje(), dtohys.getColor());
        sHyS.save(hys);

        return new ResponseEntity(new Mensaje("Skill Agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHyS dtohys) {
        //validamos si existe el id
        if (!sHyS.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        //validamos si existe el nombre
        if (sHyS.existByNombre(dtohys.getNombre()) && sHyS.getByNombre(dtohys.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        //no puede estar vacio
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        HyS hys = sHyS.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcentaje(dtohys.getPorcentaje());
        hys.setColor(dtohys.getColor());

        sHyS.save(hys);

        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }

}
