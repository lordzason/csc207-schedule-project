package csc207.schedules.EAZZ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Schedule
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Collection of schools in the conference
   */
  ArrayList<School> schools;
  /**
   * Collection of gamedays in the season
   */
  ArrayList<GameDay> gameDays;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Creates a new schedule object given two file paths, one for dates, 
   * and one for special dates. 
   * @param dateFilePath
   * @param specDateFilePath
   * @throws Exception
   */
  public Schedule(String dateFilePath, String specDateFilePath)
                                                               throws Exception
  {
    readInput(dateFilePath, specDateFilePath);
  } // Schedule(String, String)

  // +-----------------+-------------------------------------------------
  // | Local Utilities |
  // +-----------------+
  /**
   * Reads input given two filepaths.
   * @param dateFilePath
   * @param specDateFilePath
   * @throws Exception
   */
  void readInput(String dateFilePath, String specDateFilePath)
    throws Exception
  {
    File dates = new File(dateFilePath);
    File specDates = new File(specDateFilePath);
    String result;
    BufferedReader br = new BufferedReader(new FileReader(specDates));
    result = br.readLine();
    while((result = br.readLine()) != null)
      {
        loadSpecDates(result);
      } // while
    BufferedReader br2 = new BufferedReader(new FileReader(dates));
    while((result = br2.readLine()) != null)
      {
        loadDates(result);
      } // while
    br.close();
    br2.close();
  } // readInput(String, String)
  
  /**
   * Sets information in the object based on information in the special dates
   * file.
   * @param result
   * @throws Exception
   */
  void loadSpecDates(String result)
    throws Exception
  {
    String[] tmp = result.split("\\s+");
    SimpleDate date = new SimpleDate(tmp[0]);
    GameDay gameDay = new GameDay(date);
    for(int i = 0; i < tmp.length; i++)
      {
        gameDay.setAvailability(tmp[i+1], this.schools.get(i));
      } // for
    this.gameDays.add(gameDay);
  } // loadSpecDates(String)

  /**
   * Sets information in the object based on information in the dates file.
   * @param result
   * @throws Exception 
   */
  void loadDates(String result) throws Exception
  {
    GameDay gameDay = new GameDay(new SimpleDate(result));
    gameDay.setAvailability("M", this.schools);
    this.gameDays.add(gameDay);
  } // loadDates(String)
} // Schedule
