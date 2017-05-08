package android.samutils.fasterserializerdemo;


import android.samutils.fasterserializer.processor.Value;

public class Data {
	
	@Value
	public String s;
	@Value
	public int i;
	@Value
	public Data d;
}
