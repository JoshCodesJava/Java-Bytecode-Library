package jbml.core.attributes.code.stackmaptable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SameFrameExtended extends StackMapFrame
{
	private int offset;

	public SameFrameExtended(int offset)
	{
		this.offset = offset;
	}
	
	protected byte[] getBytes()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeByte(251);
			dos.writeShort(offset);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();
	}

	public int getOffset()
	{
		return offset;
	}

	public void setOffset(int offset) 
	{
		this.offset = offset;
	}
}