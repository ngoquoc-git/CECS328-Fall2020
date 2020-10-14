public class insertionSort {
    public static void main(String[] args) {
        //initialize all used variables
        int[] comparisons = new int[args.length];
        int i, compareTimes;
        String sortKey, unsortedElement;
        //Create compInOrder to display the final product in order as professor's output
        String[] compInOrder = new String[args.length];
        compInOrder = args.clone();

        //Start reading from the 2nd elemnet of args since the first one is sorted
        for (int key = 1; key < args.length; key++){
            compareTimes = 0;
            sortKey = args[key];
            //Eliminate the last character of String at k position
            unsortedElement = sortKey.substring(0, sortKey.length() - 1); 
            i = key - 1;
            
            //Case 1: unsorted element is larger or equal to the right-most sorted element
            if ((args[i].substring(0, args[i].length() - 1).compareTo(unsortedElement) <= 0)){ 
                compareTimes++;                                                
                comparisons[key] = compareTimes;                                                 
            }

            //Case 2: unsorted element is smaller than the right-most sorted element, changing happens  
            while (i >= 0 && ((args[i].substring(0, args[i].length() - 1).compareTo(unsortedElement) > 0))){
                compareTimes++;
                comparisons[key] = compareTimes;
                args[i + 1] = args[i];
                i -=1;
                
                //case 2.1: compare the second highest with the unsorted element
                if ((i >= 0 && args[i].substring(0, args[i].length() - 1).compareTo(unsortedElement) <= 0)){ 
                    compareTimes++;                                                           
                    comparisons[key] = compareTimes;                                                     
                }             
            }
            args[i+1] = sortKey;
        }

        //Display the sorted String array
        for (int n = 0; n < args.length; n++){ 
            System.out.print(args[n] + "\t");
        }

        System.out.print("\n");
        
        //Display final result in order
        for (int n = 1; n < compInOrder.length; n++){ 
            System.out.println(compInOrder[n] + " " + comparisons[n]);
        }
    }
}
