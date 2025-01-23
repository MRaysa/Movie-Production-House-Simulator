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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import modelClass.Product;
import modelClass.ProductTableData;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class User_8_View_All_ProductController implements Initializable {

    @FXML
    private TableView<ProductTableData> productsTableView;
    @FXML
    private TableColumn<ProductTableData, String> productNameTableColumn;
    @FXML
    private TableColumn<ProductTableData, Float> unitPriceTableColumn;
    @FXML
    private TableColumn<ProductTableData, Float> preDefinedVatTableColumn;
    @FXML
    private TableColumn<ProductTableData, Integer> numItemsInStockTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

productNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productNameTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        unitPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        unitPriceTableColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        preDefinedVatTableColumn.setCellValueFactory(new PropertyValueFactory<>("preDefinedVatRate"));
        preDefinedVatTableColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        numItemsInStockTableColumn.setCellValueFactory(new PropertyValueFactory<>("numItemsInStock"));
        numItemsInStockTableColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        productsTableView.setEditable(true);

        try {
            ObservableList<ProductTableData> allProductTableData = ProductTableData.loadAll();

            if (allProductTableData != null) {
                productsTableView.setItems(allProductTableData);
            }
        } catch (IOException ex) {
            Logger.getLogger(U_8_Add_New_Product_And_DelectProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(U_8_Add_New_Product_And_DelectProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    
}
