module com.github.ericnaibert.calendarchallenge {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.github.ericnaibert.calendarchallenge to javafx.fxml;
    exports com.github.ericnaibert.calendarchallenge;
}