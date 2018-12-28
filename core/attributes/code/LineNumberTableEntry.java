package jbml.core.attributes.code;

public class LineNumberTableEntry 
{
	private int startCode;
	private int lineNumber;

	public LineNumberTableEntry(int startCode, int lineNumber)
	{
		this.startCode = startCode;
		this.lineNumber = lineNumber;
	}

	public int getStartCode() 
	{
		return startCode;
	}

	public void setStartCode(int startCode) 
	{
		this.startCode = startCode;
	}

	public int getLineNumber() 
	{
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) 
	{
		this.lineNumber = lineNumber;
	}
}