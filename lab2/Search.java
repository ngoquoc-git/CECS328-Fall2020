public class Search{
    public static void main(String[] args){
        int arr[] = new int[25];
        tableConvertor(arr, args[0]);
    }

    public static void tableConvertor(int[] arr, String str){
        
        int charNum;
        
        str = str.toLowerCase();
        
        for (int i = 0; i < str.length(); i++){
            charNum = str.charAt(i) - 97;
            arr[charNum]++;
        }
        for (int n = 0; n < arr.length; n++){
            System.out.print(arr[n] + " ");
        }
    }

    
}