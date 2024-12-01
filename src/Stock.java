import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Stock {
   
    private ArrayList<StockPrice> stockPriceData; 
    private String URL;
    private String APIkey;
    private String Symbol; 

    Stock(String URL){
        try{
            FileReader ApiFile = new FileReader("../API.key");
            BufferedReader reader = new BufferedReader(ApiFile);
            URL = reader.readLine();
            APIkey = reader.readLine();
            reader.close();
        }catch(Exception e){
            URL = "";
            APIkey = "";
            e.printStackTrace();
        }
    }



    public ArrayList<StockPrice> getstockPriceData(){
        return this.stockPriceData;
    }

}
