package Conexiones;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class Procedimientos {
    
    public static void ingresarViaje(String a, String b, String c, String d, String e, String f,String g, String h) throws SQLException{
        CallableStatement ingresa = Conexion.getConexion().prepareCall("{call CrearViaje(?,?,?,?,?,?,?,?)}");
        ingresa.setString(1, a);
        ingresa.setString(2, b);
        ingresa.setString(3, c);
        ingresa.setString(4, d);
        ingresa.setString(5, e);
        ingresa.setString(6, f);
        ingresa.setString(7, g);
        ingresa.setString(8, h);
        ingresa.execute();
    }
    
    public static void ingresarAutobus(String a, String b, String c, String d, String e) throws SQLException{
        CallableStatement ingresa = Conexion.getConexion().prepareCall("{call IngresarAutobus(?,?,?,?,?)}");
        ingresa.setString(1, a);
        ingresa.setString(2, b);
        ingresa.setString(3, c);
        ingresa.setString(4, d);
        ingresa.setString(5, e);
        ingresa.execute();
    }
    
    public static void ingresarCamion(String a, String b) throws SQLException{
        CallableStatement ingresa = Conexion.getConexion().prepareCall("{call IngresarCamion(?,?)}");
        ingresa.setString(1,a);
        ingresa.setString(2,b);
        ingresa.execute();
    }
    
    public static void ingresarTripulacion(String a, String b, String c)throws SQLException{
        CallableStatement ingresa = Conexion.getConexion().prepareCall("{call IngresarTripulacion(?,?,?)}");
        ingresa.setString(1, a);
        ingresa.setString(2, b);
        ingresa.setString(3, c);
        ingresa.execute();
    }
    public static void ingresarEmpleado(String a, String b, String c, String d)throws SQLException{
        CallableStatement ingresa = Conexion.getConexion().prepareCall("{call IngresarEmpleado(?,?,?,?)}");
        ingresa.setString(1, a);
        ingresa.setString(2, b);
        ingresa.setString(3, c);
        ingresa.setString(4, d);
        ingresa.execute();
    }
    
    public static void actualizarViaje(String a, String b, String c, String d, String e, String f,String g, String h,String i)throws SQLException{
        CallableStatement ingresa = Conexion.getConexion().prepareCall("{call ModificarViaje(?,?,?,?,?,?,?,?,?)}");
        ingresa.setString(1, a);
        ingresa.setString(2, b);
        ingresa.setString(3, c);
        ingresa.setString(4, d);
        ingresa.setString(5, e);
        ingresa.setString(6, f);
        ingresa.setString(7, g);
        ingresa.setString(8, h);
        ingresa.setString(9, h);
        ingresa.execute();
        ingresa.close();
    }
    
}
