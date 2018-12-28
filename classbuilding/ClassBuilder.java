package jbml.core.classbuilding;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import jbml.core.ByteClass;
import jbml.core.Field;
import jbml.core.Method;
import jbml.core.attributes.Attribute;

public final class ClassBuilder 
{	
	private ClassBuilder()
	{
		
	}
	
	public static byte[] buildClass(ByteClass clazz, int minorVersion, int majorVersion) throws IOException
	{
		byte[] header = getHeaderBytes(minorVersion, majorVersion);
		byte[] classCode = getClassCode(clazz);
		byte[] constantPool = clazz.getConstantPoolByteCode();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		stream.write(header);
		stream.write(constantPool);
		stream.write(classCode);
		return stream.toByteArray();
	}

	private static byte[] getHeaderBytes(int minorVersion, int majorVersion) throws IOException 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeInt(0xcafebabe);
		dos.writeShort(minorVersion);
		dos.writeShort(majorVersion);
		return stream.toByteArray();
	}

	private static byte[] getClassCode(ByteClass clazz) throws IOException 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeShort(clazz.getModifiers());
		dos.writeShort(clazz.classConstant(clazz.getClassName()));
		dos.writeShort(clazz.classConstant(clazz.getSuperClassName()));
		String[] interfaces = clazz.getInterfaces();
		dos.writeShort(interfaces.length);
		
		for(String currentInterface : interfaces)
			dos.writeShort(clazz.classConstant(currentInterface));
		
		Field[] fields = clazz.getFields();
		dos.writeShort(fields.length);
		
		for(Field field : fields)
		{
			dos.writeShort(field.getModifiers());
			dos.writeShort(clazz.UTF_8_Constant(field.getName()));
			dos.writeShort(clazz.UTF_8_Constant(field.getDescriptor()));
			
			Attribute[] attributes = field.getAttributes();
			dos.writeShort(attributes.length);
			
			for(Attribute attribute : attributes)
			{
				dos.writeShort(clazz.UTF_8_Constant(attribute.getAttributeName()));
				dos.writeInt(attribute.getAttributeSize());
				dos.write(attribute.getExtraBytes());
			}
		}
		
		Method[] methods = clazz.getMethods();
		dos.writeShort(methods.length);
		
		for(Method method : methods)
		{
			dos.writeShort(method.getModifiers());
			dos.writeShort(clazz.UTF_8_Constant(method.getName()));
			dos.writeShort(clazz.UTF_8_Constant(method.getDescriptor()));
			
			Attribute[] attributes = method.getAttributes();
			dos.writeShort(attributes.length);
			
			for(Attribute attribute : attributes)
			{
				dos.writeShort(clazz.UTF_8_Constant(attribute.getAttributeName()));
				dos.writeInt(attribute.getAttributeSize());
				dos.write(attribute.getExtraBytes());
			}
		}
		
		Attribute[] attributes = clazz.getAttributes();
		dos.writeShort(attributes.length);
		
		for(Attribute attribute : attributes)
		{
			dos.writeShort(clazz.UTF_8_Constant(attribute.getAttributeName()));
			dos.writeInt(attribute.getAttributeSize());
			dos.write(attribute.getExtraBytes());
		}
		
		return stream.toByteArray();
	}
}