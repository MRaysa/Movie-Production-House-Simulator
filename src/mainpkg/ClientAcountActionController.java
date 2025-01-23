/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import CrewMembers.Client;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ClientAcountActionController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private DatePicker doj;
    @FXML
    private TextField desigField;
    @FXML
    private TextField passField;

    ArrayList<Client>arrCl;
    IdCount count;
    int id;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arrCl=ClientAcountReadWrite.getArr();
        count = new IdCount();
        id = count.getId()+1;
        idField.setText(Integer.toString(id));
        desigField.setText("Client");
        doj.setValue(LocalDate.now());
        
        
    }    

    @FXML
    private void createTheClientAccountAction(ActionEvent event) {
        if(arrCl==null){arrCl = new ArrayList();}
        if((nameField.getText()==null)||(passField.getText()==null)){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter the data");
            a.setHeaderText("Value Not Found");
            a.showAndWait();
            return;
        }
        Client newCl = new Client(id,nameField.getText(),desigField.getText(),doj.getValue(),passField.getText());
        arrCl.add(newCl);
        ClientAcountReadWrite.writeObj(arrCl);
        id+=1;
        count.writeId(id);
        idField.setText(Integer.toString(id));
        Alert a = new Alert(AlertType.INFORMATION);
        a.setContentText("Id Created SuccessFull");
        a.setHeaderText("Success");
        a.showAndWait();
        
        
    }

    @FXML
    private void gotoLoginAction(ActionEvent event) throws IOException {
            

            
            Parent r = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene sc = new Scene(r);


            Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();


            stg.setScene(sc);
            stg.show();
    }
    
    
}
