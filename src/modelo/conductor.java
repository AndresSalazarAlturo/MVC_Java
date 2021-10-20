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
public class conductor {
    
    private int usu_cc;
    private String veh_placa;

    public conductor(int usu_cc, String veh_placa) {
        this.usu_cc = usu_cc;
        this.veh_placa = veh_placa;
    }

    /**
     * @return the usu_cc
     */
    public int getUsu_cc() {
        return usu_cc;
    }

    /**
     * @return the veh_placa
     */
    public String getVeh_placa() {
        return veh_placa;
    }

    @Override
    public String toString() {
        return "conductor{" + "usu_cc=" + usu_cc + ", veh_placa=" + veh_placa + '}';
    }
}
