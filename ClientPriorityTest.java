
public class ClientPriorityTest {

	public static void main(String[] args) {

		PriorityQueue<ClientApplication> clients = new PriorityQueue<ClientApplication>(5);
		ClientApplication app1 = new ClientApplication("Messi", 31, "I am the Best");
		ClientApplication app2 = new ClientApplication("Cristiano", 33, "I am better then Messi");
		ClientApplication app3 = new ClientApplication("Maradona", 59, "I am the greatest of all times");
		ClientApplication app4 = new ClientApplication("Pele", 80, "Messi is better then Ronaldo");
		ClientApplication app5 = new ClientApplication("Ronaldo", 59, "I am the most talented");
		ClientApplication app6 = new ClientApplication("Generic", 0, "I am generic");
		ClientApplication app7 = new ClientApplication("Erasure", 1, "I am Erasure");

		clients.add(app1, 3);
		clients.add(app2, 1);
		clients.add(app3, 2);
		clients.add(app4, 4);
		clients.add(app5, 5);

		System.out.println("Clients priority queue contains app1 ? " + clients.contains(app1));
		System.out.println("Clients priority queue contains app2 ? " + clients.contains(app2));
		System.out.println("Clients priority queue contains app3 ? " + clients.contains(app3));
		System.out.println("Clients priority queue contains app4 ? " + clients.contains(app4));
		System.out.println("Clients priority queue contains app5 ? " + clients.contains(app5));
		System.out.println("Clients priority queue contains app6 ? " + clients.contains(app6) + "\n");

		clients.add(app6, 6);

		PriorityQueueIterator<ClientApplication> iter = (PriorityQueueIterator) clients.iterator();
		printQueueWithIterator(clients);

		System.out.println("app1 removed ? " + clients.remove(app1));
		System.out.println("app2 removed ? " + clients.remove(app2));
		System.out.println("app6 removed ? " + clients.remove(app6));
		System.out.println("app7 removed ? " + clients.remove(app7) + "\n");
		
		printQueueWithIterator(clients);
		
		//checked in the debugger that the elements that polled were the right one
		QueueNode<ClientApplication> polled1 = clients.poll();
		QueueNode<ClientApplication> polled2 = clients.poll();
		
		System.out.println("First element polled priority : " + polled1.getPriority() +
						   " first element polled data : " +  polled1.getData().getMessage() + "\n");
		System.out.println("Second element polled priority : " + polled2.getPriority() +
				   " second element polled data : " +  polled2.getData().getMessage() + "\n");
		
        //priority queue printed after polling two elements
		printQueueWithIterator(clients);
	}
	
	
	public static void printQueueWithIterator(PriorityQueue<ClientApplication> clients) {
		
		PriorityQueueIterator<ClientApplication> iter = (PriorityQueueIterator) clients.iterator();
		while (iter.hasNext()) {

			Object element = iter.next();
			int pr = ((QueueNode) element).getPriority();
			String data = ((ClientApplication) ((QueueNode) element).getData()).getMessage();
			System.out.println("Priority : " + pr + " Data : " + data);
		}
		System.out.println();
	}	
}
