/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.subtitle.app;

/**
 *
 * @author jehow
 */
public class subtitleDriver {

    public static void main(String[] args) {
        
        SubtitleSeqClass subtitleSeq = (SubtitleSeqClass) SubtitleSeqFactory.loadSubtitleSeq("The.Chosen.2017.S01E01.srt");
//        subtitleSeq.showText();
        subtitleSeq.showTimes();
        System.out.println("\n + \n");
        System.out.println("\n + \n");
        
//        //test remove
//        subtitleSeq.remove("I have called you by name.");
//        subtitleSeq.showText();
//        System.out.println("\n + \n");
//        System.out.println("\n + \n");
        
//        //test replace
//        subtitleSeq.replace("And He who formed you.", "Josiah");
//        subtitleSeq.showText();
//        System.out.println("\n + \n");
//        System.out.println("\n + \n");
        
//        //test cut
//        subtitleSeq.shift(50);
//        Time startTime = new TimeClass(0, 0, 50, 590); 
//        Time endTime = new TimeClass(0, 50, 18, 89);   
//        subtitleSeq.cut(startTime, endTime);
//        subtitleSeq.showText();

        //test shift
        subtitleSeq.shift(5000);
        subtitleSeq.showTimes();
    }
}
