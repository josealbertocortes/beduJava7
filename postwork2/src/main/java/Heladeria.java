public class Heladeria {
    public static void main(String[] args) {
        Helado suave = new HeladoSuave();


        suave = new CoberturaDecorador(suave);
        suave = new GranolaDecorador(suave);
        suave = new ToppingDecorador(suave);
        suave = new MermeladaDecorador(suave);
        suave = new GalletaDecorador(suave);


        System.out.println("[Ticket de compra]");
        System.out.println(suave.getDescripcion());
        System.out.println("$" + suave.getPrecio());
    }
}