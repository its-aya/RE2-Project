package real.estate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class namely RE2 was created
 * Contains array list XnY and SlopeIntercept 
 * Different readers to import the file Property
 * 
 */
public class RE2 {
//Array list 'XnY' and 'SlopenIntercept' were declared
//XMean and YMean floats were declared
    static ArrayList<Property> XnY = new ArrayList();
    static ArrayList<Double> SlopenIntercept = new ArrayList<Double>();
    private Float XMean;
    private Float YMean;

//The file Property was read with the help of improted FileReader, BufferedTeader, and Scanner
    static ArrayList<Property> readDataLineByLine(String file) throws FileNotFoundException {
        Scanner fileinput = new Scanner(new BufferedReader(new FileReader(file)));
        ArrayList<Property> mydata = new ArrayList();
        while (fileinput.hasNextLine()) {
            Property toAdd = new Property();

            String newline = fileinput.nextLine();

            String[] line = newline.trim().split(",");

            toAdd.setPrice(Double.parseDouble(line[4]));
            toAdd.setAddress(Double.parseDouble(line[9]));

            toAdd.setLandsize(Double.parseDouble(line[13]));

//            System.out.println(line[4]);
//            System.out.println(line[9]);
//            System.out.println(line[13]);

            mydata.add(toAdd);

        }

        return mydata;

    }

    /**
     *
     * @param args To store string type arguments in a string array that can be accessed from anywhere
     * and call this method using the class name.
     * @throws FileNotFoundException- the main method should terminate if an exception occurs
     */
    public static void main(String[] args) throws FileNotFoundException {
    //method to read file line by line to String
        XnY = readDataLineByLine("resources/data.csv");

//        System.out.println(XnY.get(5).getPrice());
//        System.out.println(XnY.get(14).getLandsize());
     
        sum(XnY);
        //getting values from the SlopenIntercept array
        double m = SlopenIntercept.get(0); 
        double c = SlopenIntercept.get(1);

        //Declaring sc as an object of Scanner class
        Scanner sc = new Scanner(System.in);
        System.out.println ("Please enter the Post code: "); 

        //method to read in a string of digits and convert them into int
        int X = sc.nextInt();
        System.out.println("Please enter the land size : ");

        double y = (m * X) + c;
        System.out.println("The price : " + y);

    }

    /**
     *
     * @param SpecificPostCode is an arraylist containing the specific post code which the the user is searching 
     * Sums up all X and Y values separately
     * Finds their means and subtracts it from each value and sums that 
     * Calculates variance and covariance 
     * Uses calculations to find slope and y-intercept 
     * @return
     */
    public static ArrayList<Double> sum(ArrayList<Property> SpecificPostCode) {
        double sumx = 0;
        double sumy = 0; 
        int i;
        for (i = 0; i < SpecificPostCode.size(); i++) {
            sumx = sumx + SpecificPostCode.get(i).getLandsize(); //summation of all land sizes
            sumy = sumy + SpecificPostCode.get(i).getPrice(); //summation of all prices

        }
//        System.out.println("Sum of price = " + sumy);
//        System.out.println("Sum of land size  = " + sumx);
        double n= SpecificPostCode.size();
        double meanx = sumx /n ; //finding the mean of landsizes
        double meany = sumy /n; //finding the mean of prices

//        System.out.println("mean of price = " + meany);
//        System.out.println("mean of land size  = " + meanx);

        double sumxminusm = 0;//summation of all (x-meanx) values
        double sumyminusm = 0;//summation of all (y-meany) values

        double variance = 0;//summation of all (x-meanx)values squared 

        double covariance = 0;//summation of (x-mean) * (y-mean) values 

        for (int q = 0; q < SpecificPostCode.size(); q++) {
            double xminusm = SpecificPostCode.get(q).getLandsize() - meanx; 
            double yminusm = SpecificPostCode.get(q).getPrice() - meany; 

            double xminusmp2 = Math.pow(xminusm, 2); //(landsize values - mean)squared

            sumxminusm = sumxminusm + xminusm;  
            sumyminusm = sumyminusm + yminusm; 

            variance = variance + xminusmp2; 

            covariance = covariance + (xminusm * yminusm);

//            System.out.println("sumxminusm = " + sumxminusm);
//            System.out.println("sumyminusm = " + sumyminusm);
//
//            System.out.println("variance = " + variance);
//            System.out.println("covariance = " + covariance);

        }
        double m = (covariance) / (variance);
        //this is the slope
        double c = meany - (m * meanx);
        //this is the y-intercept 

        SlopenIntercept.add(m);
        SlopenIntercept.add(c);

        System.out.println("m = " + m);
        System.out.println("c = " + c);
        
        
   
        return SlopenIntercept;
}
}

