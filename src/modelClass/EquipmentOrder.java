/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelClass;

/**
 *
 * @author abuzafor
 */
import java.io.Serializable;
import java.time.LocalDate;

public class EquipmentOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private String equipmentName;
    private int quantity;
    private LocalDate orderDate;

    public EquipmentOrder(String equipmentName, int quantity, LocalDate orderDate) {
        this.equipmentName = equipmentName;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}