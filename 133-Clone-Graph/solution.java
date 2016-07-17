/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();//log visited nodes
        LinkedList<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();//for BFS
        
        UndirectedGraphNode root=new UndirectedGraphNode(node.label);
        map.put(node, root);
        queue.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode curNode=queue.pollFirst();
            for(UndirectedGraphNode neighbor:curNode.neighbors){
                if(map.containsKey(neighbor)){
                    map.get(curNode).neighbors.add(map.get(neighbor));//add to the existing list
                }else{
                    UndirectedGraphNode nei=new UndirectedGraphNode(neighbor.label);//create new node
                    map.get(curNode).neighbors.add(nei);
                    map.put(neighbor, nei);
                    queue.add(neighbor);
                }
            }
        }
        
        return root;
        
    }
}