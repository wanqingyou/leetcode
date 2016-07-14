public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0) return true;
		// use the map to store what courses depend on a course 
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int[] a: prerequisites){
            if(map.containsKey(a[1])){
                map.get(a[1]).add(a[0]);
            }else{
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(a[0]);
                map.put(a[1], l);
            }
        }
        //track visited courses
        int[] visit = new int[numCourses];
     
        for(int i=0; i<numCourses; i++){
            if(!canFinishDFS(map, visit, i))
                return false;
        }
     
        return true;
	}
	
	private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recstack, Map<Integer, LinkedList<Integer>> map) {
		if (visited[v] == false) {
			visited[v] = true;
			recstack[v] = true;

			LinkedList<Integer> l = map.get(v);
			for (int vertex : l) {
				if (!visited[vertex] && isCyclicUtil(vertex, visited, recstack, map)) {
					return true;
				}
				else if (recstack[v]) {
					return true;
				}
			}
		}
		recstack[v] = false;//remove the vertext from recursion stack
		return false;
	}
	
	private boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, int[] visit, int i){
        if(visit[i]==-1) 
            return false;
        if(visit[i]==1) 
            return true;
     
        visit[i]=-1;
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                if(!canFinishDFS(map, visit, j)) 
                    return false;
            }
        }
     
        visit[i]=1;
     
        return true;
    }
    
}