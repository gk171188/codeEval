
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/** 
 * Knight Moves : Easy : No. 180
 */
public class KnightMoves {
	
	/** Map Containing character to digit positions in Chess */
	 @SuppressWarnings("serial")
	public static HashMap<String,Integer> boardMap=new HashMap<String, Integer>(){{
		
		 put("a", 1);
		 put("b", 2);
		 put("c", 3);
		 put("d", 4);
		 put("e", 5);
		 put("f", 6);
		 put("g", 7);
		 put("h", 8);
	 }};
	
	 /** Map Containing Digit to character positions in Chess */
	 @SuppressWarnings("serial")
		public static HashMap<Integer,String> boardPosMap=new HashMap<Integer,String>(){{
			
			 put(1,"a");
			 put(2,"b");
			 put(3,"c");
			 put(4,"d");
			 put(5,"e");
			 put(6,"f");
			 put(7,"g");
			 put(8,"h");
		 }};
		 
	 public static void main (String[] args) throws IOException {
       
    	String filePath="D:\\codeEval\\knightMoves.txt";
        
		BufferedReader buffer = new BufferedReader(new FileReader(filePath));
        String line;
        
        while ((line = buffer.readLine()) != null) {
            
        		line = line.trim();
        		
        		if(line!=null && !"".equalsIgnoreCase(line)){
        			
        			System.out.println(line+"\n");
        			System.out.println(findMoves(line));
        		}
         }
    }
    
    public static String findMoves(String input) {
	  	
	 	StringBuilder output = new StringBuilder();
	 	StringBuffer sb=new StringBuffer();
 		
	 	String cPosition;
	 	
	 	char chessChar=input.charAt(0);//Column Header as 'a','b'
	 	int chessDigit=Character.getNumericValue(input.charAt(1)); // Positions of Column cell. [1...8]
	 	int chessCharDigit=boardMap.get(String.valueOf(chessChar)); // Numberic Value of Column Header like a=1

	 	int cDigit=0;
	 	int Move1Digit=0;
	 	int Move2Digit=0;
	 	
	 	//System.out.println("chessChar : "+chessChar+" | chessDigit : "+chessDigit+" | chessCharDigit : "+chessCharDigit);
	 	
	 	/** Chess Position should be valid between 1 to 8 only */
	 	if(chessDigit>=1 && chessDigit<=8){
	 		
	 		/**  finding Left Moves
	 		 *   Note : Left moves possible only from c column onwards in Chess
	 		 *   |_ _
	 		 *   |
	 		 */
	 		if(chessCharDigit>=3){
	 			
	 			cDigit=chessCharDigit-2;
	 			cPosition=boardPosMap.get(cDigit);
	 			
	 			//System.out.println("Left Digit : "+cDigit+" | leftPosition : "+cPosition);
	 			
	 			/** Appending Lower Left Move */
	 			if(cDigit>=1){
	 				
	 				Move1Digit=chessDigit-1;
	 				//System.out.println("lowerLeftMoveDigit : "+Move1Digit);
	 				
	 				if(Move1Digit>0 && Move1Digit<=8){
	 					
	 					/** Appending Lower Left Move */
		 				output.append(cPosition);
		 				output.append(Move1Digit);
		 				output.append(" ");
	 				}
	 			}
	 			
	 			/** Appending Upper Left*/
	 			if(chessDigit<8){
	 				
	 				Move2Digit=chessDigit+1;
	 				//System.out.println("upperLeftMoveDigit : "+Move2Digit);
	 				
	 				if(Move2Digit>0 && Move2Digit<=8){
	 					
	 					/** Appending Upper Left Move */
		 				output.append(cPosition);
		 				output.append(Move2Digit);
		 				output.append(" ");
	 				}
	 				
	 			}
	 			
	 		}else{
	 			//System.out.println("No Left Moves Possible");
	 		}
	 		
	 		
	 		/**  finding Top Moves
	 		 *   Note : Top moves possible only from below 7th column in Chess
	 		 *   After adding 2 positions,columns changes but position remains Same.
	 		 *   __ __
	 		 *     |
	 		 *     |
	 		 */
	 		if(chessDigit<7 && chessDigit>0){
	 			
	 			cDigit=chessDigit+2;
	 			
	 			if((chessCharDigit-1)>0){
	 				
	 				cPosition=boardPosMap.get(chessCharDigit-1);
		 			
	 				if(cPosition!=null){
	 					
	 					/** Finding Upper Top Move */
			 			Move1Digit=cDigit;
			 			
			 			//System.out.println("Top Digit : "+Move1Digit+" | Top Left Position : "+cPosition);
			 			
			 			if(Move1Digit>0 && Move1Digit<=8){
			 				
			 				/** Appending Upper Left Top Move */
			 				output.append(cPosition);
			 				output.append(Move1Digit);
			 				output.append(" ");
			 			}
			 			
		 				
	 				}
		 		}
 				
	 			if((chessCharDigit+1) >0 && (chessCharDigit+1)<=8){
	 				
	 				cPosition=boardPosMap.get(chessCharDigit+1);
	 				Move2Digit=cDigit;
	 				
	 				//System.out.println("Top Digit : "+Move2Digit+" | Top Right Position : "+cPosition);
		 			
	 				if(cPosition!=null){
	 					
	 					if(Move2Digit>0 && Move2Digit<=8){
			 				
		 					/** Appending Upper Right Top Move */
			 				output.append(cPosition);
			 				output.append(Move2Digit);
			 				output.append(" ");
			 			}
	 				}
	 			}
	 			
	 		}else{
	 			//System.out.println("No Top Moves Possible");
	 		}
	 		
	 		
	 		/**  finding Right side Moves
	 		 *   Note : Right side moves possible only from column before g in Chess
	 		 *   After adding 2 positions right, will change column cell locations but
	 		 *   column will remain same.
	 		 *   __ __|
	 		 *        |
	 		 */
	 		if(chessCharDigit<7 && chessCharDigit>=0){
	 			
	 			cDigit=chessDigit;
	 			cPosition=boardPosMap.get(chessCharDigit+2);
	 			
	 			if(cPosition!=null){
	 				
	 				/** Finding Upper Top Move */
		 			Move1Digit=cDigit+1;
	 				
		 			//System.out.println("Top Right Digit : "+Move1Digit+" | Top Right Cell Header Position : "+cPosition);
		 			
		 			if(Move1Digit>0 && Move1Digit<=8){
		 				
		 				/** Appending Upper Left Top Move */
		 				output.append(cPosition);
		 				output.append(Move1Digit);
		 				output.append(" ");
		 			}
		 			
		 			Move2Digit=cDigit-1;
	 				
	 				//System.out.println("Botton Right Digit : "+Move2Digit+" | Top Right Cell Header Position : "+cPosition);
		 			
	 				if(Move2Digit>0 && Move2Digit<=8){
		 				
	 					/** Appending Upper Right Top Move */
	 	 				output.append(cPosition);
	 	 				output.append(Move2Digit);
	 	 				output.append(" ");
		 			}
	 			}
	 			
	 		}else{
	 			//System.out.println("No Right Side Moves Possible");
	 		}
	 		
	 		/**  finding Bottom side Moves
	 		 *   Note : Botton side moves possible only from column chess cell location 3 or higher in Chess
	 		 *   After deducting 2 positions for bottom, will change column cell locations but header will
	 		 *   remain same.
	 		 *     |
	 		 *    _|_
	 		 */
	 		if(chessDigit>=3){
	 			
	 			cDigit=chessDigit-2;
	 			cPosition=boardPosMap.get(chessCharDigit-1);
	 			
	 			if(cPosition!=null){
	 				
	 				/** Finding Upper Top Move */
		 			Move1Digit=cDigit;
	 				
		 			//System.out.println("Bottom Right Digit : "+Move1Digit+" | Bottom left Cell Header Position : "+cPosition);
		 			
		 			if(Move1Digit>0 && Move1Digit<=8){
		 				
		 				/** Appending Bottom Right Move */
		 				output.append(cPosition);
		 				output.append(Move1Digit);
		 				output.append(" ");
		 				
		 			}
	 			}
	 			
	 			cPosition=boardPosMap.get(chessCharDigit+1);
 				
	 			if(cPosition!=null){
	 				
	 				Move2Digit=cDigit;
	 				
	 				//System.out.println("Bottom Left Digit : "+Move2Digit+" | Bottom Right Cell Header Position : "+cPosition);
		 			
	 				if(Move2Digit>0 && Move2Digit<=8){
		 				
	 					/** Appending Bottom left Move */
		 				output.append(cPosition);
		 				output.append(Move2Digit);
		 				output.append(" ");
		 				
		 			}
	 			}
	 			
	 		}else{
	 			//System.out.println("No Bottom Moves Possible");
	 		}
	 		
	 		//System.out.println("Final Result BS : "+output.toString().trim());
	 		
	 		String[] arry=output.toString().split(" ");
	 		List<String> values=Arrays.asList(arry);
	 		
	 		Collections.sort(values);
	 		
	 		for(String str : values){
	 			
	 			sb.append(str);
	 			sb.append(" ");
	 		}
	 		
	 		//System.out.println("Final Result : "+sb.toString().trim());
	 		
	 	}
	 	
	    return sb.toString().trim();
	}
}
