/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelClass.Item;
import modelClass.ProductReadWrite;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class User_8_VIewOrderDetailsController implements Initializable {

    @FXML
    private TableView<Item> ProductTable;
    @FXML
    private TableColumn<Item, String> name;
    @FXML
    private TableColumn<Item, Integer> quantity;

    /**
     * Initializes the controller class.
     */
    
    ArrayList<Item> arr;
    ObservableList<Item> obl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               name.setCellValueFactory(new PropertyValueFactory("name"));
        quantity.setCellValueFactory(new PropertyValueFactory("quantity"));

        obl = FXCollections.observableArrayList();
        arr = ProductReadWrite.getArr();
        ProductTable.setItems(obl);
        ProductReadWrite.writeObj(arr);
    }    

    @FXML
    private void backToResourceSupplierDashboard(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_8_Resource_Supplier_Dashboard.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }
    
}
