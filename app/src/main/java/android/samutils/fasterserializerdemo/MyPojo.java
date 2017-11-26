package android.samutils.fasterserializerdemo;


import android.samutils.fasterserializer.processor.Value;

public class MyPojo {
	
	@Value
	public String someString;
	@Value
	public int someInt;
	@Value
	public MyPojo otherData;
	
}
