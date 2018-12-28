package jbml.core.attributes.code.stackmaptable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ChopFrame extends StackMapFrame
{
	private int offset;
	private int frameType;
	
	public ChopFrame(int frameType, int offset)
	{
		this.frameType = frameType;
		this.offset = offset;
	}
	
	protected byte[] getBytes()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeByte(frameType);
			dos.writeShort(offset);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();	
	}

	public int getFrameType() 
	{
		return frameType;
	}

	public void setFrameType(int frameType) 
	{
		this.frameType = frameType;
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