package modelo;

import java.util.List;

public class EstudianteMySQLStrategy implements IEstudianteStrategy {

    private IEstudianteDAO dao;

    public EstudianteMySQLStrategy() {
        dao = new EstudianteDAOImpl();
    }

    @Override
    public void registrar(Estudiante estudiante) {
        dao.registrar(estudiante);
    }

    @Override
    public List<Estudiante> listar() {
        return dao.listar();
    }

    @Override
    public void eliminar(int id) {
        dao.eliminar(id);
    }
    
    public boolean existeCodigo(String codigo){
        return dao.existeCodigo(codigo);
    }
}