package lk.ijse.pos.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.DateFormat;
import java.util.Calendar;

public class DashboardFormController {
    public Label lblTime;

    public void initialize() {
        setTime();
    }

    private void setTime() {
        final DateFormat dateFormat = DateFormat.getDateInstance();
        final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Calendar calendar = Calendar.getInstance();
                        lblTime.setText(
                                calendar.getTime().getHours() +
                                        " : "
                                        + calendar.getTime().getMinutes() +
                                        " : "
                                        + calendar.getTime().getSeconds());
                    }
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void customerManagementOnAction(ActionEvent actionEvent) {
    }

    public void itemManagementOnAction(ActionEvent actionEvent) {
    }

    public void orderDetailsManagementOnAction(ActionEvent actionEvent) {
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {
    }
}
