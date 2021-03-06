package com.company;

import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
	Scanner scan = new Scanner(new FileReader(args[0]));
	int timeIn,timeOut,people=0;
        ArrayList<Intervals> interv = new ArrayList<>();
        ArrayList<Intervals> statistic = new ArrayList<>();
        while(scan.hasNext()){
            String[] s;
            s = scan.nextLine().replace("\\n","").split(" ");
            String[] timeIN,timeOUT;
            timeIN = s[0].split(":");
            timeOUT = s[1].split(":");
            Intervals now = new Intervals(Short.parseShort(timeIN[0]),Short.parseShort(timeIN[1]),Short.parseShort(timeOUT[0]),Short.parseShort(timeOUT[1]));
            interv.add(now);
        }
        for (Intervals in : interv) {
            statistic.add(peopleInBank(interv,in));
        }
        Set<Intervals> set = new HashSet<>(statistic);
        statistic.clear();
        statistic.addAll(set);
        statistic.removeIf(c->c.getPeople()!=Collections.max(statistic).getPeople());
        Collections.sort(statistic);

        for (Intervals i : statistic){
            System.out.println(i.getHourIn()+":"+String.format("%02d", i.getMinIn())+" "+i.getHourOut()+":"+String.format("%02d", i.getMinOut())+"\\n");
        }
    }
    public static Intervals peopleInBank (ArrayList<Intervals> time, Intervals in){
        short inc=0;
        for (Intervals i : time){
            if ((i.getHourIn()>=in.getHourIn() && i.getMinIn()>=in.getMinIn() && i.getHourIn()<=in.getHourOut() && i.getMinIn()<in.getMinOut())
            || (i.getHourOut()>=in.getHourIn() && i.getMinOut()>in.getMinIn() && i.getHourOut()<=in.getHourOut() && i.getMinOut()<=in.getMinOut())){
                inc++;
                if (i.getHourIn()>=in.getHourIn() && i.getMinIn()>in.getMinIn()){
                    in.setHourIn(i.getHourIn());
                    in.setMinIn(i.getMinIn());
                }
                if (i.getHourOut()<=in.getHourOut() && i.getMinOut()<in.getMinOut()){
                    in.setHourOut(i.getHourOut());
                    in.setMinOut(i.getMinOut());
                }
            }
        }
        in.setPeople(inc);
        return in;
    }
}
