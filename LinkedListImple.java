import java.util.Iterator;

class LinkedList<T> implements Iterable<T>{
    // need a node that has a data and a next reference variable datatype.
    class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    LinkedList()
    {
        head=null;
    }
    public void insertAtBeg(T data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void insertAtPos(T data,int pos)
    {
        if(pos==0)
        {
            insertAtBeg(data);
            return;
        }
        Node temp = head;
        int ctr=0;
        while(ctr!=pos-1)
        {
            temp = temp.next;
            if(temp==null)
            {  // suppose there is 5 value and i give 8 as position
                System.out.println("Position OverBound for value : "+pos);
                return;
            }
            ctr++;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void insertLast(T data)
    {
        Node temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }
    public void display()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public int get(T data)
    {
        Node temp = head;
        int index=0;
        while(temp!=null)
        {
            if(temp.data==data)
            {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }
    public void deleteAtBeg() {
        head = head.next;
    }
    public void deleteAtPos(int pos)
    {
        Node temp = head;
        int ctr=0;
        if(pos==0){
            deleteAtBeg();
            return;
        }
        while(ctr!=pos-1)
        {
            temp = temp.next;
            if(temp==null)
            {  // suppose there is 5 value and i give 8 as position
                System.out.println("Position OverBound for value : "+pos);
                return;
            }
            ctr++;
        }
        // temp will be as previous node to the deleting node.
       temp.next = temp.next.next;
    }
    public void updateAtPos(int position, T newValue) {
        Node temp = head;
        int ctr=0;
        while(ctr!=position)
        {
            temp=temp.next;
            if(temp==null)
            {
                System.out.println("Position OverBound for value : "+position);
                return;
            }
            ctr++;
        }
        temp.data = newValue;
    }
    @Override
    public Iterator iterator() {
       return new Iterator<T>(){
        Node temp = head;
        public boolean hasNext() {
            return temp!=null;
        }

        @Override
        public T next() {
            T data = temp.data;
            temp = temp.next;
            return data;
        }
        
       };
    }

}
public class LinkedListImple {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>(); // accepts object too.

        list.insertAtBeg(1);
        list.insertAtBeg(2);

        list.insertAtPos(3, 1);
        list.display();

        System.out.println("1 is present in indexPos : "+list.get(1));  // if not presents returns "-1"

        list.deleteAtBeg();
        list.display();

        list.deleteAtPos(1);
        list.display();

        list.updateAtPos(0,4);
        list.display();

        list.insertLast(5);

        // same to arrays if i need to use forEach or iterator then need to implement iterator interface.
        Iterator it = list.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next()+"->");
        }
        System.out.println("null");
    }
}
