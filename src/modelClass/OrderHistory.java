///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package modelClass;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.ArrayList;
//
///**
// *
// * @author dell
// */
//public class OrderHistory extends AbstractDBModel implements Serializable {
//    // necessary fields
//
//    private ArrayList<OrderedProductData> orderedProductsList;
//
//    public class OrderedProductData implements Serializable {
//        private String productName;
//        private int numberOfItemsOrdered;
//
//       // generate constructor, getter and setter
//    }
//    
//    
//    
//    public OrderHistory() throws IOException, FileNotFoundException, ClassNotFoundException
//    {
//        super();
//    }
//    // generate getter and setter for all necessary fields EXCEPT orderedProductsList
//
//    public void addProduct(Product productInstance, int numberOfItemsOrdered) {
//        OrderedProductData newProduct = new OrderedProductData(productInstance.getProductName(), numberOfItemsOrdered);
//        this.orderedProductsList.add(newProduct);
//    }
//
//    @Override
//    public int count() throws IOException, FileNotFoundException, ClassNotFoundException
//    {
//       return this.countFromFile("OrderHistory.bin");
//    }
//
//    @Override
//    public void save() throws IOException
//    {
//        this.saveToFile("OrderHistory.bin");
//    }
//
//    @Override
//    public void update() throws IOException, FileNotFoundException, ClassNotFoundException
//    {
//        this.updateToFile("OrderHistory.bin");
//    }
//
//    @Override
//    public void delete() throws IOException, FileNotFoundException, ClassNotFoundException
//    {
//       this.deleteFromFile("OrderHistory.bin");
//    }
//
//    public static ArrayList<OrderHistory> loadAll() throws IOException, FileNotFoundException, ClassNotFoundException
//    {
//        ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();
//
//        ArrayList<AbstractDBModel> allOrders = loadAllFromFile("OrderHistory.bin");
//
//       for (AbstractDBModel eachItem: allOrders) {
//           orderHistoryList.add((OrderHistory) eachItem);
//       }
//
//       return orderHistoryList;
//    }
//    
//    public ArrayList<OrderedProductData>  getOrderedProductsList() {
//        return this.orderedProductsList;
//    }
//
//}