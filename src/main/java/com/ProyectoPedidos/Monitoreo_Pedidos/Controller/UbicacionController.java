package com.ProyectoPedidos.Monitoreo_Pedidos.Controller;


import com.ProyectoPedidos.Monitoreo_Pedidos.Model.UbicacionActual;
import com.ProyectoPedidos.Monitoreo_Pedidos.service.UbicacionActualService;
import com.ProyectoPedidos.Monitoreo_Pedidos.service.UbicacionService;
import com.ProyectoPedidos.Monitoreo_Pedidos_DTO.UbicacionActualDTO;
import com.ProyectoPedidos.Monitoreo_Pedidos_DTO.UbicacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ubicaciones")
@CrossOrigin(origins = "*")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @Autowired
    private UbicacionActualService ubicacionActualService;

    @PostMapping
    public ResponseEntity<String> registrarUbicacion(@RequestBody UbicacionDTO dto) {
        ubicacionService.registrarUbicacion(dto);
        return ResponseEntity.ok("Ubicación registrada");
    }

    @GetMapping("/actual/{idRepartidor}")
    public ResponseEntity<UbicacionActualDTO> obtenerUltimaUbicacion(@PathVariable Long idRepartidor) {
        try {
            UbicacionActualDTO dto = ubicacionActualService.obtenerUltimaUbicacion(idRepartidor);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}



