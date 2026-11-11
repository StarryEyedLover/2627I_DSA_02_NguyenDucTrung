import java.util.Scanner;

public class week9_assignment {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
    
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }

        if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }

        return root;
    }


    public static void preOrder(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.data).append(" ");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        System.out.println(sb.toString().trim());

        if (sc.hasNextInt()) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            Node ans = lca(root, v1, v2);
            System.out.println(ans.data);
        }
        sc.close();
    }
}
