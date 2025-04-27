
package controller;


import javafx.fxml.FXML;


import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    @FXML
    public Label lblDob;

    @FXML
    public Label lblEmail;

    @FXML
    public Label lblGender;

    @FXML
    public Label lblId;

    @FXML
    public Label lblName;

    Student student=LoginFromController.studentArrayList.get(LoginFromController.studentArrayList.size()-1);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblId.setText(student.getId());
        lblName.setText(student.getName());
        lblEmail.setText(student.getEmail());
        lblDob.setText(student.getDob().toString());
        lblGender.setText(student.getGender());
    }

}

