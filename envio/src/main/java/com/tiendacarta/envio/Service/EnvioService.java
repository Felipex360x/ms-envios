package com.tiendacarta.envio.Service;

import java.util.List;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tiendacarta.envio.Repository.EnvioRepository;
import com.tiendacarta.envio.DTO.EnvioDTO;
import com.tiendacarta.envio.Exception.RecursoNoEncontradoException;
import com.tiendacarta.envio.DTO.EnvioCreateDTO;
import com.tiendacarta.envio.Model.Envio;


@Service
public class EnvioService {

    private static final Logger Log =LoggerFactory.getLogger(EnvioService.class);

    @Autowired
    private EnvioRepository envioRepository;

    public List<EnvioDTO> findAll(){
        Log.info("Consultadondo a todos los Envios");
        return envioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public EnvioDTO findById(Long id){
        Log.info("Buscando Envio id={}",id);
        Envio e = envioRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Envio no encontrado:"+id));
        Log.info("Envio encotrado:", e.getComprador() ,e.getVendedor());
        return toDTO(e);
    }

    public EnvioDTO crear(EnvioCreateDTO dto){
        Log.info("creando al Envio id={}",dto.getDirrecionenvi());
        Envio e = new Envio();
        e.setDirrecionenvi(dto.getDirrecionenvi());
        e.setComprador(dto.getComprador());
        e.setVendedor(dto.getVendedor());
        e.setTiendaorigen(dto.getTiendaorigen());
        e.setDetalleproducto(dto.getDetalleproducto());
        e.setEmpresadeenvio(dto.getEmpresadeenvio());
        Envio guardar = envioRepository.save(e);
        Log.info("Envio creado id={}",guardar.getId());
        return toDTO(guardar);
    }

    public EnvioDTO actualizar(Long id,EnvioCreateDTO dto){
        Log.info("actualizando Envio id ={}",id);
        Envio e = envioRepository.findById(id) .orElseThrow(()-> new RecursoNoEncontradoException("Envio no encotrado:" +id));
        e.setDirrecionenvi(dto.getDirrecionenvi());
        e.setComprador(dto.getComprador());
        e.setVendedor(dto.getVendedor());
        e.setTiendaorigen(dto.getTiendaorigen());
        e.setDetalleproducto(dto.getDetalleproducto());
        e.setEmpresadeenvio(dto.getEmpresadeenvio());
        return toDTO(envioRepository.save(e));
    }

    public void eliminar(Long id) {
        Log.info("Eliminando Envio id={}", id);
        if (!envioRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Envio no encontrado: " + id);
        }
        envioRepository.deleteById(id);
        Log.info("Envio id={} eliminado", id);
    }


    private EnvioDTO toDTO(Envio e) {
        return new EnvioDTO(
            e.getId(),
            e.getDirrecionenvi(),
            e.getComprador(),
            e.getVendedor(),
            e.getTiendaorigen(),
            e.getDetalleproducto(),
            e.getEmpresadeenvio()
        );
    
    }


}
