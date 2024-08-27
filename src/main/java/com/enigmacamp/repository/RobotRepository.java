package com.enigmacamp.repository;

import java.io.*;
import java.util.Scanner;

import com.enigmacamp.config.FileConnection;

public class RobotRepository {
    FileConnection conn = new FileConnection();

    public boolean ifExist(){
        if (conn.initFile().exists()){
            return true;
        }
        return false;
    }

    public void readOrCreateFile(){
        if (!ifExist()){
            try {
                if (conn.initFile().createNewFile()){
                    System.out.println("File " + conn.initFile().getName() + " created");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void writeHistory(String position){
        if (ifExist()){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(conn.initFile(), true))){
                bw.write(position);
                bw.newLine();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public String getLatestLine(){
        String position = "";
        if (ifExist()){
            // Get Last line
            try {
                File file = conn.initFile();
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()){
                    position = sc.nextLine();
                }
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return position;
    }
}
