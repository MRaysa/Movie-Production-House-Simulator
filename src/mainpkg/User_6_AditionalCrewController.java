/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author abuzafor
 */
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import modelClass.CrewRequest;

public class User_6_AditionalCrewController {

    @FXML
    private TextField crewNameTextField;
    @FXML
    private TextField roleTextField;
    @FXML
    private DatePicker requestDatePicker;

    @FXML
    private void submitRequestButtonOnClick() {
        String crewName = crewNameTextField.getText();
        String role = roleTextField.getText();
        LocalDate requestDate = requestDatePicker.getValue();

        CrewRequest crewRequest = new CrewRequest(crewName, role, requestDate);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("crewRequestInfo.bin"))) {
            oos.writeObject(crewRequest);
            System.out.println("Crew request saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving crew request: " + e.getMessage());
        }
    }
}
