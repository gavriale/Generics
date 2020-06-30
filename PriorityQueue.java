import java.util.Iterator;

public class PriorityQueue<T> implements Iterable<T> {

	private QueueNode<T> head;
	private int maxPriority;
	private int queueSize;
	private final static int MAX_PRIORITY = 10;

	public PriorityQueue(int priorities) {

		if (priorities >= 1 && priorities <= MAX_PRIORITY) {
			maxPriority = priorities;
		}
		else{
			maxPriority = MAX_PRIORITY;
		}

		head = null;
		queueSize = 0;
	}

	public void add(T data, int priority) {

		QueueNode<T> nodeToAdd = new QueueNode<T>(data, priority);
		if (nodeToAdd.getPriority() > maxPriority) {
			nodeToAdd.setPriority(maxPriority);
		}

		if (head == null) {
			head = nodeToAdd;
			queueSize++;
			return;
		}

		QueueNode<T> curr = head;
		QueueNode<T> prev = head;

		if (nodeToAdd.getPriority() < head.getPriority()) {

			nodeToAdd.setNext(head);
			head = nodeToAdd;
			queueSize++;
			return;
		}

		while (curr.hasNext() && curr.getPriority() <= nodeToAdd.getPriority()) {

			prev = curr;
			curr = curr.getNext();
		}

		if (curr.hasNext() == false) {
			if (curr.getPriority() <= nodeToAdd.getPriority()) {
				curr.setNext(nodeToAdd);
				queueSize++;
				return;
			}
			if (curr.getPriority() > nodeToAdd.getPriority()) {
				prev.setNext(nodeToAdd);
				nodeToAdd.setNext(curr);
				queueSize++;
				return;
			}
		}

		else {
			if (curr.getPriority() > nodeToAdd.getPriority() && prev.getPriority() <= nodeToAdd.getPriority()) {
				prev.setNext(nodeToAdd);
				nodeToAdd.setNext(curr);
				queueSize++;
				return;
			}
		}
	}

	public QueueNode<T> poll() {

		if (queueSize == 0)
			return null;

		QueueNode<T> output = head;

		if (head.hasNext()) {
			head = head.getNext();
			queueSize--;
		} else {
			head = null;
			queueSize--;
		}

		return output;
	}

	public int size() {
		return queueSize;
	}
	
	public boolean remove(T element) {
		
		if(queueSize == 0) {
			return false;
		}
		
		if (queueSize == 1) {
			if (head.getData().equals(element)) {
				head = null;
				queueSize = 0;
				return true;
			}
			return false;
		}
		
		QueueNode prev = head;
		QueueNode curr = head.getNext();
		
		if(head.getData().equals(element)) {
			QueueNode<T> poll = this.poll();
			return true;
		}
		
		while(curr!=null) {
			
			if (curr.getData().equals(element)) {
				prev.setNext(curr.getNext());
				curr.setNext(null);
				queueSize--;
				return true;
			}
			prev = curr;
			curr = curr.getNext();	
	     }
		return false;
	}
	
	public boolean contains(T element) {
		
		if(this.queueSize == 0) {
			return false;
		}
		QueueNode<T> curr = head;
		
		while(curr!=null) {
			
			if(curr.getData().equals(element)) {
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new PriorityQueueIterator(this.head);
	}

	public QueueNode<T> getHead() {
		if (queueSize > 0)
			return head;
		return null;
	}
}