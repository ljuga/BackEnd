package com.Portfolio.Portfolio.Security.Service;

import com.Portfolio.Portfolio.Security.Entity.Rol;
import com.Portfolio.Portfolio.Security.Enums.RolNombre;
import com.Portfolio.Portfolio.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {

    @Autowired
    IRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);

    }

    public void save(Rol rol) {
        irolRepository.save(rol);

    }

}
