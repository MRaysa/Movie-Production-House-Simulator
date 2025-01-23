/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abuzafor
 */
public class User_5_OrderStatusController implements Initializable {

    @FXML
    private TableColumn<?, ?> movieNameCollum;
    @FXML
    private TableColumn<?, ?> orderIdCollum;
    @FXML
    private TableColumn<?, ?> orderDateCollum;
    @FXML
    private TableColumn<?, ?> orderStatusCollum;
    @FXML
    private TableView<?> orderStatusTableVIew;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backMainPageOnClick(ActionEvent event) throws IOException {
            Parent sceneA=FXMLLoader.load(getClass().getResource("FXMLDocument_1.fxml"));
            Scene sceneB=new Scene(sceneA);
            Stage stg=(Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Student Scene");
            stg.setScene(sceneB);
            stg.show();
    }
    
}
