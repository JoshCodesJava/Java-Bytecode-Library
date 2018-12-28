package jbml.core.attributes.code.stackmaptable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FullFrame extends StackMapFrame
{
	private int offset;
	private VerificationTypeInfo[] locals;
	private VerificationTypeInfo[] stack;

	public FullFrame(int offset, VerificationTypeInfo[] locals, VerificationTypeInfo[] stack)
	{
		this.offset = offset;
		this.locals = locals;
		this.stack = stack;
	}
	
	protected byte[] getBytes()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeByte(255);
			dos.writeShort(offset);
			dos.writeShort(locals.length);
			
			for(VerificationTypeInfo info : locals)
			{
				dos.write(info.getBytes());
			}
			
			dos.writeShort(stack.length);
			
			for(VerificationTypeInfo info : stack)
			{
				dos.write(info.getBytes());
			}
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

	public VerificationTypeInfo[] getLocals() 
	{
		return locals;
	}

	public void setLocals(VerificationTypeInfo[] locals) 
	{
		this.locals = locals;
	}

	public VerificationTypeInfo[] getStack() 
	{
		return stack;
	}

	public void setStack(VerificationTypeInfo[] stack) 
	{
		this.stack = stack;
	}
}