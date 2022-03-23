public class Place {
   private int  time;
   private int   interest;
   private String name;

public Place(String name, int time, int interest){
   this.interest = interest;
   this.time = time;
   this.name = name;
}
   public String getName() {
      return name;
   }

   public int getTime() {
     return time;
   }

   public int getInterest() {
      return interest;
   }
}


