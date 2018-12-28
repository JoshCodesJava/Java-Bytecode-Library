package jbml.core.attributes.annotations;

public class EnumValue 
{
	private int className;
	private int valueName;

	public EnumValue(int className, int valueName)
	{
		this.setClassName(className);
		this.setValueName(valueName);
	}

	public int getClassName() 
	{
		return className;
	}

	public void setClassName(int className) 
	{
		this.className = className;
	}

	public int getValueName() 
	{
		return valueName;
	}

	public void setValueName(int valueName) 
	{
		this.valueName = valueName;
	}
}