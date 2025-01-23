
package mainpkg;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class AddingProducerController implements Initializable {

    @FXML
    private TextField nameFiled;
    @FXML
    private TextField idFiled;
    @FXML
    private TextField passField;
    @FXML
    private TextArea resultBar;
    @FXML
    private ComboBox<String> desigCombo;
    @FXML
    private DatePicker doj;
    @FXML
    private TextField movieName;
    @FXML
    private TextField movieType;

    /**
     * Initializes the controller class.
     */
    ObjectReadWrite obj ;
    Producer producer;
    int id;
    User user;
    IdCount count;
    ArrayList<User>arrayOfCrew;

    public void initData(ArrayList<User> arr,String movieName,String movieType){
        arrayOfCrew = arr;
        this.movieName.setText(movieName);
        this.movieType.setText(movieType);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        desigCombo.getItems().add("Producer");
        movieType.setText(movieType.getText());
        //Id counting Dynamically in Creating Producer Instance
        count = new IdCount();
        id = count.getId()+1;
        idFiled.setText(Integer.toString(id));
        obj = new ObjectReadWrite();
        
    }    


    @FXML
    private void createTheTeam(ActionEvent event) {
            producer = new Producer(id, nameFiled.getText(), desigCombo.getValue(),doj.getValue(), passField.getText(),movieName.getText());
            if (producer == null){
                resultBar.setText("Please enter Declear The Producer");
                return;
            
            }
            producer.addCrew(arrayOfCrew);
            MovieProject newProject = new MovieProject(movieName.getText(),movieType.getText(),producer);
            obj.writeProjectObject(newProject);
            resultBar.setText(newProject.toString());
    }

    @FXML
    private void addProducerAction(ActionEvent event) {
        File f =null;
        FileOutputStream fos =null;
        ObjectOutputStream oos= null;
        try{
            f= new File("User.bin");
            if (!f.exists()){
               fos = new FileOutputStream(f); 
               oos = new ObjectOutputStream(fos);
            }else{
               fos = new FileOutputStream(f,true); 
               oos = new AppendableObjectStream(fos);
            }
            user = new Producer(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movieName.getText());
            
            oos.writeObject(user);
            oos.close();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        
        
        }
        
        catch (IOException ex) {
            ex.printStackTrace();
        }

        resultBar.setText(user.toString());
        
        
        
        
    }

    @FXML
    private void backToPreviousAction(ActionEvent event) throws IOException {
//            if(producer==null){
//                resultBar.setText("Please create a id of A producer");
//            }
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("CreateNewTeam.fxml"));
//            Parent r = loader.load();
//            Scene sc = new Scene(r);
//            CreateNewTeamController controller = loader.getController();
//            //Passing data to the privious page after creating team (Create new team page)
//            controller.initData(producer, movieName.getText());
//
//            Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
//            s.setScene(sc);
//            s.show();
            
 //Checking whether The MovieProject is adding to the Bin file or Not Succeesfully created the Movie 
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
////        MovieProject us = null;
//        User us = null;
//        try {
//
//            File f= new File("User.bin");
//            fis = new FileInputStream(f);
//            ois = new ObjectInputStream(fis);
//            while (true) {
////                us = (MovieProject) ois.readObject();
//                us = (User) ois.readObject();
//                System.out.println(us.toString());
//
//            }
//
//        } catch (Exception ex) {}
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("User.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User emp;
            try{

                while(true){
                    System.out.println("Printing objects.");
                    emp = (User)ois.readObject();
                    //Object obj = ois.readObject();
                    //obj.submitReport();
                    System.out.println(emp.toString());
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
                       
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        } 

    }

    @FXML
    private void goToLogInPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene sc = new Scene(root);
        Stage stg = (Stage)((Node) event.getSource()).getScene().getWindow();
        stg.setScene(sc);
        stg.show();
        
    }

    
}
