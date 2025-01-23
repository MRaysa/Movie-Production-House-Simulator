package mainpkg;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RequestProductSceneController implements Initializable {

    @FXML
    private ComboBox<String> requestProductComboBox;
    @FXML
    private Spinner<Integer> quantitySpinner; // Added Spinner
    @FXML
    private TableView<RequestedProduct> requestedProductTableView;
    @FXML
    private TableColumn<RequestedProduct, String> requestedProductTableColumn;
    @FXML
    private TableColumn<RequestedProduct, Integer> quantityTableColumn;
    /**
     * Initializes the controller class.
     */

    List<RequestedProduct> productList = new ArrayList<>();
    ObservableList<RequestedProduct> observableList = FXCollections.observableArrayList();
    @FXML
    private AnchorPane quantityTextField;
    @FXML
    private TableView<RequestedProduct> requestedProductTableView1;
    @FXML
    private TableColumn<RequestedProduct, String> requestedProductTableColumn1;
    @FXML
    private TableColumn<RequestedProduct, Integer> quantityTableColumn1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // ComboBox
        String[] productCategories = {"High-quality Cameras", "Lenses", "Tripods", "Lighting Equipment", "Microphones", "Audio Recorders",
            "Boom Poles", "Costumes", "Wardrobe Accessories", "Editing Software Licenses", "Visual Effects Software",
            "Set Construction Materials", "Furniture and Props", "Makeup and Hair Styling Products", "Rental Fees for Shooting Locations"};

        requestProductComboBox.getItems().addAll(productCategories);

        // Connect TableColumns with Product Class
        requestedProductTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        requestedProductTableColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityTableColumn1.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Wrap the productList with an observable list
        requestedProductTableView.setItems(observableList);

        // Spinner configuration (assuming you want 1 to 100 as the quantity range)
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        quantitySpinner.setValueFactory(valueFactory);
    }

    @FXML
    private void requestProductButtonOnClick(ActionEvent event) {
        String selectedProduct = requestProductComboBox.getValue();
        int quantity = quantitySpinner.getValue();

        if (selectedProduct != null && !selectedProduct.isEmpty()) {
            // Create a new Product instance
            RequestedProduct product = new RequestedProduct(selectedProduct, quantity);

            // Add the product to the lists
            observableList.add(product);
            productList.add(product);

            System.out.println("Added product: " + product.getName() + ", " + product.getQuantity());
            // Save the updated list to the file
            saveRequestedProductsToFile();
            saveRequestedProductsToTextFile();

            // Clear the combo box selection and reset the spinner value
            requestProductComboBox.getSelectionModel().clearSelection();
            quantitySpinner.getValueFactory().setValue(1);
            showSuccessAlert("Product Requested", "Product requested successfully.");

        }

    }

    private void showSuccessAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Product Request");
        alert.setHeaderText("Product requested successfully.");
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void saveRequestedProductsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("requestedProducts.bin"))) {
            // Save the serializable list (productList) instead of the observable list
            oos.writeObject(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveRequestedProductsToTextFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("requestedProducts.txt"))) {
            for (RequestedProduct product : productList) {
                // Write each product's details to the file
                writer.write("Product: " + product.getName() + "," + " Quantity: " + product.getQuantity());
                writer.newLine(); // Move to the next line for the next product
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception, e.g., show an alert or log the error
            showAlert("Error", "Failed to save requested products to text file.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Optional: You can call this method when closing the application to save the data
    public void onClose() {
        saveRequestedProductsToFile();
        saveRequestedProductsToTextFile();
    }

    @FXML
    private void goToInterpretScriptButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeFilm.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

    @FXML
    private void goTovisualizeFilmButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeFilm.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

    @FXML
    private void goTosetPaceAndTimingButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeFilm.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

    @FXML
    private void goToDirectActorButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/DirectActorScene.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

    @FXML
    private void goToScheduleFilmButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/ScheduleFilmDateScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage ScheduleFilmDateStage = new Stage();
            ScheduleFilmDateStage.setTitle("Schedule Film Dates Window");
            ScheduleFilmDateStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            //EquipmentSetupSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed
            // Set the new stage to be modal (blocks interactions with the main window)
            ScheduleFilmDateStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            ScheduleFilmDateStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    private void goToEquipmentSetupButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/EquipmentSetupScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage EquipmentSetupStage = new Stage();
            EquipmentSetupStage.setTitle("Equipment Setup Window");
            EquipmentSetupStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            //EquipmentSetupSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed
            // Set the new stage to be modal (blocks interactions with the main window)
            EquipmentSetupStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            EquipmentSetupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    private void goToRequestProductButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/RequestProductScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage requestProductStage = new Stage();
            requestProductStage.setTitle("Request Product Window");
            requestProductStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            RequestProductSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed

            // Set the new stage to be modal (blocks interactions with the main window)
            requestProductStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            requestProductStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    private void goToLocationButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/AddLocationScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage AddLocationStage = new Stage();
            AddLocationStage.setTitle("Add Location Window");
            AddLocationStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            //EquipmentSetupSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed
            // Set the new stage to be modal (blocks interactions with the main window)
            AddLocationStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            AddLocationStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    private void loadRequestedProductButtonOnClick(ActionEvent event) {
        // Load assigned equipment from file
        List<RequestedProduct> loadedProduct = loadRequestedProductFromFile();

        // Display the loaded equipment in the second TableView
        requestedProductTableView1.setItems(FXCollections.observableArrayList(loadedProduct));

        // Update your lists with the loaded products
        observableList.setAll(loadedProduct);
        productList.clear();
        productList.addAll(loadedProduct);
    }

    private List<RequestedProduct> loadRequestedProductFromFile() {
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
    private void toDirectorDashboardButtonOnClicked(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/DirectorDashboardScene.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }
}
