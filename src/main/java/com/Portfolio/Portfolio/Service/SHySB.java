package com.Portfolio.Portfolio.Service;


import com.Portfolio.Portfolio.Entity.HySB;
import com.Portfolio.Portfolio.Repository.RHySB;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional

@Service
public class SHySB {
    @Autowired
    RHySB rHySB;
    
    
    public List<HySB> list() {
        return rHySB.findAll();
    }

    public Optional<HySB> getOne(int id) {
        return rHySB.findById(id);
    }

    public Optional<HySB> getByNombreB(String nombreB) {
        return rHySB.findByNombreB(nombreB);
    }

    public void save(HySB skillB) {
        rHySB.save(skillB);
    }

    public void delete(int id) {
        rHySB.deleteById(id);
    }
    
    public boolean existById(int id){
    return rHySB.existsById(id);
    }
    
    public boolean existByNombreB(String nombreB){
    return rHySB.existsByNombreB(nombreB);
    }
    
}
