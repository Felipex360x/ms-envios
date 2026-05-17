package com.tiendacarta.envio.Model;


import jakarta.persistence.Id;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({
    "id","dirrecionenvi","tiendaorigen","vendedor",
    "comprador","detalleproducto","empresadeenvio"
    
})
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    /*dirrecion de envio */
    private String dirrecionenvi;
    /*comprador */
    private String comprador;
    private String vendedor;
    /*tienda de orrigen de donde sale en producto */
    private String tiendaorigen;
    /*detalle de producto */
    private String detalleproducto;
    private String empresadeenvio;



}
