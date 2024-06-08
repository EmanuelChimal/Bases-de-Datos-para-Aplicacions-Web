/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import java.io.Serializable;

/**
 *
 * @author Emanu
 */
public class Escuela implements Serializable {
    private String claveEscuela;
    private String nombreEscuela;
    private String domicilio;
    private int codigoPostal;
    private String turno;
    private int idLocalidad;

    // Constructor vacío
    public Escuela() {
    }

    // Getters y Setters
    public String getClaveEscuela() {
        return claveEscuela;
    }

    public void setClaveEscuela(String claveEscuela) {
        this.claveEscuela = claveEscuela;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
}
