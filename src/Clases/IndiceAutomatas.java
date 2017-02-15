/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Wilson Xicará
 */
public class IndiceAutomatas {
    private String nombreAutomata, descripcion;
    private int punteroARefDatos, punteroADatos, punteroARefDescripcion, punteroADescripcion;
    
    /**
     * Inicializa un nuevo objeto, con sus atributos vacíos.
     */
    public IndiceAutomatas() {
        nombreAutomata = "";
        descripcion = "<Sin descripción>";
        punteroARefDatos = punteroADatos = punteroARefDescripcion = punteroADescripcion = 0;
    }

    /**
     * Función que devuelve el Nombre del Autómata del cual tiene referencia.
     * @return el String con el Nombre del Autómata.
     */
    public String getNombreAutomata() { return nombreAutomata; }
    /**
     * Función que devuelve la Descripción del Autómata del cual tiene referencia.
     * @return el String con la Descripción del Autómata.
     */
    public String getDescripcion() { return descripcion; }
    /**
     * Función que devuelve el puntero (dentro del archivo) donde está la Referencia, en el Índice, del Registro del Autómata.
     * @return el entero que indica la posición en Índice del archivo donde inicia el bloque de Referencia al Registro de datos.
     */
    public int getPunteroARefDatos() { return punteroARefDatos; }
    /**
     * Función que devuelve el puntero (dentro del archivo) donde está el Registro del Autómata.
     * @return el entero que indica la posición donde inicia el bloque de Registro de datos.
     */
    public int getPunteroADatos() { return punteroADatos; }
    /**
     * Función que devuelve el puntero (dentro del archivo) donde está la Referencia, en el Índice, de la Descripción del Autómata.
     * @return el entero que indica la posición en Índice del archivo donde inicia el bloque de Referencia a la Descripción del Autómata.
     */
    public int getPunteroARefDescripcion() { return punteroARefDescripcion; }
    /**
     * Función que devuelve el puntero (dentro del archivo) donde está la Descripción del Autómata.
     * @return el entero que indica la posición donde inicia el bloque de Descripción del Autómata.
     */
    public int getPunteroADescripcion() { return punteroADescripcion; }

    public void setNombreAutomata(String nombreAutomata) { this.nombreAutomata = nombreAutomata; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPunteroARefDatos(int punteroARefDatos) { this.punteroARefDatos = punteroARefDatos; }
    public void setPunteroADatos(int punteroADatos) { this.punteroADatos = punteroADatos; }
    public void setPunteroARefDescripcion(int punteroARefDescripcion) { this.punteroARefDescripcion = punteroARefDescripcion; }
    public void setPunteroADescripcion(int punteroADescripcion) { this.punteroADescripcion = punteroADescripcion; }
}
