public class Date {
    int day;
    int month;
    int year;

    public Date(int d, int m, int y){
        this.day = d;
        this.month = m;
        this.year = y;
    }

    //компаратор дат
    public int compareDates(Date y){
        if (this.year > y.year)
            return 1;
        else if (this.year < y.year)
            return -1;
        else
            if (this.month > y.month)
                return 1;
            else if (this.month < y.month)
                return -1;
            else
                if (this.day > y.day)
                    return 1;
                else if (this.day < y.day)
                    return -1;
                else
                    return 0;
    }
}
