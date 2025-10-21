package ejercicio2;

// Autores: Paul Ammann & Jeff Offutt
// Termostato programable
// Capítulo 8
// Ver ThermostatTest.java para las pruebas JUnit


// Termostato programable
public class Thermostat
{
    private int curTemp;          // lectura de la temperatura actual
    private int thresholdDiff;    // diferencia de temperatura hasta que encendemos la calefacción
    private int timeSinceLastRun; // tiempo desde que la calefacción se detuvo
    private int minLag;           // cuánto tiempo debo esperar
    private boolean override;     // el usuario ha anulado el programa
    private int overTemp;         // temperatura de anulación
    private int runTime;          // salida de turnHeaterOn: cuánto tiempo ejecutar
    private boolean heaterOn;     // salida de turnHeaterOn: si debe encenderse o no
    private Period period;        // mañana, día, tarde o noche
    private DayType day;          // día de semana o fin de semana

    // Decide si encender la calefacción y por cuánto tiempo.
    public boolean turnHeaterOn (ProgrammedSettings pSet)
    {
        int dTemp = pSet.getSetting(period, day);

        if ((seRequiereEncenderElCalefactor(dTemp) || elUsuarioApagoLaCalefaccion() && sePuedePrenderNuevamenteLaCalefaccion() ))
        {  // Encender la calefacción
            // ¿Por cuánto tiempo? Suponemos 1 minuto por grado (Fahrenheit)
            int timeNeeded = Math.abs(dTemp - curTemp);
            if (override)
                timeNeeded = Math.abs(overTemp - curTemp); // abs() agregado en mayo de 2020
            setRunTime(timeNeeded);
            setHeaterOn(true);
            return(true);
        }
        else
        {
            setHeaterOn(false);
            return(false);
        }
    } // Fin de turnHeaterOn

    public boolean seRequiereEncenderElCalefactor(int temperaturaObjetivo){
        return (curTemp < temperaturaObjetivo - thresholdDiff);
    }

    public boolean elUsuarioApagoLaCalefaccion(){
        return (override && curTemp < overTemp - thresholdDiff);
    }

    public boolean sePuedePrenderNuevamenteLaCalefaccion(){
        return timeSinceLastRun > minLag;
    }

    public void setCurrentTemp(int temperature)  { curTemp = temperature; }
    public void setThresholdDiff(int delta)      { thresholdDiff = delta; }
    public void setTimeSinceLastRun(int minutes) { timeSinceLastRun = minutes; }
    public void setMinLag(int minutes)           { minLag = minutes; }
    public void setOverride(boolean value)       { override = value; }
    public void setOverTemp(int temperature)     { overTemp = temperature; }

    // para los ProgrammedSettings
    public void setDay(DayType curDay)      { day = curDay; }
    public void setPeriod(Period curPeriod) { period = curPeriod; }

    // salidas de turnHeaterOn
    void    setRunTime(int minutes)    { runTime = minutes; }
    public int     getRunTime()               { return runTime; }
    void    setHeaterOn(boolean value) { heaterOn = value; }
    public boolean getHeaterOn()              { return heaterOn; }
} // Fin de la clase Thermostat
