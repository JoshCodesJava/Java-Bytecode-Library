package jbml.core.attributes.code;

public class LocalVariableTableEntry 
{
	private int startCode;
	private int length;
	private int nameIndex;
	private int descriptorIndex;
	private int index;

	public LocalVariableTableEntry(int startCode, int length, int nameIndex, int descriptorIndex, int index)
	{
		this.startCode = startCode;
		this.length = length;
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
		this.index = index;
	}

	public int getStartCode() 
	{
		return startCode;
	}

	public void setStartCode(int startCode) 
	{
		this.startCode = startCode;
	}

	public int getLength() 
	{
		return length;
	}

	public void setLength(int length) 
	{
		this.length = length;
	}

	public int getNameIndex() 
	{
		return nameIndex;
	}

	public void setNameIndex(int nameIndex) 
	{
		this.nameIndex = nameIndex;
	}

	public int getDescriptorIndex() 
	{
		return descriptorIndex;
	}

	public void setDescriptorIndex(int descriptorIndex) 
	{
		this.descriptorIndex = descriptorIndex;
	}

	public int getIndex() 
	{
		return index;
	}

	public void setIndex(int index) 
	{
		this.index = index;
	}
}