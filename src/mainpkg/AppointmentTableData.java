//package mainpkg;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javax.lang.model.SourceVersion;
//import modelClass.Appointment;
//import modelClass.Product;
//import modelClass.ProductTableData;
//
//
//
//public class AppointmentTableData  {
//
//    private  StringProperty designation;
//    private  StringProperty appointmentDate;
//    private  StringProperty appointmentTime;
//
//    public AppointmentTableData() throws IOException, FileNotFoundException, ClassNotFoundException {
//        super();
//    }
//
//    
//    public AppointmentTableData(String designation, String appointmentDate, String appointmentTime) throws IOException, FileNotFoundException, ClassNotFoundException {
//        super();
//        this.designation = new SimpleStringProperty(designation);
//        this.appointmentDate = new SimpleStringProperty(appointmentDate);
//        this.appointmentTime = new SimpleStringProperty(appointmentTime);
//    }
//
//    // Getter methods for properties
//
//        public static ObservableList<AppointmentTableData> loadAll() throws IOException, FileNotFoundException, ClassNotFoundException
//    {
//        ArrayList<Appointment> allProducts = Appointment.loadAll();
//        
//        ObservableList<AppointmentTableData> allAppoinmentTableData = FXCollections.observableArrayList();
//        
//        if (allProducts != null)
//        {
//            for (Appointment eachAppoinment: allProducts)
//            {
//                allAppoinmentTableData.add(new AppoinmentTableData(eachAppoinment));
//            }
//        }
//        
//        return allAppoinmentTableData;
//    }
//    public String getDesignation() {
//        return designation.get();
//    }
//
//    public String getAppointmentDate() {
//        return appointmentDate.get();
//    }
//
//    public String getAppointmentTime() {
//        return appointmentTime.get();
//    }
//
//    // Property methods
//
//    public StringProperty designationProperty() {
//        return designation;
//    }
//
//    public StringProperty appointmentDateProperty() {
//        return appointmentDate;
//    }
//
//    public StringProperty appointmentTimeProperty() {
//        return appointmentTime;
//    }
//
//    public SourceVersion getSupportedSourceVersion() {
//        return SourceVersion.latest();
//    }
//
//}

///=================================================================================


//package mainpkg;
//
//import java.io.IOException;
//import java.io.Serializable;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import modelClass.Appointment;
//
//public class AppointmentTableData implements Serializable {
//
//    private StringProperty designation;
//    private StringProperty appointmentDate;
//    private StringProperty appointmentTime;
//
//    public AppointmentTableData() {
//        // Default constructor
//    }
//
//    public AppointmentTableData(String designation, String appointmentDate, String appointmentTime) {
//        this.designation = new SimpleStringProperty(designation);
//        this.appointmentDate = new SimpleStringProperty(appointmentDate);
//        this.appointmentTime = new SimpleStringProperty(appointmentTime);
//    }
//
//    public AppointmentTableData(Appointment appointment) {
//        this.designation = new SimpleStringProperty(appointment.getDesignation());
//        this.appointmentDate = new SimpleStringProperty(appointment.getAppointmentDate());
//        this.appointmentTime = new SimpleStringProperty(appointment.getAppointmentTime());
//    }
//
//    public static ObservableList<AppointmentTableData> loadAll() throws IOException, ClassNotFoundException {
//        ObservableList<AppointmentTableData> allAppointmentTableData = FXCollections.observableArrayList();
//
//        ObservableList<Appointment> allAppointments = (ObservableList<Appointment>) Appointment.loadAll();
//        if (allAppointments != null) {
//            for (Appointment eachAppointment : allAppointments) {
//                allAppointmentTableData.add(new AppointmentTableData(eachAppointment));
//            }
//        }
//
//        return allAppointmentTableData;
//    }
//
//    public String getDesignation() {
//        return designation.get();
//    }
//
//    public String getAppointmentDate() {
//        return appointmentDate.get();
//    }
//
//    public String getAppointmentTime() {
//        return appointmentTime.get();
//    }
//
//    public StringProperty designationProperty() {
//        return designation;
//    }
//
//    public StringProperty appointmentDateProperty() {
//        return appointmentDate;
//    }
//
//    public StringProperty appointmentTimeProperty() {
//        return appointmentTime;
//    }
//}

///================================================================================ 2nd ta main

package mainpkg;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelClass.Appointment;

/**
 *
 * @author Aysa
 */

public class AppointmentTableData implements Serializable {

    private StringProperty designation;
    private StringProperty appointmentDate;
    private StringProperty appointmentTime;
    private Appointment appoinmentInstance;

    public AppointmentTableData(Appointment appoinmentInstance) {
        this.appoinmentInstance = appoinmentInstance;
        
        this.designation = new SimpleStringProperty(this,"designation");
        this.designation.setValue(appoinmentInstance.getDesignation());
        
        this.appointmentDate = new SimpleStringProperty(this,"appointmentDate");
        this.appointmentDate.setValue(appoinmentInstance.getAppointmentDate());
        
        this.appointmentTime = new SimpleStringProperty(this,"appointmentTime");
        this.appointmentTime.setValue(appoinmentInstance.getAppointmentTime());
        
    }



    public static ObservableList<AppointmentTableData> loadAll() throws IOException, ClassNotFoundException {
        ArrayList<Appointment> allAppointment = Appointment.loadAll();
        ObservableList<AppointmentTableData> allAppointmentTableData = FXCollections.observableArrayList();
        if (allAppointment != null) {
            for (Appointment eachAppointment : allAppointment) {
                allAppointmentTableData.add(new AppointmentTableData(eachAppointment));
            }
        }

        return allAppointmentTableData;
    }

    public String getDesignation() {
        return designation.get();
    }

    public String getAppointmentDate() {
        return appointmentDate.get();
    }

    public String getAppointmentTime() {
        return appointmentTime.get();
    }

    public StringProperty designationProperty() {
        return designation;
    }

    public StringProperty appointmentDateProperty() {
        return appointmentDate;
    }

    public StringProperty appointmentTimeProperty() {
        return appointmentTime;
    }
}


