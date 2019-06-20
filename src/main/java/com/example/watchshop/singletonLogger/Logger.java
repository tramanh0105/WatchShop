package com.example.watchshop.singletonLogger;

import com.example.watchshop.user.UserDTO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger uniqueInstance;
    private FileWriter writer;
    private BufferedWriter bw;

    private Logger() {
        try {
            this.writer = new FileWriter("log.txt");
            this.bw = new BufferedWriter(writer);
        } catch (IOException e) {
            System.err.print(e.toString());
        }
    }

    public static Logger getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Logger();
        }
        return uniqueInstance;
    }

    public synchronized void  loginLog(UserDTO user, String date) {
        try {

            String toFile = date + ": id[" + user.getId() + "] " + user.getBenutzerName() + "\n";
            bw.write(toFile);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
