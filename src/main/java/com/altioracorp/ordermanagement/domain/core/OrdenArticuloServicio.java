package com.altioracorp.ordermanagement.domain.core;

import com.altioracorp.ordermanagement.api.model.OrdenArticuloDto;
import com.altioracorp.ordermanagement.api.model.RespuestaDto;
import com.altioracorp.ordermanagement.infraestructure.data.entities.Articulo;
import com.altioracorp.ordermanagement.infraestructure.data.entities.OrdenArticulo;
import com.altioracorp.ordermanagement.infraestructure.data.repository.ArticuloRepository;
import com.altioracorp.ordermanagement.infraestructure.data.repository.OrdenArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdenArticuloServicio {

    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    OrdenArticuloRepository ordenArticuloRepository;


    public RespuestaDto realizarMovimiento(OrdenArticuloDto solicitud)  throws Exception {


        Optional<Articulo> articuloOptional = articuloRepository.findById(solicitud.getArticuloId());
        Articulo articulo = new Articulo();
        if (articuloOptional.isPresent()) {
            articulo = articuloOptional.get();
            if (articulo.getStock() >= solicitud.getCantidad()) {
                Integer stock = articulo.getStock() - solicitud.getCantidad().intValue();
                articulo.setStock(stock);
                articuloRepository.save(articulo);
                OrdenArticulo ordenArticulo = new OrdenArticulo();
                ordenArticulo.setArticuloId(solicitud.getArticuloId());
                ordenArticulo.setOrdenId(solicitud.getOrdenId());
                ordenArticulo.setCantidad(solicitud.getCantidad());
                ordenArticuloRepository.save(ordenArticulo);

                RespuestaDto respuestaDto = new RespuestaDto();
                respuestaDto.setError("OK");
                respuestaDto.setMensaje("ok");
                return respuestaDto;
            }else {
                throw new Exception("Ocurrió un error");
            }

        }

        return null;
    }
}
