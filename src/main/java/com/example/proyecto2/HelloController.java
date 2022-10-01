package com.example.proyecto2;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    //PANE PRINCIPAL
    @FXML
    private Pane panePrincipal;

    @FXML
    private Button btnEvaluar;


    //TABLES
    @FXML
    private TableView<Cuestionario> table;
    //TEXTS
    @FXML
    private Text pinTxt;
    @FXML
    private Text nombreTxt;
    @FXML
    private Text descripcionTxt;
    @FXML
    private TextField pinFld;
    @FXML
    private TextField nombreFld;
    @FXML
    private TextArea descFld;

    @FXML
    private TableColumn<Cuestionario, String> pin;

    @FXML
    private TableColumn<Cuestionario, String> nombre;

    @FXML
    private TableColumn<Cuestionario, String> descripcion;

    ObservableList<Cuestionario> list = FXCollections.observableArrayList(
            new Cuestionario("123456", "Erick", "Esto es una prueba", "REGISTRADO"),
            new Cuestionario("123456", "Juan", "Esto es una prueba", "REGISTRADO")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pin.setCellValueFactory(new PropertyValueFactory<Cuestionario, String>("pin"));
        nombre.setCellValueFactory(new PropertyValueFactory<Cuestionario, String>("nombre"));
        descripcion.setCellValueFactory(new PropertyValueFactory<Cuestionario, String>("descripcion"));

        table.setItems(list);

//        OCULTAR ITEMS AGREGAR
        pinTxt.setVisible(false);
        pinFld.setVisible(false);
        nombreTxt.setVisible(false);
        nombreFld.setVisible(false);
        descripcionTxt.setVisible(false);
        descFld.setVisible(false);
    }

    public void abrirAgregarCuestionario() throws IOException {
        Boolean prFld = nombreFld.isVisible();
        if(pinFld.getText().isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i=100000; i<999999; i++) list.add(i);
            Collections.shuffle(list);
            for (int i=0; i<1; i++) pinFld.setText(Integer.toString(list.get(i)));
        }

        if (nombreFld.getText() == null || nombreFld.getText().trim().isEmpty() &&
            descFld.getText() == null || descFld.getText().trim().isEmpty()) {
            pinTxt.setVisible(!prFld);
            pinFld.setVisible(!prFld);
            nombreTxt.setVisible(!prFld);
            nombreFld.setVisible(!prFld);
            descripcionTxt.setVisible(!prFld);
            descFld.setVisible(!prFld);
        } else {
            Cuestionario cuest = new Cuestionario(pinFld.getText(), nombreFld.getText(), descFld.getText(), "REGISTRADO");
            table.getItems().add(cuest);

            pinFld.clear();
            nombreFld.clear();
            descFld.clear();

//            OCULTAR ITEMS CUANDO SI TENGAN VALOR ITEMS
            pinTxt.setVisible(!prFld);
            pinFld.setVisible(!prFld);
            nombreTxt.setVisible(!prFld);
            nombreFld.setVisible(!prFld);
            descripcionTxt.setVisible(!prFld);
            descFld.setVisible(!prFld);
        }


//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("agregarCuestionario.fxml"));
//        Pane root = (Pane) fxmlLoader.load();
//        Scene scene = new Scene(root, 600, 500);
//        Stage stage = new Stage();
//        stage.setTitle("UMG APP");
//        stage.setScene(scene);
//        stage.show();
    }
    @FXML
    void clonarCuestionario(ActionEvent event) {
        Cuestionario cuestionario = new Cuestionario("", table.getSelectionModel().getSelectedItem().getNombre(), table.getSelectionModel().getSelectedItem().getDescripcion(), "REGISTRADO");
        list.add(cuestionario);
        System.out.println(cuestionario.getPin());
    }
    public void pruebaAgregar(Cuestionario cuest){
        System.out.println(cuest);
//        table.getItems().add(cuest);

        list.add(cuest);
    }


    //PANE EVALUACION
    @FXML
    private Pane paneEvaluacion;

    @FXML
    void abrirEvaluar(ActionEvent event) {
//        if(event.getSource() == btnEvaluar) paneEvaluacion.toFront();
        //Traer al frente pane evaluacion
        paneEvaluacion.toFront();
    }
}
