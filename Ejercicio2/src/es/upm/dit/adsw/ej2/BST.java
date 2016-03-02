package es.upm.dit.adsw.ej2;

// Código proveniente de http://www.sanfoundry.com/java-program-implement-binary-search-tree/

/*
 *  Java Program to Implement Binary Search Tree
 */

/* Class BSTNode */
class BSTNode {
	BSTNode left, right;
	String clave;
	String valor;

	/* Constructor */
	public BSTNode() {
		left = null;
		right = null;

	}

	/* Constructor */
	public BSTNode(String clave, String valor) {
		left = null;
		right = null;
		this.clave = clave;
		this.valor = valor;

	}

	/* Function to set left node */
	public void setLeft(BSTNode n) {
		left = n;
	}

	/* Function to set right node */
	public void setRight(BSTNode n) {
		right = n;
	}

	/* Function to get left node */
	public BSTNode getLeft() {
		return left;
	}

	/* Function to get right node */
	public BSTNode getRight() {
		return right;
	}

	/* Function to set data to node */
	public void setData(String clave, String valor) {
		this.clave = clave;
		this.valor = valor;
	}

	/* Function to get data from node */
	public String getClave() {
		return clave;
	}

	public String getValor(String clave) {
		return valor;
	}
}

/* Class BST */
class BST implements Diccionario {
	private BSTNode root;

	/* Constructor */
	public BST() {
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* Functions to insert data */
	public void put(String clave, String valor) {
		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		root = put(root, clave, valor);
	}

	/* Function to insert data recursively */
	// private BSTNode put(BSTNode node, String clave, String valor) {
	//
	// if (node == null)
	// node = new BSTNode(clave, valor);
	// else {
	// if (clave.compareTo(node.getClave()) < 0)
	// node.left = put(node.left, clave, valor);
	// else
	// node.right = put(node.right, clave, valor);
	// }
	// return node;
	private BSTNode put(BSTNode node, String clave, String valor) {
		if (node == null)
			return new BSTNode(clave, valor);
		int cmp = clave.compareTo(node.getClave());
		if (cmp < 0)
			node.left = put(node.left, clave, valor);
		else if (cmp > 0)
			node.right = put(node.right, clave, valor);
		else
			node.setData(clave, valor);

		return node;
	}

	/* Functions to delete data */
	public String remove(String clave) {
		if (isEmpty())
			System.out.println("Tree Empty");
		else if (get(clave) == null) {
			System.out.println("Sorry " + clave + " is not present");
			return null;
		}

		String valorBorrado = root.getValor(clave);
		root = remove(root, clave);
		System.out.println(clave + " deleted from the tree");
		return valorBorrado;

	}

	private BSTNode remove(BSTNode root, String clave) {
		BSTNode p, p2, n;
		if (root.getClave().equals(clave)) {
			BSTNode lt, rt;
			lt = root.getLeft();
			rt = root.getRight();
			if (lt == null && rt == null)
				return null;
			else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(lt);
				return p2;
			}
		}
		if (clave.compareTo(root.getClave()) < 0) {
			n = remove(root.getLeft(), clave);
			root.setLeft(n);
		} else {
			n = remove(root.getRight(), clave);
			root.setRight(n);
		}
		return root;
	}

	/* Functions to count number of nodes */
	public int size() {
		return size(root);
	}

	/* Function to count number of nodes recursively */
	private int size(BSTNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += size(r.getLeft());
			l += size(r.getRight());
			return l;
		}
	}

	/* Functions to search for an element */
	public String get(String clave) {

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		return get(root, clave);
	}

	/* Function to get for an element recursively */
	private String get(BSTNode r, String clave) {

		if (r == null)
			return null;
		int cmp = OpMeter.compareTo(clave, r.clave);
		if (cmp < 0)
			return get(r.left, clave);
		else if (cmp > 0)
			return get(r.right, clave);
		else
			return r.getValor(clave);
	}

	@Override
	public void clear() {

		root = null;

	}

}