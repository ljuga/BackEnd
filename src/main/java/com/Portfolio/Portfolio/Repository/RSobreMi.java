package com.Portfolio.Portfolio.Repository;

import com.Portfolio.Portfolio.Entity.SobreMi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSobreMi extends JpaRepository<SobreMi, Integer> {

    public Optional<SobreMi> findBySobreMi(String sobreMi);

    public boolean existsBySobreMi(String sobreMi);
}
