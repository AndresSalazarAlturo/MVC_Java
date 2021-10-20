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
public class viaje {
    
    private int via_id;
    private int usu_cc;
    private int con_cc;
    private String fecha;

    public viaje(int via_id, int usu_cc, int con_cc, String fecha) {
        this.via_id = via_id;
        this.usu_cc = usu_cc;
        this.con_cc = con_cc;
        this.fecha = fecha;
    }

    /**
     * @return the via_id
     */
    public int getVia_id() {
        return via_id;
    }

    /**
     * @param via_id the via_id to set
     */
    public void setVia_id(int via_id) {
        this.via_id = via_id;
    }

    /**
     * @return the usu_cc
     */
    public int getUsu_cc() {
        return usu_cc;
    }

    /**
     * @return the con_cc
     */
    public int getCon_cc() {
        return con_cc;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "viaje{" + "via_id=" + via_id + ", usu_cc=" + usu_cc + ", con_cc=" + con_cc + ", fecha=" + fecha + '}';
    }
}
