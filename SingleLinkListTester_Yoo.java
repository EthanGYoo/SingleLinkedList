import java.util.NoSuchElementException;



class SingleLinkListTester_Yoo{
   public static void main(String[] args){
      SingleLinkedList list = new SingleLinkedList();
      list.addFirst(1);
      System.out.println("First element of list: " + list.get(0));
      list.addFirst(2);
      System.out.println("First element of list: " + list.get(0));
      list.addLast(3);
      list.addLast(4);
      System.out.println("Last element of list: " + list.get(list.size()-1));
      System.out.println("Last element of list removed: " + list.removeLast());
      System.out.println("Last element of list: " + list.get(list.size()-1));
      System.out.println("Second element of list: " + list.get(1));
      list.add(1, 5);
      System.out.println("Second element of list: " + list.get(1));
      System.out.println("Third element of list removed: " + list.remove(2));
      System.out.println("Third element of list: " + list.get(2));
      System.out.println("Size of list: " + list.size());
   }
}

class SingleLinkedList<E> {

	private Node first;
   private Node last;
   private int size = 0;
   
	private class Node 	{ 
		public E data;
		public Node next;
	}
	
	public SingleLinkedList() {
		first = null;
      last = null;
	}
	
	/**
	* @return the first element in the linked list
	*/	
	public E getFirst() {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}
	
	/**
	* Removes the first element in the linked list.
	* @return the removed element
	*/
	public E removeFirst() {
		if (first == null)
			throw new NoSuchElementException();
		E element = first.data;
		first = first.next;
      size--;
		return element;
	}

	/**
	* Adds an element to the front of the linked list.
	* @param element the data to store in the linked list
	*/
	public void addFirst(E element)  {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
      size++;
      if (size == 1) last = first;
	}
	
   public void addLast(E e){
      size++;
      Node newNode = new Node();
      newNode.data = e;
      newNode.next = null;
      last.next = newNode;
      last = newNode;
   }
   
   public E removeLast(){
      if (first == null) throw new NoSuchElementException();
      E removed = first.data;
      if (first.next == null){
         first = null;
         return removed;
      }
      Node current = first;
      while (true){
         if (current.next.next == null){
            removed = current.next.data;
            current.next = null;
            break;
         }
         else current = current.next;
      }
      size--;
      return removed;
   }
   
   public E get(int index){
      if (index < 0 || first == null) throw new NoSuchElementException();
      Node current = first;
      E ret = first.data;
      for (int i = 0; i < index; i++){
         current = current.next;
         if (current == null) throw new NoSuchElementException();
         ret = current.data;
      }
      return ret;
   }
   
   public void add(int index, E element){
      Node newNode = new Node();
      newNode.data = element;
      Node current = first;
      Node before = null;
      for (int i = 0; i < index; i++){
         if (i == index - 1) before = current;
         current = current.next;
      }
      newNode.next = current;
      if (!(before == null)) before.next = newNode;
      if (newNode.next == null) last = newNode;
      size++;
   }
   
   public E remove(int index){
      if (first == null) throw new NoSuchElementException();
      Node ret = first;
      if (index == 0){
         first = first.next;
         size--;
         return ret.data;
      }
      Node current = first;
      for (int i = 0; i < index - 1; i++){
         if (current == null) throw new NoSuchElementException();
         current = current.next;
      }
      
      ret = current.next;
      current.next = current.next.next;

      size--;
      return ret.data;
   }
   
   public int size(){
      return size;
   }

}