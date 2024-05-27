package com.example.gestionbibliotheque;

import com.example.gestionbibliotheque.dao.ObjectDAO;
import com.example.gestionbibliotheque.model.AdherentsEntity;
import com.example.gestionbibliotheque.model.EmpruntsEntity;
import com.example.gestionbibliotheque.model.LivresEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpruntController {

    @FXML
    VBox vbemp;

    @FXML
    private TableView<EmpruntsEntity> emptable;

    @FXML
    private TableColumn<EmpruntsEntity, String> adtc;
    @FXML
    private TableColumn<EmpruntsEntity, String> lvtc;

    @FXML
    private TableColumn<EmpruntsEntity, LocalDate> detc;
    @FXML
    private TableColumn<EmpruntsEntity, LocalDate> drptc;

    private ObjectDAO<EmpruntsEntity> obj;
    private ObservableList<EmpruntsEntity> olemp;

    private List<EmpruntsEntity> le;

    EmpruntsEntity selected = null;

    //fx-id du formulaire
    @FXML
    DatePicker datee, daterp,datere;
    @FXML
    ComboBox<String> adcb, lvcb;

    Map<Integer, String> adherentNameMap = null;
    Map<Integer, String> livreTitleMap = null;

    @FXML
    public void initialize() {
        // Configure columns for dates
        detc.setCellValueFactory(new PropertyValueFactory<>("dateemprunt"));
        drptc.setCellValueFactory(new PropertyValueFactory<>("dateretourprevue"));

        // Load data
        obj = new ObjectDAO<>();
        le = obj.getAllObjects("EmpruntsEntity");

        // Prepare maps to cache Adherents and Livres
         adherentNameMap = new HashMap<>();
         livreTitleMap = new HashMap<>();

        // Populate maps with data from the database
        ObjectDAO<AdherentsEntity> adherentsDAO = new ObjectDAO<>();
        ObjectDAO<LivresEntity> livresDAO = new ObjectDAO<>();

        //remplir les 2 comboBox
        List<AdherentsEntity> la = adherentsDAO.getAllObjects("AdherentsEntity");
        for(AdherentsEntity a:la)
            adcb.getItems().add(a.getNom()+" "+a.getPrenom());

        List<LivresEntity> lv = livresDAO.getAllObjects("LivresEntity");
        for(LivresEntity v:lv)
            lvcb.getItems().add(v.getTitre());

        //remplissage du tableview

        for (EmpruntsEntity emprunt : le) {
            int adid = emprunt.getAdherentcin();
            if (!adherentNameMap.containsKey(adid)) {
                AdherentsEntity adherent = adherentsDAO.findById(adid, "cin", "AdherentsEntity");
                if (adherent != null) {
                    adherentNameMap.put(adid, adherent.getPrenom() + " "+adherent.getNom());
                }
            }

            int lid = emprunt.getLivreid();
            if (!livreTitleMap.containsKey(lid)) {
                LivresEntity livre = livresDAO.findById(lid, "livreid", "LivresEntity");
                if (livre != null) {
                    livreTitleMap.put(lid, livre.getTitre());
                }
            }
        }

        // Configure columns for adherent and livre using the cached maps
        adtc.setCellValueFactory(cellData -> {
            int adid = cellData.getValue().getAdherentcin();
            return new SimpleStringProperty(adherentNameMap.getOrDefault(adid, ""));
        });

        lvtc.setCellValueFactory(cellData -> {
            int lid = cellData.getValue().getLivreid();
            return new SimpleStringProperty(livreTitleMap.getOrDefault(lid, ""));
        });

        // Set data to the table
        olemp = FXCollections.observableList(le);
        emptable.setItems(olemp);
    }

    @FXML
    public void displayDetails(){
        vbemp.setVisible(true);
        selected = emptable.getSelectionModel().getSelectedItem();
        adcb.getSelectionModel().select(adherentNameMap.get(selected.getAdherentcin()));
        lvcb.getSelectionModel().select(livreTitleMap.get(selected.getLivreid()));
        datee.setValue(selected.getDateemprunt());
        datere.setValue(selected.getDateretoureffective());
        daterp.setValue(selected.getDateretourprevue());

    }

}
