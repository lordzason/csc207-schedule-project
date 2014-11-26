package csc207.schedules.EAZZ;

import java.util.Hashtable;

public class MidwestConference
    extends Schedule
{
  //Create Hashtables for all distances to be hard coded in. :(
  private Hashtable<String, Integer> BCDistances =
      new Hashtable<String, Integer>();
  private Hashtable<String, Integer> CCDistances =
      new Hashtable<String, Integer>();
  private Hashtable<String, Integer> GCDistances =
      new Hashtable<String, Integer>();
  private Hashtable<String, Integer> ICDistances =
      new Hashtable<String, Integer>();
  private Hashtable<String, Integer> KCDistances =
      new Hashtable<String, Integer>();
  private Hashtable<String, Integer> LFCDistances =
      new Hashtable<String, Integer>();
  private Hashtable<String, Integer> LUDistances =
      new Hashtable<String, Integer>();
  private Hashtable<String, Integer> MCDistances =
      new Hashtable<String, Integer>();
  private Hashtable<String, Integer> RCDistances =
      new Hashtable<String, Integer>();
  private Hashtable<String, Integer> SNCDistances =
      new Hashtable<String, Integer>();

  /**
   * Constructor for loading gameDays and adding distance hashtables.
   * @param dateFilePath
   * @param specDateFilePath
   * @throws Exception
   */
  public MidwestConference(String dateFilePath, String specDateFilePath,
                           String constraintsFilePath) throws Exception
  {
    populateHashtables();
    this.addSchool(new School("Beloit College", "BC", BCDistances));
    this.addSchool(new School("Cornell College", "CC", CCDistances));
    this.addSchool(new School("Grinnell College", "GC", GCDistances));
    this.addSchool(new School("Illinois College", "IC", ICDistances));
    this.addSchool(new School("Knox College", "KC", KCDistances));
    this.addSchool(new School("Lake Forest College", "LFC", LFCDistances));
    this.addSchool(new School("Lawrence University", "LU", LUDistances));
    this.addSchool(new School("Monmouth College", "MC", MCDistances));
    this.addSchool(new School("Ripon College", "RC", RCDistances));
    this.addSchool(new School("St. Norbert College", "SNC", SNCDistances));
    initializeHaveNotPlayed();
    this.readInput(dateFilePath, specDateFilePath, constraintsFilePath);
  } // MidwestConference(String, String, String)

  public MidwestConference()
  {
    super();
    this.addSchool(new School("Beloit College", "BC", BCDistances));
    this.addSchool(new School("Cornell College", "CC", CCDistances));
    this.addSchool(new School("Grinnell College", "GC", GCDistances));
    this.addSchool(new School("Illinois College", "IC", ICDistances));
    this.addSchool(new School("Knox College", "KC", KCDistances));
    this.addSchool(new School("Lake Forest College", "LFC", LFCDistances));
    this.addSchool(new School("Lawrence University", "LU", LUDistances));
    this.addSchool(new School("Monmouth College", "MC", MCDistances));
    this.addSchool(new School("Ripon College", "RC", RCDistances));
    this.addSchool(new School("St. Norbert College", "SNC", SNCDistances));
    initializeHaveNotPlayed();
  }

  /**
   * Add all other schools to the HaveNotPlayed list in each school.
   */
  private void initializeHaveNotPlayed()
  {
    int length = this.schools.size();
    School curr;
    School other;
    for (int i = 0; i < length; i++)
      {
        curr = this.schools.get(i);
        for (int j = 0; j < length; j++)
          {
            other = this.schools.get(j);
            if (!curr.equals(other))
              {
                curr.haveNotPlayed.add(other);
              } // if
          } // for
      } // for
  } // initializeHaveNotPlayed()

  /**
   * Hard-code distance hashtables. 
   */
  private void populateHashtables()
  {
    //Beloit
    BCDistances.put("CC", 156);
    BCDistances.put("GC", 255);
    BCDistances.put("IC", 255);
    BCDistances.put("KC", 170);
    BCDistances.put("LFC", 90);
    BCDistances.put("LU", 157);
    BCDistances.put("MC", 183);
    BCDistances.put("RC", 125);
    BCDistances.put("SNC", 190);
    //Cornell
    CCDistances.put("BC", 156);
    CCDistances.put("GC", 90);
    CCDistances.put("IC", 215);
    CCDistances.put("KC", 125);
    CCDistances.put("LFC", 226);
    CCDistances.put("LU", 264);
    CCDistances.put("MC", 116);
    CCDistances.put("RC", 235);
    CCDistances.put("SNC", 290);
    //Grinnell
    GCDistances.put("BC", 255);
    GCDistances.put("CC", 90);
    GCDistances.put("IC", 270);
    GCDistances.put("KC", 175);
    GCDistances.put("LFC", 305);
    GCDistances.put("LU", 362);
    GCDistances.put("MC", 166);
    GCDistances.put("RC", 330);
    GCDistances.put("SNC", 383);
    //Illinois
    ICDistances.put("BC", 255);
    ICDistances.put("CC", 215);
    ICDistances.put("GC", 270);
    ICDistances.put("KC", 122);
    ICDistances.put("LFC", 262);
    ICDistances.put("LU", 405);
    ICDistances.put("MC", 106);
    ICDistances.put("RC", 370);
    ICDistances.put("SNC", 431);
    //Knox
    KCDistances.put("BC", 170);
    KCDistances.put("CC", 125);
    KCDistances.put("GC", 175);
    KCDistances.put("IC", 122);
    KCDistances.put("LFC", 215);
    KCDistances.put("LU", 320);
    KCDistances.put("MC", 17);
    KCDistances.put("RC", 287);
    KCDistances.put("SNC", 341);
    //Lake Forest
    LFCDistances.put("BC", 90);
    LFCDistances.put("CC", 226);
    LFCDistances.put("GC", 305);
    LFCDistances.put("IC", 262);
    LFCDistances.put("KC", 215);
    LFCDistances.put("LU", 168);
    LFCDistances.put("MC", 230);
    LFCDistances.put("RC", 145);
    LFCDistances.put("SNC", 175);
    //Lawrence
    
    LUDistances.put("BC", 157);
    LUDistances.put("CC", 264);
    LUDistances.put("GC", 362);
    LUDistances.put("IC", 405);
    LUDistances.put("KC", 320);
    LUDistances.put("LFC", 168);
    LUDistances.put("MC", 335);
    LUDistances.put("RC", 40);
    LUDistances.put("SNC", 25);
    //Monmouth
    MCDistances.put("BC", 183);
    MCDistances.put("CC", 116);
    MCDistances.put("GC", 166);
    MCDistances.put("IC", 106);
    MCDistances.put("KC", 17);
    MCDistances.put("LFC", 230);
    MCDistances.put("LU", 335);
    MCDistances.put("RC", 300);
    MCDistances.put("SNC", 356);
    //Ripon
    RCDistances.put("BC", 125);
    RCDistances.put("CC", 235);
    RCDistances.put("GC", 330);
    RCDistances.put("IC", 370);
    RCDistances.put("KC", 287);
    RCDistances.put("LFC", 145);
    RCDistances.put("LU", 40);
    RCDistances.put("MC", 300);
    RCDistances.put("SNC", 65);
    //St. Norbert
    SNCDistances.put("BC", 190);
    SNCDistances.put("CC", 290);
    SNCDistances.put("GC", 383);
    SNCDistances.put("IC", 431);
    SNCDistances.put("KC", 341);
    SNCDistances.put("LFC", 175);
    SNCDistances.put("LU", 25);
    SNCDistances.put("MC", 345);
    SNCDistances.put("RC", 65);
  } // populateHashtables()

} // MidwestConference
