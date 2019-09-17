package pkg1;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Trips {
    private static String from,to,oneway,internal,stops,price,distance, available,booked,Vehicles,unBooked;
    VBox tripsPassangers,tripsEmploee;
    HBox mangerButtons;
    Label fromLabel,toLabel,onewayLabel,internalLabel,stopsLabel,priceLabel,distanceLabel, availableLabel,bookedLabel,VehiclesLabel,unBookedLabel;
    Button bookTrip,assign,deleteTrip,modifyTrip;
    Stage bookingWindow;
    Button closeButton, bookButton,doneButton;
    ComboBox<String> driversComboBox,onewayBox,internalBox,vehicleBox;
    TextField toT,fromT,stopsT,distanceT,availableT,priceT;

    public static int[][]  numberOfLastTrips = new int[10][1];
    public static int[][]  k = new int[10][1];
    public static int[][] lastTripsArray = new int[10][10];
    public static int[][] assignedTrips = new int[10][10];

    private int j=0,foundedinLastTrips=0;
    public static String getTo() {
        return to;
    }
    public static void setTo(String to) {
        Trips.to = to;
    }
    public static String getOneway() {
        return oneway;
    }
    public static void setOneway(String oneway) {
        Trips.oneway = oneway;
    }
    public static String getInternal() {
        return internal;
    }
    public static void setInternal(String internal) {
        Trips.internal = internal;
    }
    public static String getStops() {
        return stops;
    }
    public static void setStops(String stops) {
        Trips.stops = stops;
    }
    public static String getPrice() {
        return price;
    }
    public static void setPrice(String price) {
        Trips.price = price;
    }
    public static String getDistance() {
        return distance;
    }
    public static void setDistance(String distance) {
        Trips.distance = distance;
    }
    public static String getAvailable() {
        return available;
    }
    public static void setAvailable(String available) {
        Trips.available = available;
    }
    public static String getBooked() {
        return booked;
    }
    public static void setBooked(String booked) {
        Trips.booked = booked;
    }
    public static String getVechiale() {
        return Vehicles;
    }
    public static void setVechiale(String vechiale) {
        Trips.Vehicles = vechiale;
    }
    public static String getFrom() {
        return from;
    }
    public static void setFrom(String from) {
        Trips.from = from;
    }

    public void updateTrips(int i){
        from = MainClass.trips[i][0];
        to = MainClass.trips[i][1];
        oneway = MainClass.trips[i][2];
        if(oneway.equalsIgnoreCase("1")) oneway = "One Way"; else oneway = "Round";
        internal = MainClass.trips[i][3];
        if(internal.equalsIgnoreCase("1")) internal = "Internal"; else internal = "External";
        stops = MainClass.trips[i][4];
        if(stops.equalsIgnoreCase("1")) stops = "One Stop";
        else if(stops.equalsIgnoreCase("0"))stops = "No Stops"; else stops = "Many Stops";
        price = MainClass.trips[i][5];
        distance = MainClass.trips[i][6];
        available = MainClass.trips[i][7];
        booked = MainClass.trips[i][8];
        unBooked = String.valueOf(Integer.valueOf(available) - Integer.valueOf(booked));
        Vehicles = MainClass.trips[i][9];
        if(Vehicles.equalsIgnoreCase("0")) Vehicles = "Bus";
        else if(Vehicles.equalsIgnoreCase("1")) Vehicles = "MinBus"; else Vehicles = "Limousine";
        int j=0;
    }
    public VBox viewTripsOnGUI(int Case,int index){
        fromLabel = new Label(     "Trip From:               "+ from);
        fromLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        toLabel = new Label(       "Trip To:                   "+ to);
        toLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        onewayLabel = new Label(   "Trip type:                "+ oneway);
        internalLabel = new Label( "Trip is:                     "+ internal);
        stopsLabel = new Label(    "Number of Stops:   "+ stops);
        priceLabel = new Label(    "Price:                       "+ price+"$");
        distanceLabel = new Label( "Distance:                 "+ distance+"Km");
        availableLabel = new Label("Available:                "+ available);
        bookedLabel = new Label(   "Booked:                "+ booked);
        VehiclesLabel = new Label( "Vehicle:                   "+ Vehicles);
        unBookedLabel = new Label( "Seats Left:                   "+ unBooked);
        bookTrip = new Button("Book Trip!");
        onewayLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        internalLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        stopsLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        priceLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        distanceLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        availableLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        bookedLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        VehiclesLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        unBookedLabel.setStyle("-fx-text-fill: #00365C;-fx-font-size: 12px");
        tripsPassangers = new VBox(5);
        tripsEmploee = new VBox(5);
        closeButton = new Button("Cancel");
        bookButton = new Button("Book");
        assign = new Button("Assign Driver");
        deleteTrip = new Button("Delete Trip");
        modifyTrip = new Button("Modify Trip");
        bookTrip.setStyle("-fx-background-color: #00365C;-fx-text-fill:#FFCA45;"
                + "-fx-background-radius: 6");
        assign.setStyle("-fx-background-color: #00365C;-fx-text-fill:#FFCA45;"
                + "-fx-background-radius: 6");
        deleteTrip.setStyle("-fx-background-color: #00365C;-fx-text-fill:#FFCA45;"
                + "-fx-background-radius: 6");
        modifyTrip.setStyle("-fx-background-color: #00365C;-fx-text-fill:#FFCA45;"
                + "-fx-background-radius: 6");

        Button closeButtonAssign = new Button("Close");
        doneButton = new Button("Done");
        Button doneButtonModfie = new Button("Done");
        bookingWindow = new Stage();
        Stage mangerAssign = new Stage();
        Stage modfieStage = new Stage();
        Stage deleteStage = new Stage();
        driversComboBox = new ComboBox<>();
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
        driversComboBox.setStyle("-fx-background-color: #FFCA45;"
                + "-fx-text-fill: #00365C; -fx-font-size: 12px;");
        for(int l=0; l<(MainClass.numberOfMangers+MainClass.numberOfDrivers);l++){
            if(MainClass.employees[l][4].equalsIgnoreCase("1")) {
                driversComboBox.getItems().add(
                        MainClass.employees[l][2]+" "+MainClass.employees[l][3]
                );
            }
        }

        driversComboBox.setPromptText("Select from below");
        Button yes = new Button("Yes");
        Button cancelD = new Button("Cancel");
        //System.out.println(comboBox.getValue());
        deleteTrip.setOnAction(e->{
            deleteStage.setTitle("Delete Trip");
            Pane root = new Pane();
            root.setStyle("-fx-background-color:#00365C;-fx-border-color: #FFCA45;-fx-border-width: 4px;"
                    + "-fx-border-style: solid;");
            Label label = new Label("Are you sure you want to delete this Trip?");
            label.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            VBox layout = new VBox(20);
            HBox layoutH = new HBox(10);
            yes.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                    + "-fx-background-radius: 6");
            cancelD.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                    + "-fx-background-radius: 6");
            layoutH.getChildren().addAll(yes,cancelD);
            layout.getChildren().addAll(label,layoutH);

            layout.setAlignment(Pos.CENTER);
            layout.setPadding(new Insets(20, 20, 20, 20));

            root.getChildren().add(layout);
            Scene scene = new Scene(root, 350, 100);
            deleteStage.setScene(scene);
            deleteStage.showAndWait();
        });
        yes.setOnAction(e->{
            String[] temp = new String[10];
            for(int i=index;i<MainClass.numberOfTrips-1;i++){

                for(int l=0;l<10;l++){
                    temp[l] = MainClass.trips[i+1][l];
                    MainClass.trips[i][l] = temp[l];
                }
            }
            int temps;
            for(int p=0;p<MainClass.NumberofPassangers;p++) {
                for (int i = 0; i < numberOfLastTrips[p][0]; i++) {
                    if (MainClass.trips[index][0].equalsIgnoreCase(MainClass.trips[lastTripsArray[p][i]][0])) {
                        for(int h=i;h<numberOfLastTrips[p][0]-1;h++){
                            temps = lastTripsArray[p][h+1];
                            lastTripsArray[p][h] = temps;
                        }
                        numberOfLastTrips[p][0]--;
                    }
                }
            }
            for(int p=0;p<(MainClass.numberOfDrivers+MainClass.numberOfMangers);p++) {
                for (int i = 0; i < assignedTrips[p][0]; i++) {
                    if (MainClass.trips[index][0].equalsIgnoreCase(MainClass.trips[assignedTrips[p][i]][0])) {
                        for(int h=i;h<Integer.valueOf(MainClass.employees[p][6])-1;h++){
                            temps = assignedTrips[p][h+1];
                            assignedTrips[p][h] = temps;
                        }
                        int a = Integer.valueOf(MainClass.employees[p][6]);
                        a--;
                        MainClass.employees[p][6] = String.valueOf(a);
                    }
                }
            }
            MainClass.numberOfTrips--;
            deleteStage.close();
            MainClass.MainWindow.setScene(Profile.passangerScene);
        });
        cancelD.setOnAction(e->{ deleteStage.close(); });
        bookButton.setOnAction(e->{
            String Savailable = String.valueOf(Integer.valueOf(MainClass.trips[index][7]) - Integer.valueOf(MainClass.trips[index][8])) ;
            if(Savailable.equalsIgnoreCase("0")){
                MainClass.AlertBox("ERROR!","No available Seats",1);
                bookingWindow.close();
            }
            else{
                for(int i=0;i<numberOfLastTrips[MainClass.GlobalUserIndex][0];i++){
                    if(MainClass.trips[index][0].equalsIgnoreCase(MainClass.trips[lastTripsArray[MainClass.GlobalUserIndex][i]][0]) ){
                        foundedinLastTrips=1;
                    }
                }
                if(foundedinLastTrips==0){
                    lastTripsArray[MainClass.GlobalUserIndex][k[MainClass.GlobalUserIndex][0]++] = index;
                    numberOfLastTrips[MainClass.GlobalUserIndex][0]++;
                }
                MainClass.AlertBox("Success", "You successfully booked the trip", 0);
                bookingWindow.close();
                Passengers.setHistory(Passengers.getHistory() + 1);
                MainClass.passenger[MainClass.nb][4] = String.valueOf(Integer.valueOf(MainClass.passenger[MainClass.nb][4]) + 1);
                MainClass.passengerObj.setProfile(Passengers.getName(), Passengers.getLastName(), Passengers.getHistory()," ", index);
                MainClass.trips[index][8] = String.valueOf(Integer.valueOf(MainClass.trips[index][8]) + 1);
                MainClass.users.CloseFile();
                MainClass.users.writeToFile(0);
                MainClass.MainWindow.setScene(Profile.passangerScene);
            }
        });
        closeButton.setOnAction(e->{
            bookingWindow.close();

        });
        doneButton.setOnAction(e->{
            String s = driversComboBox.getValue();
            String[] k = s.split(" ",2);

            for(int i=0; i<(MainClass.numberOfMangers+MainClass.numberOfDrivers); i++){
                if(k[0].equalsIgnoreCase(MainClass.employees[i][2])){
                    if(k[1].equalsIgnoreCase(MainClass.employees[i][3])){
                        int a = Integer.valueOf(MainClass.employees[i][6]);
                        a++;
                        int b = Integer.valueOf(MainClass.employees[i][5]);
                        b++;
                        MainClass.employees[i][6] = String.valueOf(a);
                        MainClass.employees[i][5] = String.valueOf(b);
                        System.out.println("Index el driver: "+i);
                        assignedTrips[i][j++] = index;

                        break;
                    }
                }
            }
            mangerAssign.close();
        });
        doneButtonModfie.setOnAction(e->{
            MainClass.trips[index][0] = fromT.getText();
            MainClass.trips[index][1] = toT.getText();
            MainClass.trips[index][2] = onewayBox.getValue().equalsIgnoreCase("One Way")? "1":"0";
            MainClass.trips[index][3] = internalBox.getValue().equalsIgnoreCase("Internal")? "1":"0";
            MainClass.trips[index][4] = stopsT.getText();
            MainClass.trips[index][5] = priceT.getText();
            MainClass.trips[index][6] = distanceT.getText();
            MainClass.trips[index][7] = availableT.getText();
            String q = vehicleBox.getValue();
            if(q.equalsIgnoreCase("Bus")) q = "0"; else if(q.equalsIgnoreCase("min-Bus")) q = "1";
            else q = "2";
            MainClass.trips[index][9] = q;
            modfieStage.close();
            MainClass.AlertBox("Success","All changes are saved",0);
            MainClass.users.writeToFile(0);
            MainClass.MainWindow.setScene(Profile.passangerScene);
        });
        modifyTrip.setOnAction(e->{
            modfieStage.setTitle("Modifying current Trip");
            Pane root = new Pane();
            root.setStyle("-fx-background-color:#00365C;-fx-border-color: #FFCA45;-fx-border-width: 4px;"
                    + "-fx-border-style: solid;");
            Label label = new Label("Modify what you want.");
            label.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            VBox layout = new VBox(20);
            Label from = new Label("From:         ");
            fromT = new TextField(MainClass.trips[index][0]);
            HBox s1 = new HBox(5);
            s1.getChildren().addAll(from,fromT);

            Label to = new Label("To:             ");
            toT = new TextField(MainClass.trips[index][1]);
            HBox s2 = new HBox(5);
            s2.getChildren().addAll(to,toT);

            Label oneway = new Label("Type:         ");
            onewayBox.getSelectionModel().select(Integer.valueOf(MainClass.trips[index][2])==1?"One Way":"Rounded");
            HBox s3 = new HBox(5);
            s3.getChildren().addAll(oneway,onewayBox);

            Label internal = new Label("Internal?:   ");
            internalBox.getSelectionModel().select(Integer.valueOf(MainClass.trips[index][3])==1?"Internal":"External");
            HBox s4 = new HBox(5);
            s4.getChildren().addAll(internal,internalBox);

            Label stops = new Label("Stops:       ");
            stopsT = new TextField(MainClass.trips[index][4]);
            HBox s5 = new HBox(5);
            s5.getChildren().addAll(stops,stopsT);

            Label price = new Label("Price:        ");
            priceT = new TextField(MainClass.trips[index][5]);
            HBox s6 = new HBox(5);
            s6.getChildren().addAll(price,priceT);

            Label distance = new Label("Distance:  ");
            distanceT = new TextField(MainClass.trips[index][6]);
            HBox s7 = new HBox(5);
            s7.getChildren().addAll(distance,distanceT);

            Label available = new Label("Available: ");
            availableT = new TextField(MainClass.trips[index][7]);
            HBox s8 = new HBox(5);
            s8.getChildren().addAll(available,availableT);

            Label vehicle = new Label("Vehicle:    ");
            String z = MainClass.trips[index][9];
            if(z.equalsIgnoreCase("0")) z = "Bus"; else if(z.equalsIgnoreCase("1")) z= "min-Bus";
            else z = "Limousine";
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

            vehicleBox.getSelectionModel().select(z);
            HBox s9 = new HBox(5);
            s9.getChildren().addAll(vehicle,vehicleBox);
            doneButtonModfie.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                    + "-fx-background-radius: 6");
            layout.getChildren().addAll(label,s1,s2,s3,s4,s5,s6,s7,s8,s9,doneButtonModfie);
            layout.setAlignment(Pos.CENTER);
            layout.setPadding(new Insets(20, 20, 20, 20));

            root.getChildren().add(layout);
            Scene scene = new Scene(root, 350, 550);
            modfieStage.setScene(scene);
            modfieStage.showAndWait();
        });
        assign.setOnAction(e->{
            mangerAssign.setTitle("Assign current Trip");
            Pane root = new Pane();
            root.setStyle("-fx-background-color:#00365C;-fx-border-color: #FFCA45;-fx-border-width: 4px;"
                    + "-fx-border-style: solid;");
            Label label = new Label("Select the driver you\nwant to assign trip to.");
            label.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
            VBox layout = new VBox(20);
            HBox s = new HBox(5);
            doneButton.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                    + "-fx-background-radius: 6");
            closeButtonAssign.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                    + "-fx-background-radius: 6");
            s.getChildren().addAll(doneButton,closeButtonAssign);
            layout.getChildren().addAll(label,driversComboBox,s);
            layout.setAlignment(Pos.CENTER);
            layout.setPadding(new Insets(20, 20, 20, 20));

            root.getChildren().add(layout);
            Scene scene = new Scene(root, 400, 200);
            mangerAssign.setScene(scene);
            mangerAssign.showAndWait();
        });

        closeButtonAssign.setOnAction(e -> mangerAssign.close());
        if(Case ==0){ //passangers
            bookTrip.setOnAction(e->{
                bookingWindow.setTitle("Booking");
                Pane root = new Pane();
                root.setStyle("-fx-background-color:#00365C;-fx-border-color: #FFCA45;-fx-border-width: 4px;"
                        + "-fx-border-style: solid;");
                Label label = new Label("Are you sure you want to book this trip?");
                label.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
                VBox layout = new VBox(5);
                HBox layout2 = new HBox(60);
                closeButton.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                        + "-fx-background-radius: 6");
                bookButton.setStyle("-fx-background-color: #FFCA45;-fx-text-fill:#00365C;"
                        + "-fx-background-radius: 6");

                layout2.getChildren().addAll(closeButton,bookButton);
                Label fromLabel2 = new Label(     "Trip From:               "+ MainClass.trips[index][0]);
                Label toLabel2 = new Label(       "Trip To:                   "+ MainClass.trips[index][1]);
                Label priceLabel2 = new Label(    "Price:                       "+ MainClass.trips[index][5]+"$");
                fromLabel2.setStyle("-fx-text-fill: #FFF;-fx-font-size: 12px");
                toLabel2.setStyle("-fx-text-fill: #FFF;-fx-font-size: 12px");
                priceLabel2.setStyle("-fx-text-fill: #FFF;-fx-font-size: 12px");
//                Label tickets = new Label(        "Tickets:                  " + nbOfTickets);
//            System.out.println();
                String Savailable = String.valueOf(Integer.valueOf(MainClass.trips[index][7]) - Integer.valueOf(MainClass.trips[index][8])) ;
                if(Integer.valueOf(Savailable)==0) Savailable = "No Available Seats!";
                else if(Integer.valueOf(Savailable)<10)
                    Savailable = "Hurry up! Only " + Integer.valueOf(Savailable) + " Seats are available";
                else Savailable = "Available Seats are: " + Integer.valueOf(Savailable);
                Label availableLabel2 = new Label(Savailable);
                availableLabel2.setStyle("-fx-text-fill: #FFF;-fx-font-size: 16px");
                layout.getChildren().addAll(label,fromLabel2,toLabel2,priceLabel2,availableLabel2,layout2);
                layout.setAlignment(Pos.CENTER);
                layout.setPadding(new Insets(20, 20, 20, 20));
                root.getChildren().add(layout);
                Scene scene = new Scene(root, 400, 200);
                bookingWindow.setScene(scene);
                bookingWindow.showAndWait();
            });

            tripsPassangers.getChildren().addAll(fromLabel,toLabel,onewayLabel,internalLabel,stopsLabel,priceLabel,unBookedLabel,VehiclesLabel,bookTrip);
            tripsPassangers.setAlignment(Pos.BASELINE_LEFT);
            tripsPassangers.setPadding(new Insets(20, 20, 20, 40));
            return tripsPassangers;
        }
        else {
            mangerButtons = new HBox(3);
            mangerButtons.getChildren().addAll(assign,deleteTrip,modifyTrip);
            if(MainClass.employees[MainClass.nb][4].equalsIgnoreCase("0")){
                tripsPassangers.getChildren().addAll(fromLabel,toLabel,onewayLabel,internalLabel,stopsLabel,priceLabel,
                        distanceLabel, availableLabel,bookedLabel,VehiclesLabel,unBookedLabel,mangerButtons);

            }
            else{
                tripsPassangers.getChildren().addAll(fromLabel, toLabel, onewayLabel, distanceLabel, stopsLabel, availableLabel, VehiclesLabel);
            }
            tripsPassangers.setAlignment(Pos.BASELINE_LEFT);
            tripsPassangers.setPadding(new Insets(20, 20, 20, 40));
            return tripsPassangers;
        }
    }


}
