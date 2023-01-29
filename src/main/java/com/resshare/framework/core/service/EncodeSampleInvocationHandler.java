package com.resshare.framework.core.service;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.resshare.framework.model.MethodMetadata;
import com.resshare.framework.model.ReturnMethod;
import com.resshare.framework.model.Script;

public class EncodeSampleInvocationHandler implements InvocationHandler {
	String name;
	private Script script;

	public EncodeSampleInvocationHandler(String name, Script script) {
		this.name = name;// TODO Auto-generated constructor stub
		this.script = script;
	}

	public String getName() {
		return name;
	}

	public EncodeSampleInvocationHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		try {

			if ("getName".equals(method.getName()))
				return name;
			MethodMetadata mt = new MethodMetadata();
			ReturnMethod returnMethod = new ReturnMethod();
			// mt.setInstanceClassName(method.getDeclaringClass().getName());
			mt.setMethodName(method.getName());
			mt.setInstanceName(name);
			if ("setOnClickListener".equals((method.getName()))) {

				ArrayList<Serializable> arrLst = new ArrayList<>();
				arrLst.add(((ViewOnClickListener) args[0]).getName());
				mt.setMethodParam(arrLst.toArray());
			} else {

				if (args != null) {

					mt.setMethodParamType(method.getParameterTypes());
					// method.getGenericParameterTypes()
					
					Object[] args1= new  Object[args.length]   ;
					int i=0;
					for (Object varian : args) {
						Object value = script.getVarian(varian);
						 if(value !=null)
						{
							 while(true)
							 {
								 
								if(value instanceof ReturnMethod)
								{
									break;
									
									
								}
								  Object value1 = script.getVarian(value);
								if(  value1==null)
								{	break;
								}
								else
								{
									
									value=value1;
									
								}
								
									
								 
							 }
							 
							 args1[i]=value;
							
						}
						else
						{
							 args1[i]=varian;
						}
						i++;
					}
					 
					mt.setMethodParam (args1);
					

				}
			}

			int i = script.getVarianCount();
		 
			String varianName = mt.getInstanceName() + "_" + mt.getMethodName() + "_" + i+"_" + getIdentify();
			
			if ("getSelectField".equals(method.getName()))
				varianName=varianName+args[0];
			returnMethod.setVarianName(varianName);
			// if("com.resshare.framework.model.MapObject".equals(
			// method.getDeclaringClass().getName()))
			// {
			// if( "setFieldValue".equals(method.getName()))
			// {
			// if(args.length>2)
			// returnMethod.setVarianName((String.valueOf(( args[1].toString() );
			// }
			//
			// }

			mt.setReturnMethod(returnMethod);

			script.addCommand(mt);
			script.addReturn(returnMethod);

			if (method.getReturnType() != null) {
				String className = method.getReturnType().getName();
				if ("void".endsWith(className))
					return null;
				Object objetClassss = null;
				if (("java.lang.CharSequence".equals(className)) || ("java.lang.String".equals(className))) {
				//	Date date = new Date();
					objetClassss = getIdentify();// String.valueOf(date.getTime());

				} else

				{

					Class<?> classss = Class.forName(className);
					objetClassss = classss.getConstructor().newInstance(new Object[] {});
				}
				script.addVarian(objetClassss, returnMethod);
				return objetClassss;

			}
			return returnMethod;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static long lIdentify=Long.MIN_VALUE;
public static String getIdentify()
{ 
	if(lIdentify< Long.MAX_VALUE)
	lIdentify=lIdentify+1;
	else 
		 lIdentify=Long.MIN_VALUE;
	return "Encode"+lIdentify;
	}
}