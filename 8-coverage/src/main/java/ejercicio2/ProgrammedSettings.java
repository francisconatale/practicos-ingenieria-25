package ejercicio2;

// Used with the Thermostat.java example, Chapter 8

import java.util.*;

public class ProgrammedSettings
{   // dayType -> semana o fin de semana
    // period -> mañana, dia, tarde, noche
    private Map<Period, Map<DayType, Integer>> settings = new LinkedHashMap<>();


    // Property
   public ProgrammedSettings ()
   {
      for (Period p : Period.values())
      {
         HashMap<DayType, Integer> m = new HashMap<DayType, Integer>();
         settings.put (p, m);
         for (DayType d : DayType.values())
         {
            m.put (d, 65); // Default value, 18.33C
         }
      }
   }
   public void setSetting (Period period, DayType day, int temp)
   {
      settings.get (period).put (day, temp);
   }
   public int getSetting (Period period, DayType day)
   {
      return settings.get (period).get (day);
   }
   public String toString()
   {
      return settings.toString();
   }
} // End ProgrammedSettings class
