/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author abuzafor
 */
public class User_5_DashbordController implements Initializable {

    @FXML
    private Label clientNameLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void viewProjectPageOnButtonClick(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            Parent r = loader.load(getClass().getResource("User_5_viewProject.fxml.fxml"));
            Scene sc = new Scene(r);

            Stage s = new Stage();
            s.setScene(sc);
            s.show();
            
    }

    @FXML
    private void viewUpcomingProjectPageOnButtonClick(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            Parent r = loader.load(getClass().getResource("User_5_UpcommingProject.fxml"));
            Scene sc = new Scene(r);

            Stage s = new Stage();
            s.setScene(sc);
            s.show();
            
            
    }

    @FXML
    private void viewBookedProjectPageOnButtonClick(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            Parent r = loader.load(getClass().getResource("User_5_projectBooking.fxml"));
            Scene sc = new Scene(r);

            Stage s = new Stage();
            s.setScene(sc);
            s.show();
            
    }

    @FXML
    private void viewOrderStatusPageOnButtonClick(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            Parent r = loader.load(getClass().getResource("User_5_OrderStatus.fxml"));
            Scene sc = new Scene(r);

            Stage s = new Stage();
            s.setScene(sc);
            s.show();
    }

    @FXML
    private void goLoginPageOnButtonClick(ActionEvent event) throws IOException {
            Parent sceneA=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene sceneB=new Scene(sceneA);
            Stage stg=(Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Student Scene");
            stg.setScene(sceneB);
            stg.show();
    }

    @FXML
    private void goToFinancialUpdatePageOnButtonClick(ActionEvent event) throws IOException {
            Parent sceneA=FXMLLoader.load(getClass().getResource("User_5_FInancialUpdate.fxml"));
            Scene sceneB=new Scene(sceneA);
            Stage stg=(Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Student Scene");
            stg.setScene(sceneB);
            stg.show();
    }
    
}
