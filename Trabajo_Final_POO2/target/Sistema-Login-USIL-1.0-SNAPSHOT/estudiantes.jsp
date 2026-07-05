<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sistema USIL - Gestión de Estudiantes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
        <div class="container-fluid">
            <a class="navbar-brand" href="menuPrincipal.jsp">Control Académico USIL</a>
            <div class="navbar-nav ms-auto">
                <span class="nav-link text-white me-3">Bienvenido, <strong>${usuarioLogueado}</strong></span>
                <a class="btn btn-outline-danger btn-sm" href="CerrarSesionServlet">Cerrar Sesión</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-md-4 mb-4">
                <div class="card shadow">
                    <div class="card-header bg-primary text-white">
                        <h5 class="card-title mb-0">Registrar Nuevo Estudiante</h5>
                    </div>
                    <div class="card-body">
                        <form action="EstudianteServlet" method="POST">
                            <div class="mb-3">
                                <label class="form-label">Código de Alumno</label>
                                <input type="text" name="txtCodigo" class="form-control" placeholder="Ej. 20261001" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Nombres</label>
                                <input type="text" name="txtNombres" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Apellidos</label>
                                <input type="text" name="txtApellidos" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Correo Institucional</label>
                                <input type="email" name="txtCorreo" class="form-control" placeholder="usuario@usil.pe" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Carrera</label>
                                <select name="txtCarrera" class="form-select" required>
                                    <option value="">-- Seleccionar --</option>
                                    <option value="Ingeniería de Sistemas">Ingeniería de Sistemas</option>
                                    <option value="Ingeniería de Software">Ingeniería de Software</option>
                                    <option value="Administración">Administración</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-success w-100">Guardar Estudiante</button>
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <div class="card shadow">
                    <div class="card-header bg-dark text-white">
                        <h5 class="card-title mb-0">Lista de Estudiantes Activos</h5>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-hover align-middle">
                                <thead class="table-dark">
                                    <tr>
                                        <th>Código</th>
                                        <th>Estudiante</th>
                                        <th>Correo</th>
                                        <th>Carrera</th>
                                        <th class="text-center">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="est" items="${listaEstudiantes}">
                                        <tr>
                                            <td>${est.codigoAlumno}</td>
                                            <td>${est.apellidos}, ${est.nombres}</td>
                                            <td>${est.correo}</td>
                                            <td>${est.carrera}</td>
                                            <td class="text-center">
                                                <a href="EstudianteServlet?accion=eliminar&id=${est.idEstudiante}" 
                                                   class="btn btn-danger btn-sm" 
                                                   onclick="return confirm('¿Seguro que deseas eliminar este estudiante?');">
                                                    Eliminar
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${empty listaEstudiantes}">
                                        <tr>
                                            <td colspan="5" class="text-center text-muted py-3">No hay estudiantes registrados.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

                
    <c:if test="${not empty sessionScope.mensaje}">

    <div class="alert alert-${sessionScope.tipo} alert-dismissible fade show" role="alert">

        ${sessionScope.mensaje}

        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>

    </div>

    <c:remove var="mensaje" scope="session"/>
    <c:remove var="tipo" scope="session"/>

    </c:if>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
