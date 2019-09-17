package pkg1;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
public class Passengers extends Profile {
    private static String name, lastName;
    private static int history,i=0;
    VBox x = new VBox();
    private int k=1,j=1;
    public static void setName(String Name) {
        name = Name;
    }
    public static String getName() {
        return name;
    }
    public static void setLastName(String Name) {
        lastName = Name;
    }
    public static String getLastName() {
        return lastName;
    }
    public static void setHistory(int History) {
        history = History;
    }
    public static int getHistory() {
        return history;
    }

    @Override
    public void setTrips() {

        Trips[] wowTrips = new Trips[MainClass.numberOfTrips];
        for(i=0;i<MainClass.numberOfTrips;i++) {
            wowTrips[i] = new Trips();
            wowTrips[i].updateTrips(i);
            x = wowTrips[i].viewTripsOnGUI(0,i);
            if(i%3!=0)
                k++;
            else{ j++; k=1;}

            GridPane.setConstraints(x,k,j);
            tripsLayout.getChildren().add(x);
        }
        tripsLayout.getChildren().addAll(trips,back);
        rootTrips.getChildren().add(tripsLayout);
        tripsScene = new Scene(rootTrips, 1100, 650);
        MainClass.MainWindow.setScene(tripsScene);
    }
    @Override
    public void updateHistory(int index) {
        History obj = new History(0,IndexofPass);
        historyLayout.getChildren().addAll(historyLabel1,backhistory,/*obj.doneTrips,*/obj.lastTrips,obj.bookedFrom,obj.bookedTo
                ,obj.bookedPrice /*,obj.bookedStops,obj.bookedVechicls*/);
        rootHistory.getChildren().add(historyLayout);
        historyScene = new Scene(rootHistory, 900, 400);
        MainClass.MainWindow.setScene(historyScene);
    }

}
