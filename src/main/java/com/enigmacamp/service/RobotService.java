package com.enigmacamp.service;

import com.enigmacamp.entity.Robot;
import com.enigmacamp.repository.RobotRepository;

public class RobotService {
    protected RobotRepository robotRepository;

    public RobotService(RobotRepository robotRepository){
        this.robotRepository = robotRepository;
    }

    public void initiate() {
        if (!robotRepository.ifExist()){
            robotRepository.readOrCreateFile();
        }
    }

    public void writeHistory(String robot) {
        robotRepository.writeHistory(robot);
    }

    public String getLatestLine(){
        return robotRepository.getLatestLine();
    }
}
