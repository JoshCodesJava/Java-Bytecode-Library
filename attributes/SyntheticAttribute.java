package jbml.core.attributes;

public class SyntheticAttribute extends Attribute
{	
	public String getAttributeName() 
	{
		return "Synthetic";
	}

	public byte[] getExtraBytes() 
	{
		return new byte[0];
	}
}