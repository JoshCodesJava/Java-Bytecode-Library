package jbml.core.attributes.code.stackmaptable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AppendFrame extends StackMapFrame
{
	private int frameType;
	private int offset;
	private VerificationTypeInfo[] locals;
	
	public AppendFrame(int frameType, int offset, VerificationTypeInfo[] locals)
	{
		this.frameType = frameType;
		this.offset = offset;
		this.setLocals(locals);
	}
	
	protected byte[] getBytes()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeByte(frameType);
			dos.writeShort(offset);
			
			for(int i = 0; i < frameType - 251; i++)
			{
				dos.write(locals[0].getBytes());
			}
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

	public VerificationTypeInfo[] getLocals() 
	{
		return locals;
	}

	public void setLocals(VerificationTypeInfo[] locals) 
	{
		this.locals = locals;
	}
}