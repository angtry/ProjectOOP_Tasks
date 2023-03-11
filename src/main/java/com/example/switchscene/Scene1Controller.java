package com.example.switchscene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scene1Controller {

    @FXML
    TextField nameTextField;

    @FXML
    private ListView<String> listtask;
    @FXML
    private Label showname;
    @FXML
    private Label showpass;
    public void add (ActionEvent event) throws IOException {

        /*    String username = nameTextField.getText();
            // switch scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root = loader.load();

        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.displayName(username);

        //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
*/

        listtask.getItems().add(nameTextField.getText());



    }
    public void delete(ActionEvent event) throws IOException {

    }

    public void connectDB (ActionEvent event) throws IOException{
        DBconnect connectnow = new DBconnect();
        Connection connection = connectnow.getConnection();

        String connectQuery = "select * from users;";
        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while(queryOutput.next()){
                showname.setText(queryOutput.getString("username"));
                showpass.setText(queryOutput.getString("pass"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}