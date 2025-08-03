/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos.Repository;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Ubicacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nicolas
 */
public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {
    List<Ubicacion> findTop1ByRepartidorIdOrderByFechaHoraDesc(Long idRepartidor);
}
