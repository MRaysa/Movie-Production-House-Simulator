/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Aysa
 */
public class User_7_View_Director_Purchase_RequestController implements Initializable {

    @FXML
    private TableView<RequestedProduct> requestedProductTableView;
    @FXML
    private TableColumn<RequestedProduct, String> productNameTableColumn;
    @FXML
    private TableColumn<RequestedProduct, Integer> quantityTableColumn;
    private ObservableList<RequestedProduct> observableList = FXCollections.observableArrayList();
    private List<RequestedProduct> productList = new ArrayList<>();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        requestedProductTableView.setItems(observableList);
    }    

    @FXML
    private void loadRequestedProductButtonOnClick(ActionEvent event) throws IOException {
        // Load assigned equipment from file
        List<RequestedProduct> loadedProduct = loadRequestedProductFromFile();

        // Display the loaded equipment in the second TableView
        requestedProductTableView.setItems(FXCollections.observableArrayList(loadedProduct));

        // Update your lists with the loaded products
        observableList.setAll(loadedProduct);
        productList.clear();
        productList.addAll(loadedProduct);
    }

    private List<RequestedProduct> loadRequestedProductFromFile() throws IOException {
        List<RequestedProduct> loadedProduct = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("requestedProducts.bin"))) {
            // Read the list of assigned equipment from the file
            loadedProduct = (List<RequestedProduct>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Handle the case when the file is not found
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            // Handle other exceptions
            e.printStackTrace();
        }
        return loadedProduct;

    }

    @FXML
    private void goTOProjectManagerDashboredSceeSwitchinOnAction(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("Project_Manager_Dashboard.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }
    
}
