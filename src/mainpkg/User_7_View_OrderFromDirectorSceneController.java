/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class User_7_View_OrderFromDirectorSceneController implements Initializable {

    @FXML
    private TextArea readProduct;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadProductFromDirectorTextArea(ActionEvent event) {
        this.loadRequestedProductsFromTextFile();
        
    }
     

    private void loadRequestedProductsFromTextFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("requestedProducts.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            readProduct.setText(content.toString());

            // Display success alert
            showAlert("Success", "Requested products loaded successfully.");
        } catch (FileNotFoundException e) {
            // Handle the case when the file is not found
            e.printStackTrace();
            showAlert("Error", "Requested products file not found.");
        } catch (IOException e) {
            // Handle other exceptions
            e.printStackTrace();
            showAlert("Error", "Could not load requested products from text file.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void backToProjectManager(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("Project_Manager_Dashboard.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    
}
