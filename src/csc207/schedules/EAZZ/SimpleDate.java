package csc207.schedules.EAZZ;

public class SimpleDate
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Year, in form YYYY
   */
  int year;
  /**
   * Month, in form of MM
   */
  int month;
  /**
   * Day in form of DD
   */
  int day;
  
  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Creates a SimpleDate object given the month, day and year.
   * @param month
   * @param day
   * @param year
   */
  public SimpleDate(int month, int day, int year)
  {
    this.month = month;
    this.day = day;
    this.year = year;
  } // SimpleDate(int, int, int)
  
  /**
   * Creates a Simple date object given a string that is in the form 
   * "MM/DD/YYYY".
   * @param str
   */
  public SimpleDate(String str)
  {
    String[] partsOfDate = str.split("/");
    this.month = Integer.valueOf(partsOfDate[0]);
    this.day = Integer.valueOf(partsOfDate[1]);
    this.year = Integer.valueOf(partsOfDate[2]);    
  } // SimpleDate(String)
} // SimpleDate
