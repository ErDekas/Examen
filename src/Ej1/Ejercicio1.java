package Ej1;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Ejercicio1 {
    private static String url = "jdbc:mariadb://localhost:4000/practica examen";
    private static String user = "root";
    private static String pass = "MANAGER";

    public static void main(String[] args){
        Connection conexion = null;
        Statement declaracion = null;
        ResultSet resultado = null;

        try {
            conexion = DriverManager.getConnection(url,user,pass);
            declaracion = conexion.createStatement();

            String consulta = "SELECT * FROM empleados";
            resultado = declaracion.executeQuery(consulta);

            FileWriter JSONFile = new FileWriter("src/Ej1/empleados.json");
            JSONFile.write("[\n");

            boolean first = true;
            while (resultado.next()){
                if (!first) {
                    JSONFile.write(",\n");
                }
                JSONFile.write("  {\n");
                JSONFile.write("    \"id\": " + resultado.getInt("id") + ",\n");
                JSONFile.write("    \"nombre\": \"" + resultado.getString("nombre") + "\",\n");
                JSONFile.write("    \"departamento\": \"" + resultado.getString("departamento") + "\",\n");
                JSONFile.write("    \"salario\": " + resultado.getDouble("salario") + ",\n");
                JSONFile.write("    \"fecha_contratacion\": \"" + resultado.getDate("fecha_contratacion").toString() + "\"\n");
                JSONFile.write("  }");
                first = false;
            }
            JSONFile.write("\n]");

            JSONFile.flush();
            JSONFile.close();

            System.out.println("Datos exportados a empleados.json con éxito");
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

    }
}
