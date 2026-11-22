fun main() {

    // Listar todos los videojuegos
    println("Lista de videojuegos:")
    VideojuegosDAO.listarVideojuegos().forEach {
        println(" - [${it.id}] ${it.titulo} (${it.genero}), anio: ${it.anio}, nota: ${it.nota}€")
    }

    // Consultar videojuego por ID
    val videojuego = VideojuegosDAO.consultarVideoPorId(3)
    if (videojuego != null) {
        println("Videojuego encontrado: [${videojuego.id}] ${videojuego.titulo} (${videojuego.genero}), Año: ${videojuego.anio}, Nota: ${videojuego.nota}€")
    } else {
        println("No se encontró ningun videojuego con ese ID.")
    }

    // Insertar Videojuego nuevo
    VideojuegosDAO.insertarVideojuego(
        Videojuego(
            id = 6,
            titulo = "Fortnite",
            genero = "Battle Royale",
            anio = 2019,
            nota = 4.5
        )
    )

    // Actualizar planta con id=1 (Zelda)
    VideojuegosDAO.actualizarVideojuego(
        Videojuego(
            id = 1,
            titulo = "The Legend of Zelda: Breath of the Wild",
            genero = "Aventura",
            anio = 2017,
            nota = 9.75 //actualiceé esta nota, de 9,5 que tenía antes a 9,75
        )
    )


    ListaVideojuegoDAO.anyadirALista(1, 3, "2026-11-22")
    ListaVideojuegoDAO.anyadirALista(1, 999, "2026-11-22")


    VideojuegosDAO.eliminarVideojuego(7)

    ConexionBD.testConnection()





}