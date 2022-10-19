import java.io.*;
import java.util.*;

public class DNAPalindrome {
   public static void main(String[] args) {
	   CharDoubleEndedQueueImpl A = new CharDoubleEndedQueueImpl();
	   
	   Scanner reader = new Scanner(System.in);
	   char x = 'A';
	   System.out.println("Please enter a DNA sequence to check if it is Watson-Crick Palindrome.(USE CAPITAL LETTERS ONLY!)");
	   System.out.println("To stop the sequence and check it, please type in '0' and press enter.");
	   
	   while(x == 'A' || x == 'T' || x == 'C' || x == 'G'){
		   x = reader.next().charAt(0);
		   A.addLast(x);
	   }
	   if(x == '0'){
		   A.removeLast();
		   String initial="";
		   //save the initial state of the sequence
		   ListNode current = A.start;
		   while(current != null){
			   initial = initial + current.getchar();
			   current = current.next;
		   }
		   //change the sequence
		   current = A.start; 
		   while(current != null){
			   if(current.getchar() == 'A'){
				   current.setchar('T');
			   }
			   else if(current.getchar() == 'T'){
				   current.setchar('A');
			   }
			   else if(current.getchar() == 'C'){
				   current.setchar('G');
			   }
			   else if(current.getchar() == 'G'){
				   current.setchar('C');
			   }
			   current = current.next;
		   }
		   //invert the queue
		   int important_counter = 0;
		   ListNode tmp = new ListNode('A');
		   current = A.start;
		   ListNode current1 = A.end;
		   while(important_counter != (A.size()/2)){
			   tmp.setchar(current.getchar());
			   current.setchar(current1.getchar());
			   current1.setchar(tmp.getchar());
			   current = current.next;
			   current1 = current1.prev;
			   important_counter++;
		   }
		   //assembling finale
		   String finale="";
		   current = A.start;
		   while(current != null){
			   finale = finale + current.getchar();
			   current = current.next;
		   }
		   if(finale.equals(initial)){
			   System.out.println("HOORAY THIS IS A WATSON CRICK PALINDROME!");
		   }
		   else{
			   System.out.println("we are sorry, but this is not a Watson-Crick Palindrome...");
		   }
	   }
	   else{
		   System.out.println("Error, incompatible char!");
	   }
   }
}