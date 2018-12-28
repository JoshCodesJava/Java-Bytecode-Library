package jbml.core.attributes.annotations;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ElementValue
{
	private char tag;
	private Object value;

	public ElementValue(char tag, Object value)
	{
		this.setTag(tag);
		this.setValue(value);
	}

	protected byte[] getBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);

		try 
		{
			dos.writeByte(tag);

			switch(tag)
			{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
			case 'c':
				dos.writeShort((int) value);
				break;
			case 'e':
				EnumValue enumInfo = (EnumValue)value;
				dos.writeShort((int) enumInfo.getClassName());
				dos.writeShort((int) enumInfo.getValueName());
				break;
			case '@':
				Annotation annotation = (Annotation) value;
				dos.writeShort(annotation.getTypeIndex());
				dos.writeShort(annotation.getValuePairs().length);

				for(ElementValuePair pair : annotation.getValuePairs())
				{
					dos.writeShort(pair.getElementIndex());
					dos.write(pair.getValue().getBytes());
				}
			case '[':
				ArrayValue array = (ArrayValue) value;
				dos.writeShort(array.getIndices().length);
				
				for(int i : array.getIndices())
				{
					ElementValue val = new ElementValue(array.getType(), i);
					dos.write(val.getBytes());
				}
				
				break;
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return stream.toByteArray();
	}

	public char getTag() 
	{
		return tag;
	}

	public void setTag(char tag) 
	{
		this.tag = tag;
	}

	public Object getValue() 
	{
		return value;
	}

	public void setValue(Object value) 
	{
		this.value = value;
	}
}