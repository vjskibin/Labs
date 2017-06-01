package lab2;

public class BinarySearchTree {

	enum TraverseType {
		PREORDER,
		INORDER,
		POSTORDER
	}

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public boolean find(int key) {
		Node current = root;
		while (current.data != key) {
			if (key < current.data) current = current.leftChild;
			else current = current.rightChild;
			if (current == null) return false;
		}
		return true;
	}

	public void insert(int a) {
		Node newNode = new Node(a);
		if (root == null) root = newNode;
		else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (a < current.data) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				}
				else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void display() {
		recDisplay(root);
		System.out.println();
	}

	private void recDisplay(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.rightChild);
		}
	}

	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (current.data != key) {
			parent = current;
			if (key < current.data) {
				isLeftChild = true;
				current = current.leftChild;
			} else  {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) return false;
		}

		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) root = null;
			else if (isLeftChild) parent.leftChild = null;
				else parent.rightChild = null;
		}
		else if (current.rightChild == null) {
			if (current == root) root = current.leftChild;
			else if (isLeftChild) parent.leftChild = current.leftChild;
				else parent.rightChild = current.leftChild;
		}
		else if (current.leftChild == null) {
			if (current == root) root = current.rightChild;
			else if (isLeftChild) parent.leftChild = current.rightChild;
				else parent.rightChild = current.rightChild;
		}
		else {
			Node successor = getSuccessor(current);

			if (current == root) root = successor;
			else if (isLeftChild) parent.leftChild = successor;
				else parent.rightChild = successor;
			successor.leftChild = current.leftChild;
		}
		return true;
	}

	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	public void traverse(TraverseType traverseType) {
		switch (traverseType) {
			case PREORDER:
				preOrder(root);
				break;
			case INORDER:
				inOrder(root);
				break;
			case POSTORDER:
				postOrder(root);
				break;
		}
	}

	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			//Something is done with localRoot. Ex: localRoot.data = 0;
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			//Something is done with localRoot. Ex: display data
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.rightChild);
		}
	}

	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			//Something is done with localRoot. Ex: localRoot.data = 0;
		}
	}
}
