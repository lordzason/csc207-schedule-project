package csc207.schedules.EAZZ;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class GameDay
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Date of the game.
   */
  Calendar date = Calendar.getInstance();

  /**
   * ArrayList of schools that must play this day
   */
  ArrayList<School> mustPlay;

  /**
   * ArrayList of schools that can play this day
   */
  ArrayList<School> canPlay;

  /**
   * ArrayList of schools that can't play this day
   */
  ArrayList<School> cannotPlay;

  /**
   * ArrayList of matches that will happen that day. 
   */
  ArrayList<Match> matches;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Creates a new GameDay object
   * @param month
   * @param day
   * @param year
   * @throws ParseException 
   */
  public GameDay(String str) throws ParseException
  {
    this.date.setTime(new SimpleDateFormat("MM/dd/yy").parse(str));
  } // GameDay(int, int, int)

  // +-----------+-------------------------------------------------------
  // | Observers |
  // +-----------+
  @SuppressWarnings("static-access")
  public boolean isWeekend()
  {
    int day = this.date.DAY_OF_WEEK;
    return day == 1 || day == 6 || day == 7;
  } // isWeekend

  // +----------+--------------------------------------------------------
  // | Mutators |
  // +----------+
  /**
   * Adds a school to one of the ArrayLists based on specified availability,
   * type.
   * "Y" indicates must play
   * "N" indicates cannot play
   * "M" indicates can play
   * Throws an exception if none of these types.
   * @param type
   * @param school
   * @throws Exception 
   */
  public void setAvailability(String type, School school)
    throws Exception
  {
    if (type.compareTo("Y") == 0)
      {
        this.mustPlay.add(school);
      } // if
    else if (type.compareTo("N") == 0)
      {
        this.cannotPlay.add(school);
      } // else if
    else if (type.compareTo("M") == 0)
      {
        this.canPlay.add(school);
      } // else if
    else
      {
        throw new Exception("Incorrect input " + type);
      } // else
  } // setAvailability(String, School)

  public void setAvailability(String type, ArrayList<School> schools)
    throws Exception
  {
    int length = schools.size();
    for(int i = 0; i < length; i++)
      {
        this.setAvailability(type, schools.get(i));
      } // for 
  } // setAvailability
  
} // GameDay
