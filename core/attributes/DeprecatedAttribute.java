package jbml.core.attributes;

public class DeprecatedAttribute extends Attribute
{	
	public String getAttributeName() 
	{
		return "Deprecated";
	}

	public byte[] getExtraBytes() 
	{
		return new byte[0];
	}
}