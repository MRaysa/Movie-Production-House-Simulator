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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abuzafor
 */
public class User_6_DashbordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewProjectScheduleOnButtonClick(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            Parent r = loader.load(getClass().getResource("User_6_ViewProjectSchedule.fxml"));
            Scene sc = new Scene(r);

            Stage s = new Stage();
            s.setScene(sc);
            s.show();
    }

    @FXML
    private void orderPageOnButtonClick(ActionEvent event) throws IOException {
            Parent sceneA=FXMLLoader.load(getClass().getResource("User_6_orderPage.fxml"));
            Scene sceneB=new Scene(sceneA);
            Stage stg=(Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Student Scene");
            stg.setScene(sceneB);
            stg.show();
    }

    @FXML
    private void goCollaborationPageOnButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("ProducerMettingColabBorativeDash.fxml"));
        Scene sc = new Scene(r);

        Stage s = new Stage();
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void goToLoginPageOnButtonClick(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            Parent r = loader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene sc = new Scene(r);
            Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
            s.setScene(sc);
            s.show();
    }

    @FXML
    private void applyForLeaveOnButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("ProducerAprovalApply.fxml"));
        Scene sc = new Scene(r);

        Stage s = new Stage();
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void viewMeetingScheduleOnButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_7_8_CreateAppoinmentScheduleToProjectManager.fxml"));
        Scene sc = new Scene(r);

        Stage s = new Stage();
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void viewLocationOnButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("ProducersDateLocationViewer.fxml"));
        Scene sc = new Scene(r);

        Stage s = new Stage();
        s.setScene(sc);
        s.show();
    }
    
}
