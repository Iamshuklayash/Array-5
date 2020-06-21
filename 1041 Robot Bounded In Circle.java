//1041. Robot Bounded In Circle
//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public boolean isRobotBounded(String instructions) {
        //edge case
        if(instructions ==null || instructions.length() == 0)
            return false;
        
        //Directions in the NWSE format
        int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        int current_dir = 0;
        int currentX = 0;
        int currentY = 0;
        //procesing all the instructions
        for( int i = 0; i < instructions.length(); ++i){
            char instruction = instructions.charAt(i);
            if(instruction == 'G'){
                //go in the current direction
                //what would you do if it was taking two steps?
                //multiply by the number of steps it was taking
                currentX += dirs[current_dir][0];
                currentY += dirs[current_dir][1];
                
            } else if(instruction == 'L'){
                current_dir++;
                
            } else {
                current_dir += 3;
            }
            current_dir %= 4;         
        }
        return (currentX == 0 && currentY == 0) || (current_dir != 0);
    }
}
