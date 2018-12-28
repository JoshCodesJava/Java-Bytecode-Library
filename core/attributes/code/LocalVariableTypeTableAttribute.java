package jbml.core.attributes.code;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import jbml.core.attributes.Attribute;

public class LocalVariableTypeTableAttribute extends Attribute
{
	private LocalVariableTableEntry[] entries;

	public LocalVariableTypeTableAttribute(LocalVariableTableEntry[] entries)
	{
		this.entries = entries;
	}

	public String getAttributeName() 
	{
		return "LocalVariableTypeTable";
	}

	public byte[] getExtraBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeShort(entries.length);
			
			for(LocalVariableTableEntry tableEntry : entries)
			{
				dos.writeShort(tableEntry.getStartCode());
				dos.writeShort(tableEntry.getLength());
				dos.writeShort(tableEntry.getNameIndex());
				dos.writeShort(tableEntry.getDescriptorIndex());
				dos.writeShort(tableEntry.getIndex());
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();
	}

	public LocalVariableTableEntry[] getEntries()
	{
		return entries;
	}

	public void setEntries(LocalVariableTableEntry[] entries) 
	{
		this.entries = entries;
	}
}