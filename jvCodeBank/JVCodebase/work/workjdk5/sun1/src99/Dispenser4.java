   public class Dispenser4 {
      public static void main(String[] args) {
        CoinValueVisitor cvv = new CoinValueVisitor();
       for (Coin4 coin: Coin4.values())  {
         coin.accept(cvv);
       }
     }
   }
