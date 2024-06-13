package com.altioracorp.ordermanagement.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdenArticuloDto {
    private Long ordenId;
    private Long articuloId;
    private Long cantidad;
}


