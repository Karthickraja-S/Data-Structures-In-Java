import java.util.*;
class DynamicArray<T> implements Iterable<T>{       
    // <T> accepts any type like Integer,float,object we can store in array.
    // Iterable is used to iterate the class obj's using forEach and iterator.
    static final int INITIAL_CAPACITY=6;
    T arr[];
    int size;
    int capacity;

    @SuppressWarnings("unchecked")
    DynamicArray()
    {
        arr = (T[]) new Object[INITIAL_CAPACITY];
        size=0;
        capacity = INITIAL_CAPACITY;
    }
    void display()
    {
        if(size==0)System.out.println("No elements is added.");
        else
        {
            System.out.println("Array size : "+arr.length+"\nElements in the Array : "+size);
            System.out.println("ARRAY ELEMENTS ARE LISTED");
            for(int i=0;i<size;i++)
            {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
    void add(int pos , T element)
    {
            for(int i=size;i>pos;i--)
            {
                arr[i] = arr[i-1];
            }
            arr[pos] = element;
            size++;
            if(size == capacity)
            {
                // we need to extend the array...
                System.out.println("INFO : Limit Reached . Extending the Array Size to Double");
                capacity = capacity*2;
                arr = Arrays.copyOf(arr, capacity);
            }
    }
    void delete(int pos)
    {
        if(pos>size || pos<0 || size==0)
        {
            System.out.println("Invalid input.");
        }
        else
        {
            for(int i=pos;i<size;i++)
            {
                arr[i] = arr[i+1];
            }
            size--;
        }
        // after deletion THINK : if the array is extended and if i delete more element , then the
        // extra space is waste.. so shrinking the array will be best.
        if(capacity > INITIAL_CAPACITY && capacity > 3*size)
        {
            capacity = capacity/2;
            arr = Arrays.copyOf(arr, capacity);
        }
    }
    void search(T ele)     // T is type Paramter accepts all type.
    {
        boolean found=false;
        for(int i=0;i<size;i++)
        {
            if(arr[i]==ele)
            {
                found = true;
                System.out.println("The element is found in the index : "+i);
            }
        }
        if(!found)System.out.println("No such element found in the array.");
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            int index=0;
            public T next()
            {
                return arr[index];
            }
           public boolean hasNext()
           {
                return index<size;
           }
        };
    }
}
public class ArrayImplementation{
    public static void main(String[] args) {

        Scanner ip = new Scanner(System.in);
        // By doing DynamicArray as T , we can add element like integer,float,object
        // similar to the ArrayList...
        DynamicArray<Integer> array = new DynamicArray<Integer>();

        while(true)
        {
            System.out.println("              --------- MENU --------               ");
            System.out.println("1-Display;\n2-Add with given index value;\n3-Remove with index value;\n4-Search an element;\n5-quit");
            int ch = ip.nextInt();
            switch(ch)
            {
                case 1:
                    array.display();
                    // if i want to display using forEach loop then i need to implement iterator
                    // in my class..
                    break;
                case 2:
                    System.out.println("Enter position to add (starts with 0)  : ");
                    int pos = ip.nextInt();
                    if(pos>array.size || pos<0){
                        System.out.println("Invalid Position.");
                        break;
                    }
                    System.out.println("Enter element to insert : ");
                    int element = ip.nextInt();
                    array.add(pos,element);
                    break;
                case 3:
                    System.out.println("Enter position to delete (starts with 0)  : ");
                    int poss = ip.nextInt();
                    array.delete(poss);
                    break;
                case 4:
                    System.out.println("Enter element to search : ");
                    int num = ip.nextInt();
                    array.search(num);
                    break;
                case 5:
                    ip.close();
                    System.exit(0);
            }
        }
        
    }
}