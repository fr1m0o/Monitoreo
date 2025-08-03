/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos.service;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Supervisor;
import com.ProyectoPedidos.Monitoreo_Pedidos.Repository.SupervisorRepository;
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
public class SupervisorService {
    @Autowired
    SupervisorRepository SPR;
    
    public ArrayList<Supervisor>obtenerSupervisor(){
    
    
    
        return (ArrayList<Supervisor>)SPR.findAll();
   }


public Supervisor guardarSupervisor(Supervisor supervisor){



        return SPR.save(supervisor);



}

public Optional<Supervisor>GetBYId(Long id){


        return SPR.findById(id);


}

public Supervisor UpdateById(Supervisor request, Long id) {
    Supervisor sup = SPR.findById(id).get();
    sup.setNombre(request.getNombre());
    sup.setTelefono(request.getTelefono());
    sup.setEmail(request.getEmail());
    sup.setFechaAlta(LocalDateTime.now()); // o la fecha que quieras

    return SPR.save(sup); // 💡 Esto guarda los cambios en la base
}

public Boolean borrarSupervisor(Long id){
    try {
        SPR.deleteById(id);
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }

      

}



}
