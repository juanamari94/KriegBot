package bot.exceptions;

@SuppressWarnings("serial")
public class UnreachableNodeException extends IndexOutOfBoundsException{

	public UnreachableNodeException()
	{
		super();
	}
	
	public UnreachableNodeException(String message)
	{
		super(message);
	}
}
