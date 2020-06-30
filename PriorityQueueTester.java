
public class PriorityQueueTester {

	public static void main(String[] args) {

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10);

		// add 10 elements with random values and random priorities between 1-10 to the
		for (int i = 0; i < 15; i++) {

			queue.add((int) Math.floor(Math.random() * 20), (int) (Math.random() * 10 + 1));
		}

		queuePrintedByPriority(queue);
		queuePrintedByData(queue);
		printSize(queue);
		
		//Create Object of type QueueNode to check if the queue contains them
		QueueNode<Integer> check1 = new QueueNode<Integer>(2,1);
		QueueNode<Integer> check2 = new QueueNode<Integer>(4,3);
		QueueNode<Integer> check3 = new QueueNode<Integer>(6,5);
		QueueNode<Integer> check4 = new QueueNode<Integer>(8,7);
		QueueNode<Integer> check5 = new QueueNode<Integer>(10,9);

		System.out.println("Does the queue contains element check1 ? " + queue.contains(check1.getData()));
		System.out.println("Does the queue contains element check2 ? " + queue.contains(check2.getData()));
		System.out.println("Does the queue contains element check3 ? " + queue.contains(check3.getData()));
		System.out.println("Does the queue contains element check4 ? " + queue.contains(check4.getData()));
		System.out.println("Does the queue contains element check5 ? " + queue.contains(check5.getData()));
		System.out.println();

		// check poll and remove
		QueueNode node1 = queue.poll();
		System.out.println("Polled element Data = " + node1.getData()  +  
				           " Polled element Priority = " + node1.getPriority());
		QueueNode node2 = queue.poll();
		System.out.println("Polled element Data = " + node2.getData()  +  
		           " Polled element Priority = " + node2.getPriority());
		QueueNode node3 = queue.poll();
		System.out.println("Polled element Data = " + node3.getData()  +  
		           " Polled element Priority = " + node3.getPriority() + "\n");
		
		queuePrintedByPriority(queue);
		queuePrintedByData(queue);
		printSize(queue);
		
		QueueNode<Integer> remove1 = new QueueNode<Integer>(3,1);
		QueueNode<Integer> remove2 = new QueueNode<Integer>(6,3);
		QueueNode<Integer> remove3 = new QueueNode<Integer>(9,5);
		QueueNode<Integer> remove4 = new QueueNode<Integer>(12,7);
		QueueNode<Integer> remove5 = new QueueNode<Integer>(15,9);
		
		
		System.out.println("Does remove1 removed ? " + queue.remove(remove1.getData()));
		System.out.println("Does remove2 removed ? " + queue.remove(remove2.getData()));
		System.out.println("Does remove3 removed ? " + queue.remove(remove3.getData()));
		System.out.println("Does remove4 removed ? " + queue.remove(remove4.getData()));
		System.out.println("Does remove5 removed ? " + queue.remove(remove5.getData()) + "\n");
		
		queuePrintedByPriority(queue);
		queuePrintedByData(queue);
		printSize(queue);
		
		// Iterator test - iterate through the queue and print by priorities
		PriorityQueueIterator<Integer> iter = (PriorityQueueIterator) queue.iterator();
        System.out.println("Iterator Test : ");
		while (iter.hasNext()) {

			Object element = iter.next();
			int pr = ((QueueNode) element).getPriority();
			Integer data = (Integer) ((QueueNode) element).getData();
			System.out.println("Priority : " + pr + " Data : " + data);
		}	
	}
	
	public static void 	queuePrintedByPriority(PriorityQueue<Integer> queue){
		
		QueueNode<Integer> curr = queue.getHead();

		System.out.println("Queue printed by priorities :");
		// print the queue by priorities
		while (curr != null) {

			if (curr.getNext() != null) {
				System.out.print(curr.getPriority() + ", ");
				curr = curr.getNext();
			} else {
				System.out.print(curr.getPriority());
				curr = curr.getNext();
			}
		}
		System.out.println("\n");
		
	}
	
	public static void queuePrintedByData(PriorityQueue<Integer> queue){
		
		QueueNode curr = queue.getHead();
		System.out.println("Queue printed by data :");
		while (curr != null) {

			if (curr.getNext() != null) {
				System.out.print(curr.getData() + ", ");
				curr = curr.getNext();
			} else {
				System.out.print(curr.getData());
				curr = curr.getNext();
			}
		}
		// Test contains and size
		System.out.println("\n");
	}

	public static void printSize(PriorityQueue<Integer> queue) {
		
		System.out.println("Priority Queue size is : " + queue.size() + "\n");	
	}

}
