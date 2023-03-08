public class Postwork1 {
  public static void main(String [] args) {
    System.out.println("Sumando los primeros 100 números");
    int suma = 0;

    for(int i=1;i<=100; i++){
      suma+=i;
    }

    System.out.println(String.format("La suma es %d", suma));

  }
}
