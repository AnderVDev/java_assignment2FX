module org.assignment.superhero {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires java.net.http;

    opens org.assignment.superhero to javafx.fxml;
    exports org.assignment.superhero;
    exports org.assignment.superhero.controller;
    opens org.assignment.superhero.controller to javafx.fxml;

    opens org.assignment.superhero.model to com.google.gson;

}