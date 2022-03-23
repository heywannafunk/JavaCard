import java.io.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Client> clients = new ArrayList<Client>();
    public static ArrayList<Card> cards = new ArrayList<Card>();
    public static Date currentDate = new Date(10,10,2020);

    public static void importClients(){
        try {
            File file = new File("src/main/java/clients.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String nextId = reader.readLine();

            int id;
            String name;
            int d;
            int m;
            int y;
            Client c;
            while (nextId != null) {
                id = Integer.parseInt(nextId);
                name = reader.readLine();
                d = Integer.parseInt(reader.readLine());
                m = Integer.parseInt(reader.readLine());
                y = Integer.parseInt(reader.readLine());
                clients.add(new Client(id, name, new Date(d,m,y)));
                nextId = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importCards(){
        try {
            File file = new File("src/main/java/cards.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String nextOwner = reader.readLine();

            int ownerId;
            int number;
            int dI;
            int mI;
            int yI;
            int dE;
            int mE;
            int yE;

            while (nextOwner != null) {
                ownerId = Integer.parseInt(nextOwner);
                number = Integer.parseInt(reader.readLine());
                dI = Integer.parseInt(reader.readLine());
                mI = Integer.parseInt(reader.readLine());
                yI = Integer.parseInt(reader.readLine());
                dE = Integer.parseInt(reader.readLine());
                mE = Integer.parseInt(reader.readLine());
                yE = Integer.parseInt(reader.readLine());
                cards.add(new Card(ownerId,number,new Date(dI,mI,yI), new Date(dE, mE, yE)));
                nextOwner = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        importClients();
        importCards();
    }
}
