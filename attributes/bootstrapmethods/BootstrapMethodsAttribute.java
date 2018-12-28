package jbml.core.attributes.bootstrapmethods;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import jbml.core.attributes.Attribute;

public class BootstrapMethodsAttribute extends Attribute
{
	private BootstrapMethod[] methods;

	public BootstrapMethodsAttribute(BootstrapMethod[] methods)
	{
		this.methods = methods;
	}

	public String getAttributeName() 
	{
		return "BootstrapMethods";
	}

	public byte[] getExtraBytes()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeShort(methods.length);
			
			for(BootstrapMethod method : methods)
			{
				dos.writeShort(method.getMethodRef());
				dos.writeShort(method.getArguments().length);
				
				for(int arg : method.getArguments())
					dos.writeShort(arg);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();	
	}

	public BootstrapMethod[] getMethods()
	{
		return methods;
	}

	public void setMethods(BootstrapMethod[] methods) 
	{
		this.methods = methods;
	}
}