package Main;

import java.util.HashMap;

public class CommitTree {

    private static CommitTree commitTree;

    public static CommitTree getInstance() {
        if (commitTree == null) {
            commitTree = new CommitTree();
            return commitTree;
        } else {
            return commitTree;
        }
    }

    private Node root;
    private HashMap<String, Node> commitPointer;

    private CommitTree() {
        root = new Node();
        commitPointer = new HashMap<String, Node>();
        commitPointer.put("root", root);
    }

    public void addCommitNode(Status s){
        System.out.println(s.getPreviousCommit());
        System.out.println(s.getAddedFileList());
        Node parent = commitPointer.get(s.getPreviousCommit());
        Node n = new Node(parent, s);
        System.out.print(s.getCommitName());
        System.out.println(" getCommitName()");
        commitPointer.put(s.getCommitName(), n);
        commitPointer.put(s.getBranch(), n);
        parent.addChild(n);
    }

    public Status getStatus(String commitName){
        System.out.println(commitName);
        Node n = commitPointer.get(commitName);
        System.out.println(n.getStatus().getAddedFileList());
        return n.getStatus();
    }

    public Status getParent(Status s){
        if(s.getPreviousCommit().equals("root"))
            return null;
        Node parent = commitPointer.get(s.getPreviousCommit());
        return parent.getStatus();
    }
}
