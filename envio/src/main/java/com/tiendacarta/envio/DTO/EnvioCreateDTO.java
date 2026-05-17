package com.tiendacarta.envio.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioCreateDTO {
    
    @NotBlank(message = "la Dirrecion de envio no puede estar vacia")
    private String dirrecionenvi;
    /*comprador */
    @NotBlank(message = "debe ingresar un comprador ")
    private String comprador;
    @NotBlank(message = "debe ingresar un vendedor")
    private String vendedor;
    /*tienda de orrigen de donde sale en producto */
    @NotBlank(message = "debe ingresar una tienda de origen si el producto no es de una tienda origen Coloque tienda personal")
    private String tiendaorigen;
    /*detalle de producto */
    @NotBlank(message = "debe ingresar los dettales del producto ")
    private String detalleproducto;
    @NotBlank(message = "debe ingresar la empresa de envio si no hay niguna colocar repartidor propio  ")
    private String empresadeenvio;

}
