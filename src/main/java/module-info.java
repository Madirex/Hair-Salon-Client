module com.madirex.hairsalonclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;
    requires retrofit2;
    requires retrofit2.converter.jackson;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires lombok;

    opens com.madirex.hairsalonclient to javafx.fxml, com.fasterxml.jackson.databind, com.fasterxml.jackson.datatype.jsr310;
    opens com.madirex.hairsalonclient.model to com.fasterxml.jackson.databind, com.fasterxml.jackson.datatype.jsr310;
    opens com.madirex.hairsalonclient.controller to javafx.fxml, com.fasterxml.jackson.databind, javafx.controls, com.fasterxml.jackson.datatype.jsr310;
    opens com.madirex.hairsalonclient.restcontroller to com.fasterxml.jackson.core, com.fasterxml.jackson.annotation, com.fasterxml.jackson.databind, com.fasterxml.jackson.datatype.jsr310;
    exports com.madirex.hairsalonclient;
    exports com.madirex.hairsalonclient.controller;
    exports com.madirex.hairsalonclient.model;
    exports com.madirex.hairsalonclient.restcontroller;
    exports com.madirex.hairsalonclient.model.createDTOs;
    opens com.madirex.hairsalonclient.model.createDTOs to com.fasterxml.jackson.databind, javafx.controls, javafx.fxml, com.fasterxml.jackson.datatype.jsr310;
}