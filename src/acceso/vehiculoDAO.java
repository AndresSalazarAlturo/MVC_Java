/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import modelo.vehiculo;
import utils.ConnectionDB;
/**
 *
 * @author Andres Salazar
 */
public class vehiculoDAO {
    private Connection conn = null;
    
    public ArrayList<vehiculo> getAllVehiculos() {
        ArrayList<vehiculo> vehiculos = new ArrayList();
        try {
            if(conn == null)                            // validacion de la conexion con la base de datos activa
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros FROM vehiculo;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                vehiculo vehiculox = new vehiculo(result.getString(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5), result.getString(6), result.getInt(7));
                vehiculos.add( vehiculox );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return vehiculos;
    }
    
    public ArrayList<vehiculo> getVehiculoByPlaca(int veh_placa) {
        ArrayList<vehiculo> vehiculos = new ArrayList();
        try {
            if(conn == null)                            //Confirmar la conexion con DB
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros FROM vehiculo WHERE veh_placa=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, veh_placa);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                vehiculo usuariox = new vehiculo(result.getString(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5), result.getString(6), result.getInt(7));
                vehiculos.add( usuariox );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return vehiculos;
    }
    
    public void insertVehiculo(vehiculo vehiculos){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vehiculos.getVeh_placa());
            statement.setString(2, vehiculos.getVeh_marca());
            statement.setString(3, vehiculos.getVeh_modelo());
            statement.setInt(4, vehiculos.getVeh_anio());
            statement.setInt(5, vehiculos.getVeh_capacidad());
            statement.setString(6, vehiculos.getVeh_color());
            statement.setInt(7, vehiculos.getVeh_kilometros());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void updateColorVehiculo(vehiculo vehiculos) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE vehiculo SET veh_color =? WHERE veh_placa=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vehiculos.getVeh_color());
            statement.setString(2, vehiculos.getVeh_placa());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void deleteVehiculo(String veh_placa) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM vehiculo WHERE veh_placa=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, veh_placa);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
}
