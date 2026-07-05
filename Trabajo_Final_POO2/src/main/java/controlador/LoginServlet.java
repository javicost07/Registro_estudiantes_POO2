package controlador;

import java.io.IOException;
import java.net.URLEncoder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Capturar parámetros usando los nombres exactos de tus inputs HTML
        String txtUser = request.getParameter("txtUsuario");
        String txtPass = request.getParameter("txtPassword"); 
        
        // 2. Validación Fija (Saltamos el MySQL local para que funcione en Railway)
        // Puedes cambiar "admin" y "12345" por el usuario y clave que tú quieras usar hoy
        if ("javicost07".equals(txtUser) && "12345".equals(txtPass)) {
            
            // 3. Crear sesión usando el mismo
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", txtUser); 
            
            // Redireccionar al menú principal de Bootstrap
            response.sendRedirect("menuPrincipal.jsp"); 
        } else {
            // Mensaje de error personalizado que Bootstrap renderizará en tu Login
            String mensaje = "Usuario o contraseña incorrectos. Por favor, intente de nuevo.";
            String mensajeCodificado = URLEncoder.encode(mensaje, "UTF-8");
            
            response.sendRedirect("login.jsp?error=" + mensajeCodificado);
        }
    }
}