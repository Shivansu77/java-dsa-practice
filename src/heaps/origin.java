package heaps;

public class origin {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<int[]>maxHeap=new PriorityQueue<>((a,b)->Integer.compare(
                distance(b),distance(a)));

        for(int []point:points){
            maxHeap.add(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int [][]ans=new int[k][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            ans[i++]=maxHeap.poll();
        }
        return ans;
    }
    public int distance(int[]point){
        return point[0]*point[0]+point[1]*point[1];
    }
}
