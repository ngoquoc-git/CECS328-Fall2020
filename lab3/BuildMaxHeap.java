public class BuildMaxHeap{
    public static void main(String[] args){
        int[] arr = new int[args.length];
        for (int s = 0; s < arr.length; s++){
            arr[s] = Integer.parseInt(args[s]);
        }
        HeapHeight(arr);
        for (int i = (arr.length/2 - 1); i > -1; i--){
            MaxHeap(arr, i);
        }
        System.out.print("Max Heap Array: ");
        for (int n = 0; n < arr.length; n++){
            System.out.print(arr[n] + " ");
        }
    }

    public static void MaxHeap(int[] args, int index){
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        int temp;

        if (left < args.length && args[left] > args[index]) largest = left;
        
        if (right < args.length && args[largest] < args[right]) largest = right;

        if (largest != index){
            temp = args[index];
            args[index] = args[largest];
            args[largest] = temp;
            MaxHeap(args, largest);
        }
    }

    public static void HeapHeight(int[] args){
        int height = (int)(Math.log(args.length)/ Math.log(2));
        System.out.println("Height: " + height);
    }
}