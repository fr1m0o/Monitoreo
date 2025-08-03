package com.ProyectoPedidos.Monitoreo_Pedidos.Controller;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Repartidor;
import com.ProyectoPedidos.Monitoreo_Pedidos.service.RepartidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/repartidor")
@CrossOrigin(origins = "*")
public class RepartidorController {

    @Autowired
    private RepartidorService repartidorService;

    // GET - Listar todos los repartidores
    @GetMapping
    public ArrayList<Repartidor> obtenerRepartidores() {
        return repartidorService.obtenerRepartidores();
    }

    // GET - Obtener repartidor por ID
    @GetMapping("/{id}")
    public Optional<Repartidor> obtenerRepartidorPorId(@PathVariable("id") Long id) {
        return repartidorService.getById(id);
    }

    // POST - Crear nuevo repartidor
    @PostMapping
    public Repartidor guardarRepartidor(@RequestBody Repartidor repartidor) {
        return repartidorService.guardarRepartidor(repartidor);
    }

    // PUT - Actualizar repartidor existente
    @PutMapping("/{id}")
    public Repartidor actualizarRepartidor(@RequestBody Repartidor repartidor, @PathVariable("id") Long id) {
        return repartidorService.actualizarRepartidorPorId(repartidor, id);
    }

    // DELETE - Eliminar repartidor
    @DeleteMapping("/{id}")
    public String borrarRepartidor(@PathVariable("id") Long id) {
        boolean ok = repartidorService.borrarRepartidor(id);
        return ok ? "Repartidor eliminado correctamente" : "Error al eliminar el repartidor";
    }
}
    