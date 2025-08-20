package com.ProyectoPedidos.Monitoreo_Pedidos.Controller;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Pedido;
import com.ProyectoPedidos.Monitoreo_Pedidos.service.PedidoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // GET - Listar todos los pedidos
    @GetMapping
    public List<Pedido> obtenerPedidos() {
        return pedidoService.obtenerPedidos();
    }

    // POST - Guardar pedido
    @PostMapping
    public Pedido guardarPedido(@RequestBody Pedido pedido) {
        return pedidoService.guardarPedido(pedido);
    }

    // GET por ID
    @GetMapping("/{id}")
    public Optional<Pedido> obtenerPedidoPorId(@PathVariable Long id) {
        return pedidoService.getById(id);
    }

    // PUT - Actualizar pedido
    @PutMapping("/{id}")
    public Pedido actualizarPedido(@RequestBody Pedido pedido, @PathVariable Long id) {
        return pedidoService.actualizarPedidoPorId(pedido, id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String eliminarPedido(@PathVariable Long id) {
        boolean ok = pedidoService.borrarPedido(id);
        return ok ? "Pedido con ID " + id + " eliminado." : "Error al eliminar el pedido.";
    }
}
