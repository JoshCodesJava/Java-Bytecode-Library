package jbml.core.attributes.code.stackmaptable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class VerificationTypeInfo 
{
	public final static int ITEM_Top = 0;
	public final static int ITEM_Integer = 1;
	public final static int ITEM_Float = 2;
	public final static int ITEM_Double = 3;
	public final static int ITEM_Long = 4;
	public final static int ITEM_Null = 5;
	public final static int ITEM_UninitializedThis = 6;
	public final static int ITEM_Object = 7;
	public final static int ITEM_Uninitialized = 8;
	private int tag;
	private int extra;
	private boolean usesExtra;

	public VerificationTypeInfo(int tag)
	{
		this.tag = tag;
		usesExtra = false;
	}
	
	public VerificationTypeInfo(int tag, int extra)
	{
		this.tag = tag;
		this.extra = extra;
		usesExtra = true;
	}

	public int getTag() 
	{
		return tag;
	}

	public void setTag(int tag) 
	{
		this.tag = tag;
	}

	public int getExtra() 
	{
		return extra;
	}

	public void setExtra(int extra) 
	{
		this.extra = extra;
	}
	
	protected byte[] getBytes()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{			
			dos.writeByte(tag);
			
			if(usesExtra)
				dos.writeShort(extra);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();
	}
}