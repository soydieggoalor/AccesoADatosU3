import java.sql.SQLException

object ListaDAO {
    fun insertarLista(lista: Lista) {
        val sql = "INSERT INTO listas(nombre, id_jugador) VALUES (?, ?)"
        try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, lista.nombre)
                    stmt.setInt(2, lista.idJugador)
                    if (stmt.executeUpdate() > 0) println("Lista ${lista.nombre} creada con éxito.")
                }
            }
        } catch (e: SQLException) {
            println("No se pudo crear la lista: ${e.message}")
        }
    }

    fun eliminarLista(id: Int) {
        val sql = "DELETE FROM listas WHERE id_lista = ?"
        ConexionBD.getConnection()?.use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setInt(1, id)
                if (stmt.executeUpdate() > 0) println("Lista con ID $id eliminada.")
                else println("No se encontró ninguna lista con ID $id.")
            }
        }
    }
}