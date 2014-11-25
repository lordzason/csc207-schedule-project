package csc207.schedules.EAZZ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Schedule
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Collection of schools in the conference
   */
  ArrayList<School> schools = new ArrayList<School>();
  /**
   * Collection of gamedays in the season
   */
  ArrayList<GameDay> gameDays = new ArrayList<GameDay>();

  /**
   * Median school distances
   */

  static int MEDIAN_DISTANCE = 270;

  int max_distance = MEDIAN_DISTANCE;

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
  public Schedule(String dateFilePath, String specDateFilePath,
                  String constraintsFilePath) throws Exception
  {
    readInput(dateFilePath, specDateFilePath, constraintsFilePath);
  } // Schedule(String, String)

  public Schedule()
  {

  }

  // +----------+-------------------------------------------------
  // | Mutators |
  // +----------+ 
  /**
   * Schedules games given the schools and dates in the schedule and sets
   * matches within gameDays.
   */
  public void scheduleGames()
  {
    Random random = new Random();
    int numGames = 0;
    for (GameDay gameDay : this.gameDays)
      {
        System.out.println("Game Date: " + gameDay.date.toString());
        while (!gameDay.mustPlay.isEmpty())
          {
            //pick a random index to select team from mustPlay
            int randomIndex = random.nextInt(gameDay.mustPlay.size());

            //get school at randomIndex as home team
            School home = gameDay.mustPlay.get(randomIndex);

            System.out.println("Home School: " + home.name);

            School away = awayChooser(home, gameDay);
            if (away != null)
              {
                //add the match to the game day.
                gameDay.matches.add(new Match(home, away));
                //remove home from gameDay
                gameDay.removeSchool(home);
                //remove away from gameDay
                gameDay.removeSchool(away);

                home.updateHistory(away);
                away.updateHistory(home);
                System.out.println("Away School: " + away.name);
                System.out.println("Num games:" + ++numGames);
              } // if not null
            else
              {
                break;
              } // else
          } // while mustPLay
        while (!gameDay.canPlay.isEmpty())
          {
            System.out.println("within CanPlay");
            //pick a random index to select team from mustPlay
            int randomIndex = random.nextInt(gameDay.canPlay.size());

            //get school at randomIndex as home team
            School home = gameDay.canPlay.get(randomIndex);

            System.out.println("Home School: " + home.name);

            School away = awayChooser(home, gameDay);
            if (away != null)
              {
                //add the match to the game day.
                gameDay.matches.add(new Match(home, away));
                //remove home from gameDay
                gameDay.removeSchool(home);
                //remove away from gameDay
                gameDay.removeSchool(away);

                home.updateHistory(away);
                away.updateHistory(home);
                System.out.println("Away School: " + away.name);
                System.out.println("Num games:" + ++numGames);
              } // if not null
            else
              {
                break;
              } // else
          } // while
        //-----------------------------------------------------\\

        /*
        //get school for away
        School away =
            awayChooser(gameDay.mustPlay, gameDay.canPlay, home,
                        gameDay.matches);

        //home school cannot find a match in mustPlay and canPlay
        if (away == null)
          {
            //find the closest school
          }//if
        else
          {
            //update the home
            home.haveNotPlayed.remove(away);

            if (home.havePlayedOnce.contains(away))
              {
                home.havePlayedTwice.add(away);
              }
            else
              {
                home.havePlayedOnce.add(away);
              }

            //update the away
            away.haveNotPlayed.remove(home);

            if (away.havePlayedOnce.contains(home))
              {
                away.havePlayedTwice.add(home);
              }
            else
              {
                away.havePlayedOnce.add(home);
              }

          }

        //set up match
        gameDay.matches.add(new Match(home, away));
        }//while

        while (gameDay.canPlay.size() > 0)
        {
        int randIndex = random.nextInt(gameDay.canPlay.size());

        //get school at random Index as home team

        School home = gameDay.canPlay.get(randIndex);
        gameDay.canPlay.remove(randIndex);

        //get away school

        School away = awayChooser(gameDay.canPlay, home, gameDay.matches);

        //set up match

        if (away == null)
          {
            //find the closest school
          }//if
        else
          {
        
          //update the home
            home.haveNotPlayed.remove(away);

            if (home.havePlayedOnce.contains(away))
              {
                home.havePlayedTwice.add(away);
              }
            else
              {
                home.havePlayedOnce.add(away);
              }

            //update the away
            away.haveNotPlayed.remove(home);

            if (away.havePlayedOnce.contains(home))
              {
                away.havePlayedTwice.add(home);
              }
            else
              {
                away.havePlayedOnce.add(home);
              }
          }

        //set up match
        gameDay.matches.add(new Match(home, away));

        // when there is only one school left in canPlay
        if (gameDay.canPlay.size() == 1)
          break;
          */

      }//for
  } // scheduleGames()

  /**
   * adds the school to the list of schools.
   * @param school
   */
  public void addSchool(School school)
  {
    this.schools.add(school);
  } // addSchool(School)

  public School awayChooser(School home, GameDay gameDay)
  {

    ArrayList<School> possible;
    //*May want to only add one of the arrays to possible*//
    possible = home.haveNotPlayed;
    possible.addAll(home.havePlayedOnce);
    if (!gameDay.isWeekend())
      {
        possible = allWithinDistance(possible, home.distances);
      } // if
    if (gameDay.mustPlay.isEmpty())
      {
        possible.retainAll(gameDay.canPlay);
      } // if
    else
      {
        possible.retainAll(gameDay.mustPlay);
        if (possible.isEmpty())
          {
            possible = home.haveNotPlayed;
            possible.addAll(home.havePlayedOnce);
            if (!gameDay.isWeekend())
              {
                possible = allWithinDistance(possible, home.distances);
              } // if
            possible.retainAll(gameDay.canPlay);
          } // if there are no other mustPlay teams
      } // else
    if (possible.isEmpty())
      {
        return null;
      } // if
    else
      {
        Random random = new Random();
        int r = random.nextInt(possible.size());
        return possible.get(r);
      } // else
  } // awayChooser(School, GameDay)

  /*
  public School awayChooser(ArrayList<School> mustPlay,
                            ArrayList<School> canPlay, School home,
                            ArrayList<Match> played)
  {
    School temp = awayChooser(mustPlay, home, played);
    if (temp != null)
      {
        return temp;
      }
    else
      {
        return awayChooser(canPlay, home, played);
      }
  }//awayChooser

  public School awayChooser(ArrayList<School> possibleSchools, School home,
                            ArrayList<Match> played)
  {
    Random random = new Random();

    //check if there is at least one school that is within distance
    if (anyWithinDistance(possibleSchools, home.distances))
      {

        ArrayList<School> temp = possibleSchools;

        //randomly pick a school and check if it is within distance
        while (temp.size() > 0)
          {
            

            School possibleAway = temp.get(r);
            //check if distance fits requirement
            if (home.distances.get(possibleAway.key()) <= this.max_distance
                && notScheduled(possibleAway, played))
              {
                int indexInPossibleSchools =
                    possibleSchools.indexOf(possibleAway);
                possibleSchools.remove(indexInPossibleSchools);
                return possibleAway;
              } // if
            temp.remove(r);
          } // while 
      }//if 
    return null;
  }//awayChooser

  public boolean anyWithinDistance(ArrayList<School> mustPlay,
                                   Hashtable<String, Integer> distances)
  {

    for (int i = 0; i < mustPlay.size(); i++)
      {
        if (distances.get(mustPlay.get(i).key) < this.max_distance)
          {
            return true;
          }
      }
    return false;
  }//anyWithDistance
  */
  public ArrayList<School>
    allWithinDistance(ArrayList<School> list,
                      Hashtable<String, Integer> distances)
  {
    ArrayList<School> newList = new ArrayList<School>();
    for (School school : list)
      {
        if (distances.get(school.key()) < this.MEDIAN_DISTANCE)
          {
            newList.add(school);
          } // if
      } // for
    return newList;
  } // allWithinDistance

  public boolean notScheduled(School petitioner, ArrayList<Match> matches)
  {

    for (Match match : matches)
      {
        if (match.home == petitioner || match.away == petitioner)
          return false;
      }
    return true;
  }

  // +-----------------+-------------------------------------------------
  // | Local Utilities |
  // +-----------------+
  /**
   * Reads input given two filepaths.
   * @param dateFilePath
   * @param specDateFilePath
   * @throws Exception
   */
  void readInput(String dateFilePath, String specDateFilePath,
                 String constraintsFilePath)
    throws Exception
  {
    File dates = new File(dateFilePath);
    File specDates = new File(specDateFilePath);
    File constraints = new File(constraintsFilePath);
    String result;
    BufferedReader br = new BufferedReader(new FileReader(specDates));
    result = br.readLine();
    while ((result = br.readLine()) != null)
      {
        loadSpecDates(result);
      } // while
    BufferedReader br2 = new BufferedReader(new FileReader(dates));
    while ((result = br2.readLine()) != null)
      {
        loadDates(result);
      } // while
    // get constraints arrays
    BufferedReader br3 = new BufferedReader(new FileReader(constraints));
    String schoolKeys = br3.readLine();
    String playOnce1 = br3.readLine();
    String playOnce2 = br3.readLine();
    loadConstraints(schoolKeys, playOnce1, playOnce2);
    br.close();
    br2.close();
    br3.close();
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
    GameDay gameDay = new GameDay(tmp[0]);
    for (int i = 1; i < tmp.length; i++)
      {
        gameDay.setAvailability(tmp[i], this.schools.get(i - 1));
      } // for
    this.gameDays.add(gameDay);
  } // loadSpecDates(String)

  /**
   * Sets information in the object based on information in the dates file.
   * @param result
   * @throws Exception 
   */
  void loadDates(String result)
    throws Exception
  {
    GameDay gameDay = new GameDay(result);
    gameDay.setAvailability("M", this.schools);
    this.gameDays.add(gameDay);
  } // loadDates(String)

  void loadConstraints(String keys, String playOnce1, String playOnce2)
    throws Exception
  {
    String[] schoolKeys = keys.split("\\s+");
    String[] playOnceKeys1 = playOnce1.split("\\s+");
    String[] playOnceKeys2 = playOnce2.split("\\s+");

    for (int i = 0; i < schoolKeys.length; i++)
      {
        String schoolKey = schoolKeys[i];
        School school = School.getByKey(this.schools, schoolKey);
        school.updateHistory(School.getByKey(this.schools, playOnceKeys1[i]));
        school.updateHistory(School.getByKey(this.schools, playOnceKeys2[i]));
      } // for
  } // loadConstraints(Strinng, ArrayList<String>)

  /**
   * Prints the schedule
   * @param pen
   */
  @SuppressWarnings("static-access")
  public void printSchedule(PrintWriter pen)
  {
    //STUB
    for (GameDay day : this.gameDays)
      {
       // pen.println(day.date.MONTH + "/" + day.date.DATE + "/" + day.date.YEAR);
        pen.println(day.date.getTime());
        ArrayList<Match> matches = day.matches;
        for (Match m : matches)
          {
            pen.print(" " + m.home.key() + " vs. " + m.away.key() + " "
                      + m.home.distances.get(m.away.key()) + " mi.");
            pen.println();
          } // for
      } // for gameDays
  } // printSchedule(PrintWriter)
} // Schedule  

