import java.util.ArrayList;

public class StatsLibrary {
    DataInput data = new DataInput();
    /*Global Variables
    private int n;
    private int x;
    private int middle;
    private int maxNum;
    private int count;

    private double sum;
    private double mean;
    private double sqrsum;
    private double variance;
    private double stnddev;
    private double median;
    private double mode;
    private double number;

    private ArrayList<Double> dataset;
    private ArrayList<Double> deviation;
    private ArrayList<Double> sqrDeviation;
    private ArrayList<Double> modeList;
    

    //Constructor
    public StatsLibrary(){
        //Ints
        n = 0;
        x = 0;
        middle = 0;
        maxNum = 0;
        mode = 0;
        count = 0;
        //Doubles
        sum = 0;
        mean = 0;
        sqrsum = 0;
        variance = 0;
        stnddev = 0;
        median = 0;
        number = 0;
        //Arrays
        dataset = new ArrayList<>();
        deviation = new ArrayList<>();
        sqrDeviation = new ArrayList<>();
        modeList = new ArrayList<>();
    }*/



    //Gets the dataset from DataInput Class
    public ArrayList<Double> getDataSet(){
        dataset = data.dataInput();
        n = dataset.size();
        return dataset;
    }

    //This prints out your dataset
    public void printDataset(){
        if(n==0){
            getDataSet();
        }
        System.out.println("This is your dataset: ");
        for(double num : dataset){
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    //This prints out your sorted dataset
    public void printSortedDataset(){
        if(n==0){
            getDataSet();
        }
        dataset.sort(null);
        System.out.println("This is your  sorted dataset: ");
        for(double num : dataset){
            System.out.print(num + ", ");
        }
        System.out.println();
    }




    //Finds the mean of your dataset
    public double mean(){
        if (n==0){
            getDataSet();
        }
        sum = 0;
        for (double numbers : dataset){
            sum += numbers;
        }
        mean = sum/n;
        return mean;
    }
    public double getMean(){
        if(mean == 0){
            mean();
        }
        return mean;
    }
    //Prints the Mean
    public void printMean(){
        System.out.println("This is your Mean: " + mean());
    }
    public String printedMean(){
        if(mean == 0){
            mean();
        }
        return ("This is your mean: " + mean);
    }



    //This finds your variance
    public double variance(){
        if(mean == 0){
            mean = mean();
        }
        deviation.clear();
        sqrDeviation.clear();
        //This subtracts the mean
        for(double numbers : dataset){
            numbers = numbers - mean;
            deviation.add(numbers); 
        }
        //Squares the subtracted values and adds them to a new list
        for(double num : deviation){
            num = Math.pow(num, 2);
            sqrDeviation.add(num);
        }
        //This adds squared values together
        sqrsum = 0;
        for(double num : sqrDeviation){
            sqrsum += num;
        }
        //This finds the Variance
        x = n - 1;
        variance = sqrsum/x;
        return variance;
    }

    //This prints the variance
    public void printVariance(){
        System.out.println("This is your variance: " + variance());
    }



    //This finds the Standard Deviation
    public double standardDev(){
        if (mean == 0){
            variance = variance();
        }else if (variance == 0) {
            variance = variance();
        }
        stnddev = Math.sqrt(variance);
        return stnddev;
    }

    //This prints the standard deviation
    public void printStandardDev(){
        System.out.println("This is your standard Deviation: " + standardDev());
    }



    //This finds your median
    public double median(){
        if (n==0){
            getDataSet();
        }
        dataset.sort(null);
        if (n % 2 == 1){
            middle = n/2;
            median = dataset.get(middle);
        }else if(n % 2 == 0){
            median = (dataset.get((n-1)/2)+dataset.get(n/2))/2.0;
        }
        return median;
    }
    
    //This prints your median
    public void printMedian(){
        System.out.println("This is the median of your dataset: " + median());
    }

    public String printedMedian(){
        return ("This is the median of your dataset: " + median());
    }



    //This will get the mode of your dataset
    public double mode(){
        modeList.clear();
        if (n==0){
            getDataSet();
        }
        for(double values : dataset){
            modeList.add(values);
        }
        for(int i = 0; i < dataset.size(); i++){
            number = dataset.get(i);
            count = 0;
            for (double value : modeList){
                if (value == number){
                    count++;
                }
            }
            if (count > maxNum){
                maxNum = count;
                mode = number;
            }
        }

        return mode;
    }

    //This prints the mode
    public void printMode(){
        System.out.println("The mode of your dataset was: " + mode());
    }
}