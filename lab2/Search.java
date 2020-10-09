import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;

public class Search{
    public static void main(String[] args){
        int arr[] = new int[25];
        ArrayList <String> inputStorage = new ArrayList <String> ();
        tableConvertor(arr, args[1]);
        readTxt(args[0], inputStorage, args[1]);

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

    public static void readTxt(String txtName, ArrayList<String> inputs, String mainInput){
        try {
            File myFile = new File(txtName);
            Scanner reader = new Scanner(myFile);
            int i = 0;
            String temp;

            while (reader.hasNextLine()) {

              temp = reader.nextLine();
              if(mainInput.length() == temp.length()){
               inputs.add(temp);
              }
              
              
              i++;
            }
            for(int n = 0; n < inputs.size(); n++){
                System.out.print("\n" + inputs.get(n));
            }

            reader.close();
          } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
            e.printStackTrace();
          }
    }

    public static boolean isEqual(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}