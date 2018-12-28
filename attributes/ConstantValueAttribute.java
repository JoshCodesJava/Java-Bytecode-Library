package jbml.core.attributes;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantValueAttribute extends Attribute
{
	private int index;

	public ConstantValueAttribute(int index)
	{
		this.setIndex(index);
	}
	
	public String getAttributeName() 
	{
		return "ConstantValue";
	}

	public byte[] getExtraBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeShort(index);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();
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