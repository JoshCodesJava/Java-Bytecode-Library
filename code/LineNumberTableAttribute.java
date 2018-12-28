package jbml.core.attributes.code;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import jbml.core.attributes.Attribute;

public class LineNumberTableAttribute extends Attribute
{
	private LineNumberTableEntry[] entries;

	public LineNumberTableAttribute(LineNumberTableEntry[] entries)
	{
		this.setEntries(entries);
	}

	public String getAttributeName() 
	{
		return "LineNumberTable";
	}

	public byte[] getExtraBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeShort(entries.length);
			
			for(LineNumberTableEntry tableEntry : entries)
			{
				dos.writeShort(tableEntry.getStartCode());
				dos.writeShort(tableEntry.getLineNumber());
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();
	}

	public LineNumberTableEntry[] getEntries()
	{
		return entries;
	}

	public void setEntries(LineNumberTableEntry[] entries) 
	{
		this.entries = entries;
	}
}