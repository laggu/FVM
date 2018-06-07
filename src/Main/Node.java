package Main;

import java.util.ArrayList;

class Node{
    private Status status;
    private Node parent;
    private ArrayList<Node> chlidren;

    Node(){
        parent = null;
        status = null;
        chlidren = new ArrayList<>();
    }

    Node(Node p, Status s) {
        status = s;
        parent = p;
        chlidren = new ArrayList<>();
    }

    public Status getStatus() {
        return status;
    }

    Node getParentNode(){
        return parent;
    }

    void addChild(Node n){
        chlidren.add(n);
    }
}