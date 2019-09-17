package pkg1;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class History {
    Label  lastTrips,bookedFrom,bookedTo,bookedStops,bookedPrice,bookedVechicls;
    String fromString = "Trip from:       ", toString = "Trip to:           ", stopsString = "Number of Stops: ", priceString = "Price:             "
            , vechileString = "Vehicle type:    ";
    public History(int Case, int index){
        if(Case==0){

            lastTrips = new Label("Your coming trips are: "+ Trips.numberOfLastTrips[MainClass.GlobalUserIndex][0]);
            lastTrips.setStyle("-fx-text-fill: #00365C;-fx-font-size: 16px");
            GridPane.setConstraints(lastTrips, 1, 2);

            for(int i=0; i<Trips.numberOfLastTrips[MainClass.GlobalUserIndex][0];i++){
                fromString += (" " + MainClass.trips[Trips.lastTripsArray[MainClass.GlobalUserIndex][i]][0] + " ||\t\t" );
                toString += (" " + MainClass.trips[Trips.lastTripsArray[MainClass.GlobalUserIndex][i]][1] + " ||\t\t" );
                priceString += (" " + MainClass.trips[Trips.lastTripsArray[MainClass.GlobalUserIndex][i]][5] + "$ ||\t\t" );
            }
            if(Trips.numberOfLastTrips[MainClass.GlobalUserIndex][0]==0) {
                fromString = "";
                toString = "";
                stopsString = "";
                priceString = "";
                vechileString = "";
            }
            bookedFrom = new Label(fromString);
            bookedTo = new Label(toString);
            bookedPrice = new Label(priceString );
            bookedVechicls = new Label(vechileString);
            bookedFrom.setStyle("-fx-text-fill: #00365C;-fx-font-size: 14px");
            bookedTo.setStyle("-fx-text-fill: #00365C;-fx-font-size: 14px");
            bookedPrice.setStyle("-fx-text-fill: #00365C;-fx-font-size: 14px");
            bookedVechicls.setStyle("-fx-text-fill: #00365C;-fx-font-size: 14px");
            GridPane.setConstraints(bookedFrom, 2, 4);
            GridPane.setConstraints(bookedTo, 2, 5);
            GridPane.setConstraints(bookedPrice, 2, 6);
        }
        else{
            lastTrips = new Label("You are assigned to: "+ MainClass.employees[index][6]+" trips.");
            lastTrips.setStyle("-fx-text-fill: #00365C;-fx-font-size: 16px");
            GridPane.setConstraints(lastTrips, 1, 2);
            for(int i=0; i<Integer.valueOf(MainClass.employees[index][6]);i++){
                fromString += (" " + MainClass.trips[Trips.assignedTrips[MainClass.GlobalUserIndex][i]][0] + " ||\t\t" );
                toString += (" " + MainClass.trips[Trips.assignedTrips[MainClass.GlobalUserIndex][i]][1] + " ||\t\t" );
                stopsString += (" " + MainClass.trips[Trips.assignedTrips[MainClass.GlobalUserIndex][i]][4] + "\t\t" );
                if(MainClass.trips[Trips.assignedTrips[MainClass.GlobalUserIndex][i]][9].equalsIgnoreCase("0")){
                    vechileString += (" " + "Bus" + "\t\t" );
                }
                else if(MainClass.trips[Trips.assignedTrips[MainClass.GlobalUserIndex][i]][9].equalsIgnoreCase("1")){
                    vechileString += (" " + "Min-Bus" + "\t\t" );
                }
                else{ vechileString += (" " + "Limousine" + "\t\t" );}
            }
            if(Integer.valueOf(MainClass.employees[index][6])==0) {
                fromString = "";
                toString = "";
                stopsString = "";
                priceString = "";
                vechileString = "";
            }
            bookedFrom = new Label(fromString);
            bookedTo = new Label(toString);
            bookedStops = new Label(stopsString);
            bookedVechicls = new Label(vechileString);
            bookedFrom.setStyle("-fx-text-fill: #00365C;-fx-font-size: 14px");
            bookedTo.setStyle("-fx-text-fill: #00365C;-fx-font-size: 14px");
            bookedStops.setStyle("-fx-text-fill: #00365C;-fx-font-size: 14px");
            bookedVechicls.setStyle("-fx-text-fill: #00365C;-fx-font-size: 14px");
            GridPane.setConstraints(bookedFrom, 2, 4);
            GridPane.setConstraints(bookedTo, 2, 5);
            GridPane.setConstraints(bookedStops, 2, 6);
            GridPane.setConstraints(bookedVechicls, 2, 7);
        }
    }

}
