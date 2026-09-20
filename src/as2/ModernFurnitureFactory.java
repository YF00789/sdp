package as2;
public class ModernFurnitureFactory implements IFurnitureFactory{
    @Override
    public IChair createChair(){
        IChair chair = new ModernChair();
        chair.assemble(Material.METAL);
        return chair;
    }
    @Override
    public ITable createTable(){
        ITable table = new ModernTable();
        table.assemble(Material.METAL);
        return table;
    }
}