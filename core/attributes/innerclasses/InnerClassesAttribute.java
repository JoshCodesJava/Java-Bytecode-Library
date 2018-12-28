package jbml.core.attributes.innerclasses;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import jbml.core.attributes.Attribute;

public class InnerClassesAttribute extends Attribute
{
	private InnerClassInfo[] infoArray;

	public InnerClassesAttribute(InnerClassInfo[] infoArray)
	{
		this.infoArray = infoArray;
	}

	public String getAttributeName() 
	{
		return "InnerClasses";
	}

	public byte[] getExtraBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);

		try 
		{
			dos.writeShort(infoArray.length);

			for(InnerClassInfo info : infoArray)
			{
				dos.writeShort(info.getInnerClassInfoIndex());
				dos.writeShort(info.getOuterClassInfoIndex());
				dos.writeShort(info.getInnerNameIndex());
				dos.writeShort(info.getInnerClassAccessFlags());
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return stream.toByteArray();
	}

	public InnerClassInfo[] getInfoArray() 
	{
		return infoArray;
	}

	public void setInfoArray(InnerClassInfo[] info) 
	{
		this.infoArray = info;
	}
}