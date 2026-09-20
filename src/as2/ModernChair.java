package as2;
public class ModernChair implements IChair{
    private Material material;
    @Override
    public void assemble(Material material){
        if (material==null){throw new InvalidFurnitureStateException("Material cannot be null");}
        this.material = material;
    }
    @Override
    public void sitOn(){System.out.println("Sitting on modern chair made of "+material.name());}
}