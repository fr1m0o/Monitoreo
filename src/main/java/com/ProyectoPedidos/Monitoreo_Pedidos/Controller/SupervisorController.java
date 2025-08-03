/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos.Controller;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Supervisor;
import com.ProyectoPedidos.Monitoreo_Pedidos.service.SupervisorService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nicolas
 */
@RestController
@RequestMapping("supervisor")
public class SupervisorController {
 @Autowired
 private SupervisorService SS;
    
 @GetMapping
 public ArrayList<Supervisor>GetSupervisor(){
 
 
 
     return this.SS.obtenerSupervisor();
 
 
 
 }
    
 @PostMapping
 public Supervisor saveSupervisor(@RequestBody Supervisor supervisor1){
 
 
     return this.SS.guardarSupervisor(supervisor1);
 
 
 }

@GetMapping(path="/{id}")
public Optional<Supervisor>obtenerporID(@PathVariable("id")  Long id){



     return SS.GetBYId(id);



}

@PutMapping(path="/{id}")
public Supervisor cargarSupervisorPorID(@RequestBody Supervisor Sup1,@PathVariable Long id){


     return this.SS.UpdateById(Sup1, id);


}

@DeleteMapping(path="/{id}")
public String borrarSupervisor(@PathVariable("id") Long id){
boolean ok= this.SS.borrarSupervisor(id);
if(ok){
return "SUPERVISOR CON ID: " + id+"ELIMINADO";

}
     return "error";


}


}

