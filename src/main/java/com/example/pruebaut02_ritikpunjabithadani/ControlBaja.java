package com.example.pruebaut02_ritikpunjabithadani;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * Clase que controla la ventana de la interfaz encargada de dar de baja un estudiante.
 */

public class ControlBaja {

    @FXML
    private TextField CIALField;

    /**
     * Método para dar de baja un estudiante que desplegará una ventana que nos informará si se realizó
     * correctamente o no.
     * @return
     */

    public boolean darDeBaja() {
        if(!(CIALField.getText().isBlank() || CIALField.getText().isEmpty()
        )) {
            boolean comprobado=Administrativo.darBajaEnBD(CIALField.getText());
            CIALField.setText("");
            if (comprobado) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Se ha dado de baja correctamente!");
                a.setTitle("Aviso!");
                a.setHeaderText(null);
                a.showAndWait();
                return true;
            }
        }
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("No se ha podido dar de baja, comprueba el campo!");
        a.setTitle("Aviso!");
        a.setHeaderText(null);
        a.showAndWait();
        return false;
    }
}
