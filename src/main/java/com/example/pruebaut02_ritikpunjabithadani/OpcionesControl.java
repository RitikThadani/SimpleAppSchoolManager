package com.example.pruebaut02_ritikpunjabithadani;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase que tiene los los métodos para abrir las opciones que proporcionamos.
 */

public class OpcionesControl {
    @FXML
    private Button matricularButton;

    /**
     * Método para abrir la ventana para matricular.
     */

    public void abrirMatricular(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Matricular.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            Stage ventana = new Stage();
            Scene scene = new Scene(root);
            ventana.setTitle("Matricular");
            ventana.setScene(scene);
            ventana.show();
            cerrarVentana();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para abrir la ventana para dar de baja.
     */

    public void abrirBaja(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DarBaja.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            Stage ventana = new Stage();
            Scene scene = new Scene(root);
            ventana.setTitle("Dar Baja");
            ventana.setScene(scene);
            ventana.show();
            cerrarVentana();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para abrir la ventana para mostrar todos los estudiantes.
     */

    public void abrirMostrar(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MostrarEstudiante.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            Stage ventana = new Stage();
            Scene scene = new Scene(root);
            ventana.setTitle("Lista de Estudiantes");
            ventana.setScene(scene);
            ventana.show();
            cerrarVentana();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para abrir la ventana para cerrar la ventana.
     */

    public void cerrarVentana(){
        Stage ventanaPrincipal = (Stage) matricularButton.getScene().getWindow();
        ventanaPrincipal.close();
    }
}
