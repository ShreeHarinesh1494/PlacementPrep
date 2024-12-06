Online GDP Link : - https://onlinegdb.com/gD2805VmZ

import java.util.*;

class BST
{
    private Node root;

    class Node
    {
        int value;
        Node left;
        Node right;

        Node(int value)
        {
            this.value = value;
        }
    }

    public boolean insert(int value)
    {
        Node newNode  = new Node(value);

        if(root == null)
        {
            root = newNode;
            return true;
        }

        Node temp = root;

        while(true)
        {
            if(temp.value == newNode.value)
            {
                return false;
            }

            if(newNode.value <= temp.value)
            {
                if(temp.left == null)
                {
                    temp.left = newNode;
                }

                temp = temp.left;
            }
            else
            {
                if(temp.right == null)
                {
                    temp.right = newNode;
                }

                temp = temp.right;
            }
        }
    }

    public ArrayList<Integer> BFS()
    {
        Node currentNode = root;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(q.size()>0)
        {
            currentNode = q.remove();
            result.add(currentNode.value);

            if(currentNode.left!=null)
            {
                q.add(currentNode.left);
            }

            if(currentNode.right!=null)
            {
                q.add(currentNode.right);
            }
        }

        return result;
    }

    public ArrayList<Integer> PreOrder()
    {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse
        {
            Traverse(Node node)
            {
                result.add(node.value);

                if(node.left!=null)
                {
                    new Traverse(node.left);
                }

                if(node.right!=null)
                {
                    new Traverse(node.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> InOrder()
    {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse
        {
            Traverse(Node node)
            {
                
                if(node.left!=null)
                {
                    new Traverse(node.left);
                }
                result.add(node.value);

                if(node.right!=null)
                {
                    new Traverse(node.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> PostOrder()
    {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse
        {
            Traverse(Node node)
            {
                
                if(node.left!=null)
                {
                    new Traverse(node.left);
                }
                
                if(node.right!=null)
                {
                    new Traverse(node.right);
                }
                result.add(node.value);
            }
        }
        new Traverse(root);
        return result;
    }

    public int height()
    {
        return height(root);
    }
    private int height(Node root)
    {
        if(root == null)
        {
            return -1;
        }

        int leftheight = height(root.left);
        int rightheight = height(root.right);
        return Math.max(leftheight,rightheight)+1;
    }

    public int sumleaf()
    {
        return sumleaf(root);
    }
    
    private int sumleaf(Node root)
    {
        if(root == null)
        {
            return 0;
        }

        if(root.left == null && root.right == null)
        {
            return root.value;
        }

        return sumleaf(root.left)+sumleaf(root.right);
    }

    public boolean isbst()
    {
        
        return isbst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isbst(Node node,int min,int max)
    {
        if(node == null) return true;
        if(node.value<=min || node.value>=max)
        {
            return false;
        }

        return isbst(node.left,min,node.value) && isbst(node.right,node.value,max);
    }

    public boolean isbalanced() 
    {
        return isbalanced(root);
    }
    private boolean isbalanced(Node root)
    {
        if(root == null)
        {
            return true;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        return Math.abs(lheight - rheight) <= 1;
    }

    public boolean isymmetric()
    {
        if(root == null) return true;
        return ismirror(root.left,root.right);
    }

    private boolean ismirror(Node left,Node right)
    {
        if(left == null && right == null) return true;

        if(left == null || right == null) return false;

        if(left.value != right.value) return false;

        return ismirror(left.left,right.right) && ismirror(left.right,right.left);
    }
}

public class Main
{
	public static void main(String[] args) 
	{
		BST bst = new BST();
		
		bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);

		
		ArrayList<Integer> ls1 = bst.PreOrder();
		
		System.out.println("Preorder");
		for(int n : ls1)
		{
		    System.out.print(n+" ");
		}
		
		System.out.println();
		
		
		ArrayList<Integer> ls2 = bst.InOrder();
		
		System.out.println("Inorder");
		for(int n : ls2)
		{
		    System.out.print(n+" ");
		}
		
		System.out.println();
		
		
		ArrayList<Integer> ls3 = bst.PostOrder();
		
		System.out.println("Postorder");
		for(int n : ls3)
		{
		    System.out.print(n+" ");
		}
		
		System.out.println();
		
		int heightoftree = bst.height();
		System.out.println("Height of the tree : "+heightoftree);
		
		System.out.println();
		
		int sumofleaves = bst.sumleaf();
		System.out.println("Sum of Leaves : "+sumofleaves);
		System.out.println();
		
		boolean isbsttree = bst.isbst();
		int tree = 0;
		if(isbsttree)
		{
		    tree = 1;
		}
		System.out.println("The tree is : "+tree);
		
		System.out.println("The tree is balanced : "+bst.isbalanced());
		
		System.out.println("The Tree is Symmetric : "+bst.isymmetric());
	}
}
