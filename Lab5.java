import java.util.Scanner;

public class Lab5 
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.println("Enter the numbers to insert: ");
            String input = sc.nextLine();
            String[] split = input.split(",");

            BinaryTree tree = new BinaryTree();

            for(String output : split) 
            {
                int value = Integer.parseInt(output.trim());
                tree.insert(value);
            }

            int levels = tree.maxDepth(tree.root);

            System.out.println("The resulting binary tree has " + levels + " levels");
        }
    }
}

class Node 
{
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) 
    {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }
}

class BinaryTree 
{
    Node root;

    BinaryTree() 
    {
        root = null;
    }

    void insert(int key) 
    {
        root = insertSplit(root, key);
    }

    Node insertSplit(Node root, int key) 
    {
        if(root == null) 
        {
            root = new Node(key);
            return root;
        }

        if(key < root.data)
        {
            root.leftChild = insertSplit(root.leftChild, key);
        }
        else if(key > root.data)
        {
            root.rightChild = insertSplit(root.rightChild, key);
        }
        return root;
    }

    int maxDepth(Node root) 
    {
        if(root == null)
        {
            return 0;
        }

        int leftDepth = maxDepth(root.leftChild);
        int rightDepth = maxDepth(root.rightChild);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}