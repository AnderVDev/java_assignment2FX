module org.assignment.superhero {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.assignment.superhero to javafx.fxml;
    exports org.assignment.superhero;
}