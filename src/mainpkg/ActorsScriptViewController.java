/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ActorsScriptViewController implements Initializable {

    @FXML
    private TextArea resultBar;
    ActorsScriptViewReadWrite rW;
    User user;
    public void initData(User us){
        user = us;
        rW = new ActorsScriptViewReadWrite(user.getMovieName());
        String str = rW.getStr();
        resultBar.setText(str);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backToDash(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ActorDashBoard.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ActorDashBoardController c = loader.getController();
        c.initData(user);
        
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
    }
    
}
