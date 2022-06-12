package lk.ijse.pos.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

public class DashboardFormController {
    public Label lblTime;
    public AnchorPane dashboardContainer;

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

    public void customerManagementOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CustomerForm","Customer Page");
    }

    public void itemManagementOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ItemForm","Item Page");
    }

    public void orderDetailsManagementOnAction(ActionEvent actionEvent) throws IOException {
        setUi("OrderForm","Item Page");
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {
    }

    private void setUi(String location, String title) throws IOException {
        Stage stage = (Stage) dashboardContainer.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader
                .load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
        stage.setTitle(title);
    }
}
