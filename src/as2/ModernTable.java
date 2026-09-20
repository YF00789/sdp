package as2;
public class ModernTable implements ITable{
    private Material material;
    @Override
    public void assemble(Material material){
        if (material==null){throw new InvalidFurnitureStateException("Material cannot be null");}
        this.material = material;
    }
    @Override
    public void placeItems(){System.out.println("Placing items on modern table made of "+material.name());}
}