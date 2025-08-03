/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
@Data
@Entity
@Table(name = "ubicaciones", indexes = {
    @Index(name = "idx_repartidor_fecha", columnList = "id_repartidor, fecha_hora")
})
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double latitud;

    @Column
    private Double longitud;

    @Column
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "id_repartidor", nullable = false)
    private Repartidor repartidor;
    
    
    @PrePersist
protected void onCreate() {
    this.fechaHora = LocalDateTime.now();
}


    // getters y setters
}
