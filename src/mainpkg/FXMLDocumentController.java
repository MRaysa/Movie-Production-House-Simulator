package mainpkg;

import CrewMembers.Client;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.User;
//import movieproductionhouse.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField IdField;
    @FXML
    private TextField passwordField;
    ArrayList<MovieProject> arr;
    /**
     * Initializes the controller class.
     */
    Validation val;
    @FXML
    private ComboBox<String> movieCombo;
    ObjectReadWrite obj;
    readWriteObject obj2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        arr =  new ArrayList();
//        obj2 = new readWriteObject();
        val = new Validation();
//        obj = new ObjectReadWrite();
//        arr = obj.getProjectArr();
//        File f = new File("Projects.bin"); 
//        if(f.exists()){
        arr = readWriteObject.getArr();
        if (arr == null) {
            return;
        }
        for (MovieProject i : arr) {
            movieCombo.getItems().add(i.getMovieName());
        }

    }

    public void readObject() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        MovieProject us = null;
        File f = null;
        try {
            f = new File("Project.bin");

            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            while (true) {
                us = (MovieProject) ois.readObject();
                arr.add(us);

            }

        } catch (Exception ex) {
        }
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException, ClassNotFoundException {

        if (arr == null) {
            return;
        }
        int id = Integer.parseInt(IdField.getText());
        String pass = passwordField.getText();
        if (val.idVerification(id) > 6 || val.idVerification(id) <= 0) {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Id is not Valid");
            a.setHeaderText("Invalid Id");
            a.showAndWait();
            return;
        } else {

            if (movieCombo.getValue() != null) {
                for (MovieProject i : arr) {
                    if (i.getMovieName().equals(movieCombo.getValue())) {
                        if (i.producer.getId() == Integer.parseInt(IdField.getText()) && i.producer.getPass().equals(passwordField.getText())) {
                            FXMLLoader loader = new FXMLLoader();

                            loader.setLocation(getClass().getResource("ProducersDashBoard.fxml"));
                            Parent r = loader.load();
                            Scene sc = new Scene(r);
                            ProducersDashBoardController cont = loader.getController();
                            cont.initData(i);

                            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

                            stg.setScene(sc);
                            stg.show();

                        } else {
                            for (User j : i.getCrewList()) {

                                if ((j.getId() == id) && (j.getPass().equals(pass)) && ((j.getDesig().equals("Actor")) || (j.getDesig().equals("Actress")))) {
                                    FXMLLoader loader = new FXMLLoader();

                                    loader.setLocation(getClass().getResource("ActorDashBoard.fxml"));
                                    Parent r = loader.load();
                                    Scene sc = new Scene(r);
                                    ActorDashBoardController cont = loader.getController();
                                    cont.initData(j);

                                    Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

                                    stg.setScene(sc);
                                    stg.show();
                                    return;

                                } else if ((j.getId() == id) && (j.getPass().equals(pass)) && (j.getDesig().equals("Project Manger"))) {
                                    FXMLLoader loader = new FXMLLoader();

                                    loader.setLocation(getClass().getResource("Project_Manager_Dashboard.fxml"));
                                    Parent r = loader.load();
                                    Scene sc = new Scene(r);
                                    Project_Manager_DashboardController cont = loader.getController();
                                    cont.initData(j);

                                    Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

                                    stg.setScene(sc);
                                    stg.show();
                                    return;

                                } else if ((j.getId() == id) && (j.getPass().equals(pass)) && (j.getDesig().equals("Resource Suplier"))) {
                                    FXMLLoader loader = new FXMLLoader();

                                    loader.setLocation(getClass().getResource("User_8_Resource_Supplier_Dashboard.fxml"));
                                    Parent r = loader.load();
                                    Scene sc = new Scene(r);
                                    User_8_Resource_Supplier_DashboardController cont = loader.getController();
                                    cont.initData(j);

                                    Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

                                    stg.setScene(sc);
                                    stg.show();
                                    return;

                                } else if ((j.getId() == id) && (j.getPass().equals(pass)) && (j.getDesig().equals("CinematoGrapher"))) {
                                    FXMLLoader loader = new FXMLLoader();

                                    loader.setLocation(getClass().getResource("User_6_Dashbord.fxml"));
                                    Parent r = loader.load();
                                    Scene sc = new Scene(r);
                                    User_6_DashbordController cont = loader.getController();
                                    //cont.initData(j);

                                    Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

                                    stg.setScene(sc);
                                    stg.show();
                                    return;

                                } else if ((j.getId() == id) && (j.getPass().equals(pass)) && (j.getDesig().equals("Script Writer"))) {
                                    FXMLLoader loader = new FXMLLoader();

                                    loader.setLocation(getClass().getResource("ScriptwriterDashboardScene.fxml"));
                                    Parent r = loader.load();
                                    Scene sc = new Scene(r);
                                    ScriptwriterDashboardSceneController cont = loader.getController();
                                    cont.initData(j.getDesig(), j.getName(), j.getMovieName());

                                    Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

                                    stg.setScene(sc);
                                    stg.show();
                                    return;

                                } else if ((j.getId() == id) && (j.getPass().equals(pass)) && (j.getDesig().equals("Director"))) {
                                    FXMLLoader loader = new FXMLLoader();

                                    loader.setLocation(getClass().getResource("DirectorDashboardScene.fxml"));
                                    Parent r = loader.load();
                                    Scene sc = new Scene(r);
                                    DirectorDashboardSceneController cont = loader.getController();
                                    cont.initData(j.getDesig(), j.getName(), j.getMovieName());

                                    Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

                                    stg.setScene(sc);
                                    stg.show();
                                    return;

                                }

                            }
                            Alert wPass = new Alert(AlertType.ERROR);
                            wPass.setContentText("Wrong Pass or Id");
                            wPass.setHeaderText("WrongData");
                            wPass.showAndWait();
                            return;
                        }
                    }
                }
            } else {
                ArrayList<Client> arrClient = ClientAcountReadWrite.getArr();
                if (arrClient == null) {
                    return;
                }
                for (Client i : arrClient) {
                    if ((i.getId() == id) && (i.getPass().equals(pass)) && (i.getDesig().equals("Client"))) {
                        FXMLLoader loader = new FXMLLoader();

                        loader.setLocation(getClass().getResource("User_5_Dashbord.fxml"));
                        Parent r = loader.load();
                        Scene sc = new Scene(r);
                        User_5_DashbordController cont = loader.getController();
                        //cont.initData(i.getDesig(),i.getName());

                        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        stg.setScene(sc);
                        stg.show();
                        return;

                    }

                }
                Alert wPass = new Alert(AlertType.ERROR);
                wPass.setContentText("Wrong Pass or Id");
                wPass.setHeaderText("WrongData");
                wPass.showAndWait();
                return;

            }

        }
    }

    @FXML
    private void forgotPasswordAction(ActionEvent event) throws IOException {
        Parent r = FXMLLoader.load(getClass().getResource("ForgotPassWordAction.fxml"));
        Scene sc = new Scene(r);

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(sc);
        stg.show();

    }

    @FXML
    private void CreateNewAccountAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("BuildATeam.fxml"));
        Scene sc = new Scene(r);
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void clearText(MouseEvent event) {
        passwordField.clear();
    }

    @FXML
    private void clientAction(ActionEvent event) throws IOException {
        Parent r = FXMLLoader.load(getClass().getResource("ClientAcountAction.fxml"));
        Scene sc = new Scene(r);

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(sc);
        stg.show();
    }

}
