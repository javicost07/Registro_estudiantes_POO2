package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    private static Connection conexion = null;
    
    // Configuración de los parámetros locales de MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_usil?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root"; 
    private static final String PASSWORD = "070807";

    // Constructor privado para evitar instanciaciones externas no autorizadas
    private Conexion() {}

    public static Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                // Registrar el driver clásico compatible con la versión 8.0.28 que agregamos al POM
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("--- LOG: ¡Conexión establecida con éxito en MySQL! ---");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("--- LOG ERROR EN CONEXION: " + e.getMessage() + " ---");
        }
        return conexion;
    }
}
