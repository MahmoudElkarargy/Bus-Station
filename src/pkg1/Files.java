package pkg1;

import java.io.*;
import java.util.*;


public class Files {
    private Scanner passangers,employeeF,trips;
    private Formatter PassangersWrite,employeeWrite,tripsWrite;
    private int i=0,j=0;
    public void openFile(){
        try{
            passangers = new Scanner(new File("Passangers.txt"));
            trips = new Scanner(new File("Trips.txt"));
            employeeF = new Scanner(new File("Emploee.txt"));
        }
        catch(Exception e){
            System.out.println("Couldn't find file");
        }
    }
    public void openFileToWrite(){
        try{
            PassangersWrite = new Formatter(new File("Passangers.txt"));
            tripsWrite = new Formatter(new File("Trips.txt"));
            employeeWrite = new Formatter(new File("Emploee.txt"));
        }
        catch(Exception e){
            System.out.println("Couldn't find file");
        }
    }

    public void readFromFile(){
        openFile();
        i=0;
        while (passangers.hasNext()){
            //username Pass Name lastName historyOftrips
            for(j=0;j<5;j++) {
                MainClass.passenger[i][j] = passangers.next();
            }
            i++;
        }
        MainClass.NumberofPassangers = i;
        i=0;
        while (trips.hasNext()){
//            From to One way internal stops price distance Available booked Vehicle (Driver image)
            for(j=0;j<10;j++) {
                MainClass.trips[i][j] = trips.next();
            }
            i++;
        }
        MainClass.numberOfTrips = i;
        i=0;
        MainClass.numberOfMangers = 0;
        MainClass.numberOfDrivers = 0;
        while (employeeF.hasNext() ){
            for(j=0;j<7;j++) {
                MainClass.employees[i][j] = employeeF.next();
                if(j==4){
                    if( MainClass.employees[i][4].equalsIgnoreCase("0")){
                        MainClass.numberOfMangers ++;
                    }
                else
                    MainClass.numberOfDrivers ++;
                }
            }
            i++;
        }
        CloseFile();
    }

    public void writeToFile(int firstTime){
        openFileToWrite();
        for(i=0;i<MainClass.NumberofPassangers;i++) {
            for (j = 0; j < 5; j++) {
                PassangersWrite.format("%s ", MainClass.passenger[i][j]);
            }
            PassangersWrite.format("\n");
        }
        for(i=0;i<MainClass.numberOfTrips;i++) {
            for (j = 0; j < 10; j++) {
                tripsWrite.format("%s ", MainClass.trips[i][j]);
            }
            tripsWrite.format("\n");
        }
        for(i=0;i<(MainClass.numberOfMangers+MainClass.numberOfDrivers);i++) {
            for (j = 0; j < 7; j++) {
                if(j==4){
                    if( MainClass.employees[i][4].equalsIgnoreCase("0")){
                        for(j = 4; j < 7; j++) {
                            employeeWrite.format("%s ", "0");
                        }
                    }
                    else {
                        employeeWrite.format("%s ", "1");
                    }
                }

                else if(j==6){
                    if(firstTime==1){
                        employeeWrite.format("%s ", "0");
                    }
                    else {
                        employeeWrite.format("%s ", MainClass.employees[i][j]);
                    }
                }
                else {
                    employeeWrite.format("%s ", MainClass.employees[i][j]);
                }
            }
            employeeWrite.format("\n");
        }
        CloseFileWrite();
    }

    public void CloseFile() {
        passangers.close();trips.close();employeeF.close();

    }
    public void CloseFileWrite(){
        PassangersWrite.close();
        tripsWrite.close();
        employeeWrite.close();

    }
}