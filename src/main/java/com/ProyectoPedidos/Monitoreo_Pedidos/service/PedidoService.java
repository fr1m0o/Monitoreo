
package com.ProyectoPedidos.Monitoreo_Pedidos.service;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Repartidor;
import com.ProyectoPedidos.Monitoreo_Pedidos.Repository.RepartidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepo;

    public ArrayList<Pedido> obtenerPedidos() {
        ArrayList<Pedido> pedidos = (ArrayList<Pedido>) pedidoRepo.findAll();
        // Inicializar campos por si vinieran null
        for (Pedido p : pedidos) {
            if (p.getEstado() == null) p.setEstado(Pedido.EstadoPedido.EN_CAMINO);
            if (p.getFechaPedido() == null) p.setFechaPedido(LocalDateTime.now());
        }
        return pedidos;
    }

    public Pedido guardarPedido(Pedido pedido) {
        if (pedido.getEstado() == null) pedido.setEstado(Pedido.EstadoPedido.EN_CAMINO);
        if (pedido.getFechaPedido() == null) pedido.setFechaPedido(LocalDateTime.now());
        return pedidoRepo.save(pedido);
    }

    public Optional<Pedido> getById(Long id) {
        return pedidoRepo.findById(id);
    }

    public Pedido actualizarPedidoPorId(Pedido request, Long id) {
        Pedido pedido = pedidoRepo.findById(id).orElse(null);
        if (pedido == null) return null;

        pedido.setDescripcion(request.getDescripcion());
        pedido.setEstado(request.getEstado() != null ? request.getEstado() : Pedido.EstadoPedido.EN_CAMINO);
        pedido.setFechaPedido(request.getFechaPedido() != null ? request.getFechaPedido() : LocalDateTime.now());
        pedido.setFechaEntrega(request.getFechaEntrega());

        if (request.getRepartidor() != null) {
            pedido.setRepartidor(request.getRepartidor());
        }

        return pedidoRepo.save(pedido);
    }

    public boolean borrarPedido(Long id) {
        try {
            pedidoRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


