
public class Testtask {

    public static void main(String[] args) {
        Place[] places = {new Place("Исаакиевский собор", 50, 10),
                new Place("Эрмитаж", 80, 11),
                new Place("Кунсткамера", 35, 4),
                new Place("Петропавловская крепость", 100, 7),
                new Place("Ленинградский зоопарк", 90, 15),
                new Place("Медный всадник", 10, 17),
                new Place("Казанский собор", 40, 3),
                new Place("Спас на Крови", 20, 9),
                new Place("Зимний дворец Петра I", 70, 12),
                new Place("Зоологический музей", 55, 6),
                new Place("Музей обороны и блокады Ленинграда", 20, 19),
                new Place("Русский музей", 50, 8),
                new Place("Навестить друзей", 120, 20),
                new Place("Музей восковых фигур", 20, 13),
                new Place("Литературно-мемориальный музей Ф.М. Достоевского", 40, 2),
                new Place("Екатерининский дворец", 15, 5),
                new Place("Петербургский музей кукол", 10, 14),
                new Place("Музей микроминиатюры «Русский Левша»", 30, 18),
                new Place("Всероссийский музей А.С. Пушкина и филиалы", 60, 1),
                new Place("Музей современного искусства Эрарта", 70, 16),};

        int count = places.length;
        int maxTime = 320;

        int[][] Table;
        Table = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            Table[i] = new int[ maxTime + 1];
        }

        for (int k = 0; k <= count; k++) {
            for (int s = 0; s <= maxTime; s++) {
                if (k == 0 || s == 0) {
                    Table[k][s] = 0;
                } else if (s >= places[k - 1].getTime()) {
                    Table[k][s] = Math.max(Table[k - 1][s], Table[k - 1][s - places[k - 1].getTime()] + places[k - 1].getInterest());
                } else {
                    Table[k][s] = Table[k - 1][s];
                }
            }
        }
        getPlaces(Table,places,count,maxTime);


    }
    private static void getPlaces(int [][] Table, Place[] places,int k,int s){
        if (Table[k][s]==0){
            return;
        }
        if (Table[k-1][s]== Table[k][s]){
            getPlaces(Table,places,k-1,s);
        } else{
            getPlaces(Table,places,k-1,s-places[k-1].getTime());
            System.out.println(places[k-1].getName());

        }

    }
}
