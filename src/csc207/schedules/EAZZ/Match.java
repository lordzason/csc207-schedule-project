package csc207.schedules.EAZZ;

public class Match
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * School that's playing at home.
   */
  School home;
  /**
   * School that's playing away.
   */
  School away;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a match given the home and away team.
   * @param home
   * @param away
   */
  public Match(School home, School away)
  {
    this.home = home;
    this.away = away;
  } // Match(School, School)

  // +-----------+-------------------------------------------------------
  // | Observers |
  // +-----------+
  /**
   * Check if the Object is a Match object.
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof Match)
      return this.equals((Match) obj);
    return false;
  } // equals(Object)

  /**
   * Check if the home and away teams in the match are the same between this
   * and the other.
   * @param other
   * @return
   */
  public boolean equals(Match other)
  {
    return this.away.equals(other.away) && this.home.equals(other.home);
  } // equals(Match)
  // +----------+--------------------------------------------------------
  // | Mutators |
  // +----------+
} // Match
