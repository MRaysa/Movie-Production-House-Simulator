//package modelClass;
//
//import mainpkg.*;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.ArrayList;
//
//public class Appointment extends AbstractDBModel implements Serializable {
//
//    private String designation;
//    private String appointmentDate;
//    private String appointmentTime;
//
//    public Appointment() throws IOException, FileNotFoundException, ClassNotFoundException {
//        super();
//    }
//
//    public Appointment(String designation, String appointmentDate, String appointmentTime) throws IOException, FileNotFoundException, ClassNotFoundException {
//        super();
//        this.designation = designation;
//        this.appointmentDate = appointmentDate;
//        this.appointmentTime = appointmentTime;
//    }
//
//    public String getDesignation() {
//        return designation;
//    }
//
//    public void setDesignation(String designation) {
//        this.designation = designation;
//    }
//
//    public String getAppointmentDate() {
//        return appointmentDate;
//    }
//
//    public void setAppointmentDate(String appointmentDate) {
//        this.appointmentDate = appointmentDate;
//    }
//
//    public String getAppointmentTime() {
//        return appointmentTime;
//    }
//
//    public void setAppointmentTime(String appointmentTime) {
//        this.appointmentTime = appointmentTime;
//    }
//
//    public static ArrayList<Appointment> loadAll() throws FileNotFoundException, IOException, ClassNotFoundException {
//        ArrayList<Appointment> allProducts = new ArrayList<>();
//        ArrayList<AbstractDBModel> allItems = loadAllFromFile("Appointment.bin");
//        if (allItems == null) {
//            return null;
//        }
//        for (AbstractDBModel eachItem : allItems) {
//            allProducts.add((Appointment) eachItem);
//        }
//
//        return allProducts;
//    }
//
//    @Override
//    public void update() throws FileNotFoundException, IOException, ClassNotFoundException {
//        this.updateToFile("Appointment.bin");
//    }
//
//    @Override
//    public void delete() throws FileNotFoundException, IOException, ClassNotFoundException {
//        this.deleteFromFile("Appointment.bin");
//    }
//
//    @Override
//    public void save() throws FileNotFoundException, IOException {
//        this.saveToFile("Appointment.bin");
//    }
//
//    public int count() throws IOException, FileNotFoundException, ClassNotFoundException {
//        return this.countFromFile("Appointment.bin");
//    }
//}




///============================================================================================



package modelClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Appointment extends AbstractDBModel implements Serializable {

    private String designation;
    private String appointmentDate;
    private String appointmentTime;

    public Appointment() throws IOException, FileNotFoundException, ClassNotFoundException {
        super();
    }

    public Appointment(String designation, String appointmentDate, String appointmentTime) throws IOException, FileNotFoundException, ClassNotFoundException {
        super();
        this.designation = designation;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public String getDesignation() {
        return designation;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public static ArrayList<Appointment> loadAll() throws IOException, ClassNotFoundException {
        ArrayList<Appointment> allAppointments = new ArrayList<>();

        ArrayList<AbstractDBModel> allItems = loadAllFromFile("Appointment.bin");
        if (allItems != null) {
            for (AbstractDBModel eachItem : allItems) {
                allAppointments.add((Appointment) eachItem);
            }
        }

        return allAppointments;
    }

    @Override
    public void update() throws IOException, ClassNotFoundException {
        updateToFile("Appointment.bin");
    }

    @Override
    public void delete() throws IOException, ClassNotFoundException {
        deleteFromFile("Appointment.bin");
    }

    @Override
    public void save() throws IOException {
        saveToFile("Appointment.bin");
    }

    public int count() throws IOException, ClassNotFoundException {
        return countFromFile("Appointment.bin");
    }
}


