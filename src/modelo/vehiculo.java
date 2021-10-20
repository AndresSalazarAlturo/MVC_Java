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
public class vehiculo {
    
    private String veh_placa;
    private String veh_marca;
    private String veh_modelo;
    private int veh_anio;
    private int veh_capacidad;
    private String veh_color;
    private int veh_kilometros;

    public vehiculo(String veh_placa, String veh_marca, String veh_modelo, int veh_anio, int veh_capacidad, String veh_color, int veh_kilometros) {
        this.veh_placa = veh_placa;
        this.veh_marca = veh_marca;
        this.veh_modelo = veh_modelo;
        this.veh_anio = veh_anio;
        this.veh_capacidad = veh_capacidad;
        this.veh_color = veh_color;
        this.veh_kilometros = veh_kilometros;
    }

    /**
     * @return the veh_placa
     */
    public String getVeh_placa() {
        return veh_placa;
    }

    /**
     * @return the veh_marca
     */
    public String getVeh_marca() {
        return veh_marca;
    }

    /**
     * @param veh_marca the veh_marca to set
     */
    public void setVeh_marca(String veh_marca) {
        this.veh_marca = veh_marca;
    }

    /**
     * @return the veh_modelo
     */
    public String getVeh_modelo() {
        return veh_modelo;
    }

    /**
     * @param veh_modelo the veh_modelo to set
     */
    public void setVeh_modelo(String veh_modelo) {
        this.veh_modelo = veh_modelo;
    }

    /**
     * @return the veh_anio
     */
    public int getVeh_anio() {
        return veh_anio;
    }

    /**
     * @param veh_anio the veh_anio to set
     */
    public void setVeh_anio(int veh_anio) {
        this.veh_anio = veh_anio;
    }

    /**
     * @return the veh_capacidad
     */
    public int getVeh_capacidad() {
        return veh_capacidad;
    }

    /**
     * @param veh_capacidad the veh_capacidad to set
     */
    public void setVeh_capacidad(int veh_capacidad) {
        this.veh_capacidad = veh_capacidad;
    }

    /**
     * @return the veh_color
     */
    public String getVeh_color() {
        return veh_color;
    }

    /**
     * @param veh_color the veh_color to set
     */
    public void setVeh_color(String veh_color) {
        this.veh_color = veh_color;
    }

    /**
     * @return the veh_kilometros
     */
    public int getVeh_kilometros() {
        return veh_kilometros;
    }

    /**
     * @param veh_kilometros the veh_kilometros to set
     */
    public void setVeh_kilometros(int veh_kilometros) {
        this.veh_kilometros = veh_kilometros;
    }

    @Override
    public String toString() {
        return "vehiculo{" + "veh_placa=" + veh_placa + ", veh_marca=" + veh_marca + '}';
    }
}
