package com.enigmacamp;

import com.enigmacamp.console.RobotApp;
import com.enigmacamp.repository.RobotRepository;
import com.enigmacamp.service.RobotService;
import com.enigmacamp.utils.InputHandler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RobotRepository repository = new RobotRepository();
        RobotService service = new RobotService(repository);
        InputHandler handler = new InputHandler();
        new RobotApp(service, handler).run();
    }
}
