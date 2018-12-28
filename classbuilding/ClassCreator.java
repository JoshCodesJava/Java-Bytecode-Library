package jbml.core.classbuilding;

import java.net.URLClassLoader;
import java.util.ArrayList;

public final class ClassCreator 
{
	private ClassCreator(){}
	
	private static final ArrayList<ClassLoader> loaderList = new ArrayList<ClassLoader>();

	private static class ClazzLoader extends ClassLoader
	{				
		public Class<?> loadClazz(String name, byte[] code)
		{
			Class<?> temp = defineClass(name, code, 0, code.length);
			return temp;
		}
		
		public Class<?> findClass(String s) throws ClassNotFoundException
		{
			for(ClassLoader loader : loaderList)
			{
				try
				{
					return loader.loadClass(s);
				}
				catch(Exception e)
				{
					
				}
			}
			
			return super.findClass(s);
		}
	}
	
	private static final ClazzLoader loader = new ClazzLoader();

	public static Class<?> loadClass(String name, byte[] code)
	{
		return loader.loadClazz(name, code);
	}

	public static void addClassloader(URLClassLoader loader)
	{
		loaderList.add(loader);
	}
	
	public static void removeClassloader(URLClassLoader loader)
	{
		loaderList.remove(loader);
	}
}