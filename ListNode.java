
class ListNode
{
	char char1;
	ListNode next;
	ListNode prev;

	ListNode( char char1 )
	{
		this( char1, null, null );
	} 
	

	ListNode( char char1, ListNode next1, ListNode prev1 )
	{
		this.char1 = char1;
		next = next1;
		prev = prev1;
	}

	
	char getchar()
	
	{
		return char1; 
	}
	void setchar(char char1)
	
	{
		this.char1 = char1; 
	}

} 