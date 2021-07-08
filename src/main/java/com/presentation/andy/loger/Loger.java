package com.presentation.andy.loger;

import java.io.*;
import java.util.Date;

public class Loger {
    public void log(String message){
        System.out.println(message);
        try(FileWriter writer = new FileWriter("D:\\log.txt", false))
        {
            writer.write(message+" "+new Date().toString()+" !"+"\n");
            writer.flush();
        }
        catch(IOException e){
            System.out.println(e.getMessage()+ "WARNING ошибка в логере");
        }
    }
}
