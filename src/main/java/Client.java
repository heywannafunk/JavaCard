public class Client {
    int id;             //идентификатор клиента банка
    String name;        //имя клиента
    Date dateOfBirth;   //дата рождения клиента

    public Client(int i, String n, Date dOfBirth){
        this.id = i;
        this.name = n;
        this.dateOfBirth = dOfBirth;
    }
}
