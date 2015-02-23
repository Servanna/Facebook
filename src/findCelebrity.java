
import java.util.HashSet;
import java.util.Stack;


/*asshole problem-- Nonsence
 * In a party of N people, only one person is known to everyone. 
 * Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party.
 *  We can only ask questions like “does A know B? “. 
 *  Find the stranger (celebrity) in minimum number of questions.
 *  
 *  We can describe the problem input as an array of numbers/characters 
 *  representing persons in the party.
 *  We also have a hypothetical function HaveAcquaintance(A, B)
 *  which returns true if A knows B, false otherwise. How can we solve the problem
 * 
 */
public class findCelebrity {
	static int N = 8;  
    static int size = 5;  
    static int matrix[][] = {{0,0,0,0,0},  
                             {1,0,0,1,0},
                             {1,0,0,1,0},
                             {1,0,0,0,0},
                             {1,0,0,1,0}};  
      
    public static boolean haveAcquiantance(int a, int b){  
        return matrix[a][b] != 0;  
    }  
    static int count1 = 0;
    static int count2 = 0;
    public static int celebrityUsingStack(int size){  
        Stack<Integer> stack = new Stack<Integer>();  
        int i;  
        int C;  // Celebrity  
        i = 0;  
        while(i < size){  
            stack.push(i);  
            i++;  
        }  
          
        int A = stack.pop();  
        int B = stack.pop();  
          
        while(stack.size() != 1){
        	count1++;  
            if(haveAcquiantance(A, B)){ 
                A = stack.pop();  
            }else{  
                B = stack.pop();  
            }  
        }  
          
       
        C = stack.pop();  
        count1++; 
        if(haveAcquiantance(C, B)){ 
            C = B;  
        }  
        count1++; 
        if(haveAcquiantance(C, A)){  
            C = A;  
        }  
          
        if(sanityTest(C) == -1){  
            System.out.println("Sanity Test Failed!");  
        }else{  
            System.out.println("Test ok!");  
        }  
        System.out.println(count1);
        return C;  
    }  
      
    public static int sanityTest(int C){  
        int i = 0;  
        Stack<Integer> stack = new Stack<Integer>();  
        while(i < size){  
            if(i != C){  
                stack.push(i);  
            }  
            i++;  
        }  
        while(!stack.isEmpty()){  
            i = stack.pop();  
            count1++; 
            if(haveAcquiantance(C, i)){ 
                return -1;  
            }  
            count1++; 
            if(!haveAcquiantance(i, C)){   
                return -1;  
            }  
        }  
        return C;  
    }  
      
    public static int find(int size){
    	int C = -1;
    	HashSet<Integer> set = new HashSet<Integer>();
    	int j;
    	for(int i = 0; i < size; i++){
    		if(set.contains(i)){continue;}
    		for(j = 0 ; j < size; j++){
    			if(set.contains(i)||i == j){continue;}
    			count2++;
    			if(!haveAcquiantance(i, j)){
    				set.add(j);
    			}else{
    				set.add(i);
    				i = j-1;
    				break;
    			}
    		}
    		if(j == size){C = i;}
    	}
    	j = 0;
    	while(C != -1 && j < size){
    		if(j == C){j++; continue;}
    		if(haveAcquiantance(C, j)){ 
    			count2++; 
                break;  
            }  
            j++;
    	}
    	System.out.println(count2);
    	return j == size? C : -1;
    }
    
      
    public static void main(String[] args) {  
        int id = celebrityUsingStack(size);  
        System.out.println(id);
        int id2 = find(size);
        System.out.println(id2);
    }  
}
