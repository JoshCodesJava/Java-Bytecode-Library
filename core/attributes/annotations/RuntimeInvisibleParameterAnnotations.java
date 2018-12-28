package jbml.core.attributes.annotations;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import jbml.core.attributes.Attribute;

public class RuntimeInvisibleParameterAnnotations extends Attribute
{
	private int parameters;
	private Annotation[][] annotations;

	public RuntimeInvisibleParameterAnnotations(int parameters, Annotation[][] annotations)
	{
		this.parameters = parameters;
		this.annotations = annotations;
	}
	
	public String getAttributeName() 
	{
		return "RuntimeInvisibleParameterAnnotations";
	}

	public byte[] getExtraBytes() 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		
		try 
		{
			dos.writeByte(parameters);
			
			for(int i = 0; i < parameters; i++)
			{
				Annotation[] currentParamAnnotation = annotations[i];
				dos.writeShort(currentParamAnnotation.length);
				
				for(Annotation currentAnnotation : currentParamAnnotation)
				{
					dos.writeShort(currentAnnotation.getTypeIndex());
					dos.writeShort(currentAnnotation.getValuePairs().length);
					
					for(ElementValuePair pair : currentAnnotation.getValuePairs())
					{
						dos.writeShort(pair.getElementIndex());
						dos.write(pair.getValue().getBytes());
					}
				}
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return stream.toByteArray();	
	}

	public Annotation[][] getAnnotations() 
	{
		return annotations;
	}

	public void setAnnotations(Annotation[][] annotations) 
	{
		this.annotations = annotations;
	}
}