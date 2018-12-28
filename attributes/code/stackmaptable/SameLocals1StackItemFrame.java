package jbml.core.attributes.code.stackmaptable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SameLocals1StackItemFrame extends StackMapFrame
{
	private int frameType;
	private VerificationTypeInfo stack;
	
	public SameLocals1StackItemFrame(int frameType, VerificationTypeInfo stack)
	{
		this.frameType = frameType;
		this.stack = stack;
	}
	
	protected byte[] getBytes()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeByte(frameType);
			dos.write(stack.getBytes());
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

	public VerificationTypeInfo getStack() 
	{
		return stack;
	}

	public void setStack(VerificationTypeInfo stack)
	{
		this.stack = stack;
	}
}