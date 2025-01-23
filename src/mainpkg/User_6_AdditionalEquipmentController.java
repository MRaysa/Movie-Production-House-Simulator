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
import modelClass.EquipmentOrder;

public class User_6_AdditionalEquipmentController {

    @FXML
    private TextField equipmentNameTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private DatePicker orderDatePicker;

    @FXML
    private void submitOrderButtonOnClick() {
        String equipmentName = equipmentNameTextField.getText();
        int quantity = Integer.parseInt(quantityTextField.getText());
        LocalDate orderDate = orderDatePicker.getValue();

        EquipmentOrder equipmentOrder = new EquipmentOrder(equipmentName, quantity, orderDate);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("assignedEquipment.bin"))) {
            oos.writeObject(equipmentOrder);
            System.out.println("Equipment order saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving equipment order: " + e.getMessage());
        }
    }
}

