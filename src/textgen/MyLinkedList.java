package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		
		size=0;
		head= new LLNode<E>(null);
		tail= new LLNode<E>(null);
		head.next=tail;
		tail.prev=head;
	
		// TODO: Implement this method
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if(element==null)
			throw new NullPointerException();
		
		LLNode<E> n = new LLNode<E>(element);
		n.prev= tail.prev;
		n.next= n.prev.next;
		n.prev.next=n;
		n.next.prev=n;
		size++;
		
		// TODO: Implement this method
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		
			
		if(size==0 || index<0 || index>size-1)
			throw new IndexOutOfBoundsException();
		LLNode<E> n=head;
		for(int i=0;i<=index;i++)
		{
			n=n.next;
			//System.out.println(n.data);
			
		}
		//System.out.println(size+" "+n.data);
		// TODO: Implement this method.
		return n.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		else if(element==null)
			throw new NullPointerException();
		LLNode<E> n=head;
		LLNode<E> nati=new LLNode<E>(element);
		for(int i=0;i<index;i++)
		{
			n=n.next;
			//System.out.println(n.data);
			
		}
		nati.prev= n.next.prev;
		nati.next= n.next;
		n.next.prev=nati;
		n.next=nati;
		
		size++;
		
		// TODO: Implement this method
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(size==0 || index<0 || index>size-1)
			throw new IndexOutOfBoundsException();
		LLNode<E> n=head;
		for(int i=0;i<=index;i++)
		{
			n=n.next;
			//System.out.println(n.data);
			
		}
		n.prev.next=n.next;
		n.next.prev=n.prev;
		size--;
		// TODO: Implement this method
		return n.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(size==0 || index<0 || index>size-1)
			throw new IndexOutOfBoundsException();
		else if(element==null)
			throw new NullPointerException();
		LLNode<E> n=head;
		for(int i=0;i<=index;i++)
		{
			n=n.next;
			//System.out.println(n.data);
			
		}
		E removedValue=n.data;
		
		n.data= element;
		//System.out.println(n.data);
		// TODO: Implement this method
		return removedValue;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
