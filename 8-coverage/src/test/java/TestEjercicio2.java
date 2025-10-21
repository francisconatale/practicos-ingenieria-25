import ejercicio2.DayType;
import ejercicio2.Period;
import ejercicio2.ProgrammedSettings;
import ejercicio2.Thermostat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEjercicio2 {

    @Test
    public void testTurnHeaterOnWithProgrammedDefaultSettings() {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(42);
        thermostat.setThresholdDiff(5);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setDay(DayType.WEEKEND);

        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertTrue(result);
    }

    @Test
    public void testTurnHeaterOnWithoutProgrammedDefaultSettings() {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.MORNING, DayType.WEEKEND, 20);
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(42);
        thermostat.setThresholdDiff(5);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setDay(DayType.WEEKEND);

        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertFalse(result);
    }

    @Test
    public void testTwoTurnHeaterOnWithoutProgrammedDefaultSettings() {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.MORNING, DayType.WEEKEND, 20);
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(42);
        thermostat.setThresholdDiff(5);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setDay(DayType.WEEKEND);
        thermostat.setOverride(true);
        thermostat.setTimeSinceLastRun(23);
        thermostat.setMinLag(35);

        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertFalse(result);
    }

    @Test
    public void testThreeTurnHeaterOnWithoutProgrammedDefaultSettings() {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.MORNING, DayType.WEEKEND, 20);
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(42);
        thermostat.setThresholdDiff(5);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setDay(DayType.WEEKEND);
        thermostat.setOverride(true);
        thermostat.setTimeSinceLastRun(23);
        thermostat.setMinLag(20);

        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertFalse(result);
    }

    @Test
    public void testTurnHeatherOnWithSecondCondition() {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        Thermostat thermostat = new Thermostat();
        thermostat.setDay(DayType.WEEKEND);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setCurrentTemp(42);
        thermostat.setOverTemp(60);
        thermostat.setOverride(true);
        thermostat.setThresholdDiff(5);
        thermostat.setTimeSinceLastRun(30);
        thermostat.setMinLag(20);

        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertTrue(result);
    }

    @Test
    public void testTurnHeaterOnWithProgrammedSettingsAndYouWantToDo() {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        Thermostat thermostat = new Thermostat();
        thermostat.setTimeSinceLastRun(30);
        thermostat.setMinLag(20);
        thermostat.setCurrentTemp(61);
        thermostat.setThresholdDiff(5);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setDay(DayType.WEEKEND);
        thermostat.setOverride(true);
        thermostat.setOverTemp(67);
        thermostat.turnHeaterOn(programmedSettings);
        boolean heatherIsOn = thermostat.getHeaterOn();
        int result = thermostat.getRunTime();
        assertEquals(6,result);
        assertTrue(heatherIsOn);
    }

    @Test
    public void testTurnHeaterOffBecauseRecentlyRan() {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        Thermostat thermostat = new Thermostat();
        thermostat.setDay(DayType.WEEKEND);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setCurrentTemp(42);
        thermostat.setOverTemp(60);
        thermostat.setOverride(true);
        thermostat.setThresholdDiff(5);
        thermostat.setTimeSinceLastRun(5);
        thermostat.setMinLag(20);

        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertTrue(result); // rama del else
    }

    @Test
    public void testTurnHeaterOffWhenNoConditionsApply() {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        Thermostat thermostat = new Thermostat();
        thermostat.setDay(DayType.WEEKEND);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setCurrentTemp(70);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(false);
        thermostat.setTimeSinceLastRun(30);
        thermostat.setMinLag(20);

        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertFalse(result); // ninguna condición se cumple
    }

    @Test
    public void testTwoTurnHeaterOffWhenNoConditionsApply() {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        Thermostat thermostat = new Thermostat();
        thermostat.setDay(DayType.WEEKEND);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setCurrentTemp(70);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(false);
        thermostat.setTimeSinceLastRun(15);
        thermostat.setMinLag(20);

        boolean result = thermostat.turnHeaterOn(programmedSettings);
        assertFalse(result); // ninguna condición se cumple
    }
}
