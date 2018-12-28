package jbml.core.attributes;

import java.nio.charset.Charset;

public class SourceDebugExtensionAttribute extends Attribute
{
	private String data;

	public SourceDebugExtensionAttribute(String data)
	{
		this.data = data;
	}
	
	public String getAttributeName() 
	{
		return "SourceDebugExtension";
	}

	public byte[] getExtraBytes() 
	{
		return data.getBytes(Charset.forName("UTF-8"));
	}

	public String getData() 
	{
		return data;
	}

	public void setData(String data) 
	{
		this.data = data;
	}

}