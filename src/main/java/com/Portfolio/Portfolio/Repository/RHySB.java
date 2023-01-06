package com.Portfolio.Portfolio.Repository;


import com.Portfolio.Portfolio.Entity.HySB;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHySB extends JpaRepository<HySB, Integer>{
    Optional<HySB> findByNombreB(String nombreB);
    public boolean existsByNombreB(String nombreB);
    
    
}