package csc207.schedules.EAZZ;
import java.util.Hashtable;

public class School
{
  //+--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  
  /**
   * Name of the school
   */
  String name;
  
  /**
   * School's initials, for example, Grinnell College's key is GC.
   */
  String key;
  
  /**
   * A table for storing distances this school is from other schools.
   */
  Hashtable<String, Integer> distances;
  
  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+
  
  public School(String name, String key)
  {
    this.name = name;
    this.key = key;
    // NEED TO INPUT DISTANCES
  } // School(String, String)
  
  // +-----------+-------------------------------------------------------
  // | Observers |
  // +-----------+
  
  // +----------+--------------------------------------------------------
  // | Mutators |
  // +----------+
  
} // School
