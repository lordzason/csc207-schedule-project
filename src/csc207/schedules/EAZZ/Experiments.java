package csc207.schedules.EAZZ;

import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Hashtable;

public class Experiments
{

  public static void main(String[] args) throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    MidwestConference Mschedule = new MidwestConference();
    Hashtable<String, Integer> GCDistances = new Hashtable<String, Integer>();
    GCDistances.put("BC", 255);
    GCDistances.put("CC", 90);
    GCDistances.put("IC", 270);
    GCDistances.put("KC", 175);
    GCDistances.put("LFC", 305);
    GCDistances.put("LU", 362);
    GCDistances.put("MC", 166); 
    GCDistances.put("RC", 330);
    GCDistances.put("SNC", 383);
    School grinnell = new School("Grinnell College","GC", GCDistances);
    pen.println(grinnell.key + " " + grinnell.name + " " + grinnell.distances.get("BC"));
    
    Schedule schedule = new Schedule();
    schedule.addSchool(grinnell);
    Mschedule.gameDays.add(new GameDay("11/22/14"));
    pen.println("Num schools: " + Mschedule.schools.size());
    
    Mschedule.gameDays.get(0).setAvailability("Y", Mschedule.schools.get(0));
    
  } // main(String[])

}
