package jbml.core.attributes.annotations;

public class Annotation 
{
	private int typeIndex;
	private ElementValuePair[] valuePairs;

	public Annotation(int typeIndex, ElementValuePair[] valuePairs)
	{
		this.typeIndex = typeIndex;
		this.setValuePairs(valuePairs);
	}

	public int getTypeIndex() 
	{
		return typeIndex;
	}

	public void setTypeIndex(int typeIndex) 
	{
		this.typeIndex = typeIndex;
	}

	public ElementValuePair[] getValuePairs() 
	{
		return valuePairs;
	}

	public void setValuePairs(ElementValuePair[] valuePairs) 
	{
		this.valuePairs = valuePairs;
	}
}