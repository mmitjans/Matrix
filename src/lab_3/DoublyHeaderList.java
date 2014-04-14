/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab_3;

public class DoublyHeaderList<T> {
       /**
     * This class represents the node.
     * @param <T> Type of data the node is going to store
     */
    public class DoublyHeaderListNode<T>
    {
        public T data;
        public int rowIndex;
        public int columnIndex;
        
        public DoublyHeaderListNode<T> previous;
        public DoublyHeaderListNode<T> next;
        
        /**
         * Constructor of this class. Initialize previous, next and data
         * @param previous Pointer to the previous element
         * @param next Pointer to the next element
         * @param data Data to store
         * @param rowIndex
         * @param columnIndex
         */
        public DoublyHeaderListNode(DoublyHeaderListNode<T> previous,
                                    DoublyHeaderListNode<T> next,
                                    T data, int rowIndex, int columnIndex)
        {
            this.previous = previous;
            this.next = next;
            this.data = data;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
        
        public DoublyHeaderListNode(T data, int rowIndex, int columnIndex)
        {
            this.data = data;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
        
        /**
         * Constructor that initializes to null the next and previous pointer 
         * and sets the data
         * @param data 
         */
        public DoublyHeaderListNode(T data) {
            this.previous = null;
            this.next = null;
            this.data = data;
        }
    }
    
        // Pointer Head
    private DoublyHeaderListNode<T> head;
    
       /**
     * Constructor of this class. It initializes the header node.
     */
    public DoublyHeaderList()
    {
        this.head = new DoublyHeaderListNode<T>(null);
        this.head.next = this.head;
        this.head.previous = this.head;
    }
    
    /**
     * Returns if the dequeue is empty
     * @return True when the Dequeue is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (this.head.next == this.head);
    }
    
    /**
     * This method adds to the right the data in the dequeue
     * @param data Data to insert
     */
    public void addRight(T data, int atRow, int atColumn)
    {
        insertAtEnd(data, atRow, atColumn);
    }
    
    /**
     * This method inserts the data into the next pointer by the node.
     * @param data Data to store
     * @param node Node that this data is pointing to
     */
    public void insertAtEnd(T data, int atRow, 
                            int atColumn)
    {
        DoublyHeaderListNode<T> newNode = 
                new DoublyHeaderListNode<T>(data, atRow, atColumn);
        
        if(this.head == null)
        {
            newNode.next = newNode;
            newNode.previous = newNode;
            
            head = newNode;
        } else {
            DoublyHeaderListNode<T> tempNode = head.previous;
            
            tempNode.next = newNode;
            newNode.next = head;
            head.previous = newNode;
            newNode.previous = tempNode;
        }
        
    }
    
    public void insertAtBeginning(T data, int atRow, int atColumn)
    {
        DoublyHeaderListNode<T> newnode = 
                new DoublyHeaderListNode<T>(data, atRow, atColumn);
        if (head == null) {
            newnode.next = newnode;
            newnode.previous = newnode;
            head = newnode;
        } else {
            DoublyHeaderListNode<T> temp = head.previous;
            temp.next = newnode;
            newnode.previous = temp;
            newnode.next = head;
            head.previous = newnode;
            head = newnode;
        }
    }
    
    public int getSize() {
        int count = 0;
        if (head == null)
            return count;
        else {
            DoublyHeaderListNode<T> temp = head;
            do {
                temp = temp.next;
                count++;
            } while (temp != head);
        }
        return count;
    }
    
    public void insertAtPosition(T data, int atRow, int atColumn) {
        if( atRow < 0 || atRow == 0 )
        {
            insertAtBeginning(data, atRow, atColumn);
        }  
        
        else if(atRow > getSize()|| atRow == getSize()){
            insertAtEnd(data, atRow, atColumn);
        }else{
            
            DoublyHeaderListNode<T> temp= head;
            DoublyHeaderListNode<T> newNode = new DoublyHeaderListNode<T>(data);
            for(int i=0;i<atRow;i++){
                temp=temp.next;
            }
            
            newNode.next = temp.next;
            temp.next.previous = newNode;
            temp.next = newNode;
            newNode.previous = temp;
        }
    }
    
    /**
     * This method removes from the front the data
     * @return Returns the data removed
     */
    public T removeFront()
    {
        DoublyHeaderListNode<T> firstElement = this.head.next;
        
        if(firstElement == null)
        {
            throw new RuntimeException("List is empty");
        }
        
        firstElement.previous.next = firstElement.next; 
        firstElement.next.previous = firstElement.previous; 
        firstElement.previous = firstElement.next = null; 

        return firstElement.data;
    }
}
