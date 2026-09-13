package as1;
public class AquariumDirector{
    public void buildTropicalReef(AquariumBuilder builder){
        builder.withVolume(120)
                .withWaterType(WaterType.SALTWATER)
                .withFiltrationRating("High Capacity Protein Skimmer")
                .withLighting(Lighting.REEF_SPECIFIC)
                .withSubstrate(Substrate.CRUSHED_CORAL)
                .withFlora("Coralline Algae", "Bubble Anemone")
                .withFauna(Fish.CLOWNFISH, Fish.BLUE_TANG);
    }

    public void buildPlantedDiscusTank(AquariumBuilder builder){
        builder.withVolume(75)
                .withWaterType(WaterType.FRESHWATER)
                .withFiltrationRating("Large Canister Filter")
                .withLighting(Lighting.HIGH)
                .withSubstrate(Substrate.AQUA_SOIL)
                .withFlora("Amazon Sword", "Java Fern", "Anubias")
                .withFauna(Fish.DISCUS, Fish.NEON_TETRA);
    }

    public void buildColdwaterGoldfish(AquariumBuilder builder){
        builder.withVolume(50)
                .withWaterType(WaterType.FRESHWATER)
                .withFiltrationRating("Heavy Duty HOB Filter")
                .withLighting(Lighting.LOW)
                .withSubstrate(Substrate.SAND)
                .withFlora("Anubias")
                .withFauna(Fish.GOLDFISH);
    }
}
