object JugadorDAO {
    fun insertarJugador(jugador: Jugador) {
        val sql = "INSERT INTO jugadores(nombre) VALUES (?)"
        ConexionBD.getConnection()?.use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, jugador.nombre)
                if (stmt.executeUpdate() > 0) println("Jugador ${jugador.nombre} creado con éxito.")
            }
        }
    }

    fun eliminarJugador(id: Int) {
        val sql = "DELETE FROM jugadores WHERE id_jugador = ?"
        ConexionBD.getConnection()?.use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setInt(1, id)
                if (stmt.executeUpdate() > 0) println("Jugador con ID $id eliminado.")
                else println("No se encontró ningún jugador con ID $id.")
            }
        }
    }
}