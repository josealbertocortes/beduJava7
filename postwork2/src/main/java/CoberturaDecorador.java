public class CoberturaDecorador implements Helado{
    private Helado helado;

    public CoberturaDecorador(Helado helado){
        this.helado = helado;
    }

    @Override
    public String getDescripcion(){
        return helado.getDescripcion() + ", con Cobertura Extra";
    }

    public int getPrecio(){
        return helado.getPrecio() + 20;
    }

}