/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User_5_orderMovieList implements Serializable {

    public User_5_orderMovieList(String name, String address, String email, String cineplexName, String phoneNo) {
    }
    private static class Order implements Serializable {
        private String orderId;
        private String name;
        private String address;
        private String email;
        private String cineplexName;
        private String phoneNumber;

        public Order(String name, String address, String email, String cineplexName, String phoneNumber) {
            this.name = name;
            this.address = address;
            this.email = email;
            this.cineplexName = cineplexName;
            this.phoneNumber = phoneNumber;
        }

       

        private String generateUniqueOrderId() {
            return UUID.randomUUID().toString();
        }

        // Getters for orderId, name, address, email, cineplexName, phoneNumber
        public String getOrderId() {
            return orderId;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getEmail() {
            return email;
        }

        public String getCineplexName() {
            return cineplexName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setCineplexName(String cineplexName) {
            this.cineplexName = cineplexName;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        

        @Override
        public String toString() {
            return "Order{" + "orderId=" + orderId + ", name=" + name + ", address=" + address + ", email=" + email + ", cineplexName=" + cineplexName + ", phoneNumber=" + phoneNumber + '}';
        }
        
    }
}

