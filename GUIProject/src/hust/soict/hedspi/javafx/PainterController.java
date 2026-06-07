package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    private ToggleGroup toolsGroup;

    @FXML
    public void initialize() {
        toolsGroup = new ToggleGroup();
        penRadioButton.setToggleGroup(toolsGroup);
        eraserRadioButton.setToggleGroup(toolsGroup);
        penRadioButton.setSelected(true);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle circle = new Circle(event.getX(), event.getY(), 4);

        if (eraserRadioButton.isSelected()) {
            circle.setFill(Color.WHITE);
            circle.setRadius(12);
        } else {
            circle.setFill(Color.BLACK);
            circle.setRadius(4);
        }

        drawingAreaPane.getChildren().add(circle);
    }
}