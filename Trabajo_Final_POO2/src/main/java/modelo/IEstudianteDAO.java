package modelo;

import java.util.List;

public interface IEstudianteDAO {
    // Definimos las operaciones del CRUD académico
    public boolean registrar(Estudiante estudiante);
    public List<Estudiante> listar();
    public boolean modificar(Estudiante estudiante);
    public boolean eliminar(int idEstudiante);
    public List<Estudiante> buscar(String texto);
    public boolean existeCodigo(String codigo);
}