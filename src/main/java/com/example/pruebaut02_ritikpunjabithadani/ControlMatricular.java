package com.example.pruebaut02_ritikpunjabithadani;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Clase que controla la ventana de la interfaz encargada de matricular un estudiante.
 */

public class ControlMatricular {
    @FXML
    private Button matricularButton;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidosField;
    @FXML
    private TextField CIALField;
    @FXML
    private TextField direccionField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField tlfField;
    @FXML
    private TextField cicloField;
    @FXML
    private TextField cursoField;

    /**
     * Método para matricular un estudiante que comprueba si alguno de los campos están vacíos, si se logra matricular
     * nos informará positivamente y en el caso contraria saltará una ventana de error.
     * @return
     */

    public boolean matricular() {
        if(!(CIALField.getText().isBlank() || CIALField.getText().isEmpty()
                || nombreField.getText().isBlank() || nombreField.getText().isEmpty()
                || apellidosField.getText().isBlank() || apellidosField.getText().isEmpty()
                || direccionField.getText().isBlank() || direccionField.getText().isEmpty()
                || emailField.getText().isBlank() || emailField.getText().isEmpty()
                || tlfField.getText().isBlank() || tlfField.getText().isEmpty()
                || cicloField.getText().isBlank() || cicloField.getText().isEmpty()
                || cursoField.getText().isBlank() || cursoField.getText().isEmpty()
        )) {
            boolean comprobado=Administrativo.matricularEnBD(CIALField.getText(), nombreField.getText(), apellidosField.getText(), direccionField.getText(), emailField.getText(),
                    tlfField.getText(), cicloField.getText(), cursoField.getText());
            nombreField.setText("");
            apellidosField.setText("");
            CIALField.setText("");
            direccionField.setText("");
            emailField.setText("");
            tlfField.setText("");
            cicloField.setText("");
            cursoField.setText("");
            if (comprobado) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Se ha matriculado correctamente!");
                a.setTitle("Aviso!");
                a.setHeaderText(null);
                a.showAndWait();
                return true;
            }
        }
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("No se ha podido matricular, comprueba los campos!");
        a.setTitle("Aviso!");
        a.setHeaderText(null);
        a.showAndWait();
        return false;
    }
}
