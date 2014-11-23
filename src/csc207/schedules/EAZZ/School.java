package csc207.schedules.EAZZ;

import java.util.ArrayList;
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
  
  /**
   * ArrayList for storing schools this school has not played.
   */
  ArrayList<School> haveNotPlayed = new ArrayList<School>();
  /**
   * ArrayList for storing schools this school has played once.
   */
  ArrayList<School> havePlayedOnce = new ArrayList<School>();
  /**
   * ArrayList for storing schools this school has played twice. 
   */
  ArrayList<School> havePlayedTwice = new ArrayList<School>();
  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * 
   * @param name
   * @param key
   * @param distances
   */
  public School(String name, String key, Hashtable<String, Integer> distances)
  {
    this.name = name;
    this.key = key;
    this.distances = distances;
  } // School(String, String)

  // +-----------+-------------------------------------------------------
  // | Observers |
  // +-----------+
  /**
   * Returns the School's name.
   * @return
   */
  public String name()
  {
    return this.name;
  } // name()

  /**
   * Returns the School's key.
   * @return
   */
  public String key()
  {
    return this.key;
  } // key()
  // +----------+--------------------------------------------------------
  // | Mutators |
  // +----------+

} // School
