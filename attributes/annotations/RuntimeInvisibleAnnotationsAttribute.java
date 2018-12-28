package jbml.core.attributes.annotations;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import jbml.core.attributes.Attribute;

public class RuntimeInvisibleAnnotationsAttribute extends Attribute
{
	private Annotation[] annotations;

	public RuntimeInvisibleAnnotationsAttribute(Annotation[] annotations)
	{
		this.setAnnotations(annotations);
	}
	
	public String getAttributeName() 
	{
		return "RuntimeInvisibleAnnotations";
	}

	public byte[] getExtraBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeShort(annotations.length);
			
			for(Annotation annotation : annotations)
			{
				dos.writeShort(annotation.getTypeIndex());
				dos.writeShort(annotation.getValuePairs().length);
				
				for(ElementValuePair pair : annotation.getValuePairs())
				{
					dos.writeShort(pair.getElementIndex());
					dos.write(pair.getValue().getBytes());
				}
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();
	}

	public Annotation[] getAnnotations() 
	{
		return annotations;
	}

	public void setAnnotations(Annotation[] annotations) 
	{
		this.annotations = annotations;
	}
}