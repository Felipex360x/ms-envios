package com.tiendacarta.envio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioDTO {

    private Long id;
    private String dirrecionenvi;
    private String comprador;
    private String vendedor;
    private String tiendaorigen;
    private String detalleproducto;
    private String empresadeenvio;

}
