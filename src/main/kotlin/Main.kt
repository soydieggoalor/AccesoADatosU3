fun main() {

    // Listar todos los videojuegos
    println("Lista de videojuegos:")
    VideojuegosDAO.listarVideojuegos().forEach {
        println(" - [${it.id}] ${it.titulo} (${it.genero}), stock: ${it.anio} unidades, precio: ${it.nota}€")
    }

    // Consultar videojuego por ID
    val videojuego = VideojuegosDAO.consultarVideoPorId(3)
    if (videojuego != null) {
        println("Videojuego encontrado: [${videojuego.id}] ${videojuego.titulo} (${videojuego.genero}), stock: ${videojuego.anio} unidades, precio: ${videojuego.nota}€")
    } else {
        println("No se encontró ningun videojuego con ese ID.")
    }

    // Insertar Videojuego nuevo
    VideojuegosDAO.insertarVideojuego(
        Videojuego(
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


    VideojuegosDAO.eliminarVideojuego(5)




}