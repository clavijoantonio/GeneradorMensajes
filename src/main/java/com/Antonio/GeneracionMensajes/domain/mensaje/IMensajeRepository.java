package com.Antonio.GeneracionMensajes.domain.mensaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMensajeRepository extends JpaRepository<Menssage, Long> {
}
