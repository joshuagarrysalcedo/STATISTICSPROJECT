module xu.stat.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jbcrypt;

    opens xu.stat.statestix to javafx.fxml;
    exports xu.stat.statestix;
    exports xu.stat.statestix.controllers;
    opens xu.stat.statestix.controllers to javafx.fxml;
}