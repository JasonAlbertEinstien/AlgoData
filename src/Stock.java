import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;


public class Stock {
   
    private ArrayList<StockPrice> stockPriceData; 
    private String url;
    private String APIkey;
    private String Symbol; 
    private String apiURL;

    Stock(String Symbol){
        this.Symbol = Symbol;
        try{
            readAPIFile();
            setApiURL();
            setPriceData();
        }catch(Exception e){
            url = null;
            APIkey = "";
            e.printStackTrace();
        }
    }

    public ArrayList<StockPrice> getstockPriceData(){
        return this.stockPriceData;
    }

    public void setPriceData() throws Exception{
        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(apiURL))
            .build();
        HttpResponse<String> response = HttpClient.newHttpClient()
            .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    
    }

    // private methods
    private void readAPIFile() throws Exception{
        FileReader ApiFile = new FileReader("../API.key");
        BufferedReader reader = new BufferedReader(ApiFile);
        url =  reader.readLine();
        APIkey = reader.readLine();
        reader.close();
    }

    private void setApiURL(){
        apiURL = url +"&symbol="+ this.Symbol + "&apikey="+this.APIkey;
        System.out.println(apiURL);
    }

}
