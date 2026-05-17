package com.tiendacarta.envio.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendacarta.envio.Model.Envio;
import com.tiendacarta.envio.Repository.EnvioRepository;

@Repository
public interface EnvioRepository  extends JpaRepository<Envio,Long>{

    
} 
