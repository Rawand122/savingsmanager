package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class FXMLController {
    
    @FXML
    private Label label;
    
    public void initialize() {

        label.setText("Hello Rawand, Welcome back!!");
        label.setFont(new Font("Arial\"",20));
    }
}
