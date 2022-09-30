package com.example.proyecto2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AgregarCuestionario {

    HelloController hC = new HelloController();

    @FXML
    private Button addCuestrionario;

    @FXML
    void onAddCuestionario(ActionEvent event) {
        Cuestionario cuest = new Cuestionario("222222", "Hola", "hola prueba");
        hC.pruebaAgregar(cuest);
    }

}
