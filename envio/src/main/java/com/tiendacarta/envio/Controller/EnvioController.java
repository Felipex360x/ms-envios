package com.tiendacarta.envio.Controller;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendacarta.envio.DTO.EnvioCreateDTO;
import com.tiendacarta.envio.DTO.EnvioDTO;
import com.tiendacarta.envio.Service.EnvioService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;


    @GetMapping
    public ResponseEntity<List<EnvioDTO>>getAll(){
        return ResponseEntity.ok(envioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(envioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EnvioDTO> crear(@Valid @RequestBody EnvioCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(envioService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvioDTO> actualizar(@PathVariable Long id, @Valid @RequestBody EnvioCreateDTO dto) {
        return ResponseEntity.ok(envioService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        envioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
