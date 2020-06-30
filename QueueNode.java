import java.util.Iterator;

public class QueueNode<T>{

	private T data;//the data - String,Integer,Spaceship etc
	private int priority;
	private QueueNode<T> nextNode;
	
	public QueueNode(T data, int p) {
		
		if(data == null) {
			throw new NullPointerException();
		}
		
		this.data = data;
		this.priority = p;
		this.nextNode = null;
	}
	
	public QueueNode<T> getNext() {
		
		if(this.nextNode!=null)
		     return nextNode;
		return null;
	}
	
	public boolean hasNext() {
	     return this.getNext()!=null;
	}
	
	public void setNext(QueueNode<T> node){
		this.nextNode = node;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int n) {
		priority = n;
	}
	
	public T getData() {
		return data;
	}
}
