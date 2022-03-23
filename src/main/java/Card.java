public class Card {
    int ownerId;    //идентификатор владельца карты
    int number;     //номер карты
    Date issueDate; //дата выдачи
    Date expiryDate;//дата окончания действия

    public Card(int oID, int n, Date iDate, Date eDate){
        this.ownerId = oID;
        this.number = n;
        this.issueDate = iDate;
        this.expiryDate = eDate;
    }
}
