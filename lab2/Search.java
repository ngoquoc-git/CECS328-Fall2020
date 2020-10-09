import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;

public class Search{
    public static void main(String[] args){
        int arr[] = new int[26];
        ArrayList <String> inputStorage = new ArrayList <String> ();
        
        tableConvertor(arr, args[1]);
        readTxt(args[0], inputStorage, args[1]);
        for (int i = 0; i < inputStorage.size(); i++){
            if (args[1].length() == inputStorage.get(i).length()){
                int arr2[] = new int[26];
                System.out.println();
                tableConvertor(arr2, inputStorage.get(i));
                if (isEqual(arr, arr2)){
                    System.out.println("Found search string: "+ inputStorage.get(i));
                    System.out.println("Line number: " + (i + 1));
                    break;
                }
            }
            if(i == (inputStorage.size() - 1)) System.out.println("String not found");
        }

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
            System.out.print(charNum + " " + str.charAt(i) + " ");
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
            

            while (reader.hasNextLine()) {

              inputs.add(reader.nextLine());
              
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