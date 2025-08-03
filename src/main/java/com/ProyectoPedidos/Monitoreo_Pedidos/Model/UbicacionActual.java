package com.ProyectoPedidos.Monitoreo_Pedidos.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ubicacion_actual")
public class UbicacionActual {

    @Id
    @Column(name = "id_repartidor")
    private Long idRepartidor;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_repartidor")
    private Repartidor repartidor;

    private Double latitud;
    private Double longitud;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @PrePersist
    @PreUpdate
    protected void setFechaHora() {
        this.fechaHora = LocalDateTime.now();
    }
}
