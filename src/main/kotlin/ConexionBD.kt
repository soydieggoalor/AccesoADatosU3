import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object ConexionBD {
    private const val HOST = "localhost"
    private const val PORT = 5432
    private const val DATABASE = "videojuegos"
    private const val USER = "postgres"
    private const val PASSWORD = "qwerty"

    private val url = "jdbc:postgresql://$HOST:$PORT/$DATABASE"

    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection(url, USER, PASSWORD)
        } catch (e: SQLException) {
            println("Error al conectar con la base de datos PostgreSQL: ${e.message}")
            null
        }
    }

    fun testConnection(): Boolean {
        return getConnection()?.use { conn ->
            println("Conexión establecida con éxito")
            true
        } ?: false
    }
}