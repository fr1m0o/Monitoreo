/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos.service;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Repartidor;
import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Ubicacion;
import com.ProyectoPedidos.Monitoreo_Pedidos.Model.UbicacionActual;
import com.ProyectoPedidos.Monitoreo_Pedidos.Repository.RepartidorRepository;
import com.ProyectoPedidos.Monitoreo_Pedidos.Repository.UbicacionActualRepository;
import com.ProyectoPedidos.Monitoreo_Pedidos.Repository.UbicacionRepository;
import com.ProyectoPedidos.Monitoreo_Pedidos_DTO.UbicacionDTO;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicolas
 */
@Service
public class UbicacionServiceImpl implements UbicacionService {
    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Autowired
    private UbicacionActualRepository ubicacionActualRepository;

    @Autowired
    private RepartidorRepository repartidorRepository;

  @Override
public void registrarUbicacion(UbicacionDTO dto) {
    // Validar que esté dentro de Argentina
    if (!estaEnArgentina(dto.getLatitud(), dto.getLongitud())) {
        throw new IllegalArgumentException("Ubicación fuera de Argentina.");
    }

    // Buscar el repartidor por ID
    Repartidor repartidor = repartidorRepository.findById(dto.getIdRepartidor())
        .orElseThrow(() -> new RuntimeException("Repartidor no encontrado"));

    // Guardar en historial de ubicaciones
    Ubicacion ubicacion = new Ubicacion();
    ubicacion.setLatitud(dto.getLatitud());
    ubicacion.setLongitud(dto.getLongitud());
    ubicacion.setRepartidor(repartidor);
    ubicacionRepository.save(ubicacion);

    // Guardar o actualizar última ubicación
    UbicacionActual actual = ubicacionActualRepository.findById(repartidor.getId())
        .orElseGet(() -> {
            UbicacionActual nueva = new UbicacionActual();
            nueva.setRepartidor(repartidor); // No seteamos manualmente el ID
            return nueva;
        });

    actual.setLatitud(dto.getLatitud());
    actual.setLongitud(dto.getLongitud());
    // fechaHora se setea automáticamente por @PrePersist/@PreUpdate
    ubicacionActualRepository.save(actual);
}



  private boolean estaEnArgentina(Double lat, Double lng) {
    // Coordenadas aproximadas del país:
    // Norte: -21.78 (Jujuy), Sur: -55.05 (Tierra del Fuego)
    // Oeste: -73.59 (Santa Cruz), Este: -53.64 (Misiones)
    return lat != null && lng != null &&
           lat >= -55.05 && lat <= -21.78 &&
           lng >= -73.59 && lng <= -53.64;
}

}



