
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ProducerViewScriptController implements Initializable {

    private Label resultBar;
    @FXML
    private Label moviNameFiled;
    MovieProject movie;
    /**
     * Initializes the controller class.
     */
    ProducerViewScripReadWrite obj;
    @FXML
    private TextArea resulBar;
    
    public void initData(MovieProject m){
        movie=m;
        moviNameFiled.setText("Movie Name :"+movie.getMovieName());
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    


    @FXML
    private void viewScriptAction(ActionEvent event) {
        ProducerViewScripReadWrite obj = new ProducerViewScripReadWrite(movie.getMovieName()+"Script");
        String str = obj.getStr();
        resulBar.setText(str);
        
    }



    @FXML
    private void viewDialogueAction(ActionEvent event) {
        ProducerViewScripReadWrite obj = new ProducerViewScripReadWrite(movie.getMovieName()+"Dialogue");
        String str = obj.getStr();
        resulBar.setText(str);
    }

    private void viewCharacterAction(ActionEvent event) {
        ProducerViewScripReadWrite obj = new ProducerViewScripReadWrite(movie.getMovieName()+"Character");
        String str = obj.getStr();
        resulBar.setText(str);
    }

    @FXML
    private void backToDashBoardAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersDashBoard.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersDashBoardController c = loader.getController();
        c.initData(movie);
        
        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
    }
    
}
