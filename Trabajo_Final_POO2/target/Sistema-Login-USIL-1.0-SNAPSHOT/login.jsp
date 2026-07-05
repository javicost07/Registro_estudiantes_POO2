
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido a USIL - Iniciar Sesión</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        body {
            background-color: #f4f6f9; /* Fondo gris claro muy sutil para resaltar la tarjeta */
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .login-card {
            background: #ffffff;
            border: none;
            border-radius: 15px; /* Bordes redondeados modernos */
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08); /* Sombra suave trasera */
            padding: 2.5rem;
            max-width: 450px;
            width: 100%;
        }
        .usil-title {
            color: #1a237e; /* Azul corporativo oscuro */
            font-weight: 700;
            letter-spacing: 1px;
        }
        .btn-usil {
            background-color: #0d1b87; /* Azul del botón de tu formulario */
            color: white;
            border: none;
            font-weight: 600;
            padding: 0.75rem;
            transition: all 0.3s ease;
        }
        .btn-usil:hover {
            background-color: #0a1463; /* Oscurece un poco al pasar el mouse */
            color: white;
            transform: translateY(-2px); /* Efecto sutil de levitación */
        }
        .form-label {
            color: #0d1b87;
            font-weight: 600;
        }
        .logo-container img {
            max-width: 160px;
            height: auto;
        }
    </style>
</head>
<body>

    <div class="login-card text-center">
        <div class="d-flex align-items-center justify-content-between mb-4">
            <h2 class="usil-title m-0">¡BIENVENIDO<br>A USIL!</h2>
            <div class="logo-container">
                <img src="img/Logo_Usil.png" alt="Logo USIL" onerror="this.src='https://via.placeholder.com/150x120?text=Logo+USIL'">
            </div>
        </div>
        
        <hr class="text-muted my-4">

        <form action="LoginServlet" method="POST">    

            <div class="mb-3 text-start">
                <label for="usuario" class="form-label">Ingresa tu usuario:</label>
                <input type="text" class="form-control form-control-lg" id="usuario" name="txtUsuario" placeholder="Ej. alumno123" required>
            </div>

            <div class="mb-4 text-start">
                <label for="password" class="form-label">Ingresa tu contraseña:</label>
                <input type="password" class="form-control form-control-lg" id="password" name="txtPassword" placeholder="********" required>
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-usil btn-lg rounded-3">INICIAR SESIÓN</button>
            </div>

        </form>
        
        <%-- BLOQUE DE CONTROL DE ERRORES VISUALES --%>
        <%
            String msgError = request.getParameter("error");
            if (msgError != null && !msgError.isEmpty()) {
        %>
                <div class="alert alert-danger alert-dismissible fade show mt-4 rounded-3 text-start" role="alert" style="font-size: 0.9rem;">
                    <i class="bi bi-exclaimation-triangle-fill me-2"></i>
                    <a href="login.jsp"></a>
                    <%= msgError %>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
        <%
            }
        %>
        
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>