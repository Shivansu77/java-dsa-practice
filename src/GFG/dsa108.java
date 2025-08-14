package GFG;

public class dsa108 {
        static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
            ArrayList<Integer> list=new ArrayList<>();
            Deque<Integer>dq=new LinkedList<>();

            for(int i=0;i<arr.length;i++){
                while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                    dq.pollFirst();
                }

                while(!dq.isEmpty() && arr[i]>arr[dq.peekLast()]){
                    dq.pollLast();
                }
                dq.offerLast(i);
                if(i>=k-1){
                    list.add(arr[dq.peekFirst()]);
                }


            }

            return list;
        }

    /*static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {

        ArrayList<Integer>ans=new ArrayList<>();

        for(int i=0;i<=arr.length-k;i++){
            int max=arr[i];
            for(int j=i;j<i+k;j++){
                if(arr[j]>max){
                    max=arr[j];
                }
            }
            ans.add(max);

        }
        return ans;
    }*/
    }
}