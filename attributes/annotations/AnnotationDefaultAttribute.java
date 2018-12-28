package jbml.core.attributes.annotations;
import jbml.core.attributes.Attribute;

public class AnnotationDefaultAttribute extends Attribute
{
	private ElementValue elementValue;

	public AnnotationDefaultAttribute(ElementValue elementValue) 
	{
		this.elementValue = elementValue;
	}

	public String getAttributeName() 
	{
		return "AnnotationDefault";
	}

	public byte[] getExtraBytes() 
	{
		return elementValue.getBytes();
	}

	public ElementValue getElementValue()
	{
		return elementValue;
	}

	public void setElementValue(ElementValue elementValue) 
	{
		this.elementValue = elementValue;
	}
}