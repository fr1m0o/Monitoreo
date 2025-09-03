# 🖥️ Monitoreo de Pedidos - Aplicación de Escritorio

Aplicación de escritorio desarrollada en **JavaFX** para supervisar pedidos en tiempo real, conectada a una API REST construida en **Spring Boot**.  
Permite listar, actualizar y visualizar el estado de pedidos, mostrando información relevante como fechas y repartidor asignado.

---

## 🚀 Características

- **Consumo de API REST** para obtener pedidos en tiempo real.
- **Tabla interactiva (`TableView`)** que muestra:
  - ID del pedido
  - Descripción
  - Estado (con estilos visuales)
  - Fecha de pedido y entrega
  - Nombre del repartidor
- **Interfaz responsiva** usando FXML y JavaFX.
- **Arquitectura modular**: separación clara entre controladores, vistas y modelo.
- Preparada para futuras funcionalidades:
  - Asignación de repartidores desde ComboBox.
  - Edición y eliminación de pedidos.
  - Integración con mapas para ver ubicación de repartidores.

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java 24  
- **Framework:** JavaFX (FXML, TableView, Scene Builder)  
- **Gestor de dependencias:** Maven  
- **Backend:** API REST en Spring Boot + MySQL  
- **Librerías:** Jackson (`ObjectMapper`), HttpURLConnection  
- **Control de versiones:** Git y GitHub  

---
