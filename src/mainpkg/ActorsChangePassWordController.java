/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ActorsChangePassWordController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField movieName;
    @FXML
    private TextField desigField;
    @FXML
    private DatePicker joinDate;
    @FXML
    private TextField oldPass;
    @FXML
    private TextField newPass;
//  Variable
    ArrayList<MovieProject>arrMP;
    User user;
    ArrayList<User>arr;
    MovieProject movie;
    public void initData(User us){
        user = us;
        arrMP = readWriteObject.getArr();
        for(MovieProject i:arrMP){
            if(i.getMovieName().equals(user.getMovieName())){
                movie = i;
                arr=i.getCrewList();
                break;
            
            }
        }
        
        
    
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setPassAction(ActionEvent event) {
        for(User i:arr){
            if((i.getName().equals(nameField.getText())) && (i.getId()==Integer.parseInt(idField.getText())) && (i.getDOJ().equals(joinDate.getValue())) && (i.getMovieName().equals(movieName.getText())) && (i.getPass().equals(oldPass.getText()))){
                Alert alt = new Alert(AlertType.CONFIRMATION);
                alt.setContentText("Are You Sure to chenge the Pass");
                alt.setHeaderText("Change Pass");
                Optional<ButtonType> bt = alt.showAndWait();
                if(bt.get()==ButtonType.OK){
                    i.setPass(newPass.getText());
                    for(MovieProject j:arrMP){
                        if(i.getMovieName().equals(i.getMovieName())){
                            j.addCrewList(arr);
                            break;
                        }
                    }
                    readWriteObject.writeObj(arrMP);
                    return;
                }else{
                    return;
                
                }
            }
        
        }
        Alert a = new Alert(AlertType.ERROR);
        a.setContentText("Some information is not marching");
        a.setHeaderText("Pass Not Changed");
        a.showAndWait();
        
        
    }
    
}
