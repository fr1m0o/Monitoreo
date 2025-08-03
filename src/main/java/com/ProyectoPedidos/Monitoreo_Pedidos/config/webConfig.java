/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoPedidos.Monitoreo_Pedidos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author nicolas
 */
@Configuration
public class webConfig implements  WebMvcConfigurer{
      @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapea las peticiones al challenge de Let's Encrypt
        registry.addResourceHandler("/.well-known/acme-challenge/**")
                .addResourceLocations("file:C:/ProgramData/win-acme/acme-v02.api.letsencrypt.org/.well-known/acme-challenge/");
    }
}
