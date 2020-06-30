import java.util.Iterator;

public class PriorityQueueIterator<T> implements Iterator{

	private QueueNode<T> current;
	
	public PriorityQueueIterator(QueueNode<T> head){
		this.current = head;
	}
	
	@Override
	public boolean hasNext() {
		
		if(current!=null && current.getNext() == null)
			return true;
		
		if(current!=null)
		   return current.hasNext();
		return false;
	}

	@Override
	public QueueNode<T> next() {

		if(current == null)
			return null;
		
		QueueNode<T> node = current;

		if(current.getNext()!=null) {
			current = current.getNext();
			return node;
		}
		else {
			current = current.getNext();
			return node;
		}
	}
}