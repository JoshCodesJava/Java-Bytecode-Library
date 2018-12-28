package jbml.core.attributes.code.stackmaptable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SameLocals1StackItemFrameExtended extends StackMapFrame
{
	private int offset;
	private VerificationTypeInfo stack;
	
	public SameLocals1StackItemFrameExtended(int offset, VerificationTypeInfo stack)
	{
		this.offset = offset;
		this.stack = stack;
	}
	
	protected byte[] getBytes()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeByte(247);
			dos.writeShort(offset);
			dos.write(stack.getBytes());
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

	public VerificationTypeInfo getStack() 
	{
		return stack;
	}

	public void setInfo(VerificationTypeInfo stack)
	{
		this.stack = stack;
	}
}