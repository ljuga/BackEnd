package com.Portfolio.Portfolio.Service;

import com.Portfolio.Portfolio.Entity.SobreMi;
import com.Portfolio.Portfolio.Repository.RSobreMi;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSobreMi {
    
    @Autowired
    RSobreMi rSobreMi;
    
     public List<SobreMi> list() {
        return rSobreMi.findAll();
    }

    public Optional<SobreMi> getOne(int id) {
        return rSobreMi.findById(id);
    }

    public Optional<SobreMi> getByNombreE(String sobreMi) {
        return rSobreMi.findBySobreMi(sobreMi);
    }

    public void save(SobreMi Smi) {
        rSobreMi.save(Smi);
    }

    public void delete(int id) {
        rSobreMi.deleteById(id);
    }
    
    public boolean existById(int id){
    return rSobreMi.existsById(id);
    }
    
    public boolean existBySobreMi(String sobreMi){
    return rSobreMi.existsBySobreMi(sobreMi);
    }
}
