/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelClass.Product;

/**
 * FXML Controller class
 *
 * @author Aysa
 */
public class User_8_Update_and_Delet_ProductController implements Initializable {

    @FXML
    private TableView<Product> productsTableView;
    @FXML
    private CheckBox selectAllCheckBoxTableColumn;
    @FXML
    private TableColumn<Product, String> productNameTableColumn;
    @FXML
    private TableColumn<Product, Double> unitPriceTableColumn;
    @FXML
    private TableColumn<Product, Double> preDefinedVatTableColumn;
    @FXML
    private TableColumn<Product, Integer> numItemsInStockTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Product> ProductList = FXCollections.observableArrayList();
        //    formate:  columnFxid.setCellValueFactory(new PropertyValueFactory<ModelClass, Type>("ModelcCassFieldName"));
        productNameTableColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        unitPriceTableColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("unitPrice"));
        preDefinedVatTableColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("preDefinedVat"));
        numItemsInStockTableColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("numItemsInStock"));

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("ProductsTableData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Product p;
            try {
                while (true) {
                    p = (Product) ois.readObject();
                    ProductList.add(p);
                    System.out.println(p.toString());
                }
            } catch (Exception e) {
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }

        }
        productsTableView.setItems(ProductList);
    }    

    @FXML
    private void Go_to_Dashboard_SceneSwitchingButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_8_Resource_Supplier_Dashboard.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void deleteProductButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void selectAllCheckBoxOnAction(ActionEvent event) {
    }
    
}
