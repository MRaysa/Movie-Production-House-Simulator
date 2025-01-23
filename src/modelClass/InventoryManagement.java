/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelClass;

/**
 *
 * @author DELL
 */
public class InventoryManagement {
    private String name;
    private int quantity;
    private String currentStatus;

    public InventoryManagement(String name, int quantity, String currentStatus) {
        this.name = name;
        this.quantity = quantity;
        this.currentStatus = currentStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return "InventoryManagement{" + "name=" + name + ", quantity=" + quantity + ", currentStatus=" + currentStatus + '}';
    }
    
    
}
