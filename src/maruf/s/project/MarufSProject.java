 package maruf.s.project;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

 
public class MarufSProject extends Application {
    
         private Stage window;
         private String  inputlekha="Binary", outputlekha = "Decimal";
           Converter converter;
           AlertBox alert;
     
    public void start(Stage primaryStage) {
       window = primaryStage;
       window.setHeight(400);
       window.setWidth(700);
       window.setResizable(false);
       
       window.setTitle("Number Converter");
        window.getIcons().add(new Image("maruf/s/project/res/icon.png"));
      
        
        
        
       
       HBox hBox = new HBox();
       Label label = new Label(inputlekha+" to "+outputlekha);
       label.getStyleClass().add("label");
       hBox.getChildren().add(label);
       hBox.getStyleClass().add("hbox");
       
       VBox vBox = new VBox();
       vBox.getStyleClass().add("vbox");
       
       Label text = new Label("Convert :");
       text.setFont(new Font(5));
       
       
       GridPane gridPane = new GridPane();
       gridPane.setVgap(10);
       gridPane.setHgap(10);
       gridPane.getStyleClass().add("pane");
       
       Label input, output;
       input = new Label();
       input.setFont(new Font(20));
       input.setText("Input");
       output = new Label();
       output.setFont(new Font(20));
       output.setText("Output");
        
       
       TextField inputBox = new TextField();
       inputBox.getStyleClass().add("inputbox");
       inputBox.setPromptText(inputlekha);
       
       TextField outputBox = new TextField();
       outputBox.getStyleClass().add("inputbox");
       outputBox.setPromptText(outputlekha);
       
       
       
          ChoiceBox<String> choiceBox = new ChoiceBox<>();
                choiceBox.getItems().addAll("Bin <-> Dec", "Bin <-> Oct", "Bin <-> Hex", "Bin <-> BCD");
                choiceBox.getItems().addAll("Dec <-> Oct", "Dec <-> Hex", "Dec <-> BCD");
                choiceBox.getItems().addAll("Oct <-> Hex","Oct <-> BCD");
                choiceBox.getItems().addAll("Hex <-> BCD");
                
                choiceBox.getStyleClass().add("choicebox");
                choiceBox.setValue("Bin <-> Dec");
   
                    choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldV,newV)->{
                        
                      if(newV.equalsIgnoreCase("Bin <-> Dec"))
                      {
                         inputlekha = "Binary";
                         outputlekha = "Decimal";
                      }

                      else if(newV.equalsIgnoreCase("Bin <-> Oct"))
                      {
                          inputlekha="Binary";
                          outputlekha = "Octal";
                      }

                       else if(newV.equalsIgnoreCase("Bin <-> Hex"))
                       {
                            inputlekha = "Binary";
                            outputlekha = "Hexadecimal";
                       }

                       else if(newV.equalsIgnoreCase("Bin <-> BCD"))
                       {
                           inputlekha = "Binary";
                           outputlekha = "BCD";
                       }
                      
                      else if(newV.equalsIgnoreCase("Dec <-> Oct"))
                      {
                          inputlekha="Decimal";
                          outputlekha = "Octal";
                      }

                       else if(newV.equalsIgnoreCase("Dec <-> Hex"))
                       {
                            inputlekha = "Decimal";
                            outputlekha = "Hexadecimal";
                       }

                       else if(newV.equalsIgnoreCase("Dec <-> BCD"))
                       {
                           inputlekha = "Decimal";
                           outputlekha = "BCD";
                       }
                      
                      else if(newV.equalsIgnoreCase("Oct <-> Hex"))
                      {
                          inputlekha="Octal";
                          outputlekha = "Hexadecimal";
                      }

                       else if(newV.equalsIgnoreCase("Oct <-> BCD"))
                       {
                            inputlekha = "Octal";
                            outputlekha = "BCD";
                       }

                       else if(newV.equalsIgnoreCase("Hex <-> BCD"))
                       {
                           inputlekha = "Hexadecimal";
                           outputlekha = "BCD";
                       }
                      
                      
                      label.setText(inputlekha +" to "+outputlekha);
                      inputBox.clear();
                      outputBox.clear();
                      inputBox.setPromptText(inputlekha);
                      outputBox.setPromptText(outputlekha);

                  });
                    
       
       vBox.getChildren().addAll(text, choiceBox);
       
            
       
       Button ok, rev;
       
       ok = new Button();
       ok.setFont(new Font(20));
       ok.setText("Ok");
     
       
       ok.setOnAction(e-> {
           String inputValue, outputValue;
           inputValue = new String();
           inputValue = inputBox.getText();
           outputValue = outputBox.getText();
         converter  = new Converter();
         
           
          
           if( !(inputValue.isEmpty()) && Check(inputValue))
           {
                
              outputBox.setText( converter.Convert(inputlekha, inputValue,outputlekha) );
           }
           /*else if(!(outputValue.isEmpty()))
           {
               
              String temp = new String();
              temp = inputlekha;
             inputlekha = outputlekha;
             outputlekha = temp;
            
             if(Check(outputValue))
             {
                   
                 inputBox.setText(converter.Convert(inputlekha, outputValue,outputlekha));
             }
             
             else{
               alert = new AlertBox();
               alert.Alert("Invalid Number", "Attention");
           }
           
           }*/
           
           else if((inputValue.isEmpty()) && (outputValue.isEmpty()))
           {
               alert = new AlertBox();
               alert.Alert("Enter Any Number", "Attention");  
           }
           else{
               alert = new AlertBox();
               alert.Alert("Invalid Number", "Attention");
           }
           
       });
       
       
       
       
       
       rev = new Button();
       rev.getStyleClass().add("buttOn");
       rev.setText("<->");
       
       rev.setOnAction(e->{
          String temp;
          temp = inputlekha;
          inputlekha = outputlekha;
          outputlekha = temp;
          
          label.setText(inputlekha+" to "+outputlekha);
          inputBox.clear();
         outputBox.clear();
          inputBox.setPromptText(inputlekha);
          outputBox.setPromptText(outputlekha);
       });
       
       
       
       gridPane.add(input,0, 0);
       gridPane.add(output,2,0);
       gridPane.add(inputBox, 0, 1);
       gridPane.add(rev, 1, 1);
       gridPane.add(outputBox, 2, 1);
       gridPane.add(ok, 1,3);
       
       BorderPane borderPane = new BorderPane();
       borderPane.setTop(hBox);
       borderPane.setLeft(vBox);
       borderPane.setCenter(gridPane);
       
       
       
       
       Scene scene = new Scene(borderPane);
       scene.getStylesheets().add("maruf/s/project/myStyle.css");
       window.setScene(scene);
       window.show();
    }

     
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public boolean Check(String inputNumber){
        
        int i, len, j;
         len = inputNumber.length();
         
         if(inputlekha.equalsIgnoreCase("Decimal")){
             for(i=0; i<len; i++){
              if(inputNumber.charAt(i) <'0' || inputNumber.charAt(i)> '9')
                  return false;
          }
            return true;
         }
         
         else if(inputlekha.equalsIgnoreCase("Binary")){
           
             
          for(i=0; i<len; i++){
              if( inputNumber.charAt(i)!='1'  &&  inputNumber.charAt(i)!= '0')
                  return false;
          }
            return true;
        }
        
        
        else if(inputlekha.equalsIgnoreCase("Octal")){
           for(i=0; i<len; i++){
              if(inputNumber.charAt(i)<'0' || inputNumber.charAt(i)>'7')
                  return false;
          }
            return true; 
            
        }
        else if(inputlekha.equalsIgnoreCase("Hexadecimal")){
            char test;
            
            for(i=0; i<len; i++){
                test = inputNumber.charAt(i);
              if(test<'0')
              {
                  return false;
              }
              else if(test>'9'){
                  if(test<'A')
                      return false;
                  
                  else if(test>'F'){
                      if(test<'a' || test>'f')
                          return false;
                  }
              }
          }
            return true;
      }
        else if(inputlekha.equalsIgnoreCase("BCD")){
             int temp, mul;
            if(len%4!=0)
                return false;
            
                for(i=0; i<len; i+=4)
                 {
                    j=i+3;
                    temp=0;
                    mul=1;
                    while(j>=i && j<len)
                    {
                      temp = temp+(inputNumber.charAt(j)-48)*mul;
                      mul *= 2;
                      j--;
                    }
                  if(temp>9)
                      return false;
                }
            
            for(i=0; i<len; i++){
              if(inputNumber.charAt(i)!='1' && inputNumber.charAt(i)!='0')
                  return false;
          }
            return true;
            
        }
        
   return false;
    }
    
}
