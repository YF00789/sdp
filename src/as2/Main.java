package as2;
public class Main{
    public static void main(String[] args){
        System.out.println("Part A");
        IChairMaker modernMaker = new ModernChairMaker();
        IChair modernChair = modernMaker.createChair();
        modernChair.sitOn();
        IChairMaker victorianMaker = new VictorianChairMaker();
        IChair victorianChair = victorianMaker.createChair();
        victorianChair.sitOn();

        System.out.println("\nPart B");
        IFurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureStore modernStore = new FurnitureStore(modernFactory);
        modernStore.displayRoom();
        IFurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        FurnitureStore victorianStore = new FurnitureStore(victorianFactory);
        victorianStore.displayRoom();
    }
}