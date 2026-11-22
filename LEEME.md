# Catálogo de Videojuegos

Aplicación de consola en Kotlin para gestionar videojuegos, jugadores y listas. Usa PostgreSQL con JDBC y el patrón DAO.

## Base de datos

Tiene 4 tablas:

- `videojuegos`: los videojuegos del catálogo.
- `jugadores`: los jugadores.
- `listas`: cada lista pertenece a un jugador (FK `id_jugador`).
- `listas_videojuegos`: une listas y videojuegos.

```
jugadores 1 ---- N listas N ---- N videojuegos (con listas_videojuegos)
```

El esquema y los datos de prueba están en `datos/videojuegos.sql`.

## Cómo ejecutarlo

1. Instala PostgreSQL y crea una base de datos llamada `videojuegos`.
2. Ejecuta el script `datos/videojuegos.sql` en esa base de datos.
3. En `ConexionBD.kt` pon tu usuario y contraseña de PostgreSQL.
4. Ejecuta `Main.kt`.

## Decisiones de diseño

- **Tabla `jugadores`:** tiene `id_jugador` (clave primaria) y `nombre`.
- **Relación con listas:** `listas` tiene la clave foránea `id_jugador`, así que toda lista pertenece a un jugador. Si el jugador no existe, la lista no se crea.
- **Borrado:** uso `ON DELETE CASCADE`. Al eliminar un jugador se eliminan sus listas.
- **Añadir a una lista:** se hace con una transacción. Si falla, se hace `rollback`.
- **PostgreSQL:** elegí PostgreSQL porque [escribe aquí tu motivo].