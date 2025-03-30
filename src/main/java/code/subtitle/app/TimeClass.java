/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.subtitle.app;

/**
 *
 * @author jehow
 */
public class TimeClass implements Time{
    int HH; 
    int MM; 
    int SS; 
    int MS;

    public int getHH() {
        return HH;
    }

    public void setHH(int HH) {
        this.HH = HH;
    }

    public int getMM() {
        return MM;
    }

    public void setMM(int MM) {
        this.MM = MM;
    }

    public int getSS() {
        return SS;
    }

    public void setSS(int SS) {
        this.SS = SS;
    }

    public int getMS() {
        return MS;
    }

    public void setMS(int MS) {
        this.MS = MS;
    }

    public TimeClass() {
          }
    
     public TimeClass(int HH, int MM, int SS, int MS) {
        this.HH = HH;
        this.MM = MM;
        this.SS = SS;
        this.MS = MS;
//         System.out.println("Trigger");
    }
    
    public int toMilliseconds() {
        return (HH * 3600000) + (MM * 60000) + (SS * 1000) + MS;
    }

   
    public static TimeClass fromMilliseconds(int totalMilliseconds) {
        int HH = (totalMilliseconds / 3600000) % 24; 
        totalMilliseconds %= 3600000;
        int MM = totalMilliseconds / 60000;
        totalMilliseconds %= 60000;
        int SS = totalMilliseconds / 1000;
        int MS = totalMilliseconds % 1000;
        
        return new TimeClass(HH, MM, SS, MS);
    }
    
    
    public boolean isBefore(TimeClass tm2){
        int time1 = this.toMilliseconds();
        int time2 = tm2.toMilliseconds();
        if(!(time1 > time2)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isAfter(TimeClass tm2){
        int time1 = this.toMilliseconds();
        int time2 = tm2.toMilliseconds();
        if(!(time1 < time2)){
            return true;
        }else{
            return false;
        }
    }
    
    
    public TimeClass shift(int offset){
        int tm = this.toMilliseconds();
        tm += offset;
        TimeClass result = fromMilliseconds(tm);
        return result;   
    }

}
