module com.github.ericnaibert.calendarchallenge {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.github.ericnaibert.calendarchallenge to javafx.fxml;
    exports com.github.ericnaibert.calendarchallenge;
    exports com.github.ericnaibert.calendarchallenge.calendar;
    opens com.github.ericnaibert.calendarchallenge.calendar to javafx.fxml;
    exports com.github.ericnaibert.calendarchallenge.calendar.month;
    opens com.github.ericnaibert.calendarchallenge.calendar.month to javafx.fxml;
}