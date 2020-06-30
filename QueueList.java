
public class QueueList<T> {

  private QueueNode<T> head;
	
	public QueueList(){
		head = null;
	}
	
	public QueueList(QueueNode<T> node){
		head = node;
	}
	
	public QueueNode<T> getHead(){
	   return head;
	}	
}