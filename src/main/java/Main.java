import java.io.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Client> clients = new ArrayList<Client>();   //список клиентов
    public static ArrayList<Card> cards = new ArrayList<Card>();         //список карт
    public static Date currentDate = new Date(10,10,2020);      //текущая дата

    //возвращает клиента по идентификатору
    public static Client getClientById(int id){
        for (Client c : clients){
            if (c.id==id)
                return c;
        }
        return null;
    }

    //импортирует данные о клиентах из файла
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

    //импортирует данные о картах из файла
    public static void importCards(){
        try {
            File file = new File("src/main/java/cards.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String nextOwner = reader.readLine();

            int ownerId;
            String number;
            int dI;
            int mI;
            int yI;
            int dE;
            int mE;
            int yE;

            while (nextOwner != null) {
                ownerId = Integer.parseInt(nextOwner);
                number = reader.readLine();
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

    //записывает в файл уведомление клиента об истечении срока действия его карты
    public static void notifyClient(){
        try(FileWriter writer = new FileWriter("src/main/java/notifications.txt", false))
        {
            String note;
            for (Card c : cards){
                if (c.expiryDate.compareDates(currentDate) == 0){
                    note = getClientById(c.ownerId).name + ", срок действия вашей карты номер " + c.number + " истёк.";
                    writer.write(note);
                }
            }
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    //основная программа
    public static void main(String[] args) {
        importClients();
        importCards();
        notifyClient();
    }
}
