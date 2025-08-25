package com.ProyectoPedidos.Monitoreo_Pedidos.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER) // cambiar a EAGER para que se cargue el repartidor
    @JoinColumn(name = "id_repartidor")
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
            if (value == null) return EN_CAMINO;
            return switch (value.toUpperCase()) {
                case "EN_CAMINO", "EN CAMINO" -> EN_CAMINO;
                case "ENTREGADO" -> ENTREGADO;
                case "NO_ENTREGADO", "NO ENTREGADO" -> NO_ENTREGADO;
                case "DEMORADO" -> DEMORADO;
                default -> EN_CAMINO; // valor por defecto para evitar errores de deserialización
            };
        }
    }
}

