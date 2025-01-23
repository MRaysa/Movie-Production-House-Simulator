package mainpkg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import modelClass.Appointment;

/**
 * FXML Controller class
 *
 * @author Aysa
 */

public class User_7_8_CreateAppoinmentScheduleToProjectManagerController implements Initializable {

    @FXML
    private DatePicker appoinmentDatePicker;
    @FXML
    private TextField appointmentTimeTextField;
    @FXML
    private TableView<AppointmentTableData> appointmentListTable;
    @FXML
    private TableColumn<AppointmentTableData, String> designationColumn;
    @FXML
    private TableColumn<AppointmentTableData, String> appointmentDateColumn;
    @FXML
    private TableColumn<AppointmentTableData, String> appointmentTimeColumn;
    @FXML
    private ComboBox<String> designationComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        designationComboBox.getItems().addAll("Producer", "Director",
                "Actor", "Script Writer", "Client", "Cinematographer",
                "Client", "Resource Supplier");

        designationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
        designationColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        appointmentDateColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        appointmentDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        appointmentTimeColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointmentTimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        appointmentListTable.setEditable(true);

        try {
            ObservableList<AppointmentTableData> allAppointmentTableData = AppointmentTableData.loadAll();

            if (allAppointmentTableData != null) {
                appointmentListTable.setItems(allAppointmentTableData);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(User_7_8_CreateAppoinmentScheduleToProjectManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void saveToTableOnActionButtonOnClick(ActionEvent event) {
        try {
            Appointment newAppointment = getAppoinmentFromTextFields();

            if (newAppointment != null) {
                AppointmentTableData newAppointmentTableData = new AppointmentTableData(newAppointment);
                for (AppointmentTableData eachAppointment : appointmentListTable.getItems()) {
                    if (newAppointment.getDesignation().equals(eachAppointment.getDesignation())
                            && newAppointment.getAppointmentDate().equals(eachAppointment.getAppointmentDate())
                            && newAppointment.getAppointmentTime().equals(eachAppointment.getAppointmentTime())) {
                        showAlert(Alert.AlertType.ERROR, "Error", "Appointment already exists");
                        return;
                    }
                }
                appointmentListTable.getItems().add(newAppointmentTableData);
                newAppointment.save();
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(User_7_8_CreateAppoinmentScheduleToProjectManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Appointment getAppoinmentFromTextFields() throws IOException, ClassNotFoundException {
        String designation = designationComboBox.getValue();
        String appointmentDate = appoinmentDatePicker.getValue().toString();
        String appointmentTime = appointmentTimeTextField.getText();

        if (designation == null || appointmentDate.isEmpty() || appointmentTime.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "All fields must be filled");
            return null;
        }

        for (AppointmentTableData appointment : appointmentListTable.getItems()) {
            if (appointment.getDesignation().equals(designation)
                    && appointment.getAppointmentDate().equals(appointmentDate)
                    && appointment.getAppointmentTime().equals(appointmentTime)) {
                showAlert(Alert.AlertType.ERROR, "Error", "Appointment already exists");
                return null;
            }

            if (appointment.getAppointmentTime().equals(appointmentTime)) {
                showAlert(Alert.AlertType.ERROR, "Error", "Another appointment already exists at the same time");
                return null;
            }
        }

     
        return new Appointment(designation, appointmentDate, appointmentTime);
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
