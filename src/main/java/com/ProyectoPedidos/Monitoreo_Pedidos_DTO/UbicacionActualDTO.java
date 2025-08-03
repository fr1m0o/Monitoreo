/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos_DTO;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author nicolas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UbicacionActualDTO {
    private Long idRepartidor;
    private Double latitud;
    private Double longitud;
    private LocalDateTime fechaHora;
    private String direccion;
}

