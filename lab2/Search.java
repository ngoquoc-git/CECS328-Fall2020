//Author: Quoc Ngo, Fiona Le, Marie Payad
//Project: Lab 2
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;

public class Search{
    /**
     * Search algorithm is executed here
     * @param args pass read file and given string
     */
    public static void main(String[] args){
        int arr[] = new int[26];
        ArrayList <String> inputStorage = new ArrayList <String>();
        
        tableConvertor(arr, args[1]);
        readTxt(args[0], inputStorage);
        
        for (int i = 0; i < inputStorage.size(); i++){
            //Eleminate strings that are longer or shorter than the searched string to avoid cases
            if (args[1].length() == inputStorage.get(i).length()){
                int arr2[] = new int[26];
                tableConvertor(arr2, inputStorage.get(i));
                //break loop if a similar string is found
                if (isEqual(arr, arr2)){
                    System.out.println("Found search string: "+ inputStorage.get(i));
                    System.out.println("Line number: " + (i + 1));
                    break;
                }
            }
            //If no similar string is found 
            if(i == (inputStorage.size() - 1)) System.out.println("String not found");
        }
    }

    /**
     * Turn a string to a table of int array contain 26 alplabetical letters
     * @param arr The converted table is stored
     * @param str receive the string to convert
     */
    public static void tableConvertor(int[] arr, String str){
        //convert every character of the string to integer
        int charNum;
        //convert string to lower case
        str = str.toLowerCase();
        
        //Read every letter of the string to turn to the table format
        for (int i = 0; i < str.length(); i++){
            charNum = str.charAt(i) - 97;
            arr[charNum]++;
        }
    }

    /**
     * Read through the input text file
     * @param txtName name of the file to be read
     * @param inputs Stored strings in array list inputs
     */
    public static void readTxt(String txtName, ArrayList<String> inputs){
        try {
            File myFile = new File(txtName);
            Scanner reader = new Scanner(myFile);

            while (reader.hasNextLine()) {
              inputs.add(reader.nextLine());
            }
            reader.close();
          } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
            e.printStackTrace();
          }
    }

    /**
     * Check if two strings are similar
     * @param arr1 receive first string to compare
     * @param arr2 compare to string 1
     * @return true if they are similar, false otherwise
     */
    public static boolean isEqual(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}