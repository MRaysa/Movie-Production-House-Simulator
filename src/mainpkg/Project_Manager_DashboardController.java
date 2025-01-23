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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aysa
 */
public class Project_Manager_DashboardController implements Initializable {

    private String desig;
    private String name;
    @FXML
    private Label user_name;
    private User user;

    public void initData(User u) {
        this.user=u;
        this.desig = user.getDesig();
        this.name = user.getName();

        user_name .setText("User "+this.desig+" : "+this.name); 
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void CreatAppoinmentScheduleDashboardSceneSwitchButtonOnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_7_8_CreateAppoinmentScheduleToProjectManager.fxml"));
        Scene sc = new Scene(r);

        Stage s = new Stage();
        s.setScene(sc);
        s.show();
    }

//        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

    @FXML
    private void CollaborateOnBudgetSceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        
                FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProducerSpendOfProject.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerSpendOfProjectController c = loader.getController();
        c.initData(user.getMovieName());
        Stage s = new Stage();
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void InventoryManagementSceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_7_Inventory_Management.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void CollaborateSceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_7_Collaborate.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();

    }

    @FXML
    private void Go_to_loginPage_OnActionButttonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void placeOrder_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("U_7_Place_Order.fxml"));
        Scene sc = new Scene(r);

        Stage s = new Stage();
        s.setScene(sc);
        s.show();

    }

    @FXML
    private void ViewDirectorPurchaseRequestSceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_7_View_OrderFromDirectorScene.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void Apply_For_LeaveButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProducerAprovalApply.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerAprovalApplyController c = loader.getController();
        c.initData(user);
        Stage s = new Stage();
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void ViewAllMovieLocationSceneSwitchingButtonOnAction(ActionEvent event) throws IOException {

                        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProducersDateLocationViewer.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersDateLocationViewerController c = loader.getController();
        c.initData2(user);
        Stage s = new Stage();
        s.setScene(sc);
        s.show();
    }

}
