import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class Search{
    public static void main(String[] args){
        int arr[] = new int[25];
        tableConvertor(arr, args[1]);
        
    }

    /**
     * Turn a string to a table of int array contain 26 alplabetical letters
     * @param arr pass the array here
     * @param str receive the string to convert
     */
    public static void tableConvertor(int[] arr, String str){
        
        int charNum;
        
        str = str.toLowerCase();
        
        //Read every letter of the string to turn to the table format
        for (int i = 0; i < str.length(); i++){
            charNum = str.charAt(i) - 97;
            arr[charNum]++;
        }

        //Test display - will delete
        for (int n = 0; n < arr.length; n++){
            System.out.print(arr[n] + " ");
        }
    }

    public static void readTxt(String txtName){
        try {
            File myFile = new File(txtName);
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
              String data = reader.nextLine();
              System.out.println(data);
            }
            reader.close();
          } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
            e.printStackTrace();
          }
    }
}