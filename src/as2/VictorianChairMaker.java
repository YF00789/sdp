package as2;
public class VictorianChairMaker implements IChairMaker{
    @Override
    public IChair createChair(){
        IChair chair = new VictorianChair();
        chair.assemble(Material.WOOD);
        return chair;
    }
}