package Ej2;

import java.sql.*;
import java.io.FileWriter;
import java.io.IOException;


public class Ejercicio2 {
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

            String consulta = "SELECT * FROM estudiantes";
            resultado = declaracion.executeQuery(consulta);

            FileWriter XMLFile = new FileWriter("src/Ej2/estudiantes.xml");
            XMLFile.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
            XMLFile.write("<estudiantes>\n");
            boolean first = true;
            while(resultado.next()){
                if(!first){
                    XMLFile.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
                    XMLFile.write("<estudiantes>\n");
                }
                XMLFile.write(" <estudiante>\n");
                XMLFile.write("     <id>\n");
                XMLFile.append("        "+resultado.getInt("id")+"\n");
                XMLFile.write("     </id>\n");
                XMLFile.write("     <nombre>\n");
                XMLFile.append("        "+resultado.getString("nombre")+"\n");
                XMLFile.write("     </nombre>\n");
                XMLFile.write("     <apellido>\n");
                XMLFile.append("        "+resultado.getString("apellido")+"\n");
                XMLFile.write("     </apellido>\n");
                XMLFile.write("     <curso>\n");
                XMLFile.append("        "+resultado.getString("curso")+"\n");
                XMLFile.write("     </curso>\n");
                XMLFile.write("     <fecha_inscripcion>\n");
                XMLFile.append("        "+resultado.getDate("fecha_inscripcion").toString()+"\n");
                XMLFile.write("     </fecha_inscripcion>\n");
                XMLFile.write(" </estudiante>\n");
            }
            XMLFile.write("</estudiantes>");

            XMLFile.flush();
            XMLFile.close();

            System.out.println("Datos exportados a estudiantes.xml con exito");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
