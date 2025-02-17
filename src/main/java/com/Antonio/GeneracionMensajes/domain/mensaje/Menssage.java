package com.Antonio.GeneracionMensajes.domain.mensaje;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity(name="menssage")
@Table(name="mensaje")

public class Menssage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String mensaje;
    private LocalDateTime fecha;

    public Menssage() {

    }

    public Menssage(DatosMensaje datos) {
        this.nombre = datos.nombre();
        this.mensaje = datos.mensaje();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.fecha = LocalDateTime.parse(datos.fecha(),formatter);
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
