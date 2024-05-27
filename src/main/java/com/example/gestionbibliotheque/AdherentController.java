package com.example.gestionbibliotheque;

import com.example.gestionbibliotheque.dao.ObjectDAO;
import com.example.gestionbibliotheque.model.AdherentsEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.Optional;

public class AdherentController {
    @FXML
    TableView<AdherentsEntity> adherentTable;
    @FXML
    private TableColumn<AdherentsEntity, Long > colcin;
    @FXML
    private TableColumn<AdherentsEntity, String> colnom,colprenom,colfonction;

    ObjectDAO<AdherentsEntity> obj = null;
    @FXML
    TextField cinfx,nomfx,prenomfx,emailfx,telfx,chercherfx;
    @FXML
    TextArea adressefx;
    @FXML
    RadioButton ensbtnfx,etudbtnfx,adminbtnfx,tibtnfx,gebtnfx,segbtnfx,gmbtnfx;
    @FXML
    DatePicker datefx;
    ObservableList<AdherentsEntity> allUsers=null;

    AdherentsEntity selected = null;

    @FXML
    ComboBox<String> dropdownfx;



    @FXML
    public void initialize(){
        dropdownfx.getItems().addAll("cin","nom","departement");

        // remplissage du tableau :

        colcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colfonction.setCellValueFactory(new PropertyValueFactory<>("typeadherent"));


        // recuperer la liste users à partir de la base

        obj = new ObjectDAO();
        String AdherentsEntity = null;
        List<AdherentsEntity> li= obj.getAllObjects("AdherentsEntity");
        allUsers = FXCollections.observableList(li);
        adherentTable.setItems(allUsers);


    }



    @FXML
    void displayDetails() {
        //recuperer la ligne selectionnée du tableview
        selected = adherentTable.getSelectionModel().getSelectedItem();
        cinfx.setText("" + selected.getCin());
        nomfx.setText(selected.getNom());
        prenomfx.setText(selected.getPrenom());
        telfx.setText("" + selected.getTelephone());
        emailfx.setText(selected.getEmail());
        adressefx.setText(selected.getAdresse());
        datefx.setValue(selected.getDateinscription());
        // display adherent type selection
        if (selected.getTypeadherent().equalsIgnoreCase("enseignant")){
            ensbtnfx.setSelected(true);}
        else if (selected.getTypeadherent().equalsIgnoreCase("etudiant")){
                etudbtnfx.setSelected(true);}
            else{
                adminbtnfx.setSelected(true);}

        // display departement selection
        if (selected.getDepartement().equalsIgnoreCase("TI"))
        {
            tibtnfx.setSelected(true);}
        else if (selected.getDepartement().equalsIgnoreCase("GE"))
        {gebtnfx.setSelected(true);}
        else if (selected.getDepartement().equalsIgnoreCase("SEG"))
        {segbtnfx.setSelected(true);}
        else
        {gmbtnfx.setSelected(true);}



    }
    public void refreshTableViw(){
        obj=new ObjectDAO<>();
        List<AdherentsEntity> lu = obj.getAllObjects("AdherentsEntity");
        allUsers.clear();
        allUsers.addAll(lu);
        adherentTable.refresh();
    }
    public void clearForm() {
        cinfx.setText("");
        nomfx.setText("");
        prenomfx.setText("");
        adressefx.setText("");
        emailfx.setText("");
        telfx.setText("");
        datefx.getEditor().clear();
        ensbtnfx.setSelected(false);
        etudbtnfx.setSelected(false);
        adminbtnfx.setSelected(false);
        tibtnfx.setSelected(false);
        gebtnfx.setSelected(false);
        segbtnfx.setSelected(false);
        gmbtnfx.setSelected(false);
    }

/*
    public void saveUpdateUser( ){

*/
public void deleteAdherent(){
    obj = new ObjectDAO<>();
    if(selected!=null){
        //afficher une alert pour confirmer la supression :
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText(null);
        a.setContentText("are you sure you want to delete this Adherent ?  ");
        Optional<ButtonType> res = a.showAndWait();
        if (res.get() == ButtonType.OK) {
            boolean t =obj.deleteObject(selected);
            refreshTableViw();
            Alert b=new Alert(Alert.AlertType.INFORMATION);
            b.setContentText("adherent deleted Sucessfully");
            b.show();

            clearForm();
        }

    }
}



}
