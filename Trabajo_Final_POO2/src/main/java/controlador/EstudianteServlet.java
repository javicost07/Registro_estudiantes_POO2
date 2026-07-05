package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import modelo.Estudiante;
import modelo.IEstudianteStrategy;
import modelo.EstudianteMySQLStrategy;

@WebServlet(name = "EstudianteServlet", urlPatterns = {"/EstudianteServlet"})
public class EstudianteServlet extends HttpServlet {

    // Se mantiene la interfaz general aplicando el patrón Strategy
    private IEstudianteStrategy estrategiaAlmacenamiento;

    @Override
    public void init() throws ServletException {
        // SOLUCIÓN AL ERROR 500: Ahora inicializa la estrategia en memoria limpia
        this.estrategiaAlmacenamiento = new EstudianteMySQLStrategy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if (accion == null) { accion = "listar"; }

        if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            
            // El servlet ejecuta la estrategia asignada en memoria
            estrategiaAlmacenamiento.eliminar(id);

            request.getSession().setAttribute("mensaje", "Estudiante eliminado correctamente.");
            request.getSession().setAttribute("tipo", "warning");

            response.sendRedirect("EstudianteServlet?accion=listar");
            return;
        }

        if (accion.equals("listar")) {
            // El servlet lista usando la colección en memoria
            request.setAttribute("listaEstudiantes", estrategiaAlmacenamiento.listar());
            request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigo = request.getParameter("txtCodigo");
        String nombres = request.getParameter("txtNombres");
        String apellidos = request.getParameter("txtApellidos");
        String correo = request.getParameter("txtCorreo");
        String carrera = request.getParameter("txtCarrera");
        
        // CORRECCIÓN: Validamos usando la estrategia activa en memoria de forma segura
        // Nota: Si te da error en 'existeCodigo', asegúrate de que tu interfaz IEstudianteStrategy tenga el método, 
        // o si prefieres saltar la validación por ahora para tu entrega, puedes comentar este bloque 'if'.
        if (estrategiaAlmacenamiento.existeCodigo(codigo)) {
            request.getSession().setAttribute("mensaje", "El código del alumno ya existe.");
            request.getSession().setAttribute("tipo", "danger");

            response.sendRedirect("EstudianteServlet?accion=listar");
            return;
        }

        Estudiante nuevoEst = new Estudiante(0, codigo, nombres, apellidos, correo, carrera);
        
        // Registramos usando la colección en memoria
        estrategiaAlmacenamiento.registrar(nuevoEst);

        // Guardamos un mensaje en la sesión
        request.getSession().setAttribute("mensaje", "Estudiante registrado correctamente.");
        request.getSession().setAttribute("tipo", "success");

        response.sendRedirect("EstudianteServlet?accion=listar");
    }
}