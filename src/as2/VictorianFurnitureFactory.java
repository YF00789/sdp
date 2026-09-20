package as2;
public class VictorianFurnitureFactory implements IFurnitureFactory{
    @Override
    public IChair createChair(){
        IChair chair = new VictorianChair();
        chair.assemble(Material.WOOD);
        return chair;
    }
    @Override
    public ITable createTable(){
        ITable table = new VictorianTable();
        table.assemble(Material.WOOD);
        return table;
    }
}