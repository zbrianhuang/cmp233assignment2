public class Nodes {
    public int getNodes(Node node){
        if(node==null){
            return 0;
        }
        return 1+getNodes(node.next);
    }
}
