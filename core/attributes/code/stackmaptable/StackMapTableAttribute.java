package jbml.core.attributes.code.stackmaptable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import jbml.core.attributes.Attribute;

public class StackMapTableAttribute extends Attribute 
{
	private StackMapFrame[] frames;

	public StackMapTableAttribute(StackMapFrame[] frames)
	{
		this.frames = frames;
	}
	
	public String getAttributeName()
	{
		return "StackMapTable";
	}

	public byte[] getExtraBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeShort(frames.length);
			
			for(StackMapFrame frame : frames)
				dos.write(frame.getBytes());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();
	}

	public StackMapFrame[] getFrames() 
	{
		return frames;
	}

	public void setFrames(StackMapFrame[] frames) 
	{
		this.frames = frames;
	}
}