fun leerTexto(mensaje: String): String { print(mensaje); return readLine() ?: "" }
fun leerEntero(mensaje: String): Int { print(mensaje); return readLine()?.toIntOrNull() ?: -1 }
fun leerDecimal(mensaje: String): Double { print(mensaje); return readLine()?.toDoubleOrNull() ?: -1.0 }

fun mostrarMenu() {
    println("""
        ===== CATÁLOGO DE VIDEOJUEGOS =====

        --- VIDEOJUEGOS ---
        1. Ver todos los videojuegos
        2. Buscar videojuego por ID
        3. Añadir videojuego
        4. Modificar videojuego
        5. Eliminar videojuego

        --- JUGADORES ---
        6. Crear jugador
        7. Eliminar jugador

        --- LISTAS ---
        8. Crear lista
        9. Eliminar lista
        10. Añadir videojuego a una lista
        11. Ver videojuegos de una lista

        0. Salir
        ====================================

    """.trimIndent())
}

fun main() {
    var opcion: Int
    do {
        mostrarMenu()
        opcion = leerEntero("Escoge una opción: ")
        when (opcion) {
            1 -> VideojuegoDAO.listarVideojuegos().forEach {
                println(" - [${it.id}] ${it.titulo} (${it.genero}), año: ${it.anio}, nota: ${it.nota}")
            }
            2 -> {
                val v = VideojuegoDAO.consultarVideoPorId(leerEntero("ID del videojuego: "))
                println(v ?: "No se encontró ningún videojuego con ese ID.")
            }
            3 -> VideojuegoDAO.insertarVideojuego(Videojuego(
                titulo = leerTexto("Título: "),
                genero = leerTexto("Género: "),
                anio = leerEntero("Año: "),
                nota = leerDecimal("Nota: ")
            ))
            4 -> VideojuegoDAO.actualizarVideojuego(Videojuego(
                id = leerEntero("ID del videojuego a modificar: "),
                titulo = leerTexto("Nuevo título: "),
                genero = leerTexto("Nuevo género: "),
                anio = leerEntero("Nuevo año: "),
                nota = leerDecimal("Nueva nota: ")
            ))
            5 -> VideojuegoDAO.eliminarVideojuego(leerEntero("ID del videojuego a eliminar: "))
            6 -> JugadorDAO.insertarJugador(Jugador(nombre = leerTexto("Nombre del jugador: ")))
            7 -> JugadorDAO.eliminarJugador(leerEntero("ID del jugador a eliminar: "))
            8 -> ListaDAO.insertarLista(Lista(
                nombre = leerTexto("Nombre de la lista: "),
                idJugador = leerEntero("ID del jugador propietario: ")
            ))
            9 -> ListaDAO.eliminarLista(leerEntero("ID de la lista a eliminar: "))
            10 -> ListaVideojuegoDAO.anyadirALista(
                leerEntero("ID de la lista: "),
                leerEntero("ID del videojuego: "),
                leerTexto("Fecha (AAAA-MM-DD): ")
            )
            11 -> {
                val videojuegos = ListaVideojuegoDAO.obtenerVideojuegosDeLista(leerEntero("ID de la lista: "))
                if (videojuegos.isEmpty()) println("La lista está vacía o no existe.")
                else videojuegos.forEach { println(" - [${it.id}] ${it.titulo} (${it.genero}), año: ${it.anio}, nota: ${it.nota}") }
            }
            0 -> println("Hasta pronto.")
            else -> println("Opción no válida.")
        }
    } while (opcion != 0)
}