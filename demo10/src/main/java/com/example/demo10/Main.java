package com.example.demo10;// Importing essential packages


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//Main function od the program, core root, initializing first class and cotroller
public class Main extends Application implements EventHandler <ActionEvent> {

    Button btn, btn2, btn3, btn4, btn5, btn6;
    Group root, root2;
    Label label, label2, label3, label4, label5, label7, label8, label9,label10,label11;
    TextField textField, textField3, textField4,
            textField6, textField7,textField10,textField11;
    TextArea textArea;
    PasswordField textField2, password2;





    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("first stage");
        root = new Group();

        btn = new Button("Login");

        btn.setOnAction(this);

        btn.setLayoutY(150.0);
        btn.setLayoutX(150.0);
        btn.setBackground(Background.fill(Color.PINK));
        label = new Label("User name");
        label.setLayoutX(50.0);
        label.setLayoutY(80.0);
        label.setFont(Font.font("Arial", 16));
        textField = new TextField();
        textField.setLayoutX(130.0);
        textField.setLayoutY(80.0);

        label2 = new Label("Password");
        label2.setLayoutX(50.0);
        label2.setLayoutY(110.0);
        label2.setFont(Font.font("Arial", 16));
        textField2 = new PasswordField();
        textField2.setLayoutX(130.0);
        textField2.setLayoutY(110.0);
        primaryStage.setTitle("Login page");
        Text text = new Text("HOTEL MANAGEMENT SYSTEM");
        text.setFont(Font.font("Arial", 28));
        text.setLayoutY(40.0);
        text.setLayoutX(60.0);


        root.getChildren().addAll(btn, text, label, label2, textField, textField2);


        primaryStage.setResizable(true);
        Scene scene = new Scene(root, 600, 600, Color.YELLOWGREEN);
        primaryStage.setScene(scene);

        primaryStage.show();


    }


    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == btn) {

            ConnectionD conn = new ConnectionD();
            conn.connMethod();

            String userName = textField.getText();
            String password = textField2.getText();
            if (userName.equals(" dandej") && password.equals("123456 ")) {
                Alert alert1=new Alert(Alert.AlertType.INFORMATION);
               alert1.setContentText("you entered to system");
                alert1.showAndWait();
            }
            else {


               Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                alert1.setContentText("please try again");
               alert1.showAndWait();
                System.exit(0);
            }


            root2 = new Group();
            Stage stage = new Stage();
            stage.setTitle("second stage");
            Scene scene2 = new Scene(root2, 650.0, 650.0, Color.WHITE);
            btn3 = new Button("CUSTOMER");
            btn3.setLayoutX(50.0);
            btn3.setLayoutY(10.0);
            btn3.setPrefSize(150, 6);
            btn3.setBackground(Background.fill(Color.PINK));

            btn4 = new Button("ADD FOOD TYPE");
            btn4.setLayoutX(400.0);
            btn4.setLayoutY(10.0);
            btn4.setPrefSize(150, 6);
            btn4.setBackground(Background.fill(Color.PINK));

            label3 = new Label("Fname");
            label3.setFont(Font.font("Arial", 17));
            label3.setLayoutX(10.0);
            label3.setLayoutY(50.0);
            label3.setBackground(Background.fill(Color.GRAY));
            textField3 = new TextField();
            textField3.setLayoutX(70.0);
            textField3.setLayoutY(50.0);
            label4 = new Label("Lname");
            label4.setFont(Font.font("Arial", 17));
            label4.setLayoutX(10.0);
            label4.setLayoutY(80.0);
            label4.setBackground(Background.fill(Color.GRAY));
            textField4 = new TextField();
            textField4.setLayoutX(70.0);
            textField4.setLayoutY(80.0);
            label10 =new Label("cust_id");
            label10.setFont(Font.font("Arial", 17));
            label10.setLayoutX(10.0);
            label10.setLayoutY(110.0);
            label10.setBackground(Background.fill(Color.GRAY));
            textField10=new TextField();
            textField10.setLayoutX(70.0);
            textField10.setLayoutY(110.0);
            label11 = new Label("email");
            label11.setFont(Font.font("Arial", 17));
            label11.setLayoutX(10.0);
            label11.setLayoutY(140.0);
            label11.setBackground(Background.fill(Color.GRAY));
            textField11 = new TextField();
            textField11.setLayoutX(70.0);
            textField11.setLayoutY(140.0);
            label5 = new Label("emailps");
            label5.setLayoutX(10.0);
            label5.setLayoutY(170.0);
            label5.setFont(Font.font("Arial", 17));
            label5.setBackground(Background.fill(Color.GRAY));
            password2 = new PasswordField();
            password2.setLayoutX(70.0);
            password2.setLayoutY(170.0);



            btn5 = new Button("add");
            btn5.setOnAction(e -> {
                String fname, lname,cust_id,email, foodtype, price,emailpas;
                fname = textField3.getText();
                lname = textField4.getText();
                cust_id=textField10.getText();
                email=textField11.getText();
                foodtype = textField6.getText();
                price = textField7.getText();
                emailpas=password2.getText();
                try {
                    String query = "Insert into HotelManagement(FName,LName,foodtype,price,cust_id,email,emailpassword)" +
                            "values(' " + fname + " ',' " + lname + " ' ,' " + foodtype + " ' ," +
                            "' " + price + " ',' " + cust_id + " ',' " + email + " ',' " + emailpas + " ')";

                    ConnectionD conn2 = new ConnectionD();
                    Connection connection = conn2.connMethod();
                    Statement statement = connection.createStatement();
                    boolean status = statement.execute(query);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    if (!status) {
                        alert.setContentText("successfully inserted");
                        alert.showAndWait();

                    } else {
                        alert.setContentText("not inserted");
                        alert.showAndWait();

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            });

           btn5.setLayoutX(50);
            btn5.setLayoutY(240);
           btn5.setBackground(Background.fill(Color.GREEN));
           Alert alert=new Alert(Alert.AlertType.INFORMATION);
           btn6=new Button("delete");
btn6.setOnAction(e->{
    String str=textField10.getText();
    boolean status=false;
    String query="delete from HotelManagement where CUST_ID=' " +str+ " ' ";
    ConnectionD conn2 = new ConnectionD();
    Connection connection = conn2.connMethod();
    Statement statement = null;
    try{
        statement=connection.createStatement();
        status=statement.execute(query);
    }
    catch (SQLException ex){
        throw new RuntimeException(ex);
    }
    if(!status){
        alert.setContentText("deleted");
        alert.show();
    }
    else
    {
        System.exit(0);
    }

});

           btn6.setLayoutX(450);
           btn6.setLayoutY(140);
            btn6.setBackground(Background.fill(Color.GREEN));
            root2.getChildren().addAll(btn3, btn4, btn5, btn6,label3,
                    textField3, label4,textField4, label5, password2,label10,label11,textField10,textField11);
            label7 = new Label("Food type");

            label7.setFont(Font.font("Arial", 17));
            label7.setLayoutX(400.0);
            label7.setLayoutY(55.0);
            label7.setBackground(Background.fill(Color.GRAY));
            label8 = new Label("  Price(Birr)");
            label8.setFont(Font.font("Arial", 17));
            label8.setLayoutX(500.0);
            label8.setLayoutY(55.0);
            label8.setBackground(Background.fill(Color.GRAY));
            textField6 = new TextField();
            textField6.setLayoutX(350.0);
            textField6.setLayoutY(90.0);
            textField7 = new TextField();
            textField7.setLayoutX(490.0);
            textField7.setLayoutY(90.0);
            label9 = new Label("List of some Available Food ");
            label9.setFont(Font.font("Arial", 20));
            label9.setLayoutX(45);
            label9.setLayoutY(270);
            label9.setBackground(Background.fill(Color.YELLOWGREEN));

            ListView<String> list = new ListView<String>();
            ObservableList<String> items = FXCollections.observableArrayList(
                    "Burger....500Br", "Pizza....600Br", "Sandwich....400Br",
                    "Tibsi....550Br", "Dullat....600Br", "pasta....200", "Shiro....200", "Kitifo....600Br",
                    "Qeywatt....200");
            list.setItems(items);
            list.setLayoutX(60);
            list.setLayoutY(300);
            list.setPrefSize(200, 210);
            root2.getChildren().addAll(label7, label8, label9, textField6, textField7,
                    list);
            stage.setScene(scene2);

            System.out.println("you loogged");
            stage.show();

        }
        }
    }




