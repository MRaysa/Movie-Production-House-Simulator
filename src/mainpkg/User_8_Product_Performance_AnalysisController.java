/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelClass.ProductTableData;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class User_8_Product_Performance_AnalysisController implements Initializable {

    @FXML
    private PieChart productPerformanceAnalysis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadProductPerformanceData();
    }

    private void loadProductPerformanceData() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        try {
            ObservableList<ProductTableData> allProducts = ProductTableData.loadAll(); // Method to load all product data

            for (ProductTableData product : allProducts) {
                // Assuming ProductTableData has a method getNumItemsInStock to retrieve the number of items in stock.
                pieChartData.add(new PieChart.Data(product.getProductName(), product.getNumItemsInStock()));
            }

            productPerformanceAnalysis.setData(pieChartData);

        } catch (Exception e) {
            // Handle exceptions appropriately here.
            e.printStackTrace();
        }
    }

    @FXML
    private void backToREsourceSupplierDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("User_8_Resource_Supplier_Dashboard.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }
}
