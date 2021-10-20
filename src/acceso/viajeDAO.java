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
import modelo.viaje;
import utils.ConnectionDB;
/**
 *
 * @author Andres Salazar
 */
public class viajeDAO {
    
    private Connection conn = null;
    
    public ArrayList<viaje> getAllViajes() {
        ArrayList<viaje> viajes = new ArrayList();
        try {
            if(conn == null)                            // validacion de la conexion con la base de datos activa
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT via_id, usu_cc, con_cc, fecha FROM viaje;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                viaje viajex = new viaje(result.getInt(1), result.getInt(2), result.getInt(3), result.getString(4));
                viajes.add( viajex );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return viajes;
    }
    
    public ArrayList<viaje> getViajeByID(int via_id) {
        ArrayList<viaje> viajes = new ArrayList();
        try {
            if(conn == null)                            //Confirmar la conexion con DB
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT via_id, usu_cc, con_cc, fecha FROM viaje WHERE via_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, via_id);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                viaje viajex = new viaje(result.getInt(1), result.getInt(2), result.getInt(3), result.getString(4));
                viajes.add( viajex );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return viajes;
    }
    
    public ArrayList<viaje> getViajeByConductor(int con_cc) {
        ArrayList<viaje> viajes = new ArrayList();
        try {
            if(conn == null)                            //Confirmar la conexion con DB
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT via_id, usu_cc, con_cc, fecha FROM viaje WHERE con_cc=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, con_cc);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                viaje viajex = new viaje(result.getInt(1), result.getInt(2), result.getInt(3), result.getString(4));
                viajes.add( viajex );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return viajes;
    }
    
    public void insertViaje(viaje viajes){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO viaje(via_id, usu_cc, con_cc, fecha) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, viajes.getVia_id());
            statement.setInt(2, viajes.getUsu_cc());
            statement.setInt(3, viajes.getCon_cc());
            statement.setString(4, viajes.getFecha());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void updateFechaViaje(viaje viajes) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE viaje SET fecha =? WHERE con_cc=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, viajes.getFecha());
            statement.setInt(2, viajes.getCon_cc());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void deleteViaje(int via_id) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM viaje WHERE via_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, via_id);
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
