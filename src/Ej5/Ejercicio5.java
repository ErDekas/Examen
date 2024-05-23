package Ej5;
import java.sql.*;
import java.io.FileWriter;
import java.io.IOException;
public class Ejercicio5 {
    private static String url = "jdbc:mariadb://localhost:4000/practica examen";
    private static String user = "root";
    private static String pass = "MANAGER";

    public static void main(String[] args){
        Connection conexion = null;
        Statement declaracion = null;
        ResultSet resultado = null;
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            declaracion = conexion.createStatement();

            String consulta = "SELECT * FROM participantes";
            resultado = declaracion.executeQuery(consulta);

            FileWriter HTMLFile = new FileWriter("src/Ej5/participantes.html");
            HTMLFile.write("<html>\n");
            HTMLFile.write("<head>\n");
            HTMLFile.write("    <title>Lista de participantes</title>\n");
            HTMLFile.write("</head>\n");
            HTMLFile.write("<body>\n");
            HTMLFile.write("    <table border='1'>\n");
            HTMLFile.write("        <tr>\n");
            HTMLFile.write("            <th>ID</th>\n");
            HTMLFile.write("            <th>Nombre</th>\n");
            HTMLFile.write("            <th>Apellido</th>\n");
            HTMLFile.write("            <th>Email</th>\n");
            HTMLFile.write("            <th>Fecha de Registros</th>\n");
            HTMLFile.write("        <tr>\n");
            while(resultado.next()){
                HTMLFile.write("        <tr>\n");
                HTMLFile.write("            <th>"+resultado.getInt("id")+"</th>\n");
                HTMLFile.write("            <th>"+resultado.getString("nombre")+"</th>\n");
                HTMLFile.write("            <th>"+resultado.getString("apellido")+"</th>\n");
                HTMLFile.write("            <th>"+resultado.getString("email")+"</th>\n");
                HTMLFile.write("            <th>"+resultado.getDate("fecha_registro").toString()+"</th>\n");
                HTMLFile.write("        <tr>\n");
            }
            HTMLFile.write("    </table>\n");
            HTMLFile.write("</body>\n");
            HTMLFile.write("</html>\n");

            HTMLFile.flush();
            HTMLFile.close();
            conexion.close();

            System.out.println("Datos exportado a participantes.html correctamente");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
