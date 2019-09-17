package pkg1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

abstract public class Profile {
    private Label namelabel,lastnamelabel,historylabel;
    public static Scene passangerScene;
    private GridPane passangersLayout;
    private Pane rootPassangers;
    private int mangerWithoutViewHistory=0;
    public static Button viewTrips, viewHistory, back, backhistory,logOut,New;
    Pane rootTrips, rootHistory;
    GridPane tripsLayout, historyLayout;
    Scene tripsScene, historyScene;
    Label trips,historyLabel1;
    Stage addStage = new Stage();
    ComboBox<String> onewayBox,internalBox,vehicleBox;
    TextField toT,fromT,stopsT,distanceT,availableT,priceT;

    public static int IndexofPass;
    public void setProfile(String name, String lastname,int history, String Roll, int index){
        IndexofPass = index;
        MainClass.MainWindow.setTitle("Profile");
        rootPassangers = new Pane();
        rootPassangers.setStyle("-fx-background-color:#00365C;-fx-border-color: #FFCA45;-fx-border-width: 4px;"
                + "-fx-border-style: solid;");
        passangersLayout = new GridPane();
        passangersLayout.setPadding(new Insets(20, 20, 20, 20)); //Setting gaps in corners
        passangersLayout.setVgap(8);
        passangersLayout.setHgap(10);
        Button done = new Button("Done");
        Button cancel = new Button("Cancel");
        onewayBox = new ComboBox<>();
        internalBox = new ComboBox<>();
        vehicleBox = new ComboBox<>();
        onewayBox.getItems().addAll(
                "One Way" , "Rounded"
        );
        internalBox.getItems().addAll(
                "Internal" , "External"
        );
        vehicleBox.getItems().addAll(
                "Bus" , "min-Bus" , "Limousine"
        );
        onewayBox.setStyle("-fx-background-color: #FFCA45;"
                + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
        internalBox.setStyle("-fx-background-color: #FFCA45;"
                + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
        vehicleBox.setStyle("-fx-background-color: #FFCA45;"
                + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
        namelabel = new Label("Name: "+ name);
        namelabel.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
        lastnamelabel = new Label("Last Name: " + lastname);
        lastnamelabel.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
        New = new Button("Add new Trip");
        if(!Roll.equalsIgnoreCase("0"))
            historylabel = new Label("History of Trips: "+ history);
        else {
            historylabel = new Label("MANGER ");
            mangerWithoutViewHistory=1;
        }
        historylabel.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
        GridPane.setConstraints(namelabel, 1,0);
        GridPane.setConstraints(lastnamelabel, 1,1);
        GridPane.setConstraints(historylabel, 1,2);
        logOut = new Button("LogOut");
        logOut.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                + "-fx-background-radius: 6");
        GridPane.setConstraints(logOut,4,0);
        logOut.setOnAction(e->{
            MainClass.MainWindow.setScene(MainClass.loginScene);
//            MainClass.users.openFile();
            MainClass.users.writeToFile(0);
//            Trips.numberOfLastTrips[MainClass.GlobalUserIndex][0] = 0;
//            Trips.k=0;
        });
        viewTrips = new Button("View Trips");
        viewTrips.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                + "-fx-background-radius: 6");

        New.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                + "-fx-background-radius: 6");
        GridPane.setConstraints(viewTrips, 0,5);
        viewHistory = new Button("View History");
        viewHistory.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                + "-fx-background-radius: 6");
        GridPane.setConstraints(viewHistory, 2,5);
        viewHistory.setOnAction(e->{
            creatInterfaceHistory();
            updateHistory(index);
        });
        viewTrips.setOnAction(e -> {
            creatInterface();
            setTrips();
        });
        cancel.setOnAction(e->{addStage.close();});
        done.setOnAction(e->{
//            System.out.println("Number of Trips is: "+MainClass.numberOfTrips);
            MainClass.trips[MainClass.numberOfTrips][0] = fromT.getText();
            MainClass.trips[MainClass.numberOfTrips][1] = toT.getText();
            MainClass.trips[MainClass.numberOfTrips][2] = onewayBox.getValue().equalsIgnoreCase("One Way")? "1":"0";
            MainClass.trips[MainClass.numberOfTrips][3] = internalBox.getValue().equalsIgnoreCase("Internal")? "1":"0";
            MainClass.trips[MainClass.numberOfTrips][4] = stopsT.getText();
            MainClass.trips[MainClass.numberOfTrips][5] = priceT.getText();
            MainClass.trips[MainClass.numberOfTrips][6] = distanceT.getText();
            MainClass.trips[MainClass.numberOfTrips][7] = availableT.getText();
            MainClass.trips[MainClass.numberOfTrips][8] = "0";
            String q = vehicleBox.getValue();
            if(q.equalsIgnoreCase("Bus")) q = "0"; else if(q.equalsIgnoreCase("min-Bus")) q = "1";
            else q = "2";
            MainClass.trips[MainClass.numberOfTrips][9] = q;
            MainClass.numberOfTrips++;
//            System.out.println("Now nb is: "+MainClass.numberOfTrips);
            MainClass.users.writeToFile(0);
            addStage.close();
            MainClass.MainWindow.setScene(Profile.passangerScene);
        });
        New.setOnAction(e->{
            addStage.setTitle("Adding");
            Pane root = new Pane();
            root.setStyle("-fx-background-color:#00365C;-fx-border-color: #FFCA45;-fx-border-width: 4px;"
                    + "-fx-border-style: solid;");
            Label label = new Label("Add new trip!");
            label.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            VBox layout = new VBox(20);
            Label from = new Label("From:         ");
            fromT = new TextField();
            HBox s1 = new HBox(5);
            s1.getChildren().addAll(from,fromT);

            Label to = new Label("To:             ");
            toT = new TextField();
            HBox s2 = new HBox(5);
            s2.getChildren().addAll(to,toT);

            Label oneway = new Label("Type:         ");
//            onewayBox.getSelectionModel().select(Integer.valueOf(MainClass.trips[index][2])==1?"One Way":"Rounded");
            HBox s3 = new HBox(5);
            s3.getChildren().addAll(oneway,onewayBox);

            Label internal = new Label("Internal?:   ");
//            internalBox.getSelectionModel().select(Integer.valueOf(MainClass.trips[index][3])==1?"Internal":"External");
            HBox s4 = new HBox(5);
            s4.getChildren().addAll(internal,internalBox);

            Label stops = new Label("Stops:       ");
            stopsT = new TextField();
            HBox s5 = new HBox(5);
            s5.getChildren().addAll(stops,stopsT);

            Label price = new Label("Price:        ");
            priceT = new TextField();
            HBox s6 = new HBox(5);
            s6.getChildren().addAll(price,priceT);

            Label distance = new Label("Distance:  ");
            distanceT = new TextField();
            HBox s7 = new HBox(5);
            s7.getChildren().addAll(distance,distanceT);

            Label available = new Label("Available: ");
            availableT = new TextField();
            HBox s8 = new HBox(5);
            s8.getChildren().addAll(available,availableT);

            Label vehicle = new Label("Vehicle:    ");

            from.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            to.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            oneway.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            stops.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            price.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            distance.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            available.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            vehicle.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            internal.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            fromT.setStyle("-fx-background-color: #FFCA45;"
                    + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
            toT.setStyle("-fx-background-color: #FFCA45;"
                    + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
            stopsT.setStyle("-fx-background-color: #FFCA45;"
                    + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
            priceT.setStyle("-fx-background-color: #FFCA45;"
                    + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
            distanceT.setStyle("-fx-background-color: #FFCA45;"
                    + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
            availableT.setStyle("-fx-background-color: #FFCA45;"
                    + "-fx-text-fill: #00365C; -fx-font-size: 12px;");

            HBox s9 = new HBox(5);
            s9.getChildren().addAll(vehicle,vehicleBox);
            HBox s10 = new HBox(100);
            done.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                    + "-fx-background-radius: 6");
            cancel.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                    + "-fx-background-radius: 6");
            s10.getChildren().addAll(done,cancel);
            layout.getChildren().addAll(label,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10);
            layout.setAlignment(Pos.CENTER);
            layout.setPadding(new Insets(20, 20, 20, 20));

            root.getChildren().add(layout);
            Scene scene = new Scene(root, 350, 550);
            addStage.setScene(scene);
            addStage.showAndWait();
        });
        if(mangerWithoutViewHistory==0)
            passangersLayout.getChildren().addAll(namelabel,lastnamelabel,historylabel,viewTrips,viewHistory,logOut);
        else {
            GridPane.setConstraints(New, 2,5);
            passangersLayout.getChildren().addAll(namelabel,lastnamelabel,historylabel,viewTrips,logOut,New);
            mangerWithoutViewHistory=0;
        }
        rootPassangers.getChildren().add(passangersLayout);
        passangerScene = new Scene(rootPassangers, 600, 300);

        MainClass.MainWindow.setScene(passangerScene);
        }
    public void setTrips(){

    }
    public void updateHistory(int index){

    }
    public void creatInterface() {
        MainClass.MainWindow.setTitle("Trips");
        rootTrips = new Pane();
        rootTrips.setStyle("-fx-background-color:#FFCA45;-fx-border-color: #00365C;-fx-border-width: 4px;"
                + "-fx-border-style: solid;");
        tripsLayout = new GridPane();
        tripsLayout.setPadding(new Insets(20, 20, 20, 20)); //Setting gaps in corners
        tripsLayout.setVgap(8);
        tripsLayout.setHgap(10);


        trips = new Label("Trips Available ....");
        trips.setStyle("-fx-text-fill: #00365C;-fx-font-size: 16px");
        GridPane.setConstraints(trips, 0, 0);
        back = new Button("Return back");
        back.setStyle("-fx-background-color: #00365C;-fx-text-fill:#FFCA45;"
                + "-fx-background-radius: 6");
        GridPane.setConstraints(back, 3, 0);
        back.setOnAction(e -> {
            MainClass.users.writeToFile(0);
            MainClass.MainWindow.setScene(passangerScene);

        });
    }
    public void creatInterfaceHistory(){
        MainClass.MainWindow.setTitle("History");
        rootHistory = new Pane();
        rootHistory.setStyle("-fx-background-color:#FFCA45;-fx-border-color: #00365C;-fx-border-width: 4px;"
                + "-fx-border-style: solid;");
        historyLayout = new GridPane();
        historyLayout.setPadding(new Insets(20, 20, 20, 20)); //Setting gaps in corners
        historyLayout.setVgap(8);
        historyLayout.setHgap(10);


        historyLabel1 = new Label("Your History..");
        historyLabel1.setStyle("-fx-text-fill: #00365C;-fx-font-size: 16px");
        GridPane.setConstraints(historyLabel1, 0, 0);
        backhistory = new Button("Return back");
        backhistory.setStyle("-fx-background-color: #00365C;-fx-text-fill:#FFCA45;"
                + "-fx-background-radius: 6");
        GridPane.setConstraints(backhistory, 5, 0);

        backhistory.setOnAction(e -> {
            MainClass.MainWindow.setScene(passangerScene);
            MainClass.users.writeToFile(0);
        });

    }
}
