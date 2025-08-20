package com.ProyectoPedidos.Monitoreo_Pedidos.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_repartidor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Repartidor repartidor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPedido estado = EstadoPedido.EN_CAMINO;

    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido = LocalDateTime.now();

    @Column(name = "fecha_entrega")
    private LocalDateTime fechaEntrega;

    public enum EstadoPedido {
        EN_CAMINO,
        ENTREGADO,
        NO_ENTREGADO,
        DEMORADO;

        @JsonCreator
        public static EstadoPedido fromValue(String value) {
            return switch (value.toUpperCase()) {
                case "EN_CAMINO" -> EN_CAMINO;
                case "ENTREGADO" -> ENTREGADO;
                case "NO_ENTREGADO" -> NO_ENTREGADO;
                case "DEMORADO" -> DEMORADO;
                default -> throw new IllegalArgumentException("EstadoPedido desconocido: " + value);
            };
        }
    }
}
