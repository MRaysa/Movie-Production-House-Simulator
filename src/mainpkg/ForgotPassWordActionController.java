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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ForgotPassWordActionController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private DatePicker doj;
    @FXML
    private TextField passField;
    @FXML
    private ComboBox<String> desigCombo;
    ArrayList<MovieProject> arrMP;
    ArrayList<Client> arrCLient;
    @FXML
    private ComboBox<String> moveNameCombo;
    Producer pro;
    ArrayList<User> arrUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arrMP = readWriteObject.getArr();
        arrCLient = ClientAcountReadWrite.getArr();
        desigCombo.getItems().addAll("Producer", "Director", "Project Manger", "Actor", "Actress", "CinematoGrapher",
                "Script Writer", "Suplier", "Client");
        if (arrMP != null) {
            for (MovieProject i : arrMP) {
                moveNameCombo.getItems().add(i.getMovieName());

            }

        }

    }

    @FXML
    private void gotoLoginAction(ActionEvent event) throws IOException {
        Parent r = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene sc = new Scene(r);

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(sc);
        stg.show();

    }

    @FXML
    private void resetPassAction(ActionEvent event) {
        if (desigCombo.getValue().equals("Producer")) {
            if (arrMP == null) {
                Alert alt = new Alert(Alert.AlertType.ERROR);
                alt.setContentText("Movie Does not Exist");
                alt.setHeaderText("Not Found Error");
                alt.showAndWait();
                return;

            }
            for (MovieProject i : arrMP) {
                if (moveNameCombo.getValue().equals(i.getMovieName())) {

                    pro = i.getProducer();

                }
            }
            int id = Integer.parseInt(idField.getText());

            String Moviename = moveNameCombo.getValue();
            String name = nameField.getText();
            String newPass = passField.getText();
            System.out.println(id + " " + Moviename + " " + name + " " + newPass);
            System.out.println(pro);

            if ((pro.getId() == id) && (Moviename.equals(pro.getMovieName())) && (pro.getName().equals(name)) && (pro.getDOJ().equals(doj.getValue()))) {

                Alert alt = new Alert(Alert.AlertType.CONFIRMATION);
                alt.setContentText("Are You Sure to chenge the Pass");
                alt.setHeaderText("Change Pass");
                Optional<ButtonType> bt = alt.showAndWait();
                if (bt.get() == ButtonType.OK) {
                    for (MovieProject i : arrMP) {
                        if (i.getMovieName().equals(Moviename)) {
                            Producer temp = i.getProducer();
                            temp.setPass(newPass);
                            i.setProducer(temp);
                            break;

                        }

                    }
                    readWriteObject.writeObj(arrMP);
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Successfully Changed the password");
                    a.setHeaderText("SuccessFull");
                    a.showAndWait();
                    return;
                } else {
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Information Not matched");
                    a.setHeaderText("Not found");
                    a.showAndWait();
                    return;

                }
            }

        } else if (desigCombo.getValue().equals("Client")) {
            if (arrCLient == null) {
                Alert alt = new Alert(Alert.AlertType.ERROR);
                alt.setContentText("No Client Exist");
                alt.setHeaderText("Not Found Error");
                alt.showAndWait();
                return;

            } else {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String newPass = passField.getText();
                LocalDate doj = this.doj.getValue();
                for (Client i : arrCLient) {
                    if ((i.getId() == id) && (i.getName().equals(name)) && (i.getDOJ().equals(doj))) {
                        Alert alt = new Alert(Alert.AlertType.CONFIRMATION);
                        alt.setContentText("Are You Sure to chenge the Pass");
                        alt.setHeaderText("Change Pass");
                        Optional<ButtonType> bt = alt.showAndWait();
                        if (bt.get() == ButtonType.OK) {
                            i.setPass(newPass);
                            ClientAcountReadWrite.writeObj(arrCLient);
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("Successfully Changed the password");
                            a.setHeaderText("SuccessFull");
                            a.showAndWait();
                            return;

                        } else {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("Information Not matched");
                            a.setHeaderText("Not found");
                            a.showAndWait();
                            return;

                        }

                    }

                }
            }

        } else {
            if (arrMP == null) {
                Alert alt = new Alert(Alert.AlertType.ERROR);
                alt.setContentText("Movie Does not Exist");
                alt.setHeaderText("Not Found Error");
                alt.showAndWait();
                return;

            }
            int id = Integer.parseInt(idField.getText());

            String Moviename = moveNameCombo.getValue();
            String name = nameField.getText();
            String newPass = passField.getText();
            System.out.println(id + " " + Moviename + " " + name + " " + newPass);

            for (MovieProject i : arrMP) {
                if (moveNameCombo.getValue().equals(i.getMovieName())) {
                    System.out.println(i.getCrewList());
                    arrUser = i.getCrewList();
                    for (User j : arrUser) {

                        if ((j.getId() == id) && (j.getName().equals(name)) && (j.getMovieName().equals(Moviename)) && (j.getDesig().equals(desigCombo.getValue()))) {
                            Alert alt = new Alert(Alert.AlertType.CONFIRMATION);
                            alt.setContentText("Are You Sure to chenge the Pass");
                            alt.setHeaderText("Change Pass");
                            Optional<ButtonType> bt = alt.showAndWait();
                            if (bt.get() == ButtonType.OK) {
                                j.setPass(newPass);
                                i.addCrewList(arrUser);
                                readWriteObject.writeObj(arrMP);

                                Alert a = new Alert(Alert.AlertType.INFORMATION);
                                a.setContentText("Successfully Changed the password");
                                a.setHeaderText("SuccessFull");
                                a.showAndWait();
                                return;

                            }
                        }

                    }
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Information Not matched");
                    a.setHeaderText("Not found");
                    a.showAndWait();
                    return;

                }
            }

        }
    }

}
