package jbml.core.attributes.code;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import jbml.core.ByteClass;
import jbml.core.attributes.Attribute;

public class CodeAttribute extends Attribute
{
	private int maxStack;
	private int maxLocals;
	private byte[] code;
	private ExceptionHandler[] handlers;
	private Attribute[] attributes;
	private ByteClass clazz;

	public CodeAttribute(int maxStack, int maxLocals, byte[] code, ExceptionHandler[] handlers, Attribute[] attributes, ByteClass clazz)
	{
		this.maxStack = maxStack;
		this.maxLocals = maxLocals;
		this.code = code;
		this.handlers = handlers;
		this.attributes = attributes;
		this.clazz = clazz;
	}
	
	public int getMaxStack() 
	{
		return maxStack;
	}

	public void setMaxStack(int maxStack) 
	{
		this.maxStack = maxStack;
	}

	public int getMaxLocals() 
	{
		return maxLocals;
	}

	public void setMaxLocals(int maxLocals) 
	{
		this.maxLocals = maxLocals;
	}

	public byte[] getCode() 
	{
		return code;
	}

	public void setCode(byte[] code) 
	{
		this.code = code;
	}

	public String getAttributeName() 
	{
		return "Code";
	}

	public byte[] getExtraBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeShort(maxStack);
			dos.writeShort(maxLocals);
			dos.writeInt(code.length);

			for(int b : code)
			{
				dos.writeByte(b);
			}
			
			dos.writeShort(handlers.length);
			
			for(ExceptionHandler handler : handlers)
			{
				dos.writeShort(handler.getStartCode());
				dos.writeShort(handler.getEndCode());
				dos.writeShort(handler.getHandlerCode());
				dos.writeShort(handler.getExceptionClass());
			}
			
			dos.writeShort(attributes.length);
			
			for(Attribute attribute : attributes)
			{
				dos.writeShort(clazz.UTF_8_Constant(attribute.getAttributeName()));
				dos.writeInt(attribute.getAttributeSize());
				dos.write(attribute.getExtraBytes());
			}		
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();
	}

	public ExceptionHandler[] getHandlers()
	{
		return handlers;
	}

	public void setHandlers(ExceptionHandler[] handlers) 
	{
		this.handlers = handlers;
	}

	public Attribute[] getAttributes() 
	{
		return attributes;
	}

	public void setAttributes(Attribute[] attributes) 
	{
		this.attributes = attributes;
	}

	public ByteClass getClazz() 
	{
		return clazz;
	}

	public void setClazz(ByteClass clazz) 
	{
		this.clazz = clazz;
	}
}
