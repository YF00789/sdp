package as2;
public class ModernChairMaker implements IChairMaker{
    @Override
    public IChair createChair(){
        IChair chair = new ModernChair();
        chair.assemble(Material.METAL);
        return chair;
    }
}