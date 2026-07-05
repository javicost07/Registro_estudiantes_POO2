package modelo;

import java.util.List;

public interface IEstudianteStrategy {
    void registrar(Estudiante estudiante);
    List<Estudiante> listar();
    void eliminar(int id);

    public boolean existeCodigo(String codigo);
}