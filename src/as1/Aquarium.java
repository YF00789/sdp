package as1;
import java.util.ArrayList;
import java.util.List;

public class Aquarium{
    private final int volume;
    private final WaterType waterType;
    private final String filtrationRating;
    private final Lighting lighting;
    private final Substrate substrate;
    private final List<String> flora;
    private final List<Fish> fauna;

    Aquarium(AquariumBuilder builder){
        this.volume = builder.volume;
        this.waterType = builder.waterType;
        this.filtrationRating = builder.filtrationRating;
        this.lighting = builder.lighting;
        this.substrate = builder.substrate;
        this.flora = new ArrayList<>(builder.flora);
        this.fauna = new ArrayList<>(builder.fauna);
    }

    @Override
    public String toString(){
        return "Aquarium{"+"volume="+volume+
                ", waterType="+waterType+
                ", filtrationRating='"+filtrationRating+'\''+
                ", lighting="+lighting+
                ", substrate="+substrate+
                ", flora="+flora+
                ", fauna="+fauna+
                '}';
    }
}
