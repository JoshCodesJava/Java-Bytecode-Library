package jbml.core.attributes;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ExceptionAttribute extends Attribute
{
	private int[] exceptions;

	public ExceptionAttribute(int[] exceptions)
	{
		this.setExceptions(exceptions);
	}
	
	public String getAttributeName() 
	{
		return "Exceptions";
	}

	public byte[] getExtraBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeShort(exceptions.length);
			
			for(int exceptions : exceptions)
				dos.writeShort(exceptions);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();	
	}

	public int[] getExceptions() 
	{
		return exceptions;
	}

	public void setExceptions(int[] exceptions) 
	{
		this.exceptions = exceptions;
	}
}