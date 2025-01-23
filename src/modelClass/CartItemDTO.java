/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelClass;

/**
 *
 * @author DELL
 */


import java.io.Serializable;

public class CartItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean selected;
    private String productName;
    private int quantity;
    private float unitPrice, totalPrice, vatAmount, vatRate, totalPriceWithVat;
    private int orderId; // Assuming you want to add an orderId field
    private String status;
    public CartItemDTO(CartItem cartItem) {
        this.selected = cartItem.isSelected();
        this.productName = cartItem.getProductName();
        this.quantity = cartItem.getQuantity();
        this.unitPrice = cartItem.getUnitPrice();
        this.totalPrice = cartItem.getTotalPrice();
        this.vatAmount = cartItem.getVatAmount();
        this.vatRate = cartItem.getVatRate();
        this.totalPriceWithVat = cartItem.getTotalPriceWithVat();
        // Initialize orderId if CartItem contains this information
        // this.orderId = cartItem.getOrderId(); // Uncomment if CartItem has getOrderId()
    }


  
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(float vatAmount) {
        this.vatAmount = vatAmount;
    }

    public float getVatRate() {
        return vatRate;
    }

    public void setVatRate(float vatRate) {
        this.vatRate = vatRate;
    }

    public float getTotalPriceWithVat() {
        return totalPriceWithVat;
    }

    public void setTotalPriceWithVat(float totalPriceWithVat) {
        this.totalPriceWithVat = totalPriceWithVat;
    }
     
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
 
    public String getStatus() {
        return status;
    }

  
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "CartItemDTO{" + "selected=" + selected + ", productName=" + productName + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", vatAmount=" + vatAmount + ", vatRate=" + vatRate + ", totalPriceWithVat=" + totalPriceWithVat + '}';
    }

}
