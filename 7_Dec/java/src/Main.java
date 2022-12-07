import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Node {
    private String label;
    private Node parent;
    private List<Node> children = new ArrayList<>();
    private List<FileNode> files = new ArrayList<>();
    private int size = 0;

    public Node(String name, Node parent) {
        this.label = name;
        this.parent = parent;
    }

    public String getName() {
        return this.label;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public List<FileNode> getFiles() {
        return files;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class FileNode {
    private int size;
    private String name;

    public FileNode(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}


public class Main {
    public static int setSizes(Node node) {
        int total = node.getChildren().stream().mapToInt((dirNode) -> setSizes(dirNode)).sum() + node.getFiles().stream().mapToInt((file) -> file.getSize()).sum();
        node.setSize(total);
        return total;
    }

    public static List<Node> getNodes(Node node) {
        List<Node> nodes = new ArrayList<>();
        for (Node child : node.getChildren()) {
            nodes.addAll(getNodes(child));
        }
        nodes.add(node);
        return nodes;
    }


    public static void main(String[] args) {
        try {
            File myObj = new File("src/input_radu.txt");
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            Scanner myReader = new Scanner(myObj);
            Node root = new Node("/", null);
            Node pointer = root;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arrData = data.split(" ");
                if (arrData[1].equals("ls")) {

                } else if (arrData[1].equals("cd")) {
                    if (arrData[2].equals("/")) {
                        pointer = root;
                    } else if (arrData[2].equals("..")) {
                        pointer = pointer.getParent();
                    } else {
                        pointer = pointer.getChildren().stream().filter((node -> node.getName().equals(arrData[2]))).toList().get(0);
                    }
                } else if (arrData[0].equals("dir")) {
                    pointer.getChildren().add(new Node(arrData[1], pointer));
                } else {
                    pointer.getFiles().add(new FileNode(arrData[1], Integer.parseInt(arrData[0])));
                }

            }
            root.setSize(setSizes(root));
            System.out.println(setSizes(root));
            List<Node> smallNodes = getNodes(root);
            int threshold_1 = 100_000;
            System.out.println("Output: " + smallNodes.stream().mapToInt(Node::getSize).filter(x -> x  < threshold_1).sum());

            int threshold_2 = Math.abs(root.getSize() - 40_000_000);
            List<Node> greaterNodes = getNodes(root);
            greaterNodes.stream().mapToInt(Node::getSize).sorted().toArray();
            System.out.println("Output: " + greaterNodes.stream().mapToInt(Node::getSize).filter(x -> x  >= threshold_2).min());

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}