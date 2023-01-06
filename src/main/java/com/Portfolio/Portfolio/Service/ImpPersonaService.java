package com.Portfolio.Portfolio.Service;

import com.Portfolio.Portfolio.Entity.Persona;
import com.Portfolio.Portfolio.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {

    @Autowired
    IPersonaRepository ipersonaRepository;

      public List<Persona> list() {
        return ipersonaRepository.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return ipersonaRepository.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return ipersonaRepository.findByNombre(nombre);
    }

    public void save(Persona pers) {
        ipersonaRepository.save(pers);
    }

    public void delete(int id) {
        ipersonaRepository.deleteById(id);
    }
    
    public boolean existById(int id){
    return ipersonaRepository.existsById(id);
    }
    
    public boolean existByNombre(String nombre){
    return ipersonaRepository.existsByNombre(nombre);
    }
}
