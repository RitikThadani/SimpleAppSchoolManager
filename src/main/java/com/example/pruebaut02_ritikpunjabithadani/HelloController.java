package com.example.pruebaut02_ritikpunjabithadani;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Clase que controla nuestra interfaz principal.
 */

public class HelloController implements Initializable {

    @FXML
    private TextField usuarioField;
    @FXML
    private TextField contraField;
    @FXML
    private Button iniciarButton;

    /**
     * Método para iniciar sesión.
     */

    public void iniciarSesion() {
        if(!(usuarioField.getText().isBlank() || contraField.getText().isBlank())){
            boolean comprobado = Administrativo.comprobarUsuario(usuarioField.getText(), contraField.getText());
            if(comprobado){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Opciones.fxml"));
                Parent root;
                try {
                    root = fxmlLoader.load();
                    Stage ventana = new Stage();
                    Scene scene = new Scene(root);
                    ventana.setTitle("Opciones");
                    ventana.setScene(scene);
                    ventana.show();
                    cerrarVentana();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else{
                Alert a  = new Alert(Alert.AlertType.ERROR);
                a.setContentText("La Combinación no es Correcta!");
                a.setTitle("Aviso!");
                a.setHeaderText(null);
                a.showAndWait();
            }
        }
    }

    /**
     * Método que cierra la ventana.
     */

    public void cerrarVentana(){
        Stage ventanaPrincipal = (Stage) iniciarButton.getScene().getWindow();
        ventanaPrincipal.close();
    }

    /**
     * Método que inicializa otros métodos al ejecutarse la interfaz, en este caso establece la conexión.
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Administrativo.connection();
    }
}
