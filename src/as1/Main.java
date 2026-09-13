package as1;
public class Main{
    public static void main(String[] args){
        AquariumDirector director = new AquariumDirector();

        AquariumBuilder reefBuilder = new AquariumBuilder();
        director.buildTropicalReef(reefBuilder);
        Aquarium reefTank = reefBuilder.build();
        System.out.println(reefTank);

        AquariumBuilder discusBuilder = new AquariumBuilder();
        director.buildPlantedDiscusTank(discusBuilder);
        Aquarium discusTank = discusBuilder.build();
        System.out.println(discusTank);

        AquariumBuilder goldfishBuilder = new AquariumBuilder();
        director.buildColdwaterGoldfish(goldfishBuilder);
        Aquarium goldfishTank = goldfishBuilder.build();
        System.out.println(goldfishTank);

        System.out.println("\nTesting Validation");
        try{
            AquariumBuilder invalidBuilder = new AquariumBuilder();
            invalidBuilder.withVolume(20)
                    .withWaterType(WaterType.FRESHWATER)
                    .withFauna(Fish.CLOWNFISH);
            invalidBuilder.build();
        }catch (IllegalStateException e){System.out.println("Validation Exception Caught: " + e.getMessage());}
    }
}