
public class LinkedListOfEmployee {
	
	private Node head;
	
	public LinkedListOfEmployee() {
		head = null;
	}
	
	public void insertAtFront(Employee e) {
		Node newNode = new Node(e);
		newNode.setNext(head);
		head = newNode;
	}
	
	public void insertAtBack(Employee e) {
		Node newNode = new Node(e);
		if(head == null)
			head = newNode;
		else {
			Node curr = head;
			while(curr.getNext() != null)
				curr = curr.getNext();
			curr.setNext(newNode);
		}
	}
	
	public int countEmployee(String g) {
		Node curr = head;
		int counter = 0;
		while (curr != null) {
			if(curr.getData().getGender().equalsIgnoreCase(g))
				counter++;
			curr = curr.getNext();
		}
		return counter;
	}
	
	public Employee getOldestEmployee() {
		Employee oldest = null;
		Node curr = head;
		while (curr != null) {
			if(curr.getData().getAge() > oldest.getAge())
				oldest = curr.getData();
			curr = curr.getNext();
		}
		return oldest;
	}
	
	public LinkedListOfEmployee getEmployees(String g) {
		LinkedListOfEmployee newList = new LinkedListOfEmployee();
		Node curr = head;
		while(curr != null) {
			if(curr.getData().getGender().equalsIgnoreCase(g))
				newList.insertAtBack(curr.getData());
			curr = curr.getNext();
		}
		return newList;
	}
	
	public void splitEmployee(LinkedListOfEmployee male, LinkedListOfEmployee female) {
		Node curr = head;
		while(curr != null) {
			if(curr.getData().getGender().equalsIgnoreCase("male"))
				male.insertAtBack(curr.getData());
			else if(curr.getData().getGender().equalsIgnoreCase("female"))
				female.insertAtBack(curr.getData());
			curr = curr.getNext();
		}
	}
	
	public void display() {
		Node curr = head;
		while(curr != null) {
			curr.getData().displayInfo();
			curr = curr.getNext();
		}
	}	
	
}
