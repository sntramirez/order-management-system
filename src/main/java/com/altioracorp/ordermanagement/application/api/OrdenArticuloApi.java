package com.altioracorp.ordermanagement.application.api;


import com.altioracorp.ordermanagement.api.model.OrdenArticuloDto;
import com.altioracorp.ordermanagement.api.model.RespuestaDto;
import com.altioracorp.ordermanagement.domain.core.OrdenArticuloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orden-articulo-api")
public class OrdenArticuloApi {

    @Autowired
    OrdenArticuloServicio ordenArticuloServicio;

    @PostMapping
    public ResponseEntity<RespuestaDto> movimientos(@RequestBody OrdenArticuloDto solicitud) {
        try {
            return new ResponseEntity<>(ordenArticuloServicio.realizarMovimiento(solicitud), HttpStatus.OK);
        } catch (Exception e) {
            RespuestaDto respuestaDto = new RespuestaDto();
            respuestaDto.setError("Error");
            respuestaDto.setMensaje("no existe stock");
            return new ResponseEntity<>(respuestaDto, HttpStatus.NOT_IMPLEMENTED);
        }
    }

}
