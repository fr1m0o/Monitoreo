package com.ProyectoPedidos.Monitoreo_Pedidos.Controller;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Pedido;
import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Repartidor;
import com.ProyectoPedidos.Monitoreo_Pedidos.Repository.RepartidorRepository;
import com.ProyectoPedidos.Monitoreo_Pedidos.service.PedidoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public ArrayList<Pedido> obtenerPedidos() {
        return pedidoService.obtenerPedidos();
    }

    @PostMapping
    public Pedido guardarPedido(@RequestBody Pedido pedido) {
        return pedidoService.guardarPedido(pedido);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> obtenerPedidoPorId(@PathVariable("id") Long id) {
        return pedidoService.getById(id);
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(@RequestBody Pedido pedido, @PathVariable("id") Long id) {
        return pedidoService.actualizarPedidoPorId(pedido, id);
    }

    @DeleteMapping("/{id}")
    public String eliminarPedido(@PathVariable("id") Long id) {
        boolean ok = pedidoService.borrarPedido(id);
        return ok ? "Pedido con ID " + id + " eliminado." : "Error al eliminar el pedido.";
    }
    
    


    
    
}
