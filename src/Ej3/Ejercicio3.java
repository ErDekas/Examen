package Ej3;

import java.sql.*;
import java.io.FileWriter;
import java.io.IOException;
public class Ejercicio3 {
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

            String consulta = "SELECT * FROM libros";
            resultado = declaracion.executeQuery(consulta);

            FileWriter CSSFile = new FileWriter("src/Ej3/libros.css");

            while(resultado.next()){
                CSSFile.write("ID: {"+resultado.getInt("id")+"};\n");
                CSSFile.write("Título: {"+resultado.getString("titulo")+"};\n");
                CSSFile.write("Autor: {"+resultado.getString("autor")+"};\n");
                CSSFile.write("Género: {"+resultado.getString("genero")+"};\n");
                CSSFile.write("Fecha de Publicación: {"+resultado.getDate("fecha_publicacion").toString()+"};\n");
            }

            CSSFile.flush();
            CSSFile.close();
            System.out.println("Datos exportados a libros.css correctamente");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
