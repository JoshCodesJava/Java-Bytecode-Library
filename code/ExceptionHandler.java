package jbml.core.attributes.code;

public class ExceptionHandler 
{
	private int startCode;
	private int endCode;
	private int handlerCode;
	private int exceptionClass;

	public ExceptionHandler(int startCode, int endCode, int handlerCode, int exceptionClass)
	{
		this.startCode = startCode;
		this.endCode = endCode;
		this.handlerCode = handlerCode;
		this.exceptionClass = exceptionClass;
	}

	public int getStartCode() 
	{
		return startCode;
	}

	public void setStartCode(int startCode) 
	{
		this.startCode = startCode;
	}

	public int getEndCode() 
	{
		return endCode;
	}

	public void setEndCode(int endCode) 
	{
		this.endCode = endCode;
	}

	public int getHandlerCode() 
	{
		return handlerCode;
	}

	public void setHandlerCode(int handlerCode) 
	{
		this.handlerCode = handlerCode;
	}

	public int getExceptionClass() 
	{
		return exceptionClass;
	}

	public void setExceptionClass(int exceptionClass) 
	{
		this.exceptionClass = exceptionClass;
	}
}