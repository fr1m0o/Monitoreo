/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos.service;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Pedido;
import com.ProyectoPedidos.Monitoreo_Pedidos.Repository.PedidoRepository;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicolas
 */
@Service
public class PedidoService {
@Autowired
    PedidoRepository pedidoRepo;

 public ArrayList<Pedido> obtenerPedidos() {
        return (ArrayList<Pedido>) pedidoRepo.findAll();
    }

    public Pedido guardarPedido(Pedido pedido) {
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

    // Actualizar solo el nombre del repartidor si corresponde
    if (pedido.getRepartidor() != null && request.getRepartidor() != null) {
        pedido.getRepartidor().setNombre(request.getRepartidor().getNombre());
        // Podés agregar más campos si querés permitir editar otros datos:
        // pedido.getRepartidor().setTelefono(request.getRepartidor().getTelefono());
        // pedido.getRepartidor().setEmail(request.getRepartidor().getEmail());
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
