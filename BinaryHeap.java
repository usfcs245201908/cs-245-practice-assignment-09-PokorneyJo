public class BinaryHeap
{
    int[] arr = new int[10];
    int size = 0;

    public void add(int priority){
        if(size+1 > arr.length)
            grow_array();
        arr[size++] = priority;
        int child = size-1;
        int parent = (child-1)/2;
    
        while(parent >= 0 && arr[parent] > arr[child]){
            swap(arr, parent, child);
            child = parent;
            parent = (child-1)/2;
        }
    }

    public int remove(){
        int temp = arr[0];
        arr[0] = arr[--size];
        siftdown(0);
        return temp;
    }

    private void siftdown(int parent){
        int child = parent*2 + 1;
        if(child < size && child+1 < size && arr[child+1] < arr[child])
            child = child+1;
        if(child < size && arr[parent] > arr[child]){
            swap(arr, child, parent);
            siftdown(child);
        }
    }

    private void swap(int[] a, int index1, int index2){
        int tempValue = a[index1];
        a[index1] = a[index2];
        a[index2] = tempValue;
    }

    private void grow_array(){
        int [] newArr = new int[arr.length*2];
        System.arraycopy(arr, 0, newArr, 0 , arr.length);
        arr = newArr;
    }

}