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
import modelo.conductor;
import utils.ConnectionDB;
/**
 *
 * @author Andres Salazar
 */
public class conductorDAO {
    
    private Connection conn = null;
    
    public ArrayList<conductor> getAllConductores() {
        ArrayList<conductor> conductores = new ArrayList();
        try {
            if(conn == null)                            // validacion de la conexion con la base de datos activa
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT usu_cc, veh_placa FROM conductor;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                conductor conductorx = new conductor(result.getInt(1), result.getString(2));
                conductores.add( conductorx );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return conductores;
    }
    
    public ArrayList<conductor> getConductorByPlaca(String veh_placa) {
        ArrayList<conductor> conductores = new ArrayList();
        try {
            if(conn == null)                            //Confirmar la conexion con DB
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT usu_cc, veh_placa FROM conductor WHERE veh_placa=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, veh_placa);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                conductor conductorx = new conductor(result.getInt(1), result.getString(2));
                conductores.add( conductorx );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return conductores;
    }
    
    public void insertConductor(conductor conductores){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO conductor(usu_cc, veh_placa) VALUES (?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, conductores.getUsu_cc());
            statement.setString(2, conductores.getVeh_placa());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void updatePlacaConductor(conductor conductores) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE conductor SET veh_placa =? WHERE usu_cc=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, conductores.getVeh_placa());
            statement.setInt(2, conductores.getUsu_cc());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void deleteConductor(int usu_cc) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM conductor WHERE usu_cc=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, usu_cc);
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
