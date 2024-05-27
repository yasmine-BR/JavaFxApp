module com.example.gestionbibliotheque {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;
    requires java.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;


    opens com.example.gestionbibliotheque.model to javafx.fxml, org.hibernate.orm.core, javafx.base;
    opens com.example.gestionbibliotheque to javafx.fxml;
    exports com.example.gestionbibliotheque;
}