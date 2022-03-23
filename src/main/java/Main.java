import java.util.ArrayList;

public class Main {
    public static ArrayList<Client> clients = new ArrayList<Client>();
    public static ArrayList<Card> cards = new ArrayList<Card>();
    public static Date currentDate = new Date(10,10,2020);

    public static void importClients(){}

    public static void importCards(){}

    public static void main(String[] args) {
        cards.add(new Card(1,1, new Date(10,10,2010),new Date(10,10,2020)));
        if (currentDate.compareDates(cards.get(0).expiryDate) == 0)
            System.out.println("kyfe");
    }
}
