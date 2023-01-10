package com.Portfolio.Portfolio.Repository;

import com.Portfolio.Portfolio.Entity.HyS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHyS extends JpaRepository<HyS, Integer>{
    Optional<HyS> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
    
    
}
