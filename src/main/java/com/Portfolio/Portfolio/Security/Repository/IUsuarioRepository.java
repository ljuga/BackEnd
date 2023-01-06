
package com.Portfolio.Portfolio.Security.Repository;


import com.Portfolio.Portfolio.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepositoryImplementation< Usuario, Integer>{
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    
}
