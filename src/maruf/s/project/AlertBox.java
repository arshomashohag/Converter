/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maruf.s.project;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Shohag
 */
public class AlertBox {
    
    public void Alert(String message, String title)
    {
        Stage  alertWindow = new Stage();
        alertWindow.setHeight(200);
        alertWindow.setWidth(300);
        alertWindow.setResizable(false);
        alertWindow.initModality(Modality.APPLICATION_MODAL);
        alertWindow.setTitle(title);
         alertWindow.getIcons().add(new Image("maruf/s/project/res/icoalert.png"));
        
        
        Label alertMessage = new Label(message+" !!!!");
         alertMessage.setFont(new Font(20));
         
         Button button = new Button("Close");
         button.setFont(new Font(10));
         button.setOnAction(e->alertWindow.close());
         
         VBox alertBox = new VBox();
         alertBox.setPadding(new Insets(20));
         
         alertBox.setSpacing(10);
         alertBox.getChildren().addAll(alertMessage, button);
         
         Scene scene = new Scene(alertBox);
         
         alertWindow.setScene(scene);
         alertWindow.show();
    }
    
}
