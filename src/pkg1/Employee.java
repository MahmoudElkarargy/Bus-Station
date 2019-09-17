package pkg1;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Employee extends Profile {
    private static String name, lastName,history,assignedTrips,roll;
    private static int i=0;
    VBox x = new VBox();
    private int k=1,j=1;
    public static String getName() {
        return name;
    }
    public static void setName(String name) {
        Employee.name = name;
    }
    public static String getLastName() {
        return lastName;
    }
    public static void setLastName(String lastName) {
        Employee.lastName = lastName;
    }
    public static String getHistory() {
        return history;
    }
    public static void setHistory(String history) {
        Employee.history = history;
    }
    public static String getAssignedTrips() {
        return assignedTrips;
    }
    public static void setAssignedTrips(String assignedTrips) {
        Employee.assignedTrips = assignedTrips;
    }
    public static String getRoll() {
        return roll;
    }
    public static void setRoll(String roll) {
        Employee.roll = roll;
    }

    @Override
    public void setTrips() {
        Trips[] wowTrips = new Trips[MainClass.numberOfTrips];
        for(i=0;i<MainClass.numberOfTrips;i++) {
            wowTrips[i] = new Trips();
            wowTrips[i].updateTrips(i);
            x = wowTrips[i].viewTripsOnGUI(1,i);

            if(i%3!=0)
                k++;
            else{ j++; k=1;}

            GridPane.setConstraints(x,k,j);
            tripsLayout.getChildren().add(x);
        }
        tripsLayout.getChildren().addAll(trips,back);
        rootTrips.getChildren().add(tripsLayout);
        tripsScene = new Scene(rootTrips, 1200, 700);
        MainClass.MainWindow.setScene(tripsScene);
    }

    @Override
    public void updateHistory(int index) {
        History obj = new History(1,IndexofPass);
        historyLayout.getChildren().addAll(historyLabel1,backhistory,obj.lastTrips,obj.bookedFrom,obj.bookedTo
                ,obj.bookedStops,obj.bookedVechicls);
        rootHistory.getChildren().add(historyLayout);
        historyScene = new Scene(rootHistory, 900, 400);
        MainClass.MainWindow.setScene(historyScene);
    }
}
