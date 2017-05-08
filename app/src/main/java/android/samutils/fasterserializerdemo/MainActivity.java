package android.samutils.fasterserializerdemo;

import android.os.Bundle;
import android.samutils.fasterserializer.mapping.Jsoner;
import android.samutils.fasterserializer.mapping.Serializer;
import android.samutils.fasterserializer.processor.ValueMapFiller;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Serializer.setValueMap(new ValueMapFiller());
		
		MyPojo testPojo = new MyPojo();
		testPojo.someString = "some string";
		testPojo.someInt = 1337;
		
		Log.d("serializer test", "input pojo to json: "+Jsoner.toString(testPojo));
		
		//test write
		byte[] bytesOut = Serializer.toBytes(testPojo);
		
		Log.d("serializer test", "bytes count: "+bytesOut.length);
		
		//test read
		MyPojo testPojoOut = Serializer.read(bytesOut);
		
		Log.d("serializer test", "out pojo: "+ Jsoner.toString(testPojoOut));
	
		
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
					.setAction("Action", null).show();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
