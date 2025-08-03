/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos.Repository;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Pedido;
import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nicolas
 */
@Repository
public interface RepartidorRepository  extends JpaRepository<Repartidor, Long>  {
    
}
