/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import modelClass.CartItem;
import modelClass.DialogBoxTools;
import modelClass.Product;
import modelClass.SceneTools;

/**
 * FXML Controller class
 *
 * @author Aysa
 */
public class U_7_Place_OrderController implements Initializable, SceneTools, DialogBoxTools {

    @FXML
    private ComboBox<Product> selectProductComboBox;
    @FXML
    private ComboBox<Integer> quantityComboBox;
    @FXML
    private Label unitPriceLabel;
    @FXML
    private Label predefinedVatLabel;

    @FXML
    private TableView<CartItem> cartItemTable;
    @FXML
    private TableColumn<CartItem, String> productNameTableColumn;
    @FXML
    private TableColumn<CartItem, Float> unitPriceTableColumn;
    @FXML
    private TableColumn<CartItem, Integer> quantityTableColumn;
    @FXML
    private TableColumn<CartItem, Float> totalPriceTableColumn;
    @FXML
    private TableColumn<CartItem, Float> vatTableColumn;
    @FXML
    private TableColumn<CartItem, Float> vatAmountTableColumn;
    @FXML
    private TableColumn<CartItem, Float> totalPriceWithVatTableColumn;
    @FXML
    private Label totalAmountOutputLabel;
    @FXML
    private Label numItemsInStockLabel;
    @FXML
    private Label usernameDisplayLabel;

    @FXML
    private TableColumn<CartItem, Boolean> selectAllCheckBoxTableColumn;

    @FXML
    private CheckBox selectAllCheckBox;
    @FXML
    private Button goBackButton;

    ArrayList<CartItem> arr;
    ObservableList<CartItem> obl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//
//           obl= FXCollections.observableArrayList();
//           arr=ProductReadWrite.getArr();
//           if(arr!=null){
//           obl.addAll(arr);
//           cartItemTable.setItems(obl);
//           }
//

        for (int i = 1; i <= 10; i++) {
            quantityComboBox.getItems().add(i);
        }

        quantityComboBox.getSelectionModel().selectFirst();

        ArrayList<Product> allProducts;
        try {
            allProducts = Product.loadAll();
            if (allProducts != null) {
                selectProductComboBox.getItems().addAll(allProducts);
                selectProductComboBox.getSelectionModel().selectFirst();
            }

        } catch (IOException ex) {
            Logger.getLogger(U_7_Place_OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(U_7_Place_OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        updateProductInfo();

        selectAllCheckBoxTableColumn.setCellValueFactory(new PropertyValueFactory<>("selected"));
        selectAllCheckBoxTableColumn.setCellFactory(cell
                -> {
            CheckBoxTableCell<CartItem, Boolean> myCell = new CheckBoxTableCell<>();

            return myCell;
        });

        productNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        unitPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityTableColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        totalPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        vatTableColumn.setCellValueFactory(new PropertyValueFactory<>("vatRate"));
        vatAmountTableColumn.setCellValueFactory(new PropertyValueFactory<>("vatAmount"));
        totalPriceWithVatTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalPriceWithVat"));

        cartItemTable.setEditable(true);

    }

    private void updateProductInfo() {
        Product selectedProduct = selectProductComboBox.getSelectionModel().getSelectedItem();

        if (selectedProduct != null) {
            unitPriceLabel.setText(Float.toString(selectedProduct.getUnitPrice()));
            predefinedVatLabel.setText(Float.toString(selectedProduct.getPreDefinedVatRate()));
            numItemsInStockLabel.setText(Integer.toString(selectedProduct.getNumItemsInStock()));
        }
    }

    @FXML
    private void addProductToCartButtonOnClick(ActionEvent event) {
        Product selectedProduct = selectProductComboBox.getSelectionModel().getSelectedItem();

        if (selectedProduct == null) {
            showError("Please select a product");
            return;
        }

        int quantity = quantityComboBox.getSelectionModel().getSelectedItem();

        float totalAmount = 0.0f;

        boolean selectedProductAlreadyInCart = false;

        for (CartItem eachItem : cartItemTable.getItems()) {
            totalAmount += eachItem.getTotalPriceWithVat();
            if (eachItem.getProductName().equals(selectedProduct.getProductName())) {
                selectedProductAlreadyInCart = true;
                int newQuantity = eachItem.getQuantity() + quantity;

                if (newQuantity <= selectedProduct.getNumItemsInStock()) {
                    eachItem.setQuantity(newQuantity);
                    cartItemTable.refresh();
                } else {
                    showError("Chosen quantity exceeds number of items in stock");
                }
            }
        }

        if (!selectedProductAlreadyInCart) {
            if (quantity <= selectedProduct.getNumItemsInStock()) {
                CartItem newItem = new CartItem(selectedProduct, quantity);
//                if (arr==null){
//                    arr=new ArrayList();
//                    
//                }
//                arr.add(newItem);
//                obl.clear();
//                obl.addAll(arr);
//                cartItemTable.setItems(obl);
//                ProductReadWrite.writeObj(arr);
                cartItemTable.getItems().add(newItem);
                totalAmount += newItem.getTotalPriceWithVat();
            } else {
                showError("Chosen quantity exceeds number of items in stock");
            }
        }

        totalAmountOutputLabel.setText("Total Amount with Vat of all products: " + totalAmount);
    }

    @FXML
    private void selectProductComboBoxOnItemSelected(ActionEvent event) {
        updateProductInfo();
    }

    @FXML
    private void checkOutButtonOnClick(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        if (askYesNo("Are you sure you want to Confirm Order ?") == true) {
            for (CartItem eachCartItem : cartItemTable.getItems()) {
                eachCartItem.updateProduct();
            }

            updateProductInfo();

            cartItemTable.getItems().clear();
        }

//        if (askYesNo("Are you sure you want to Confirm Order ?")) {
//            for (CartItem eachCartItem : cartItemTable.getItems()) {
//                eachCartItem.updateProduct(); // Update the product in the database or wherever necessary
//            }
//            saveOrdersToBinFile(cartItemTable.getItems()); // Save the orders to a bin file
//            cartItemTable.getItems().clear();
//        }
    }

    private void saveOrdersToBinFile(ObservableList<CartItem> cartItems) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("orders.bin"))) {
        oos.writeObject(new ArrayList<>(cartItems)); // Convert ObservableList to ArrayList for serialization
    } catch (IOException e) {
        e.printStackTrace();
        showError("Error", "Failed to save orders.");
    }
}
    
    
    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
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
    private void quantityTableColumnOnEditCommit(TableColumn.CellEditEvent<CartItem, Integer> event) {
        CartItem currentRow = event.getRowValue();

        if (event.getNewValue() > currentRow.getProductInstance().getNumItemsInStock()) {
            showError("Quantity exceeds number of items in stock");
        } else if (event.getNewValue() < 1) {
            cartItemTable.getItems().remove(currentRow);
        } else {
            currentRow.setQuantity(event.getNewValue());
        }
        cartItemTable.refresh();

        float total = 0;
        for (CartItem eachItem : cartItemTable.getItems()) {
            total += eachItem.getTotalPriceWithVat();
        }

        totalAmountOutputLabel.setText("Total Amount with Vat of all products: " + total);
    }

    @FXML
    private void selectAllCheckBoxOnClick(ActionEvent event) {
        for (CartItem eachItem : cartItemTable.getItems()) {
            eachItem.setSelected(selectAllCheckBox.isSelected());
        }
    }

    @FXML
    private void removeSelectedButtonOnClick(ActionEvent event) {
        if (askYesNo("Are you sure you want to delete the selected products from cart?")) {
            int i = 0;

            while (i < cartItemTable.getItems().size()) {
                if (cartItemTable.getItems().get(i).isSelected()) {
                    cartItemTable.getItems().remove(i);
                } else {
                    i++;
                }
            }

            selectAllCheckBox.setSelected(false);
            cartItemTable.refresh();
            float total = 0;
            for (CartItem eachItem : cartItemTable.getItems()) {
                total += eachItem.getTotalPriceWithVat();
            }

            totalAmountOutputLabel.setText("Total Amount with Vat of all products: " + total);
        }
    }

}
