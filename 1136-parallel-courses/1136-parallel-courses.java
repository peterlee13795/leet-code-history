class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Vertex[] vertexs = new Vertex[n + 1];
        for(int i = 1 ; i <=n ;i++) vertexs[i] = new Vertex();
        
        // 피격 = 0 list
        for(int[] relation: relations) {
            vertexs[relation[0]].childs.add(relation[1]);
            vertexs[relation[1]].targetCount++;
        }
        
        // 방문여부
        boolean[] visits = new boolean[n + 1];
        
        // 2중 queue처리
        Queue<Vertex> nowQueue = new LinkedList<>();
        Queue<Vertex> nextQueue = new LinkedList<>();
        for(int i= 1 ; i<= n; i++) {
            if(vertexs[i].targetCount == 0) {
                nowQueue.add(vertexs[i]);
                visits[i] = true;
            }
        }
        
        if(nowQueue.isEmpty()) return -1;
        
        // queue 소모 끝나면 다면 queue로 이동하면서 semester++
        int semester = 1;
        while(!nowQueue.isEmpty()) {
            Vertex nowVertex = nowQueue.poll();
            
            for(Integer childIndex: nowVertex.childs) {
                Vertex nextVertex = vertexs[childIndex];
                nextVertex.targetCount--;
                if(nextVertex.targetCount == 0) {
                    visits[childIndex] = true;
                    nextQueue.add(nextVertex);
                }
            }
            
            if(nowQueue.isEmpty()) {
                nowQueue = nextQueue;
                nextQueue = new LinkedList<>();
                if(!nowQueue.isEmpty()) {
                    semester++;
                }
            }
        }
        
        for(int i = 1 ; i <= n ; i++) {
            if(!visits[i]) return -1;
        }
        
        
        return semester;
    }
    
    static class Vertex {
        int targetCount = 0;
        List<Integer> childs = new ArrayList<>();
    }
}