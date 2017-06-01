package lab2;

class Node {
	int data;

	Node leftChild;
	Node rightChild;

	Node(int data) {
		this.data = data;
		leftChild = null;
		rightChild = null;
	}

	public void display() {
		System.out.print(data);
	}
}
