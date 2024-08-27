package com.enigmacamp.entity;

public class Robot {
    private String originDirection;
    private int xAxis;
    private int yAxis;

    public String getOriginDirection() {
        return originDirection;
    }

    public void setOriginDirection(String originDirection) {
        this.originDirection = originDirection;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setOriginPosition(String direction, int x, int y) {
        this.originDirection = direction;
        this.xAxis = x;
        this.yAxis = y;
    }

    public void turn(String directionTurn) {
        if (directionTurn.equals("R")){
            if (this.originDirection.equals("N")){
                this.originDirection = "E";
            } else if (this.originDirection.equals("E")){
                this.originDirection = "S";
            } else if (this.originDirection.equals("S")){
                this.originDirection = "W";
            } else if (this.originDirection.equals("W")){
                this.originDirection = "N";
            }
        } else if (directionTurn.equals("L")) {
            if (this.originDirection.equals("N")){
                this.originDirection = "W";
            } else if (this.originDirection.equals("E")){
                this.originDirection = "N";
            } else if (this.originDirection.equals("S")){
                this.originDirection = "E";
            } else if (this.originDirection.equals("W")){
                this.originDirection = "S";
            }
        }
    }

    public void move() {
        if (this.originDirection.equals("N")){
            this.yAxis += 1;
        } else if (this.originDirection.equals("E")) {
            this.xAxis += 1;
        } else if (this.originDirection.equals("S")) {
            this.yAxis -= 1;
        } else if (this.originDirection.equals("W")) {
            this.xAxis -= 1;
        }
    }

    public String getCurrentPosition(Robot robot){
        return robot.originDirection + "," + robot.xAxis + "," + robot.yAxis;
    }
}
