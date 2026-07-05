package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EstudianteMemoriaStrategy implements IEstudianteStrategy {
    
    // Lista segura para subprocesos (concurrente) que guarda los alumnos en memoria
    private static final List<Estudiante> lista = new CopyOnWriteArrayList<>();
    private static int contadorId = 1;

    @Override
    public void registrar(Estudiante estudiante) {
        estudiante.setIdEstudiante(contadorId++);
        lista.add(estudiante);
    }

    @Override
    public List<Estudiante> listar() {
        // Retorna la lista completa
        return new ArrayList<>(lista);
    }

    @Override
    public void eliminar(int id) {
        // Filtra y elimina usando expresiones lambda
        lista.removeIf(estudiante -> estudiante.getIdEstudiante() == id);
    }

    @Override
    public boolean existeCodigo(String codigo) {
        // Evalúa si algún estudiante ya tiene ese código usando Streams
        return lista.stream().anyMatch(estudiante -> estudiante.getCodigoAlumno().equalsIgnoreCase(codigo));
    }
}