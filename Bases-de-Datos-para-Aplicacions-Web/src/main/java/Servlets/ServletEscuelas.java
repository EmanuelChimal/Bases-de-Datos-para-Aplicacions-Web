/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;
import JavaBean.Escuela;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEscuelas", urlPatterns = {"/ServletEscuelas"})
public class ServletEscuelas extends HttpServlet {

    private Connection connect;
    private Statement statement;
    private ResultSet resultSet;

    // JDBC URL, usuario y contraseña de MySQL
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:/universidad?user=root&password=root";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    // Método para obtener la lista de escuelas desde la base de datos
    private List<Escuela> getListaEscuelas() throws SQLException {
        String query = "SELECT * FROM Escuelas";
        List<Escuela> escuelas = new ArrayList<>();

        try (Connection connect = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connect.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Escuela escuela = new Escuela();
                escuela.setClaveEscuela(resultSet.getString("claveEscuela"));
                escuela.setNombreEscuela(resultSet.getString("nombreEscuela"));
                escuela.setDomicilio(resultSet.getString("domicilio"));
                escuela.setCodigoPostal(resultSet.getInt("codigoPostal"));
                escuela.setTurno(resultSet.getString("turno"));
                escuela.setIdLocalidad(resultSet.getInt("idLocalidad"));

                escuelas.add(escuela);
            }
        }

        return escuelas;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletEscuelas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Escuelas</h1>");

            // Obtener la lista de escuelas
            List<Escuela> listaEscuelas = getListaEscuelas();

            // Mostrar la lista de escuelas en una tabla
            out.println("<table border='1'>");
            out.println("<tr><th>Clave Escuela</th><th>Nombre Escuela</th><th>Domicilio</th><th>Código Postal</th><th>Turno</th><th>ID Localidad</th></tr>");

            for (Escuela escuela : listaEscuelas) {
                out.println("<tr>");
                out.println("<td>" + escuela.getClaveEscuela() + "</td>");
                out.println("<td>" + escuela.getNombreEscuela() + "</td>");
                out.println("<td>" + escuela.getDomicilio() + "</td>");
                out.println("<td>" + escuela.getCodigoPostal() + "</td>");
                out.println("<td>" + escuela.getTurno() + "</td>");
                out.println("<td>" + escuela.getIdLocalidad() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}