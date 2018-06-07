package Main;

import Network.Network;

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
        Node parent = commitPointer.get(s.getPreviousCommit());
        Node n = new Node(parent, s);
        commitPointer.put(s.getCommitName(), n);
        parent.addChild(n);
    }

    public Status getStatus(String commitName){
        Node n = commitPointer.get(commitName);
        return n.getStatus();
    }

    public Status getParent(Status s){
        Node parent = commitPointer.get(s.getPreviousCommit());
        return parent.getStatus();
    }
}
