
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
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
public class ProducersPassWordChangingController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField movieNameField;
  
    @FXML
    private TextField oldPassField;
    @FXML
    private TextField newPassField;
    MovieProject movie;
    ArrayList<MovieProject>movieArr;
    public void initData(MovieProject movie){
        this.movie = movie;
        movieArr = readWriteObject.getArr();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        movieArr = null;
    }    

    @FXML
    private void setPassAction(ActionEvent event) {
        if(movieArr==null){return;}
        Producer pro = movie.getProducer();
        Producer temp=null;
        String pass = oldPassField.getText();
        String newPass = newPassField.getText();
        String name =  nameField.getText();
        
        int id = Integer.parseInt(idField.getText());
        String Moviename = movieNameField.getText();
        System.out.println("Runnig");
        if((pro.getId()==id) && (pro.getPass().equals(pass)) && (Moviename.equals(pro.getMovieName())) && (pro.getName().equals(name))){
            
                Alert alt = new Alert(AlertType.CONFIRMATION);
                alt.setContentText("Are You Sure to chenge the Pass");
                alt.setHeaderText("Change Pass");
                Optional<ButtonType> bt = alt.showAndWait();
                if(bt.get()==ButtonType.OK){
                    for(MovieProject i:movieArr){
                        if(i.getMovieName().equals(Moviename)){
                            temp = i.getProducer();
                            temp.setPass(newPass);
                            i.setProducer(temp);
                            break;
                    
                        }
            
                    }   
                }else{
                    return;
                }
                readWriteObject.writeObj(movieArr);
                Alert cp = new Alert(AlertType.ERROR);
                cp.setContentText("Password Change Success");
                cp.setHeaderText("Pass Changed");
                cp.showAndWait();
            
        
        }else{
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Information is Wrong");
            a.setHeaderText("Wrong Info");
            a.showAndWait();
            return;
        }
    }
    
}
