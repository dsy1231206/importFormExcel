package hn.fish;

public class Trie{

    class Node{
        Node[] children;
        boolean isLeaf;
    }

    Node root;

    public void add(String value){
        if(value == null || value.length() == 0) return;

        Node cur = root;

        for(int i = 0; i < value.length(); i++){
            int index = value.charAt(i) - 'a';
            if(cur.children[index] == null){
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.isLeaf = true;
    }
}
