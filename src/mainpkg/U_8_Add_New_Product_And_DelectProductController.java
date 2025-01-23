/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import modelClass.DialogBoxTools;
import modelClass.Product;
import modelClass.ProductTableData;
import modelClass.SceneTools;

/**
 * FXML Controller class
 *
 * @author Aysa
 */
public class U_8_Add_New_Product_And_DelectProductController implements Initializable, SceneTools, DialogBoxTools {

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
    @FXML
    private TextField productNameTextField;
    @FXML
    private TextField unitPriceTextField;
    @FXML
    private TextField preDefinedVatTextField;
    @FXML
    private TextField numItemsInStockTextField;
    @FXML
    private Label usernameDisplayLabel;
    @FXML
    private TableColumn<ProductTableData, Boolean> selectAllCheckBoxTableColumn;
    @FXML
    private CheckBox selectAllCheckBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectAllCheckBoxTableColumn.setCellValueFactory(new PropertyValueFactory<>("selected"));
        selectAllCheckBoxTableColumn.setCellFactory(cell -> {
            CheckBoxTableCell myCell = new CheckBoxTableCell<>();

            return myCell;
        });

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
    private void productNameTableColumnOnEditCommit(TableColumn.CellEditEvent<ProductTableData, String> event) throws IOException, FileNotFoundException, ClassNotFoundException {
        ProductTableData currentRow = event.getRowValue();

        if (event.getNewValue().length() > 4) {
            currentRow.setProductName(event.getNewValue());
            currentRow.update();
        } else {

            showError("Product Name must be at least 4 characters long");
            productsTableView.refresh();
        }
    }

    @FXML
    private void unitPriceTableColumnOnEditCommit(TableColumn.CellEditEvent<ProductTableData, Float> event) throws IOException, FileNotFoundException, ClassNotFoundException {
        ProductTableData currentRow = event.getRowValue();

        System.out.println("unit price: " + event.getNewValue());
        if (event.getNewValue() >= 1.0f) {
            currentRow.setUnitPrice(event.getNewValue());
            currentRow.update();
        } else {
            Alert msgbox = new Alert(Alert.AlertType.ERROR);
            msgbox.setContentText("Unit Price must be at least 1 taka");
            msgbox.showAndWait();
            productsTableView.refresh();
        }
    }

    @FXML
    private void preDefinedVatTableColumnOnEditCommit(TableColumn.CellEditEvent<ProductTableData, Float> event) throws IOException, FileNotFoundException, ClassNotFoundException {
        ProductTableData currentRow = event.getRowValue();

        if (event.getNewValue() >= 0) {
            currentRow.setPreDefinedVatRate(event.getNewValue());
            currentRow.update();
        } else {
            Alert msgbox = new Alert(Alert.AlertType.ERROR);
            msgbox.setContentText("Pre Defined Vat Rate must be a positive number or 0");
            msgbox.showAndWait();
            productsTableView.refresh();
        }
    }

    @FXML
    private void numItemsInStockTableColumnOnEditCommit(TableColumn.CellEditEvent<ProductTableData, Integer> event) throws IOException, FileNotFoundException, ClassNotFoundException {
        ProductTableData currentRow = event.getRowValue();

        if (event.getNewValue() > 0) {
            currentRow.setNumItemsInStock(event.getNewValue());
            currentRow.update();
        } else {
            Alert msgbox = new Alert(Alert.AlertType.ERROR);
            msgbox.setContentText("Number of Items in Stock must be at least 1");
            msgbox.showAndWait();
            productsTableView.refresh();
        }
    }

    private Product getProductFromTextFields() throws IOException, FileNotFoundException, ClassNotFoundException {
        Alert msgbox = new Alert(Alert.AlertType.ERROR);

        String productName = productNameTextField.getText();
        float unitPrice, preDefinedVatRate;
        int numItemsInStock;

        if (productName.length() < 5) {
            msgbox.setContentText("Product name must be at least 5 characters long");
            msgbox.showAndWait();
            return null;
        }

        try {
            unitPrice = Float.parseFloat(unitPriceTextField.getText());
        } catch (NumberFormatException ex) {
            msgbox.setContentText("Unit Price must be a real number");
            msgbox.showAndWait();
            return null;
        }

        if (unitPrice < 1) {
            msgbox.setContentText("Unit Price must be at least 1 taka");
            msgbox.showAndWait();
            return null;
        }

        try {
            preDefinedVatRate = Float.parseFloat(preDefinedVatTextField.getText());
        } catch (NumberFormatException ex) {
            msgbox.setContentText("Pre Defined Vat Rate must be a real number");
            msgbox.showAndWait();
            return null;
        }

        if (preDefinedVatRate < 0) {
            msgbox.setContentText("Pre Defined Vat Rate must be a positive number or 0");
            msgbox.showAndWait();
            return null;
        }

        try {
            numItemsInStock = Integer.parseInt(numItemsInStockTextField.getText());
        } catch (NumberFormatException ex) {
            msgbox.setContentText("Number of Items in Stock must be a whole number");
            msgbox.showAndWait();
            return null;
        }

        if (numItemsInStock < 1) {
            msgbox.setContentText("Number of Items in Stock must be at least 1");
            msgbox.showAndWait();
            return null;
        }

        Product newProduct = new Product(productName, unitPrice, preDefinedVatRate, numItemsInStock);

        return newProduct;
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {

        Product newProduct = getProductFromTextFields();

        if (newProduct != null) {
            ProductTableData newProductTableData = new ProductTableData(newProduct);
            for (ProductTableData eachProduct : productsTableView.getItems()) {
                if (newProduct.getProductName().equals(eachProduct.getProductName())) {
                    Alert msgbox = new Alert(Alert.AlertType.ERROR);
                    msgbox.setContentText("Product already exists. To edit the product, double click a cell in the table below");
                    msgbox.showAndWait();
                    return;
                }
            }
            productsTableView.getItems().add(newProductTableData);
            newProduct.save();
        }
    }

    @FXML
    private void logoutButtonOnClick(ActionEvent event) throws IOException {
       // switchScene(event, getClass().getResource("User_8_Resource_Supplier_Dashboard.fxml"));
                FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_8_Resource_Supplier_Dashboard.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }

    @Override
    public void initializeScene(HashMap<Object, Object> sceneData) {
    }

    @FXML
    private void selectAllCheckBoxOnClick(ActionEvent event) {
        for (ProductTableData eachProduct : productsTableView.getItems()) {
            eachProduct.setSelected(selectAllCheckBox.isSelected());
        }
    }

    @FXML
    private void deleteButtonOnClick(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        if (askYesNo("Are you sure you want to delete the selected products?")) {
            int i = 0;

            while (i < productsTableView.getItems().size()) {
                if (productsTableView.getItems().get(i).isSelected()) {
                    productsTableView.getItems().get(i).delete();
                    productsTableView.getItems().remove(i);
                } else {
                    i++;
                }
            }

            selectAllCheckBox.setSelected(false);
            productsTableView.refresh();
        }
    }

}
