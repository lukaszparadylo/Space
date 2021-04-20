package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;

import java.util.Timer;
import java.util.TimerTask;

public class Controller implements EventHandler<KeyEvent> {
    @FXML
    private Button button;
    @FXML
    private BorderPane borderPane;
    @FXML
    public void moveUp(ActionEvent actionEvent){
        //button.setTranslateX(100.0);
    }

    Timer timer = new Timer();
    String w="", s="", a="", d="";
    public Controller() {
        timer.schedule(timerTask,1000,10);
    }
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            if(Math.abs(button.getTranslateX())<=borderPane.getWidth()/2) {

                if(w=="W" && a=="A"){
                    button.setTranslateX(button.getTranslateX()-10);
                    button.setTranslateY(button.getTranslateY()-10);
                }
                if(w=="W" && d=="D"){
                    button.setTranslateX(button.getTranslateX()+10);
                    button.setTranslateY(button.getTranslateY()-10);
                }
                if(s=="S" && a=="A"){
                    button.setTranslateX(button.getTranslateX()-10);
                    button.setTranslateY(button.getTranslateY()+10);
                }
                if(s=="S" && d=="D"){
                    button.setTranslateX(button.getTranslateX()+10);
                    button.setTranslateY(button.getTranslateY()+10);
                }
                if(w=="W" && s=="" && a=="" && d==""){
                    button.setTranslateY(button.getTranslateY()-10);
                }
                if(w=="" && s=="S" && a=="" && d==""){
                    button.setTranslateY(button.getTranslateY()+10);
                }
                if(w=="" && s=="" && a=="A" && d==""){
                    button.setTranslateX(button.getTranslateX()-10);
                }
                if(w=="" && s=="" && a=="" && d=="D"){
                    button.setTranslateX(button.getTranslateX()+10);
                }
                System.out.println("Tick "+w+s+a+d+borderPane.getWidth()+" "+button.getTranslateX());
            }
        }
    };
    @Override
    public void handle(KeyEvent keyEvent) {
        button.setText(keyEvent.getCode().toString());
        String eventType = keyEvent.getEventType().toString();
        String code = keyEvent.getCode().toString();
        //System.out.println(keyEvent.getEventType().toString());

        if(eventType=="KEY_PRESSED"){
            if(code == "W"){
                w = "W";
            }
            if(code == "S"){
                s = "S";
            }
            if(code == "A"){
                a = "A";
            }
            if(code == "D"){
                d = "D";
            }
        }
        if(eventType=="KEY_RELEASED"){
            if(code == "W"){
                w = "";
            }
            if(code == "S"){
                s = "";
            }
            if(code == "A"){
                a = "";
            }
            if(code == "D"){
                d = "";
            }
        }

        /*if(keyEvent.getCode().toString()=="W") {
            if(keyEvent.getCode().toString()=="A"){
                button.setTranslateX(button.getTranslateX()-10);
                button.setTranslateY(button.getTranslateY()-10);
            }
        }
        switch (keyEvent.getCode().toString()){
            case "A":
                button.setTranslateX(button.getTranslateX()-10);
                break;
            case "D":
                button.setTranslateX(button.getTranslateX()+10);
                break;
            case "W":
                button.setTranslateY(button.getTranslateY()-10);
                break;
            case "S":
                button.setTranslateY(button.getTranslateY()+10);
                break;
        }*/

    }
}
