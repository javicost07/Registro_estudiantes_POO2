package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOImpl implements IEstudianteDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public boolean registrar(Estudiante est) {
        String sql = "INSERT INTO estudiantes (codigo_alumno, nombres, apellidos, correo, carrera) VALUES (?, ?, ?, ?, ?)";
        try {
            con = Conexion.getConexion(); // Usando tu Singleton listo
            ps = con.prepareStatement(sql);
            ps.setString(1, est.getCodigoAlumno());
            ps.setString(2, est.getNombres());
            ps.setString(3, est.getApellidos()); // Si pusiste apellidos con una 'p', asegúrate de que coincida con tu Bean
            ps.setString(4, est.getCorreo());
            ps.setString(5, est.getCarrera());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("--- ERROR DAO AL REGISTRAR: " + e.getMessage() + " ---");
            return false;
        }
    }

    @Override
    public List<Estudiante> listar() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes WHERE estado = 'Activo'";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudiante est = new Estudiante();
                est.setIdEstudiante(rs.getInt("id_estudiante"));
                est.setCodigoAlumno(rs.getString("codigo_alumno"));
                est.setNombres(rs.getString("nombres"));
                est.setApellidos(rs.getString("apellidos"));
                est.setCorreo(rs.getString("correo"));
                est.setCarrera(rs.getString("carrera"));
                est.setEstado(rs.getString("estado"));
                lista.add(est);
            }
        } catch (SQLException e) {
            System.out.println("--- ERROR DAO AL LISTAR: " + e.getMessage() + " ---");
        }
        return lista;
    }

    @Override
    public boolean modificar(Estudiante est) {
        String sql = "UPDATE estudiantes SET codigo_alumno=?, nombres=?, apellidos=?, correo=?, carrera=? WHERE id_estudiante=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, est.getCodigoAlumno());
            ps.setString(2, est.getNombres());
            ps.setString(3, est.getApellidos());
            ps.setString(4, est.getCorreo());
            ps.setString(5, est.getCarrera());
            ps.setInt(6, est.getIdEstudiante());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("--- ERROR DAO AL MODIFICAR: " + e.getMessage() + " ---");
            return false;
        }
    }

    @Override
    public boolean eliminar(int idEstudiante) {
        // Hacemos una eliminación lógica cambiando el estado, una práctica excelente en ingeniería
        String sql = "UPDATE estudiantes SET estado = 'Inactivo' WHERE id_estudiante = ?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEstudiante);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("--- ERROR DAO AL ELIMINAR: " + e.getMessage() + " ---");
            return false;
        }
    }
    
    @Override
    public List<Estudiante> buscar(String texto) {

        List<Estudiante> lista = new ArrayList<>();

        String sql = "SELECT * FROM estudiantes "
               + "WHERE estado='Activo' "
               + "AND (codigo_alumno LIKE ? "
               + "OR nombres LIKE ? "
               + "OR apellidos LIKE ?)";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            String criterio = "%" + texto + "%";

            ps.setString(1, criterio);
            ps.setString(2, criterio);
            ps.setString(3, criterio);

            rs = ps.executeQuery();

            while (rs.next()) {

                Estudiante est = new Estudiante();

                est.setIdEstudiante(rs.getInt("id_estudiante"));
                est.setCodigoAlumno(rs.getString("codigo_alumno"));
                est.setNombres(rs.getString("nombres"));
                est.setApellidos(rs.getString("apellidos"));
                est.setCorreo(rs.getString("correo"));
                est.setCarrera(rs.getString("carrera"));
                est.setEstado(rs.getString("estado"));

                lista.add(est);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return lista;
    }
    @Override
    public boolean existeCodigo(String codigo) {

        String sql = "SELECT COUNT(*) FROM estudiantes WHERE codigo_alumno = ?";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, codigo);

            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;
    }
}