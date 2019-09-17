package pkg1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MainClass extends Application {
    public static String[][] passenger = new String[100][5];
    public static String[][] trips     = new String[100][11];
    public static String[][] employees = new String[100][7];

    private int rightPass =0;
    public static Stage MainWindow;
    public static Scene loginScene;
    public static int GlobalUserIndex;
    Button check, SignUpButton,done,cancelB;
    Label userName, password, Type, signUp;
    GridPane loginLayout;
    TextField userNameText,usernameT,passT,lastNameT,FirstT;
    PasswordField passwordText;
    Pane rootLogin;
    ComboBox<String> comboBox;
    ComboBox<String> comboBox2;
    Stage newUser = new Stage();
    public static Files users             = new Files();
    public static Passengers passengerObj = new Passengers();
    public static Employee employeeObj    = new Employee();
    private int wrongPassCounter;
    public static int NumberofPassangers=0,numberOfTrips=0,nb=0,numberOfDrivers=0,numberOfMangers=0;

    private String enteredUsername, enteredPassword;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        users.openFile();
        users.readFromFile();
        users.writeToFile(1);
        MainWindow = primaryStage; //Renaming the stage to be more easier in use.
        MainWindow.setTitle("Buss Station - Login");
        rootLogin = new Pane();
        rootLogin.setStyle("-fx-background-color:#00365C;-fx-border-color: #FFCA45;-fx-border-width: 4px;"
                + "-fx-border-style: solid;");
        loginLayout = new GridPane();

        loginLayout.setPadding(new Insets(20, 20, 20, 20)); //Setting gaps in corners
        loginLayout.setVgap(8);
        loginLayout.setHgap(10);

        //Login GUI ..
        Type = new Label("Type: ");
        GridPane.setConstraints(Type, 0,0);
        Type.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
            "Passenger", "Employee"
        );
        comboBox.setStyle("-fx-background-color: #FFCA45;"
                + "-fx-text-fill: #00365C; -fx-font-size: 12px;");

        comboBox.setPromptText("Select from below");
        comboBox2 = new ComboBox<>();
        comboBox2.getItems().addAll(
                "Passenger", "Employee"
        );
        comboBox2.setPromptText("Select from below");
        GridPane.setConstraints(comboBox, 1,0);


        userName = new Label("UserName: ");
        GridPane.setConstraints(userName, 0,1);
        userName.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
        userNameText = new TextField("MahmoudElkarargy");
        userNameText.setStyle("-fx-background-color: #FFCA45;"
                + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
        GridPane.setConstraints(userNameText, 1,1);

        password = new Label("Password: ");
        GridPane.setConstraints(password, 0,2);
        password.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
        passwordText = new PasswordField();
        passwordText.setStyle("-fx-background-color: #FFCA45;"
                + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
        passwordText.setPromptText("**Write Password here**");
        GridPane.setConstraints(passwordText, 1,2);

        cancelB = new Button("Cancel");
        done = new Button("Done");
        check = new Button("Sign In");
        SignUpButton = new Button("Sign Up");
        GridPane.setConstraints(check, 1,3);
        check.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                + "-fx-background-radius: 6");
        SignUpButton.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                + "-fx-background-radius: 6");
        signUp = new Label("Don't have an account yet?");
        signUp.setStyle("-fx-text-fill: #FFF;-fx-font-size: 20px");
        GridPane.setConstraints(signUp, 0,6);
        GridPane.setConstraints(SignUpButton, 1,6);
        cancelB.setOnAction(e->{
            newUser.close();
        });
        done.setOnAction(e->{
            if(comboBox2.getValue().equalsIgnoreCase("Passenger")){
                passenger[NumberofPassangers][0] = usernameT.getText();
                passenger[NumberofPassangers][1] = passT.getText();
                passenger[NumberofPassangers][2] = FirstT.getText();
                passenger[NumberofPassangers][3] = lastNameT.getText();
                passenger[NumberofPassangers][4] = "0";
                NumberofPassangers++;
            }
            else{
                employees[(numberOfDrivers+numberOfMangers)][0] = usernameT.getText();
                employees[(numberOfDrivers+numberOfMangers)][1] = passT.getText();
                employees[(numberOfDrivers+numberOfMangers)][2] = FirstT.getText();
                employees[(numberOfDrivers+numberOfMangers)][3] = lastNameT.getText();
                employees[(numberOfDrivers+numberOfMangers)][4] = "1";
                employees[(numberOfDrivers+numberOfMangers)][5] = "0";
                employees[(numberOfDrivers+numberOfMangers)][6] = "0";
                numberOfDrivers++;
            }
            AlertBox("Done","You successfully added new user",0);
            newUser.close();
            MainClass.users.writeToFile(0);
        });
        SignUpButton.setOnAction(e->{
            newUser.setTitle("Sign UP");
            Pane root = new Pane();
            root.setStyle("-fx-background-color:#FFCA45;-fx-border-color: #00365C;-fx-border-width: 4px;"
                    + "-fx-border-style: solid;");
            Label label = new Label("Enter your data");
            label.setStyle("-fx-text-fill: #00365C;-fx-font-size: 16px");
            VBox layout = new VBox(20);
            Label Username = new Label("Username:   ");
            Username.setStyle("-fx-text-fill: #00365C;-fx-font-size: 16px");
            usernameT = new TextField();
            usernameT.setStyle("-fx-background-color: #fff;"
                    + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
            HBox s1 = new HBox(5);
            s1.getChildren().addAll(Username,usernameT);

            Label pass = new Label(    "Password:   ");
            pass.setStyle("-fx-text-fill: #00365C;-fx-font-size: 16px");
            passT = new TextField();
            passT.setStyle("-fx-background-color: #fff;"
                    + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
            HBox s2 = new HBox(5);
            s2.getChildren().addAll(pass,passT);

            Label First = new Label(   "First Name: ");
            First.setStyle("-fx-text-fill: #00365C;-fx-font-size: 16px");
            FirstT = new TextField();
            FirstT.setStyle("-fx-background-color: #fff;"
                    + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
            HBox s3 = new HBox(5);
            s3.getChildren().addAll(First,FirstT);

            Label lastName = new Label("Last Name: ");
            lastName.setStyle("-fx-text-fill: #00365C;-fx-font-size: 16px");
            lastNameT = new TextField();
            lastNameT.setStyle("-fx-background-color: #fff;"
                    + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
            HBox s4 = new HBox(5);
            s4.getChildren().addAll(lastName,lastNameT);
            done.setStyle("-fx-background-color: #00365C;-fx-text-fill:#FFCA45;"
                    + "-fx-background-radius: 6");
            cancelB.setStyle("-fx-background-color: #00365C;-fx-text-fill:#FFCA45;"
                    + "-fx-background-radius: 6");
            HBox s10 = new HBox(100);
            s10.getChildren().addAll(done,cancelB);
            layout.getChildren().addAll(label,comboBox2,s1,s2,s3,s4,s10);
            layout.setAlignment(Pos.CENTER);
            layout.setPadding(new Insets(20, 20, 20, 20));

            root.getChildren().add(layout);
            Scene scene = new Scene(root, 300, 400);
            newUser.setScene(scene);
            newUser.showAndWait();
        });
        check.setOnAction(e->{
            if(comboBox.getValue()=="Passenger"){

                NumberofPassangers=0;numberOfTrips=0;nb=0;numberOfDrivers=0;numberOfMangers=0;
                users.readFromFile();
                enteredUsername = userNameText.getText();
                enteredPassword = passwordText.getText();

                nb = NumberofPassangers;
                while(nb>=0) {
                    if (enteredUsername.equalsIgnoreCase(passenger[nb][0])) {
                        rightPass =1;
                        if (enteredPassword.equalsIgnoreCase(passenger[nb][1])) {
                            wrongPassCounter = 0;
                            GlobalUserIndex =nb;
                            passengerObj.setName(passenger[nb][2]);
                            passengerObj.setLastName(passenger[nb][3]);
                            passengerObj.setHistory(Integer.valueOf(passenger[nb][4]));
                            passengerObj.setProfile(passenger[nb][2],passenger[nb][3],
                                    Integer.valueOf(passenger[nb][4])," " ,nb);
                            break;
                        } else {
                            AlertBox("WORNING!","Wrong Password",1);
                            wrongPassCounter ++;
                            break;
                        }
                    }
                    nb--;
                }
                if(rightPass==0)
                    AlertBox("WORNING!","Can't find user\nTry SignUp!",1);
                if(wrongPassCounter>=3) {
                    AlertBox("WORNING!","System is closing\nYou entered password 3 time Wrong",1);
                    MainWindow.close();
                }
                rightPass =0;
            }
            else if(comboBox.getValue()=="Employee"){
                users.readFromFile();
                enteredUsername = userNameText.getText();
                enteredPassword = passwordText.getText();
                nb = numberOfDrivers+numberOfMangers;
                while(nb>=0) {
                    if (enteredUsername.equalsIgnoreCase(employees[nb][0])) {
                        rightPass =1;
                        if (enteredPassword.equalsIgnoreCase(employees[nb][1])) {
                            wrongPassCounter=0;
                            GlobalUserIndex =nb;
                            employeeObj.setName(employees[nb][2]);
                            employeeObj.setLastName(employees[nb][3]);
                            employeeObj.setRoll(employees[nb][4]);
                            employeeObj.setHistory(employees[nb][5]);
                            employeeObj.setAssignedTrips(employees[nb][6]);
                            employeeObj.setProfile(employees[nb][2],employees[nb][3],
                                    Integer.valueOf(employees[nb][5]), employees[nb][4], nb);
                            break;
                        } else {
                            AlertBox("WORNING!","Wrong Password",1);
                            wrongPassCounter++;
                            break;
                        }
                    }
                    nb--;
                }
                if(rightPass==0)
                    AlertBox("WORNING!","Can't find employee\nTry SignUp!",1);
                if(wrongPassCounter>=3) {
                    AlertBox("WORNING!","System is closing\nYou entered password 3 time Wrong",1);
                    MainWindow.close();
                }
                rightPass=0;
            }
            else{
                AlertBox("WARNING","Please select the kind",1);
            }
        });

        loginLayout.getChildren().addAll(userName,password,userNameText,passwordText,comboBox,Type,check,SignUpButton,signUp);
        rootLogin.getChildren().add(loginLayout);
        loginScene = new Scene(rootLogin, 500, 250);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
    public static void AlertBox(String title, String message, int type) {
        Stage alertWindow = new Stage();
        alertWindow.initModality(Modality.APPLICATION_MODAL);
        alertWindow.setTitle(title);
        Pane root = new Pane();
        Label label = new Label(message);
        label.setStyle("-fx-text-fill: #000;-fx-font-size: 20px");
        Button closeButton = new Button("Close");

        if (type == 1) {
            root.setStyle("-fx-background-color:#DC143C");
            closeButton.setStyle("-fx-background-color: #3CB371;-fx-text-fill:#FFF;" + "-fx-background-radius: 6");

        } else {
            root.setStyle("-fx-background-color:#3CB371");
            closeButton.setStyle("-fx-background-color: #DC143C;-fx-text-fill:#FFF;" + "-fx-background-radius: 6");

        }
        closeButton.setOnAction(e -> alertWindow.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));

        root.getChildren().add(layout);
        Scene scene = new Scene(root, 380, 140);
        alertWindow.setScene(scene);
        alertWindow.showAndWait();
    }

}
