package android.samutils.fasterserializerdemo;

import android.os.Bundle;
import android.samutils.fasterserializer.mapping.JacksonJsoner;
import android.samutils.fasterserializer.mapping.Jsoner;
import android.samutils.fasterserializer.mapping.Serializer;
import android.samutils.fasterserializer.mapping.value.IValueMap;
import android.samutils.fasterserializer.processor.ValueMapFiller;
import android.samutils.fasterserializerdemo.com.example.Example;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings({ "MagicNumber", "ResultOfMethodCallIgnored" })
public class MainActivity extends AppCompatActivity {
	
	private static final ExecutorService SINGLE_POOL_EXECUTOR =
		Executors.newSingleThreadExecutor();
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		final IValueMap valueMap = new ValueMapFiller();
		Serializer.setValueMap(valueMap);
		JacksonJsoner.setValueMap(valueMap);
		
		final MyPojo testPojo = new MyPojo();
		testPojo.someString = "some string";
		testPojo.someInt = 1337;
		
		Log.e("serializer test", "input pojo to json: " + Jsoner.toString(testPojo));
		
		//test write
		final byte[] bytesOut = Serializer.toBytes(testPojo, MyPojo.class);
		
		Log.e("serializer test", "bytes count: " + bytesOut.length);
		
		//test read
		final MyPojo testPojoOut = Serializer.read(bytesOut, MyPojo.class);
		
		Log.e("serializer test", "out pojo: " + Jsoner.toString(testPojoOut));
		
		try {
			test("jacksonjsoner read", () -> {
				
				try {
					JacksonJsoner.read(Data.WEATHER_JSON, Example.class);
				} catch (final IOException e) {
					e.printStackTrace();
				}
			});
			
			test("jsoner read", () -> Jsoner.read(Data.WEATHER_JSON));
			
			final Example example = JacksonJsoner.read(Data.WEATHER_JSON, Example.class);
			
			test("jsoner write", () -> Jsoner.toString(example));
			
			final byte[] exampleBytes = Serializer.toBytes(example, Example.class);
			
			Log.e(" example", Jsoner.toString(Serializer.read(exampleBytes, Example.class)));
			
			Log.e("example bytes", " " + exampleBytes.length);
			
			test("serializer toBytes ", () -> Serializer.toBytes(example, Example.class));
			
			test("serializer read ", () -> Serializer.read(exampleBytes, Example.class));
			
		} catch (final IOException e) {
			e.printStackTrace();
		}
		
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		final int id = item.getItemId();
		
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	private static void test(final String msg, final Runnable r) {
		SINGLE_POOL_EXECUTOR.execute(() -> {
			final int n = 10000;
			final long t = System.nanoTime();
			for (int i = 0; i < n; i++) {
				r.run();
			}
			Log.e("test", msg + ": " + (System.nanoTime() - t) / n);
		});
	}
}
