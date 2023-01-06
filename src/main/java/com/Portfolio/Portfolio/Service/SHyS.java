package com.Portfolio.Portfolio.Service;


import com.Portfolio.Portfolio.Entity.HyS;
import com.Portfolio.Portfolio.Repository.RHyS;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional

@Service
public class SHyS {
    @Autowired
    RHyS rHyS;
    
    
    public List<HyS> list() {
        return rHyS.findAll();
    }

    public Optional<HyS> getOne(int id) {
        return rHyS.findById(id);
    }

    public Optional<HyS> getByNombre(String nombre) {
        return rHyS.findByNombre(nombre);
    }

    public void save(HyS skill) {
        rHyS.save(skill);
    }

    public void delete(int id) {
        rHyS.deleteById(id);
    }
    
    public boolean existById(int id){
    return rHyS.existsById(id);
    }
    
    public boolean existByNombre(String nombre){
    return rHyS.existsByNombre(nombre);
    }
    
}
