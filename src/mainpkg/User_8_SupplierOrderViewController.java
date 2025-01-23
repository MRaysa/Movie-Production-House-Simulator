/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

/**
 * FXML Controller class
 *
 * @author DELL
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelClass.Order;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelClass.CartItem;
import modelClass.CartItemDTO;

public class User_8_SupplierOrderViewController implements Initializable {
    @FXML
    private TableView<Order> pendingOrdersTable;
    @FXML
    private TableColumn<Order, Integer> orderIdColumn;
    @FXML
    private TableColumn<Order, String> productNameColumn;
    @FXML
    private TableColumn<Order, Integer> quantityColumn;
    @FXML
    private TableColumn<Order, String> statusColumn;
    @FXML
    private Button confirmOrderButton;
    @FXML
    private Label statusMessageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        loadOrdersFromBinFile();
        refreshPendingOrdersTable();
    }
 
private void loadOrdersFromBinFile() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("orders.bin"))) {
        List<CartItemDTO> cartItemDTOs = (List<CartItemDTO>) ois.readObject();
        ObservableList<Order> orders = FXCollections.observableArrayList(cartItemDTOs.stream()
            .map(cartItemDTO -> new Order(
                cartItemDTO.getOrderId(), // Ensure this getter exists
                cartItemDTO.getProductName(),
                cartItemDTO.getQuantity(),
                cartItemDTO.getStatus() // Ensure this getter exists
            ))
            .collect(Collectors.toList()));
        pendingOrdersTable.setItems(orders);
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
        showAlert("Error", "Failed to load orders.");
    }
}


private void refreshPendingOrdersTable() {
    try {
        ObservableList<Order> pendingOrders = Order.getPendingOrdersFromDatabase();
        if (pendingOrders != null && !pendingOrders.isEmpty()) {
            pendingOrdersTable.setItems(pendingOrders);
            pendingOrdersTable.refresh(); // Refresh the TableView to display the data
            System.out.println("Orders loaded successfully.");
        } else {
            System.err.println("No pending orders found or unable to load from the database.");
            showAlert("Error", "No pending orders found or unable to load from the database.");
        }
    } catch (Exception e) {
        System.err.println("Error loading orders: " + e.getMessage());
        showAlert("Error", "An error occurred while loading orders: " + e.getMessage());
    }
}

    
    

    @FXML
    private void confirmOrderButtonOnClick() {
        Order selectedOrder = pendingOrdersTable.getSelectionModel().getSelectedItem();
        if (selectedOrder != null && "Pending".equals(selectedOrder.getStatus())) {
            boolean confirmationResult = selectedOrder.confirmOrder();
            if (confirmationResult) {
                refreshPendingOrdersTable(); // Refresh the table to show updated status
                showAlert("Success", "Order confirmed successfully.");
            } else {
                showAlert("Error", "Order confirmation failed.");
            }
        } else {
            showAlert("Warning", "Please select a pending order to confirm.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void goToResourceSupplier(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_8_Resource_Supplier_Dashboard.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }
    
    
    
}
