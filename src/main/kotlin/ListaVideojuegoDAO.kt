import java.sql.Connection
import java.sql.SQLException

object ListaVideojuegoDAO {
    fun anyadirALista(idLista: Int, idVideojuego: Int, fecha: String) {
        var conn: Connection? = null
        try {
            conn = ConexionBD.getConnection()
            conn?.autoCommit = false // 1. Iniciar transacción

            var existe = false
            conn?.prepareStatement("SELECT id FROM videojuegos WHERE id = ?")?.use { stmt ->
                stmt.setInt(1, idVideojuego)
                existe = stmt.executeQuery().next()
            }
            if (!existe) {
                println("No existe el videojuego con el ID $idVideojuego")
                conn?.rollback()
                return
            }

            conn?.prepareStatement("INSERT INTO listas_videojuegos(id_lista, id_videojuego, fecha_añadido) VALUES (?, ?, ?)")
                ?.use { stmt ->
                    stmt.setInt(1, idLista)
                    stmt.setInt(2, idVideojuego)
                    stmt.setString(3, fecha)
                    stmt.executeUpdate()
                }

            conn?.commit() // 2. Confirmar cambios
            println("Videojuego añadido a la lista. Transacción completada.")
        } catch (e: SQLException) {
            println("Error en la transacción, se revierten los cambios: ${e.message}")
            conn?.rollback() // 3. Revertir cambios
        } finally {
            conn?.autoCommit = true
            conn?.close()
        }
    }
}