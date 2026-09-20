package as2;
public class FurnitureStore{
    private final IChair chair;
    private final ITable table;
    public FurnitureStore(IFurnitureFactory factory){
        if (factory==null){throw new IllegalArgumentException("FurnitureFactory cannot be null");}
        this.chair = factory.createChair();
        this.table = factory.createTable();
    }
    public void displayRoom(){
        chair.sitOn();
        table.placeItems();
    }
}