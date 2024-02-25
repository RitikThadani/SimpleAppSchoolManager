package com.example.pruebaut02_ritikpunjabithadani;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Clase que controla la ventana de la interfaz encargada de mostrar los estudiantes matriculados.
 */

public class ControlMostrar implements Initializable {

    @FXML
    private TextArea listaEst;

    /**
     * Método que inicializa otros métodos al abrirse la interfaz.
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrar();
    }

    /**
     * Método que muestra en nuestro TextArea los estudiantes matriculados.
     */

    public void mostrar(){
        String mensaje=Administrativo.mostrarDatosdeBD();
        listaEst.setText(mensaje);
    }

}
