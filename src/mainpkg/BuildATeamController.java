
package mainpkg;

import CrewMembers.Actor;
import CrewMembers.CineMatoGrapher;
import CrewMembers.Client;
import CrewMembers.Director;

import CrewMembers.ProjectManager;
import CrewMembers.ScriptWriter;
import CrewMembers.Suplier;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class BuildATeamController implements Initializable {

    @FXML
    private TextField nameFiled;
    @FXML
    private TextField idFiled;
    @FXML
    private DatePicker doj;
    private DatePicker dob;
    private TextField passwordField;
    @FXML
    private TextArea resultBar;
    @FXML
    private ComboBox<String> desigCombo;

    @FXML
    private TableView<User> crewTable;
    @FXML
    private TableColumn<User, String> nameCol;
    @FXML
    private TableColumn<User, Integer> idCol;
    @FXML
    private TableColumn<User, LocalDate> dojCol;
    @FXML
    private TableColumn<User, String> desigCol;
    @FXML
    private TextField movieName;
    
    @FXML
    private TableColumn<User, String> passCol;

    @FXML
    private TextField passField;
    
    @FXML
    private TextField producerName;
    @FXML
    private TextField producerId;
    @FXML
    private DatePicker movieCreationDate;
    @FXML
    private TextField producerDesig;
    @FXML
    private ComboBox<String> movieType;
    
    //Fields Of this class
    ArrayList<User> arr;
    User user;
    Validation valid;
//    ObjectReadWrite obj;
    int id;
    public IdCount c;
    Producer producer;
    readWriteObject obj2;
    ArrayList<MovieProject>arrProjects = new ArrayList();
    
    @FXML
    private TextField producerPass;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LocalDate i = LocalDate.now();
        movieCreationDate.setValue(i);
        producerDesig.setText("Producer");
        
        
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        dojCol.setCellValueFactory(new PropertyValueFactory("DOJ"));
        desigCol.setCellValueFactory(new PropertyValueFactory("desig"));
        passCol.setCellValueFactory(new PropertyValueFactory("pass"));
        
        movieType.getItems().addAll("Action","Action Thriller","BioPic","Romantic","Comedy","Educational"
                                    ,"Historical","Others","Horror");
        desigCombo.getItems().addAll( "Director", "Project Manger", "Actor", "Actress", "CinematoGrapher",
                                     "Script Writer","Resource Suplier");
        
        
        

        c = new IdCount();
        valid = new Validation();
        arr = new ArrayList();

        id = c.getId()+1;
        producerId.setText(Integer.toString(id));
    }

    @FXML
    private void logInPageAction(ActionEvent event) throws ClassNotFoundException, IOException{
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();


    }
    

    @FXML
    private void addCrewAction(ActionEvent event){
        if (producer==null){
          resultBar.setText("Please Declear The Producer ");
          return;
        }
        Period p = Period.between(LocalDate.now(),doj.getValue());
        if(p.getDays()>=0){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("The Date of joining input is Incorrect");
            a.setHeaderText("Invalid Date input");
            a.showAndWait();
            return;
        }


        if(desigCombo.getValue().equals("Actor")){
            user =  new Actor(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movieName.getText());
        } 
        else if(desigCombo.getValue().equals("Actress")){
            user =  new Actor(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movieName.getText());
        } 
        else if(desigCombo.getValue().equals("CinematoGrapher")){
            user =  new CineMatoGrapher(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movieName.getText());
        } 
        else if(desigCombo.getValue().equals("Director")){
            user =  new Director(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movieName.getText());
        } 
        else if(desigCombo.getValue().equals("Script Writer")){
            user =  new ScriptWriter(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movieName.getText());
        } 
        else{
            user =  new Suplier(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movieName.getText());
        } 
        
        crewTable.getItems().add(user);
        arr.add(user);
        System.out.println(user);
            


        c.writeId(id);
        id = id + 1;
        
        idFiled.setText(Integer.toString(id)); 
    }
  

    @FXML
    private void createTheTeam(ActionEvent event) {

            if(movieName.getText()==null){
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("MOvie name is not Declear");
                a.setHeaderText("Movie Name not found");
                a.showAndWait();
                resultBar.setText("Please Enter The Movie Name");
                return ;
            }
            if(arr.size()==0){
                    Alert a = new Alert(AlertType.INFORMATION);
                    a.setContentText("Please Add Some Crew");
                    a.setHeaderText("Add Crew");
                    a.showAndWait();
                
                    resultBar.appendText("Please add some crew");
            }
            
            producer.addCrew(arr);

                //add a producer instance
                ArrayList<MovieProject> arr3 = readWriteObject.getArr();
                MovieProject newProject = new MovieProject(movieName.getText(),movieType.getValue(),producer);
                arrProjects.add(newProject);

                if(arr3!=null){
                    arr3.add(newProject);
                    readWriteObject.writeObj(arr3);
                }else{
                    readWriteObject.writeObj(arrProjects);
                }
                
                

                resultBar.setText("SuccessFully created Team");
                


    }




    @FXML
    private void createTheProducerIntance(ActionEvent event) {
        
        
        producer = new Producer(id,producerName.getText(),producerDesig.getText(),movieCreationDate.getValue(),producerPass.getText(),movieName.getText());
        c.writeId(id);
        id+=1;
        idFiled.setText(Integer.toString(id));
        
        
    }




}
