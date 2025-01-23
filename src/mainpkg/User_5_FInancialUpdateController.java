/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author abuzafor
 */
public class User_5_FInancialUpdateController implements Initializable {

    @FXML
    private ComboBox<String> selectProjectCombobox;
    @FXML
    private DatePicker selectDateDatePicker;
    @FXML
    private TextField dayIncomeTextField;
    private ObservableList<User_5_financialUpdate> FList= FXCollections.observableArrayList();
    @FXML
    private TableView<User_5_financialUpdate> financialInfoTable;
    @FXML
    private TableColumn<User_5_financialUpdate, String> movieNameTableCollum;
    @FXML
    private TableColumn<User_5_financialUpdate, String> dateTableCollum;
    @FXML
    private TableColumn<User_5_financialUpdate, String> dailyIncomeTableCollum;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectProjectCombobox.getItems().addAll("a","b");
    } 

    public ObservableList<User_5_financialUpdate> getFList() {
        return FList;
    }

    public void setFList(ObservableList<User_5_financialUpdate> FList) {
        this.FList = FList;
    }

    
    

    @FXML
    private void uploadFinancialUpdateButton(ActionEvent event) {
        int income=Integer.parseInt(dayIncomeTextField.getText());
        String mName= selectProjectCombobox.getValue();
        LocalDate date= selectDateDatePicker.getValue();
        User_5_financialUpdate dayUpdate= new User_5_financialUpdate(income,mName,date);
        FList.add(dayUpdate);
        financialInfoTable.setItems(FList);
        System.out.println(FList);
    }
    
}
