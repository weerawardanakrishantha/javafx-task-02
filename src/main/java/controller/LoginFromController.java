
package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;

public class LoginFromController {

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String email=txtEmail.getText();
        String password=txtPassword.getText();
        Student student=findStudent(email);

            if (student.getPassword().equals(password)) {

                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/dashboard-view.fxml"))));
                stage.show();


            } else {
                new Alert(Alert.AlertType.INFORMATION, "not a valid password").show();
            }

    }
    private Student findStudent(String email){
        for(Student student: DBConnection.getInstance().getConnection()){
            if(student.getEmail().equals(email)){
                return student;
            }
        }
        return null;
    }
}
