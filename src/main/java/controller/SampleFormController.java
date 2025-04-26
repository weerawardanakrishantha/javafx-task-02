package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SampleFormController implements Initializable {

    @FXML
    private ComboBox cmbGender;

    @FXML
    private DatePicker dateDob;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/login-view.fxml"))));
        stage.show();
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        String id=txtId.getText();
        String name=txtName.getText();
        String email=txtEmail.getText();
        String password=txtPassword.getText();
        LocalDate dob=dateDob.getValue();
        String gender=cmbGender.getValue().toString();

        Student student=new Student(id,name,email,password,dob,gender);
        DBConnection.getInstance().getConnection().add(student);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCmb();
    }
    private void loadCmb(){
        ObservableList<String> genderList= FXCollections.observableArrayList();
        genderList.add("Male");
        genderList.add("Female");
        cmbGender.setItems(genderList);
    }
}

