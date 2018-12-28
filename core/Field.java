package jbml.core;

import java.util.ArrayList;

import jbml.core.attributes.Attribute;

public class Field 
{
	private String name;
	private String descriptor;
	private int modifiers;
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	
	public Field(String name, String descriptor, int modifiers)
	{
		this.name = name;
		this.descriptor = descriptor;
		this.modifiers = modifiers;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getDescriptor()
	{
		return descriptor;
	}

	public void setDescriptor(String descriptor) 
	{
		this.descriptor = descriptor;
	}

	public int getModifiers() 
	{
		return modifiers;
	}

	public void setModifiers(int modifiers) 
	{
		this.modifiers = modifiers;
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