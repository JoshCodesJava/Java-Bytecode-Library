package jbml.core.attributes;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EnclosingMethodAttribute extends Attribute
{
	private int classIndex;
	private int methodIndex;

	public EnclosingMethodAttribute(int classIndex, int methodIndex)
	{
		this.classIndex = classIndex;
		this.methodIndex = methodIndex;
	}
	
	public String getAttributeName() 
	{
		return "EnclosingMethod";
	}

	public byte[] getExtraBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeShort(classIndex);
			dos.writeShort(methodIndex);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();	
	}

	public int getClassIndex() 
	{
		return classIndex;
	}

	public void setClassIndex(int classIndex) 
	{
		this.classIndex = classIndex;
	}

	public int getMethodIndex() 
	{
		return methodIndex;
	}

	public void setMethodIndex(int methodIndex) 
	{
		this.methodIndex = methodIndex;
	}
}