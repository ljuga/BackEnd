package com.Portfolio.Portfolio.Service;

import com.Portfolio.Portfolio.Entity.Educacion;
import com.Portfolio.Portfolio.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {

    @Autowired
    REducacion rEducacion;

    public List<Educacion> list() {
        return rEducacion.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return rEducacion.findById(id);
    }

    public Optional<Educacion> getByNombreED(String nombreED) {
        return rEducacion.findByNombreED(nombreED);
    }

    public void save(Educacion expe) {
        rEducacion.save(expe);
    }

    public void delete(int id) {
        rEducacion.deleteById(id);
    }

    public boolean existById(int id) {
        return rEducacion.existsById(id);
    }

    public boolean existByNombreED(String nombreED) {
        return rEducacion.existsByNombreED(nombreED);
    }
}
