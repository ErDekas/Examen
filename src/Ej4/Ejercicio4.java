package Ej4;
import java.sql.*;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
public class Ejercicio4 {
    private static String url = "jdbc:mariadb://localhost:4000/practica examen";
    private static String user = "root";
    private static String pass = "MANAGER";
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Connection conexion = null;
        Statement declaracion = null;
        ResultSet resultado = null;

        try {
            conexion = DriverManager.getConnection(url,user,pass);
            declaracion = conexion.createStatement();

            String consulta = "SELECT * FROM productos";
            resultado = declaracion.executeQuery(consulta);

            FileWriter YAMLFile = new FileWriter("src/Ej4/productos.yaml");
            String linea = "L";
            while(true) {
                System.out.println("Desea el archivo escrito en linea o en bloque? (L/B)");
                linea = sc.nextLine();
                if (!linea.equals("L") && !linea.equals("B")) {
                    System.out.println("Solo se admite L o B");
                }
                else {
                    break;
                }
            }
            while(resultado.next()){
                if(linea.equals("L")){
                    YAMLFile.write("["+resultado.getInt("id"));
                    YAMLFile.write(resultado.getString("nombre"));
                    YAMLFile.write(resultado.getString("categoria"));
                    YAMLFile.write(resultado.getString("precio"));
                    YAMLFile.write(resultado.getDate("fecha_creacion").toString()+"]\n");
                }if(linea.equals("B")){
                    YAMLFile.write("- id: "+resultado.getInt("id")+"\n");
                    YAMLFile.write("- nombre: "+resultado.getString("nombre")+"\n");
                    YAMLFile.write("- categoria: "+resultado.getString("categoria")+"\n");
                    YAMLFile.write("- precio: "+resultado.getString("precio")+"\n");
                    YAMLFile.write("- fecha_creacion: "+resultado.getDate("fecha_creacion").toString()+"\n");
                }
            }

            YAMLFile.flush();
            YAMLFile.close();
            declaracion.close();
            System.out.println("Datos exportados a productos.yaml correctamente");

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
