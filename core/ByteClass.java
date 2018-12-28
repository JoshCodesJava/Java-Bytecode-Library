package jbml.core;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import jbml.core.attributes.Attribute;

public class ByteClass 
{
	private static final int UTF_8 = 1;
	private static final int INTEGER = 3;
	private static final int FLOAT = 4;
	private static final int LONG = 5;
	private static final int DOUBLE = 6;
	private static final int CLASS_REF = 7;
	private static final int STRING_REF = 8;
	private static final int FIELD_REF = 9;
	private static final int METHOD_REF = 10;
	private static final int INTERFACE_METHOD_REF = 11;
	private static final int NAME_AND_TYPE = 12;
	private static final int METHOD_HANDLE = 15;
	private static final int METHOD_TYPE = 16;
	private static final int INVOKE_DYNAMIC = 18;
	
	private ArrayList<Object[]> constantPool = new ArrayList<Object[]>();
	private String superClassName;
	private String className;
	private int modifiers;
	private ArrayList<String> interfaces = new ArrayList<String>();
	private ArrayList<Field> fields = new ArrayList<Field>();
	private ArrayList<Method> methods = new ArrayList<Method>();
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();

	public ByteClass(int modifiers, String className, String superClassName) 
	{
		this.setClassName(className);
		this.setSuperClassName(superClassName);
		this.setModifiers(modifiers);
	}

	public byte[] getConstantPoolByteCode() throws IOException 
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeShort(constantPool.size()+1);

		for(Object[] arr : constantPool)
		{
			if(arr != null)
			{
				dos.writeByte((int) arr[0]);

				switch((int) arr[0])
				{
				case UTF_8:
					dos.writeUTF((String)arr[1]);
					break;
				case INTEGER:
					dos.writeInt((int) arr[1]);
					break;
				case FLOAT:
					dos.writeFloat((float) arr[1]);
					break;
				case LONG:
					dos.writeLong((long) arr[1]);
					break;
				case DOUBLE:
					dos.writeDouble((double) arr[1]);
					break;
				case CLASS_REF:
					dos.writeShort((int) arr[1]);
					break;
				case STRING_REF:
					dos.writeShort((int) arr[1]);
					break;
				case FIELD_REF:
					dos.writeShort((int) arr[1]);
					dos.writeShort((int) arr[2]);
					break;
				case METHOD_REF:
					dos.writeShort((int) arr[1]);
					dos.writeShort((int) arr[2]);
					break;
				case INTERFACE_METHOD_REF:
					dos.writeShort((int) arr[1]);
					dos.writeShort((int) arr[2]);
					break;
				case NAME_AND_TYPE:
					dos.writeShort((int) arr[1]);
					dos.writeShort((int) arr[2]);
					break;
				case METHOD_HANDLE:
					dos.writeByte((int) arr[1]);
					dos.writeShort((int) arr[2]);
					break;
				case METHOD_TYPE:
					dos.writeShort((int) arr[1]);
					break;
				case INVOKE_DYNAMIC:
					dos.writeShort((int) arr[1]);
					dos.writeShort((int) arr[2]);
				}
			}
		}

		return stream.toByteArray();	
	}

	private int constant(Object... arr)
	{
		boolean contains = false;
		int index = 0;
		
		for(Object[] check : constantPool)
		{
			if(Arrays.equals(check, arr))
			{
				contains = true;
				index = constantPool.indexOf(check);
				break;
			}
		}
		
		if(!contains)
		{
			constantPool.add(arr);
			index = constantPool.indexOf(arr);
		}
		
		return index + 1;
	}

	public int UTF_8_Constant(String string) 
	{
		return constant(UTF_8, string);
	}

	public int integerConstant(int value) 
	{
		return constant(INTEGER, value);
	}

	public int floatConstant(float value) 
	{
		return constant(FLOAT, value);
	}

	public int longConstant(long value) 
	{
		int index = constant(LONG, value);
		constantPool.add(null);
		return index;
	}
	
	public int doubleConstant(double value) 
	{
		int index = constant(DOUBLE, value);
		constantPool.add(null);
		return index;
	}

	public int classConstant(String className) 
	{
		int classNameIndex = UTF_8_Constant(className);
		return constant(CLASS_REF, classNameIndex);
	}
	
	public int classConstant(int index) 
	{
		return constant(CLASS_REF, index);
	}
	
	public int stringConstant(String string)
	{
		int stringIndex = UTF_8_Constant(string);
		return constant(STRING_REF, stringIndex);
	}
	
	public int stringConstant(int index)
	{
		return constant(STRING_REF, index);
	}
	
	public int fieldRefConstant(String className, String identifier, String descriptor)
	{
		int classRef = classConstant(className);
		int nameAndTypeRef = nameAndTypeConstant(identifier, descriptor);
		return constant(FIELD_REF, classRef, nameAndTypeRef);
	}
	
	public int fieldRefConstant(int classIndex, int nameAndTypeIndex)
	{
		return constant(FIELD_REF, classIndex, nameAndTypeIndex);
	}
	
	public int methodRefConstant(String className, String identifier, String descriptor)
	{
		int classRef = classConstant(className);
		int nameAndTypeRef = nameAndTypeConstant(identifier, descriptor);
		return constant(METHOD_REF, classRef, nameAndTypeRef);
	}
	
	public int methodRefConstant(int classIndex, int nameAndTypeIndex)
	{
		return constant(METHOD_REF, classIndex, nameAndTypeIndex);
	}
	
	public int interfaceMethodRefConstant(String className, String identifier, String descriptor)
	{
		int classRef = classConstant(className);
		int nameAndTypeRef = nameAndTypeConstant(identifier, descriptor);
		return constant(INTERFACE_METHOD_REF, classRef, nameAndTypeRef);
	}
	
	public int interfaceMethodRefConstant(int classIndex, int nameAndTypeIndex)
	{
		return constant(INTERFACE_METHOD_REF, classIndex, nameAndTypeIndex);
	}
	
	public int nameAndTypeConstant(String identifier, String descriptor)
	{
		int identifierIndex = UTF_8_Constant(identifier);
		int descriptorIndex = UTF_8_Constant(descriptor);
		return constant(NAME_AND_TYPE, identifierIndex, descriptorIndex);
	}
	
	public int nameAndTypeConstant(int identifierIndex, int descriptorIndex)
	{
		return constant(NAME_AND_TYPE, identifierIndex, descriptorIndex);
	}
	
	public int methodHandleConstant(int kind, int index)
	{
		return constant(METHOD_HANDLE, kind, index);
	}
	
	public int methodTypeConstant(String descriptor)
	{
		return constant(METHOD_TYPE, UTF_8_Constant(descriptor));
	}
	
	public int methodTypeConstant(int descriptorIndex)
	{
		return constant(METHOD_TYPE, descriptorIndex);
	}
	
	public int invokeDynamicConstant(int index, String name, String descriptor)
	{
		return constant(INVOKE_DYNAMIC, index, nameAndTypeConstant(name, descriptor));
	}
	
	public int invokeDynamicConstant(int index, int nameAndTypeIndex)
	{
		return constant(INVOKE_DYNAMIC, index, nameAndTypeIndex);
	}

	public String getSuperClassName() 
	{
		return superClassName;
	}

	public void setSuperClassName(String superClassName) 
	{
		this.superClassName = superClassName;
	}

	public String getClassName() 
	{
		return className;
	}

	public void setClassName(String className) 
	{
		this.className = className;
	}

	public int getModifiers() 
	{
		return modifiers;
	}

	public void setModifiers(int modifiers) 
	{
		this.modifiers = modifiers;
	}

	public void addInterface(String interfaceName)
	{
		interfaces.add(interfaceName);
	}
	
	public void removeInterface(String interfaceName)
	{
		interfaces.remove(interfaceName);
	}
	
	public String[] getInterfaces()
	{
		return interfaces.toArray(new String[]{});
	}
	
	public void addField(Field field)
	{
		fields.add(field);
	}
	
	public void removeField(Field field)
	{
		fields.remove(field);
	}
	
	public Field[] getFields()
	{
		return fields.toArray(new Field[]{});
	}
	
	public void addMethod(Method method)
	{
		methods.add(method);
	}
	
	public void removeMethod(Method method)
	{
		methods.remove(method);
	}
	
	public Method[] getMethods()
	{
		return methods.toArray(new Method[]{});
	}

	public void addAttribute(Attribute attribute)
	{
		attributes.add(attribute);
	}
	
	public void removeAttribute(Attribute attribute)
	{
		attributes.remove(attribute);
	}
	
	public Attribute[] getAttributes()
	{
		return attributes.toArray(new Attribute[]{});
	}
}
