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
import modelo.usuario;
import utils.ConnectionDB;

/**
 *
 * @author Andres Salazar
 */
public class usuarioDAO {
    
    private Connection conn = null;
    
    public ArrayList<usuario> getAllusuarios() {
        ArrayList<usuario> usuarios = new ArrayList();
        try {
            if(conn == null)                            // validacion de la conexion con la base de datos activa
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT usu_cc, usu_nombre, usu_apellido, usu_email FROM usuario;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                usuario usuariox = new usuario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                usuarios.add( usuariox );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }
    public ArrayList<usuario> getUsuarioByCc(int usu_cc) {
        ArrayList<usuario> usuarios = new ArrayList();
        try {
            if(conn == null)                            //Confirmar la conexion con DB
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT usu_cc, usu_nombre, usu_apellido, usu_email FROM usuario WHERE usu_cc=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, usu_cc);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                usuario usuariox = new usuario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                usuarios.add( usuariox );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }
        public ArrayList<usuario> getUsuarioByNombre(String nombre) {
        ArrayList<usuario> usuarios = new ArrayList();
        try {
            if(conn == null)                            //Confirmar la conexion con DB
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT usu_cc, usu_nombre, usu_apellido, usu_email FROM usuario WHERE usu_nombre=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                usuario usuariox = new usuario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                usuarios.add( usuariox );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }
    
    public void insertUsuario(usuario usuarios){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, usuarios.getUsu_cc());
            statement.setString(2, usuarios.getUsu_nombre());
            statement.setString(3, usuarios.getUsu_apellido());
            statement.setString(4, usuarios.getUsu_email());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    public void updateEmailUsuario(usuario usuarios) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE usuario SET usu_email =? WHERE usu_cc=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuarios.getUsu_email());
            statement.setInt(2, usuarios.getUsu_cc());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void deletePresentation(int usu_cc) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM usuario WHERE usu_cc=?;";
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
