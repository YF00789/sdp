package as1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class AquariumBuilder{
    int volume;
    WaterType waterType;
    String filtrationRating;
    Lighting lighting;
    Substrate substrate;
    List<String> flora = new ArrayList<>();
    List<Fish> fauna = new ArrayList<>();

    public AquariumBuilder withVolume(int volume){
        this.volume = volume;
        return this;
    }

    public AquariumBuilder withWaterType(WaterType waterType){
        this.waterType = waterType;
        return this;
    }

    public AquariumBuilder withFiltrationRating(String filtrationRating){
        this.filtrationRating = filtrationRating;
        return this;
    }

    public AquariumBuilder withLighting(Lighting lighting){
        this.lighting = lighting;
        return this;
    }

    public AquariumBuilder withSubstrate(Substrate substrate){
        this.substrate = substrate;
        return this;
    }

    public AquariumBuilder withFlora(String... plants){
        this.flora.addAll(Arrays.asList(plants));
        return this;
    }

    public AquariumBuilder withFauna(Fish... fishes){
        this.fauna.addAll(Arrays.asList(fishes));
        return this;
    }

    public Aquarium build(){
        if (volume<=0){throw new IllegalStateException("Volume must be greater than zero.");}
        if (waterType==null){throw new IllegalStateException("Water type must be specified.");}
        for (Fish fish : fauna){
            if (fish.getRequiredWater()!=waterType){
                throw new IllegalStateException("Cannot mix "+fish.getRequiredWater()+
                        " fish into a "+waterType+" tank.");
            }
        }
        return new Aquarium(this);
    }
}
