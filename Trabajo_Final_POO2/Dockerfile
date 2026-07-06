FROM tomcat:10.1-jdk17-slim

# Eliminar las aplicaciones por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiar tu archivo WAR compilado renombrándolo a ROOT.war
COPY target/Sistema-Login-USIL-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
