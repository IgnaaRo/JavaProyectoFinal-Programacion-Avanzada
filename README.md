# Chat en Red — Java Sockets

Aplicación de mensajería en tiempo real desarrollada en Java, con arquitectura cliente-servidor basada en sockets TCP. Permite que múltiples usuarios se conecten a un servidor central y se comuniquen mediante mensajes grupales o privados, todo a través de una interfaz gráfica construida con Swing.

---

## Características principales

- Mensajería grupal y mensajes privados entre usuarios conectados
- Detección automática de conexiones y desconexiones en tiempo real
- Historial de conversaciones separado por contacto (Grupo General / privado)
- Validación de nombre de usuario (3–12 caracteres, solo letras y números)
- Correo electrónico opcional con validación de formato
- Reloj en tiempo real visible en la interfaz del cliente
- Contador de usuarios conectados actualizado automáticamente
- El servidor asigna un sufijo numérico si el nombre elegido ya está en uso

---

## Tecnologías y herramientas

- Java SE (JDK 8 o superior)
- Java Swing + AbsoluteLayout (NetBeans GUI Builder)
- Sockets TCP (`java.net.Socket` / `ServerSocket`)
- Hilos (`Thread` / `Runnable`) para manejo concurrente de clientes
- Patrón de diseño MVC en el lado del cliente
- Patrón Singleton en el servidor
- NetBeans IDE

---

## Estructura del proyecto

```
ProyectoFinal/
├── src/
│   ├── proyectofinal/
│   │   ├── MainCliente.java       # Punto de entrada del cliente
│   │   └── MainServidor.java      # Punto de entrada del servidor
│   ├── Servidor/
│   │   ├── Servidor.java          # Servidor Singleton, escucha en puerto 5000
│   │   └── ClienteHilo.java       # Hilo por cliente conectado
│   └── Cliente/
│       ├── Controlador/
│       │   └── Controlador.java   # Lógica de eventos (login y chat)
│       ├── Modelo/
│       │   ├── Modelo.java        # Datos del usuario (nombre, correo)
│       │   └── Utils.java         # Validaciones de nombre y correo
│       ├── Network/
│       │   ├── Cliente.java       # Conexión al servidor y envío de mensajes
│       │   └── ClienteR.java      # Hilo receptor de mensajes entrantes
│       └── Vista/
│           ├── Login.java         # Ventana de registro/login
│           └── Vista.java         # Ventana principal del chat
```

---

## Cómo ejecutar

El proyecto se compone de dos programas independientes que deben correrse por separado.

### 1. Iniciar el servidor

Ejecutar la clase `MainServidor`. El servidor quedará a la escucha en el puerto **5000**.

```
proyectofinal.MainServidor
```

En consola debería aparecer:
```
=== Servidor iniciado ===
PUERTO 5000
```

### 2. Iniciar el cliente

Ejecutar la clase `MainCliente` (en la misma máquina o en otra dentro de la misma red).

```
proyectofinal.MainCliente
```

Se abrirá la ventana de login. Completar el nombre de usuario (obligatorio) y, opcionalmente, el correo. Hacer clic en **Conectarse**.

> Por defecto el cliente intenta conectarse a `localhost:5000`. Para conectarse desde otra máquina hay que modificar la IP en `Cliente.java`.

---

## Protocolo de mensajes

La comunicación entre cliente y servidor se realiza mediante cadenas de texto con prefijos que indican el tipo de evento:

| Prefijo | Dirección | Descripción |
|---|---|---|
| `NUEVO_USUARIO:<nombre>` | Servidor → Clientes | Notifica que un usuario se conectó |
| `USUARIO_DESCONECTADO:<nombre>` | Servidor → Clientes | Notifica que un usuario se fue |
| `PRIVADO:<destinatario>:<texto>` | Cliente → Servidor | Mensaje privado |
| *(sin prefijo)* | Ambas direcciones | Mensaje grupal |

---

## Validaciones de registro

- El nombre de usuario es obligatorio y debe tener entre 3 y 12 caracteres, solo letras y números, sin espacios ni caracteres especiales.
- Si el nombre ya lo usa otro cliente conectado, el servidor le agrega un número al final (ej: `Juan2`).
- El correo es opcional. Si se completa, debe tener un formato válido (`usuario@dominio.com`).

---

## Notas

- El servidor no persiste mensajes: al reiniciarlo se pierde el historial.
- La IP está hardcodeada como `localhost` en `Cliente.java`. Para entornos en red hay que reemplazarla por la IP del servidor.
- El proyecto fue desarrollado y probado en NetBeans; para compilarlo fuera del IDE puede requerirse incluir manualmente la librería `AbsoluteLayout.jar` en el classpath.
