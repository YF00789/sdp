package as2;
public class VictorianChair implements IChair{
    private Material material;
    @Override
    public void assemble(Material material){
        if (material==null){throw new InvalidFurnitureStateException("Material cannot be null");}
        if (material==Material.PLASTIC){throw new InvalidFurnitureStateException("Victorian furniture cannot be plastic");}
        this.material = material;
    }
    @Override
    public void sitOn(){System.out.println("Sitting on victorian chair made of "+material.name());}
}