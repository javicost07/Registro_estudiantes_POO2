<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
    // CONTROL DE SEGURIDAD: Evita que entren escribiendo la URL sin haberse logueado
    if (session.getAttribute("usuarioLogueado") == null) {
        response.sendRedirect("login.jsp?error=Por favor, inicie sesion primero.");
        return;
    }
    
    // Extraemos el nombre guardado en el paso anterior
    String alumnoActivo = (String) session.getAttribute("usuarioLogueado");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú Principal - USIL</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Segoe UI', sans-serif;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .welcome-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
            padding: 3rem;
            max-width: 500px;
            width: 100%;
            text-align: center;
        }
        .welcome-title {
            color: #1a237e;
            font-weight: 700;
        }
        .user-highlight {
            color: #0d1b87;
            font-weight: 600;
            background-color: #e8eaf6;
            padding: 5px 15px;
            border-radius: 20px;
            display: inline-block;
            margin-top: 10px;
        }
        .btn-logout {
            background-color: #dc3545;
            color: white;
            font-weight: 600;
            border: none;
            padding: 0.6rem 1.5rem;
            transition: all 0.3s ease;
        }
        .btn-logout:hover {
            background-color: #bd2130;
            transform: translateY(-1px);
        }
        /* Estilo personalizado para tu nuevo botón de módulo */
        .btn-modulo {
            background-color: #1a237e;
            color: white;
            font-weight: 600;
            padding: 0.75rem 1.5rem;
            transition: all 0.3s ease;
        }
        .btn-modulo:hover {
            background-color: #0d1b87;
            color: white;
            transform: translateY(-1px);
        }
    </style>
</head>
<body>


<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-9">
            <div class="welcome-card">
                <div class="mb-4">
                    <span class="badge bg-success px-3 py-2 rounded-pill">
                        Sesión Activa
                    </span>
                </div>
                <h2 class="welcome-title">
                    Sistema Académico USIL
                </h2>
                <div class="user-highlight fs-5 mb-4">
                    👤 Bienvenido, <%= alumnoActivo %>
                </div>
                <div class="row g-3">
                    <div class="col-md-4">
                        <div class="card shadow-sm border-0">
                            <div class="card-body">
                                <h1>🎓</h1>
                                <h5>Estudiantes</h5>
                                <p class="text-muted">
                                    Registrar, consultar y administrar estudiantes.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card shadow-sm border-0">
                            <div class="card-body">
                                <h1>👨‍🏫</h1>
                                <h5>Usuarios</h5>
                                <p class="text-muted">
                                    Acceso mediante autenticación segura.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card shadow-sm border-0">
                            <div class="card-body">
                                <h1>🏫</h1>
                                <h5>Carreras</h5>
                                <p class="text-muted">
                                    Ingeniería de Sistemas
                                    <br>
                                    Ingeniería de Software
                                    <br>
                                    Administración
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="d-grid mt-4">
                    <a href="EstudianteServlet?accion=listar"
                       class="btn btn-modulo btn-lg">
                        🎓 Gestionar Estudiantes
                    </a>
                </div>
                <hr>
                <a href="CerrarSesionServlet"
                   class="btn btn-logout">
                    Cerrar Sesión
                </a>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>