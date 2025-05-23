/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

/**
 *
 * @author Amada
 */


public class ConfiguracionSistema {
    private int idConfiguracion;
    private String nombreEmpresa;
    private String idioma;
    private String zonaHoraria;
    private int tiempoVencimiento;
    private String nivelesPrioridad;

    public ConfiguracionSistema(int idConfiguracion,String nombreEmpresa, String idioma, String zonaHoraria, int tiempoVencimiento, String nivelesPrioridad) {
        if (nombreEmpresa == null || nombreEmpresa.isEmpty() || nombreEmpresa.length() < 3) {
            throw new IllegalArgumentException("El nombre de la empresa debe tener al menos 3 caracteres");
        }
        if (idioma == null || idioma.isEmpty()) {
            throw new IllegalArgumentException("Seleccione un idioma");
        }
        if (zonaHoraria == null || zonaHoraria.isEmpty()) {
            throw new IllegalArgumentException("La zona horaria no puede estar vacía");
        }
        if (tiempoVencimiento < 1 || tiempoVencimiento > 365) {
            throw new IllegalArgumentException("El tiempo de vencimiento debe estar entre 1 y 365 días");
        }
        if (nivelesPrioridad == null || nivelesPrioridad.isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos 3 niveles de prioridad");
        }
       // constructor con ID 
        this.idConfiguracion=idConfiguracion;
        this.nombreEmpresa = nombreEmpresa;
        this.idioma = idioma;
        this.zonaHoraria = zonaHoraria;
        this.tiempoVencimiento = tiempoVencimiento;
        this.nivelesPrioridad = nivelesPrioridad;
    }
    // Constructor sin ID (Para guardar nueva configuración)
    public ConfiguracionSistema(String nombreEmpresa, String idioma, String zonaHoraria, int tiempoVencimiento, String nivelesPrioridad) {
        this.nombreEmpresa = nombreEmpresa;
        this.idioma = idioma;
        this.zonaHoraria = zonaHoraria;
        this.tiempoVencimiento = tiempoVencimiento;
        this.nivelesPrioridad = nivelesPrioridad;
    }

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        if (nombreEmpresa == null || nombreEmpresa.isEmpty() || nombreEmpresa.length() < 3) {
            throw new IllegalArgumentException("El nombre de la empresa debe tener al menos 3 caracteres");
        }
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getTiempoVencimiento() {
        return tiempoVencimiento;
    }

    public void setTiempoVencimiento(int tiempoVencimiento) {
        if (tiempoVencimiento < 1 || tiempoVencimiento > 365) {
            throw new IllegalArgumentException("El tiempo de vencimiento debe estar entre 1 y 365 días");
        }
        this.tiempoVencimiento = tiempoVencimiento;
        
        
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public String getNivelesPrioridad() {
        return nivelesPrioridad;
    }

    public void setNivelesPrioridad(String nivelesPrioridad) {
        this.nivelesPrioridad = nivelesPrioridad;
    }
}