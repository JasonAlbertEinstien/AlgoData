package algodata;


public class BackTest {

    private final double initialAmount;
    private double currentAmount;
    
    BackTest(int initialAmount){
        this.initialAmount = initialAmount;
        currentAmount = initialAmount;
    }

    public void setCurrentAmount(double currentAmount){
        this.currentAmount = currentAmount;
    }

    public double getInitialAmount(){
        return initialAmount;
    }

    public double getcurrentAmount(){
        return this.currentAmount;
    }

    public double getpercentageReturn(){
        double percentageReturn = (currentAmount - initialAmount)/initialAmount;
        return percentageReturn;
    }
    
}