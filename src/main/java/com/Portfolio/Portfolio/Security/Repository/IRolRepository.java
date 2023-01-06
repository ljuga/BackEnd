
package com.Portfolio.Portfolio.Security.Repository;

import com.Portfolio.Portfolio.Security.Entity.Rol;
import com.Portfolio.Portfolio.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepositoryImplementation<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
