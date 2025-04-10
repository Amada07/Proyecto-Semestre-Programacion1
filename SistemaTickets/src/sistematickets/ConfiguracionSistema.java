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
    private String nombreEmpresa;
    private String idioma;
    private String zonaHoraria;
    private int tiempoVencimiento;
    private String[] nivelesPrioridad;

    public ConfiguracionSistema(String nombreEmpresa, String idioma, String zonaHoraria, int tiempoVencimiento, String[] nivelesPrioridad) {
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
        if (nivelesPrioridad == null || nivelesPrioridad.length < 3) {
            throw new IllegalArgumentException("Debe haber al menos 3 niveles de prioridad");
        }

        this.nombreEmpresa = nombreEmpresa;
        this.idioma = idioma;
        this.zonaHoraria = zonaHoraria;
        this.tiempoVencimiento = tiempoVencimiento;
        this.nivelesPrioridad = nivelesPrioridad;
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
}