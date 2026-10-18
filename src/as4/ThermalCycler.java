package as4;
public class ThermalCycler{
    public void startCycling(int cycles, int targetTemperature){
        System.out.println("Thermal cycling started: "+cycles+" cycles at "+targetTemperature+"C.");
    }
    public void stopAndCool(){
        System.out.println("Thermal cycler stopped and returned to ambient temperature.");
    }
}