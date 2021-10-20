/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Andres Salazar
 */
public class usuario {
    
    private int usu_cc; 
    private String usu_nombre; 
    private String usu_apellido;
    private String usu_email;

    public usuario(int usu_cc, String usu_nombre, String usu_apellido, String usu_email) {
        this.usu_cc = usu_cc;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.usu_email = usu_email;
    }

    /**
     * @return the usu_cc
     */
    public int getUsu_cc() {
        return usu_cc;
    }

    /**
     * @return the usu_nombre
     */
    public String getUsu_nombre() {
        return usu_nombre;
    }

    /**
     * @return the usu_apellido
     */
    public String getUsu_apellido() {
        return usu_apellido;
    }

    /**
     * @return the usu_email
     */
    public String getUsu_email() {
        return usu_email;
    }

    /**
     * @param usu_email the usu_email to set
     */
    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    @Override
    public String toString() {
        return "usuario{" + "usu_cc=" + usu_cc + ", usu_nombre=" + usu_nombre + '}';
    }
    
}
