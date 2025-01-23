package mainpkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User_5_viewCartAndOrderPageController implements Initializable {

    @FXML
    private TextField addressTextField;
    @FXML
    private TextField cineplexNameTextField;
    @FXML
    private TextField phoneNoTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TableView<User_5_orderMovieList> cartItemsTable;
    @FXML
    private TableColumn<User_5_orderMovieList, String> orderIdColumn;
    @FXML
    private TableColumn<User_5_orderMovieList, String> movieNameColumn;
    @FXML
    private TableColumn<User_5_orderMovieList, String> cineplexNameColumn;

    private ObservableList<User_5_orderMovieList> orderList= FXCollections.observableArrayList(); 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void SUbmitRequestOnButtonClick(ActionEvent event) {
        // Read user input
        String name = ""; // You need to get the name from somewhere (it's not available in the FXML)
        String address = addressTextField.getText();
        String cineplexName = cineplexNameTextField.getText();
        String phoneNo = phoneNoTextField.getText();
        String email = emailTextField.getText();

        User_5_orderMovieList orderL = new User_5_orderMovieList(name, address,email, cineplexName,phoneNo);

        // Add the order to the User_5_orderMovieList
        orderList.add(orderL);
    }

    @FXML
    private void removeProductFromCartListOnButtonClick(ActionEvent event) {
        
    }
}
