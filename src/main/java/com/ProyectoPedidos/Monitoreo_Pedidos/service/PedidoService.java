package com.ProyectoPedidos.Monitoreo_Pedidos.service;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Pedido;
import com.ProyectoPedidos.Monitoreo_Pedidos.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepo;

    public ArrayList<Pedido> obtenerPedidos() {
        return (ArrayList<Pedido>) pedidoRepo.findAll();
    }

    public Pedido guardarPedido(Pedido pedido) {
        // Verifica que haya repartidor asignado y que exista
        if (pedido.getRepartidor() != null && pedido.getRepartidor().getId() == null) {
            pedido.setRepartidor(null); // Evita error si repartidor no existe
        }
        return pedidoRepo.save(pedido);
    }

    public Optional<Pedido> getById(Long id) {
        return pedidoRepo.findById(id);
    }

    public Pedido actualizarPedidoPorId(Pedido request, Long id) {
        Pedido pedido = pedidoRepo.findById(id).orElse(null);
        if (pedido == null) return null;

        pedido.setDescripcion(request.getDescripcion());
        pedido.setEstado(request.getEstado());
        pedido.setFechaPedido(request.getFechaPedido());
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
