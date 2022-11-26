
public class Pokupki {
    String title;
    String date;
    Integer sum;


    public Pokupki(String title, String date, Integer sum) {
        this.title = title;
        this.date = date;
        this.sum = sum;
    }

    public String getTitle() {
        return title;
    }

    public int getSum() {
        return sum;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Pokupki{" +
                "title='" + title + '\'' +
                ", date=" + date + '\'' +
                ", sum=" + sum + '\'' +
                '}';
    }
}