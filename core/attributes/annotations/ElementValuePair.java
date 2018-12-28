package jbml.core.attributes.annotations;

public class ElementValuePair 
{
	private int elementIndex;
	private ElementValue value;

	public ElementValuePair(int elementIndex, ElementValue value)
	{
		this.setElementIndex(elementIndex);
		this.setValue(value);
	}

	public int getElementIndex() 
	{
		return elementIndex;
	}

	public void setElementIndex(int elementIndex) 
	{
		this.elementIndex = elementIndex;
	}

	public ElementValue getValue() 
	{
		return value;
	}

	public void setValue(ElementValue value) 
	{
		this.value = value;
	}
}