# Chat en Red — Java Sockets

Aplicación de chat en tiempo real con arquitectura cliente-servidor. Varios usuarios pueden conectarse y enviarse mensajes grupales o privados a través de una interfaz gráfica.

---

## Tecnologías

- Java SE + Swing
- Sockets TCP
- Hilos (Thread / Runnable)
- NetBeans IDE

---

## Cómo ejecutar

**1. Iniciar el servidor**

Correr la clase `MainServidor`. Queda escuchando en el puerto 5000.

**2. Iniciar el cliente**

Correr la clase `MainCliente`. Se abre una ventana de login donde hay que ingresar un nombre de usuario (3–12 caracteres, sin espacios) y, opcionalmente, un correo. Al hacer clic en **Conectarse** se accede al chat.

> El cliente se conecta por defecto a `localhost:5000`. Para usarlo en red, cambiar la IP en `Cliente.java`.

---

## Funcionalidades

- Mensajes grupales y privados entre usuarios conectados
- Notificación automática cuando alguien entra o sale
- Historial de conversaciones separado por contacto
- Contador de usuarios conectados en tiempo real

---
