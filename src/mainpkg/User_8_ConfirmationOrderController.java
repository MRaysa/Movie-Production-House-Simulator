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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelClass.CartItem;
import modelClass.Item;
import modelClass.ProductReadWrite;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class User_8_ConfirmationOrderController implements Initializable {

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
    @FXML
    private ComboBox<String> nameCombo;
    @FXML
    private ComboBox<Integer> QuantityCombo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCombo.getItems().addAll("Lighting Kit ", "Camera Equipment Package", " Audio Recording Devices ", "lehenga", "make_up","Green Screen and Backdrops",
                "Editing Software Licenses","Drone for Aerial Shots ","Special Effects Makeup Kit","Production Crew Services","Wardrobe and Costume Rentals"
        ,"Stunt Equipment","Catering Services  ","Transport and Logistics    ","Set Design and Construction"," Miscellaneous Production Supplies","High-Resolution Drone Cameras\n" +
"Advanced Audio Mixing Consoles" ,
"Wireless Communication Systems" ,
"Customizable LED Stage Lighting" ,
"Professional Grade Boom Microphones" ,
"Virtual Reality Filming Rig" ,
"Multi-Camera Live Streaming Setup" ,
"3D Scanning and Printing Services" ,
"Motion Capture Suits and Equipment" ,
"Augmented Reality Set Design Software");
        QuantityCombo.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 9,10,11,12,13,14,15,16,17,18,19,20,21,22);
        name.setCellValueFactory(new PropertyValueFactory("name"));
        quantity.setCellValueFactory(new PropertyValueFactory("quantity"));

        obl = FXCollections.observableArrayList();
        arr = ProductReadWrite.getArr();
        if (arr != null) {
            obl.addAll(arr);
            ProductTable.setItems(obl);
        }
    }

    @FXML
    private void addAction(ActionEvent event) {
        if (arr == null) {
            arr = new ArrayList();

        }
        Item newItem = new Item(nameCombo.getValue(), QuantityCombo.getValue());
        arr.add(newItem);
        obl.clear();
        obl.addAll(arr);
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
