/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelClass;

/**
 *
 * @author DELL
 */


import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// This is a simple class, for a real application you need to implement the persistence logic.
public class Order {

    private final SimpleIntegerProperty orderId = new SimpleIntegerProperty();
    private final SimpleStringProperty productName = new SimpleStringProperty();
    private final SimpleIntegerProperty quantity = new SimpleIntegerProperty();
    private final SimpleStringProperty status = new SimpleStringProperty();

    public Order(int orderId, String productName, int quantity, String status) {
        this.orderId.set(orderId);
        this.productName.set(productName);
        this.quantity.set(quantity);
        this.status.set(status);
    }

    // Getters and setters for the properties
    public int getOrderId() { return orderId.get(); }
    public void setOrderId(int value) { orderId.set(value); }
    public SimpleIntegerProperty orderIdProperty() { return orderId; }

    public String getProductName() { return productName.get(); }
    public void setProductName(String value) { productName.set(value); }
    public SimpleStringProperty productNameProperty() { return productName; }

    public int getQuantity() { return quantity.get(); }
    public void setQuantity(int value) { quantity.set(value); }
    public SimpleIntegerProperty quantityProperty() { return quantity; }

    public String getStatus() { return status.get(); }
    public void setStatus(String value) { status.set(value); }
    public SimpleStringProperty statusProperty() { return status; }

 public boolean confirmOrder() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseHandler.getConnection();
            String updateQuery = "UPDATE orders SET status = ? WHERE order_id = ?";
            pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, "Confirmed");
            pstmt.setInt(2, this.getOrderId());
            int updatedRows = pstmt.executeUpdate();
            if (updatedRows > 0) {
                this.status.set("Confirmed");
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.err.println("SQLException (on close): " + ex.getMessage());
            }
        }
    }

private boolean updateOrderStatusInDatabase(int orderId, String newStatus) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        conn = DatabaseHandler.getConnection();
        String sql = "UPDATE orders SET status = ? WHERE order_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newStatus);
        pstmt.setInt(2, orderId);

        int affectedRows = pstmt.executeUpdate();
        return affectedRows == 1; // If one row was updated, return true
    } catch (SQLException e) {
        System.err.println("Error updating order status: " + e.getMessage());
        return false; // If there's an error, return false
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.err.println("Error closing connection: " + ex.getMessage());
        }
    }
}


    
public static ObservableList<Order> getPendingOrdersFromDatabase() {
    ObservableList<Order> pendingOrders = FXCollections.observableArrayList();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        conn = DatabaseHandler.getConnection();
        if (conn != null) {
            System.out.println("Connection to database established.");
            String query = "SELECT * FROM orders WHERE status = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "Pending");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");
                Order order = new Order(orderId, productName, quantity, status);
                pendingOrders.add(order);
            }
        } else {
            System.err.println("Failed to make connection to database.");
        }
    } catch (Exception e) {
        System.err.println("Exception: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            System.err.println("Exception (on close): " + ex.getMessage());
        }
    }
    return pendingOrders;
}


}

