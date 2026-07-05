package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public boolean validarUsuario(String username, String password) {
        // Esta consulta busca directamente en la tabla de la 3FN física de MySQL
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password_hash = ? AND bloqueado = 0 AND estado = 'Activo'";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Retorna true si las credenciales existen en MySQL
            }
            
        } catch (Exception e) {
            System.out.println("Error en UsuarioDAO: " + e.getMessage());
            return false;
        }
    }
}