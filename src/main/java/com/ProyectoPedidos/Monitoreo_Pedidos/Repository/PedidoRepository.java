package com.ProyectoPedidos.Monitoreo_Pedidos.Repository;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


}