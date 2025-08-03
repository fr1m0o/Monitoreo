/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos.service;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.UbicacionActual;
import com.ProyectoPedidos.Monitoreo_Pedidos.Repository.UbicacionActualRepository;
import com.ProyectoPedidos.Monitoreo_Pedidos_DTO.UbicacionActualDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicolas
 */
@Service
public class UbicacionActualImpl implements UbicacionActualService {
    @Autowired
    private UbicacionActualRepository ubicacionActualRepository;

    @Autowired
    private GeocodingService geocodingService;

    @Override
    public UbicacionActualDTO obtenerUltimaUbicacion(Long idRepartidor) {
        UbicacionActual ubicacion = ubicacionActualRepository.findById(idRepartidor)
            .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));

        String direccion = geocodingService.obtenerDireccionDesdeCoordenadas(
            ubicacion.getLatitud(), ubicacion.getLongitud()
        );

        return new UbicacionActualDTO(
            ubicacion.getIdRepartidor(),
            ubicacion.getLatitud(),
            ubicacion.getLongitud(),
            ubicacion.getFechaHora(),
            direccion
        );
    }
}

    
    
    
    
    

