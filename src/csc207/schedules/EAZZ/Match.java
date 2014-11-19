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
  public Match(School home, School away)
  {
    this.home = home;
    this.away = away;
  } // Match(School, School)

  // +-----------+-------------------------------------------------------
  // | Observers |
  // +-----------+
  public boolean equals(Object obj)
  {
    if (obj instanceof Match)
      return this.equals((Match) obj);
    return false;
  } // equals(Object)

  public boolean equals(Match other)
  {
    return this.away.equals(other.away) && this.home.equals(other.home);
  } // equals(Match)
  // +----------+--------------------------------------------------------
  // | Mutators |
  // +----------+
} // Match
