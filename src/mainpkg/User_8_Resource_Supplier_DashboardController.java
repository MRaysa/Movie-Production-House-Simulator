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
public class User_8_Resource_Supplier_DashboardController implements Initializable {

    private String desig;
    private String name;
    @FXML
    private Label user_name;
    private User user;

    public void initData(User u) {
        this.user = u;
        this.desig = user.getDesig();
        this.name = user.getName();
        //      user_name.setText("Welcome " + this.desig + this.name);
//        user_name.setText("User" + this.desig + this.name);
        user_name.setText("User " + this.desig + " : " + this.name);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void add_New_Product_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("U_8_Add_New_Product_And_DelectProduct.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();

    }

    @FXML
    private void confirm_order_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_8_ConfirmationOrder.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    private void delet_Product_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("U_8_Add_New_Product_And_DelectProduct.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void view_order_details_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_8_VIewOrderDetails.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void view_order_history_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_8_ViewOrderHistoryScene.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void product_Performance_analysis_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_8_Product_Chart_Analysis.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void creat_AppoinmentToProjectManager_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_7_8_CreateAppoinmentScheduleToProjectManager.fxml"));
        Scene sc = new Scene(r);

        Stage s = new Stage();
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void logout_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void view_All_Product_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_8_View_All_Product.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void CollaborateSceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("ProducerMettingColabBorativeDash.fxml"));
        Scene sc = new Scene(r);

        Stage s = new Stage();
        s.setScene(sc);
        s.show();
    }

}
