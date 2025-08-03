package com.ProyectoPedidos.Monitoreo_Pedidos.service;

import com.ProyectoPedidos.Monitoreo_Pedidos.Model.Repartidor;
import com.ProyectoPedidos.Monitoreo_Pedidos.Repository.RepartidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RepartidorService {

    @Autowired
    private RepartidorRepository repartidorRepo;

    public ArrayList<Repartidor> obtenerRepartidores() {
        return (ArrayList<Repartidor>) repartidorRepo.findAll();
    }

    public Repartidor guardarRepartidor(Repartidor repartidor) {
        return repartidorRepo.save(repartidor);
    }

    public Optional<Repartidor> getById(Long id) {
        return repartidorRepo.findById(id);
    }

    public Repartidor actualizarRepartidorPorId(Repartidor request, Long id) {
        Repartidor repartidor = repartidorRepo.findById(id).orElse(null);
        if (repartidor == null) return null;

        repartidor.setNombre(request.getNombre());
        repartidor.setTelefono(request.getTelefono());
        repartidor.setEmail(request.getEmail());
        repartidor.setFechaAlta(request.getFechaAlta());

        return repartidorRepo.save(repartidor);
    }

    public boolean borrarRepartidor(Long id) {
        try {
            repartidorRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
