package com.ProyectoPedidos.Monitoreo_Pedidos.service;

import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodingService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String obtenerDireccionDesdeCoordenadas(double lat, double lon) {
        // Parámetros:
        // format=json -> para respuesta JSON
        // lat, lon -> coordenadas
        // zoom=19 -> máximo detalle
        // addressdetails=1 -> para que traiga detalle de dirección
        String url = String.format(
            "https://nominatim.openstreetmap.org/reverse?format=json&lat=%f&lon=%f&zoom=19&addressdetails=1",
            lat, lon
        );

        HttpHeaders headers = new HttpHeaders();
        // Cambiá el User-Agent por uno propio que identifique tu aplicación y correo real
        headers.set("User-Agent", "MiAppPedidos/1.0 (tu_email@dominio.com)");

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            request,
            Map.class
        );

        Map<String, Object> body = response.getBody();
        if (body != null && body.containsKey("display_name")) {
            return body.get("display_name").toString();
        }

        return "Dirección desconocida";
    }
}
