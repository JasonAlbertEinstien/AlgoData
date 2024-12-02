package algodata;


import java.time.LocalDate;

public class Price {
    private double price;
    private LocalDate date;

    public double getPrice(){
        return this.price;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

}
