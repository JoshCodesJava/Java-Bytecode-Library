package jbml.core.attributes.annotations;

public class ArrayValue 
{
	private char type;
	private int[] indices;

	public ArrayValue(char type, int[] indices)
	{
		this.type = type;
		this.indices = indices;
	}
	
	public char getType() 
	{
		return type;
	}

	public void setType(char type) 
	{
		this.type = type;
	}

	public int[] getIndices() 
	{
		return indices;
	}

	public void setIndices(int[] indices) 
	{
		this.indices = indices;
	}
}