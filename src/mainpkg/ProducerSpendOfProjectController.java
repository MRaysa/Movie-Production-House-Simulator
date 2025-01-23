
package mainpkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ProducerSpendOfProjectController implements Initializable {

    @FXML
    private TableView<Spends> tableOfCosts;
    @FXML
    private TableColumn<Spends, String> costTypeCol;
    @FXML
    private TableColumn<Spends, String> costFieldCol;
    @FXML
    private TableColumn<Spends, Float> costCol;
    @FXML
    private TableColumn<Spends, Float> reaminedBudgetCol;
    @FXML
    private ComboBox<String> costTypeCombo;
    @FXML
    private ComboBox<String> costFieldCombo;
    @FXML
    private TextField costField;
    ObservableList<String> comboxOb;
    ArrayList<Spends>dataArr;
    String movieName;
    float budget,preProductionBudget,postProductionBudget,supliesBudget;
    Spends newSpnd;
    ArrayList<BudgetManangeMent> budArr;
    ObservableList<Spends>spendArr;
    ProducerSpendOfProjectReadWrite spendRW;
    float totalpreProduction,totalPostProduction,totalSupliesCost;
    public void initData(String Moviename){
        movieName = Moviename;
        spendRW = new ProducerSpendOfProjectReadWrite(movieName);
        spendArr =FXCollections.observableArrayList();
        dataArr=spendRW.getArr();
        budArr = ProducersBudgetMangeMentDataBase.getArr();
        System.out.println(budArr);
        if(budArr!=null){
            for(BudgetManangeMent i : budArr){
                if(i.getMovieName().equals(movieName)){
                    budget = i.getBudget();
                    preProductionBudget = i.getPreProduction();
                    postProductionBudget = i.getPostProduction();
                    supliesBudget = i.getToolCost();
                    System.out.println( i.getPreProduction()+" "+i.getPostProduction()+" "+i.getToolCost());
                }
            }
        }
        if(dataArr!=null){
            for(Spends i:dataArr){
                if(i.getSpendType().equals("PreProduction")){
                    totalpreProduction += i.getCost();
                    
                }
                if(i.getSpendType().equals("PostProduction")){
                    totalPostProduction += i.getCost();
                }
                if(i.getSpendType().equals("SupliesCost")){
                    totalSupliesCost += i.getCost();
                    
                }
                spendArr.add(i);
                
                
            }
            System.out.println(totalpreProduction);
            System.out.println(totalSupliesCost);
            System.out.println(totalPostProduction);
            tableOfCosts.setItems(spendArr);
        }
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        budArr = null;
        spendArr =null;
        costTypeCombo.getItems().addAll("PreProduction","PostProduction","SupliesCost");
        comboxOb = FXCollections.observableArrayList();
        costTypeCol.setCellValueFactory(new PropertyValueFactory("spendType"));
        costFieldCol.setCellValueFactory(new PropertyValueFactory("spendField"));
        costCol.setCellValueFactory(new PropertyValueFactory("cost"));
        reaminedBudgetCol.setCellValueFactory(new PropertyValueFactory("reaminedBudget"));
        totalpreProduction=0f;
        totalPostProduction=0f;
        totalSupliesCost=0f;
    }    



    @FXML
    private void addTheCostAction(ActionEvent event) {
        System.out.println("");

    float cost = Float.parseFloat(costField.getText());
    float remainCost;
    if(dataArr==null){
            dataArr= new ArrayList();
            if(costTypeCombo.getValue().equals("SupliesCost")){
                totalSupliesCost = totalSupliesCost + cost;
                remainCost = supliesBudget - totalSupliesCost;}
            else if(costTypeCombo.getValue().equals("PostProduction")){
                totalPostProduction=totalPostProduction + cost;
                remainCost = postProductionBudget - totalPostProduction;}
            else {
                totalpreProduction = totalpreProduction + cost;
                remainCost = preProductionBudget-totalpreProduction;
            }
            if(remainCost>=0){
                    newSpnd = new Spends(costTypeCombo.getValue(),costFieldCombo.getValue(),cost,remainCost);
            }else{
                Alert a = new Alert(AlertType.INFORMATION,"Your Budget Overflow");
                return;
                
            }

            
            dataArr.add(newSpnd);
            spendArr.add(newSpnd);
            tableOfCosts.setItems(spendArr);
            spendRW.writeObj(dataArr);
    }else{
            if(costTypeCombo.getValue().equals("SupliesCost")){
                totalSupliesCost = totalSupliesCost + cost;
                remainCost = supliesBudget - totalSupliesCost;}
            else if(costTypeCombo.getValue().equals("PostProduction")){
                totalPostProduction=totalPostProduction + cost;
                remainCost = postProductionBudget - totalPostProduction;}
            else {
                totalpreProduction = totalpreProduction + cost;
                remainCost = preProductionBudget-totalpreProduction;
            }
            if(remainCost>=0){
                    newSpnd = new Spends(costTypeCombo.getValue(),costFieldCombo.getValue(),cost,remainCost);
            }else{
                Alert a = new Alert(AlertType.INFORMATION,"Your Budget Overflow");
                a.setAlertType(AlertType.ERROR);
                a.showAndWait();
                return;
                
            }
            dataArr.add(newSpnd);
            spendArr.add(newSpnd);
            tableOfCosts.setItems(spendArr);
            spendRW.writeObj(dataArr);
        
        }   
    }
    @FXML
    private void costTypeComboAction(ActionEvent event) {
        if(costTypeCombo.getValue().equals("PreProduction")){
            comboxOb.clear();
            comboxOb.addAll("Contract","LocationCost","PreperationCost",
                                               "TravelandAccomodaTion","Insuarance","OfficeSetUp"
                                                ,"Salaries");
            costFieldCombo.setItems(comboxOb);
        }else if(costTypeCombo.getValue().equals("PostProduction")){
            
            comboxOb.clear();
            comboxOb.addAll("Editing","VisualEffects","SoundDesignandMixing",
                                            "QualityControlandTesting","ArchiveandStorage","ColorCorrection");
            costFieldCombo.setItems(comboxOb);
        }else if(costTypeCombo.getValue().equals("SupliesCost")){
            comboxOb.clear();
            comboxOb.addAll("SoundRecoder","Camera gear","Lights","Costume",
                                                "MakeUps","Medicine");
            costFieldCombo.setItems(comboxOb);
        }
    }

    @FXML
    private void saveAction(ActionEvent event) {
        if(spendArr==null){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("The Array Is Empty");
            a.showAndWait();
            return;
        }
        
        spendRW.writeObj(dataArr);
        System.out.println("Successful");
    }
    
    
}
