package modelo;

public class Estudiante {
    // Atributos privados (Encapsulamiento)
    private int idEstudiante;
    private String codigoAlumno;
    private String nombres;
    private String apellidos;
    private String correo;
    private String carrera;
    private String estado;

    // Constructor vacío (Obligatorio para Beans de Java)
    public Estudiante() {
    }

    // Constructor completo para cuando creemos o listemos estudiantes
    public Estudiante(int idEstudiante, String codigoAlumno, String nombres, String apellidos, String correo, String carrera) {
        this.idEstudiante = idEstudiante;
        this.codigoAlumno = codigoAlumno;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.carrera = carrera;
        this.estado = estado;
    }

    // Métodos Getter y Setter (El estándar que pide tu carrera)
    public int getIdEstudiante() { return idEstudiante; }
    public void setIdEstudiante(int idEstudiante) { this.idEstudiante = idEstudiante; }

    public String getCodigoAlumno() { return codigoAlumno; }
    public void setCodigoAlumno(String codigoAlumno) { this.codigoAlumno = codigoAlumno; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
