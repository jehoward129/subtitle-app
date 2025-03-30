/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.subtitle.app;

/**
 *
 * @author jehow
 */
public class SubtitleClass implements Subtitle{
    Time startTime;
    Time endTime;
    String text;
    int subNum;

    @Override
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Override
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSubNum() {
        return subNum;
    }

    public void setSubNum(int subNum) {
        this.subNum = subNum;
    }

    public SubtitleClass(int subNum, Time startTime, Time endTime, String text) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.text = text;
        this.subNum = subNum;
    }

   
    
}
