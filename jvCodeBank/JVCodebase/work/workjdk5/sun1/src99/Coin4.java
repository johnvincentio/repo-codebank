   public enum Coin4 {
     PENNY {
       void accept( CoinVisitor cv) {cv.visitPenny(this);}
     },
     NICKEL {
       void accept( CoinVisitor cv) {cv.visitNickel(this);}
     },
     DIME {
       void accept( CoinVisitor cv) {cv.visitDime(this);}
     },
     QUARTER {
       void accept( CoinVisitor cv) {cv.visitQuarter(this);}
     };
     abstract void accept(CoinVisitor cv);
   }
