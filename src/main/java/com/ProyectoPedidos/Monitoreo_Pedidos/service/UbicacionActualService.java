/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos.service;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.UbicacionActual;
import com.ProyectoPedidos.Monitoreo_Pedidos_DTO.UbicacionActualDTO;

/**
 *
 * @author nicolas
 */
public interface UbicacionActualService {
      UbicacionActualDTO obtenerUltimaUbicacion(Long idRepartidor);
}
