public class TrapingRainWater {

    //Auxiliary Space Approach O(n) Time Complexity O(n)
    public static int trapWater(int[] height) {
        //max left waterlevel
        int[] leftMax = new int[height.length];
        leftMax[0]=height[0];
        for(int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        
        //max right waterlevel
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trapedWater = 0;
        //loop
        for(int i = 0; i < height.length; i++){
            //waterlevel
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            //traped water
            trapedWater += ((waterLevel - height[i]) * 1);
        }

        return trapedWater;
    }
    public static void main(String[] args) {
        int[] height = {4,2,3,6,2,1,5};
        System.out.println(trapWater(height));
    }
}
