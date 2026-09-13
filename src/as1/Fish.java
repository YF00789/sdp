package as1;
public enum Fish{
    GOLDFISH(WaterType.FRESHWATER),
    DISCUS(WaterType.FRESHWATER),
    NEON_TETRA(WaterType.FRESHWATER),
    CLOWNFISH(WaterType.SALTWATER),
    BLUE_TANG(WaterType.SALTWATER);

    private final WaterType requiredWater;
    Fish(WaterType requiredWater){this.requiredWater = requiredWater;}
    public WaterType getRequiredWater(){return requiredWater;}
}
