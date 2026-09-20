package as2;
public class VictorianTable implements ITable{
    private Material material;
    @Override
    public void assemble(Material material){
        if (material==null){throw new InvalidFurnitureStateException("Material cannot be null");}
        if (material==Material.PLASTIC){throw new InvalidFurnitureStateException("Victorian furniture cannot be plastic");}
        this.material = material;
    }
    @Override
    public void placeItems(){System.out.println("Placing items on victorian table made of "+material.name());}
}