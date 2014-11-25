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

  @Override
  public boolean equals(Object other)
  {
    if (other instanceof School)
      {
        return this.equals((School) other);
      } // if
    else
      return false;
  } // equals(Object)

  public boolean equals(School other)
  {
    return ((this.key.compareTo(other.key) == 0)
           && (this.name.compareTo(other.name) == 0));
  } // equals(School)

  // +----------+--------------------------------------------------------
  // | Mutators |
  // +----------+
  // +-----------+-------------------------------------------------------
  // | Utilities |
  // +-----------+

  public static ArrayList<School> intersection(ArrayList<School> list1,
                                               ArrayList<School> list2)
  {
    ArrayList<School> newList = new ArrayList<School>();
    for (School item : list1)
      {
        if (list2.contains(item))
          {
            newList.add(item);
          } // if
      } // for
    return newList;
  } // intersection(ArrayList<School>, ArrayList<School>)

  public static School getByKey(ArrayList<School> schools, String key)
    throws Exception
  {
    int length = schools.size();
    for (int i = 0; i < length; i++)
      {
        if (schools.get(i).key().compareTo(key) == 0)
          {
            return schools.get(i);
          } // if
      } // for
    throw new Exception("Key " + key + " not found.");
  } // getByKey(ArrayList<School>)

  public void updateHistory(School other)
  {
    if (this.haveNotPlayed.contains(other))
      {
        this.haveNotPlayed.remove(other);
        this.havePlayedOnce.add(other);
      } // if
    else if (this.havePlayedOnce.contains(other))
      {
        this.havePlayedOnce.remove(other);
        this.havePlayedTwice.add(other);
      } // else
  } // updateHistory(School)

} // School
