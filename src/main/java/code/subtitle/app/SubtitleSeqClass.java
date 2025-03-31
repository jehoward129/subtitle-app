/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.subtitle.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jehow
 */
public class SubtitleSeqClass implements SubtitleSeq{
    List<Subtitle> subSeq = new ArrayList<>();

    public SubtitleSeqClass(List<Subtitle> subtitles) {
        this.subSeq = subtitles;
    }
    public SubtitleSeqClass(){
        
    }
    @Override
    public void addSubtitle(Subtitle st) { 
        subSeq.add(st);
    }

    @Override
    public List<Subtitle> getSubtitles() {
        return subSeq;
    }

    @Override
    public Subtitle getSubtitle(Time time) {
//        System.out.println(time.getSS());
        TimeClass tim = ((TimeClass)time);
//        System.out.println(tim.getSS());
        int input = tim.toMilliseconds();
        for(Subtitle s: subSeq){
            SubtitleClass t = ((SubtitleClass)s);
            
            TimeClass a = ((TimeClass)t.getStartTime());
            int start = a.toMilliseconds();
            TimeClass b = ((TimeClass)t.getEndTime());
            int end = b.toMilliseconds();
//            System.out.println(start + "   " + input + "   " + end);
            
            if((input >= start)&&(input <= end)){
                Subtitle subby =  s;
                return subby;
            }
        }
        return null;
    }

    @Override
    public List<Subtitle> getSubtitles(Time startTime, Time endTime) {
        List<Subtitle> tempSeq = new ArrayList<>();
        TimeClass begin = ((TimeClass)startTime);
        TimeClass end = ((TimeClass)endTime);
        for(Subtitle s: subSeq){
            TimeClass tempSTm = ((TimeClass)s.getStartTime());
            TimeClass tempETm = ((TimeClass)s.getEndTime());
            if(tempSTm.isBefore(end) && tempSTm.isAfter(begin)){
                tempSeq.add(s);
            }
            if(tempETm.isBefore(end) && tempETm.isAfter(begin)){
                tempSeq.add(s);
            }
        }
        return tempSeq;
    }

    @Override
    public List<Subtitle> getSubtitles(String str) {
        List<Subtitle> tempSeq = new ArrayList<>();
        for(Subtitle s: subSeq){
            String text = s.getText();
            if(text.toUpperCase().contains(str.toUpperCase())){
                tempSeq.add(s);
            }
        }
        return tempSeq;
    }

    @Override
    public void remove(String str) {
        Iterator<Subtitle> iterator = subSeq.iterator();
        while (iterator.hasNext()) {
            Subtitle s = iterator.next();
            String text = s.getText();
            if (text.toUpperCase().contains(str.toUpperCase())) {
                iterator.remove();
            }
        }
    }

    @Override
    public void replace(String str1, String str2) {
        for(Subtitle s: subSeq){
            String text = s.getText();
            if(text.toUpperCase().contains(str1.toUpperCase())){
                String tempstr = s.getText().replace(str1, str2);
                s.setText(tempstr);
            }
        }
    }

    @Override
    public void shift(int offset) {
        for (Subtitle sub : subSeq) {
            SubtitleClass s = ((SubtitleClass) sub);

            // Shift start time and update
            TimeClass t = (TimeClass) s.getStartTime();
            TimeClass newStart = t.shift(offset); // Get the shifted time
            sub.setStartTime(newStart); // Update the start time

            // Shift end time and update
            TimeClass t1 = (TimeClass) s.getEndTime();
            TimeClass newEnd = t1.shift(offset); // Get the shifted time
            sub.setEndTime(newEnd); // Update the end time
        }
    }
    @Override
    public void cut(Time startTime, Time endTime) {
        TimeClass et = ((TimeClass) endTime);
        TimeClass st = ((TimeClass) startTime);
        Iterator<Subtitle> iterator = subSeq.iterator();

        while (iterator.hasNext()) {
            Subtitle s = iterator.next();
            TimeClass start = (TimeClass) s.getStartTime();
            TimeClass end = (TimeClass) s.getEndTime();

            if ((start.isBefore(et) && start.isAfter(st)) || (end.isBefore(et) && end.isAfter(st))) {
                iterator.remove();
            }
        }
    }
    public void showText(){
        for(Subtitle s: subSeq){
            System.out.println(s.getText());
        }
    }
    public void showTimes(){
        for(Subtitle s: subSeq){
            Time st = s.getStartTime();
            Time et = s.getEndTime();
            System.out.println(st.getHH() + ":" + st.getMM() + ":" + st.getSS() + "," + st.getMS());
        }
    }
    

    
    
    
}
