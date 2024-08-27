package com.enigmacamp.console;

import com.enigmacamp.entity.Robot;
import com.enigmacamp.service.RobotService;
import com.enigmacamp.utils.InputHandler;

public class RobotApp {
    private Robot robot = new Robot();
    private RobotService service;
    private InputHandler handler;

    public RobotApp(RobotService robotService, InputHandler handler) {
        this.service = robotService;
        this.handler = handler;
//        this.service.initiate();
    }

    public void run(){
        service.initiate();
        while (true) {
            menu();
            int choice = handler.getInt("Type your choice (number only): ");
            switch (choice) {
                case 1:
                    robotAdvance();
                    break;
                case 2:
                    robotTurn("L");
                    break;
                case 3:
                    robotTurn("R");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Current position: " + getLatestLine());
            String retry = handler.getString("\nType N or n to exit : ");
            if (retry.equals("N") || retry.equals("n")){
                return;
            }
        }

    }

    private void menu(){
        System.out.println("=== MOVE ROBOT MOVE ===");
        System.out.println("Current position: " + getLatestLine());
        System.out.println("Which direction you want to turn to?");
        System.out.println("If you move forward, you will change position but still face the same direction");
        System.out.println("Option:\n 1. Go Straight\n 2. Turn Left\n 3. Turn Right");
    }

    private String getLatestLine(){
        return service.getLatestLine();
    }

    protected void getLatestPosition(){
        String position = getLatestLine();
        String[] coordinate = position.split(",");
        robot.setOriginPosition(coordinate[0], Integer.parseInt(coordinate[1]), Integer.parseInt(coordinate[2]));
    }

    protected void writeToFile(Robot robot){
        service.writeHistory(robot.getCurrentPosition(robot));
    }

    protected void robotAdvance(){
        getLatestPosition();
        robot.move();
        writeToFile(robot);
        getLatestPosition();
    }

    protected void robotTurn(String direction){
        getLatestPosition();
        robot.turn(direction);
        writeToFile(robot);
    }

    void play(){
        robotAdvance();
        robotAdvance();
        robotTurn("L");
        robotAdvance();
        robotAdvance();
        robotTurn("R");
    }
}
