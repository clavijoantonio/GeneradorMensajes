package com.Antonio.GeneracionMensajes.Controller;

import com.Antonio.GeneracionMensajes.domain.mensaje.DatosMensaje;
import com.Antonio.GeneracionMensajes.domain.mensaje.IMensajeRepository;
import com.Antonio.GeneracionMensajes.domain.mensaje.Menssage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {
    
	@Autowired
    private IMensajeRepository mensajeRepository;

    @GetMapping
    public List<Menssage> recibirMensaje (){
        return mensajeRepository.findAll();
    }
    @PostMapping
    @Transactional
    public ResponseEntity<DatosMensaje> enviarMensaje(@RequestBody @Valid DatosMensaje datos, UriComponentsBuilder uriComponentsBuilder){
       Menssage mensaje = mensajeRepository.save(new Menssage(datos));
       DatosMensaje datosMensaje= new DatosMensaje(mensaje.getMensaje(), mensaje.getNombre(), mensaje.getFecha().toString() );
       URI uri= uriComponentsBuilder.path("/mensaje/{id}").buildAndExpand(mensaje.getId()).toUri();
       return ResponseEntity.created(uri).body(datosMensaje);
    }
}
