module xu.stat.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jbcrypt;
    requires java.sql;
    requires junit;
    requires commons.math3;
    requires org.testng;
    exports xu.stat.statestix;
    exports xu.stat.statestix.controllers;
    exports xu.stat.statestix.test to junit;
    opens xu.stat.statestix.controllers to javafx.fxml;
}