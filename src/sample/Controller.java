package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Controller {


    @FXML
    public javafx.scene.control.Button button;

    @FXML
    public TextField textField;
    @FXML
    public Label label;



    @FXML
    public void initialize() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

   
        this.button.setOnAction(e ->{
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/validate?value="+textField.getText())).build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if(response.body().equals("true")){
                    label.setText("Good to go!");
                }else{
                    label.setText("21 and up only!");
                }

            } catch (InterruptedException | IOException ex) {
                ex.printStackTrace();
            }

        });
    }




}
