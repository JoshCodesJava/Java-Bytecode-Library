package jbml.core.attributes.bootstrapmethods;

public class BootstrapMethod 
{
	private int methodRef;
	private int[] arguments;

	public BootstrapMethod(int methodRef, int[] arguments)
	{
		this.methodRef = methodRef;
		this.arguments = arguments;
	}

	public int getMethodRef() 
	{
		return methodRef;
	}

	public void setMethodRef(int methodRef) 
	{
		this.methodRef = methodRef;
	}

	public int[] getArguments() 
	{
		return arguments;
	}

	public void setArguments(int[] arguments) 
	{
		this.arguments = arguments;
	}
}