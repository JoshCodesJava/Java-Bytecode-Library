package jbml.core.attributes.innerclasses;

public class InnerClassInfo 
{
	private int innerClassInfoIndex;
	private int outerClassInfoIndex;
	private int innerNameIndex;
	private int innerClassAccessFlags;

	public InnerClassInfo(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccessFlags)
	{
		this.innerClassInfoIndex = innerClassInfoIndex;
		this.outerClassInfoIndex = outerClassInfoIndex;
		this.innerNameIndex = innerNameIndex;
		this.innerClassAccessFlags = innerClassAccessFlags;
	}

	public int getInnerClassInfoIndex() 
	{
		return innerClassInfoIndex;
	}

	public void setInnerClassInfoIndex(int innerClassInfoIndex) 
	{
		this.innerClassInfoIndex = innerClassInfoIndex;
	}

	public int getOuterClassInfoIndex() 
	{
		return outerClassInfoIndex;
	}

	public void setOuterClassInfoIndex(int outerClassInfoIndex) 
	{
		this.outerClassInfoIndex = outerClassInfoIndex;
	}

	public int getInnerNameIndex() 
	{
		return innerNameIndex;
	}

	public void setInnerNameIndex(int innerNameIndex) 
	{
		this.innerNameIndex = innerNameIndex;
	}

	public int getInnerClassAccessFlags() 
	{
		return innerClassAccessFlags;
	}

	public void setInnerClassAccessFlags(int innerClassAccessFlags) 
	{
		this.innerClassAccessFlags = innerClassAccessFlags;
	}
}