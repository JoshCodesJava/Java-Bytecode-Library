package jbml.core.attributes.code.stackmaptable;

public class SameFrame extends StackMapFrame
{
	private int frameType;

	public SameFrame(int frameType)
	{
		this.frameType = frameType;
	}
	
	protected byte[] getBytes()
	{
		return new byte[]{(byte) frameType};
	}

	public int getFrameType() 
	{
		return frameType;
	}

	public void setFrameType(int frameType)
	{
		this.frameType = frameType;
	}
}