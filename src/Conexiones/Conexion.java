package Conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class Conexion {
    static Connection contacto = null;
    public static String usuario, password;
    public static boolean status = false;
    
    public static void setCuenta(String usuario, String password){
        Conexion.usuario = usuario;
        Conexion.password = password;
    }
    
    public static Connection getConexion(){
        status = false;
        String url = "jdbc:sqlserver://LAPTOP-HFQ80BCJ\\MSSQLSERVER01:1433;databaseName=Viaje_Placentero";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "No se encontró la conexion "+e.getMessage());
        }
        try{
            contacto = DriverManager.getConnection(url,Conexion.usuario,Conexion.password);
            status = true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Usuario no encontrado "+e.getMessage());
        }
        return contacto;
    }
    
    public static boolean getStatus(){
        return status;
    }
    
    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try{
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo hacer la consulta "+e.getMessage());
        }
        return null;
    }
}
