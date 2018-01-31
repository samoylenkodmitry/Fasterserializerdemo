# Fasterserializerdemo
Demo application demonstrates usage of 'faster-serializer' library

https://android-arsenal.com/details/1/6511

How to use library 'faster-serializer' (https://github.com/s-a--m/faster-serializer)

1. In module-app gradle after 'apply plugin...' insert:

```gradle
repositories {
	maven {
		url 'https://dl.bintray.com/dmitrysamoylenko/fasterserializer/'
	}
}
```

2. In android section insert annotation processor info:
```gradle
android {
	packagingOptions {
		exclude 'META-INF/license.txt'
		exclude 'META-INF/LICENSE'
	}
...
	defaultConfig {
...
		javaCompileOptions {
			annotationProcessorOptions {
				className 'android.samutils.fasterserializer.processor.AnnotationProcessor'
			}
		}

	}
```
3. In dependencies:
```gradle
dependencies {
...
	compile 'android.samutils:faster-serializer:+'// 0.9.5 for current time
	compile 'android.samutils:processorannotations:+'
	annotationProcessor 'android.samutils:processor:+'

}
```

Usage:

1. Create POJO

```java
public class MyPojo {

  @Value
  public String someString;
  @Value
  public int someInt;
  @Value
  public MyPojo someOtherData;

}
```

Note: each annotated field must be non-final public

2. Initialize Serializer before usage:

```java
		Serializer.setValueMap(new ValueMapFiller());
```
Note: class ValueMapFiller is auto generated after first POJO created and build successfully finished

3. Use public method of Serializer:

```java
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
```

```logcat
E/serializer test: input pojo to json: {"__class__":"android.samutils.fasterserializerdemo.MyPojo","someInt":1337,"someString":"some string"}
E/serializer test: bytes count: 46
E/serializer test: out pojo: {"__class__":"android.samutils.fasterserializerdemo.MyPojo","someInt":1337,"someString":"some string"}
E/ example: {"__class__":"android.samutils.fasterserializerdemo.com.example.Example","calctime":0.310699999332428,"cnt":15,"cod":"200","list":[{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":88},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.063289642333984,"lon":12.528590202331543},"dt":1485784982,"id":2208791,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":85,"pressure":961,"seaLevel":0,"temp":9.680000305175781,"tempMax":0,"tempMin":0},"name":"Yafran","rain":{"__class__":"android.samutils.fasterserializerdemo.com.example.Rain","_3h":0},"weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"light rain","icon":"10d","id":500,"main":"Rain"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":356,"speed":3.9600000381469727,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":56},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.93119812011719,"lon":12.081990242004395},"dt":1485784982,"id":2208425,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":89,"pressure":1036,"seaLevel":0,"temp":15.359999656677246,"tempMax":0,"tempMin":0},"name":"Zuwarah","weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"broken clouds","icon":"04d","id":803,"main":"Clouds"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":30,"speed":5.460000038146973,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":92},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.79335021972656,"lon":12.488450050354004},"dt":1485784982,"id":2212771,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":100,"pressure":1037,"seaLevel":0,"temp":15.3100004196167,"tempMax":0,"tempMin":0},"name":"Sabratah","weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"overcast clouds","icon":"04d","id":804,"main":"Clouds"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":28,"speed":6.710000038146973,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":92},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.172218322753906,"lon":13.020279884338379},"dt":1485784982,"id":2217362,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":90,"pressure":1004,"seaLevel":0,"temp":11.229999542236328,"tempMax":0,"tempMin":0},"name":"Gharyan","rain":{"__class__":"android.samutils.fasterserializerdemo.com.example.Rain","_3h":0},"weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"light rain","icon":"10d","id":500,"main":"Rain"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":16,"speed":3.859999895095825,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":40},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.752220153808594,"lon":12.72778034210205},"dt":1485784982,"id":2216885,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":55,"pressure":1024,"seaLevel":0,"temp":17,"tempMax":0,"tempMin":0},"name":"Zawiya","weather":[{"
E/example bytes:  3416
E/read from parcel: {"__class__":"android.samutils.fasterserializerdemo.com.example.Example","calctime":0.310699999332428,"cnt":15,"cod":"200","list":[{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":88},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.063289642333984,"lon":12.528590202331543},"dt":1485784982,"id":2208791,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":85,"pressure":961,"seaLevel":0,"temp":9.680000305175781,"tempMax":0,"tempMin":0},"name":"Yafran","rain":{"__class__":"android.samutils.fasterserializerdemo.com.example.Rain","_3h":0},"weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"light rain","icon":"10d","id":500,"main":"Rain"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":356,"speed":3.9600000381469727,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":56},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.93119812011719,"lon":12.081990242004395},"dt":1485784982,"id":2208425,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":89,"pressure":1036,"seaLevel":0,"temp":15.359999656677246,"tempMax":0,"tempMin":0},"name":"Zuwarah","weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"broken clouds","icon":"04d","id":803,"main":"Clouds"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":30,"speed":5.460000038146973,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":92},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.79335021972656,"lon":12.488450050354004},"dt":1485784982,"id":2212771,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":100,"pressure":1037,"seaLevel":0,"temp":15.3100004196167,"tempMax":0,"tempMin":0},"name":"Sabratah","weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"overcast clouds","icon":"04d","id":804,"main":"Clouds"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":28,"speed":6.710000038146973,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":92},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.172218322753906,"lon":13.020279884338379},"dt":1485784982,"id":2217362,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":90,"pressure":1004,"seaLevel":0,"temp":11.229999542236328,"tempMax":0,"tempMin":0},"name":"Gharyan","rain":{"__class__":"android.samutils.fasterserializerdemo.com.example.Rain","_3h":0},"weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"light rain","icon":"10d","id":500,"main":"Rain"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":16,"speed":3.859999895095825,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":40},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.752220153808594,"lon":12.72778034210205},"dt":1485784982,"id":2216885,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":55,"pressure":1024,"seaLevel":0,"temp":17,"tempMax":0,"tempMin":0},"name":"Zawiya","weat
E/read from parcel:: {"__class__":"android.samutils.fasterserializerdemo.com.example.Example","calctime":0.310699999332428,"cnt":15,"cod":"200","list":[{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":88},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.063289642333984,"lon":12.528590202331543},"dt":1485784982,"id":2208791,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":85,"pressure":961,"seaLevel":0,"temp":9.680000305175781,"tempMax":0,"tempMin":0},"name":"Yafran","rain":{"__class__":"android.samutils.fasterserializerdemo.com.example.Rain","_3h":0},"weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"light rain","icon":"10d","id":500,"main":"Rain"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":356,"speed":3.9600000381469727,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":56},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.93119812011719,"lon":12.081990242004395},"dt":1485784982,"id":2208425,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":89,"pressure":1036,"seaLevel":0,"temp":15.359999656677246,"tempMax":0,"tempMin":0},"name":"Zuwarah","weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"broken clouds","icon":"04d","id":803,"main":"Clouds"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":30,"speed":5.460000038146973,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":92},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.79335021972656,"lon":12.488450050354004},"dt":1485784982,"id":2212771,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":100,"pressure":1037,"seaLevel":0,"temp":15.3100004196167,"tempMax":0,"tempMin":0},"name":"Sabratah","weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"overcast clouds","icon":"04d","id":804,"main":"Clouds"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":28,"speed":6.710000038146973,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":92},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.172218322753906,"lon":13.020279884338379},"dt":1485784982,"id":2217362,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":90,"pressure":1004,"seaLevel":0,"temp":11.229999542236328,"tempMax":0,"tempMin":0},"name":"Gharyan","rain":{"__class__":"android.samutils.fasterserializerdemo.com.example.Rain","_3h":0},"weather":[{"__class__":"android.samutils.fasterserializerdemo.com.example.Weather","description":"light rain","icon":"10d","id":500,"main":"Rain"}],"wind":{"__class__":"android.samutils.fasterserializerdemo.com.example.Wind","deg":16,"speed":3.859999895095825,"varBeg":0,"varEnd":0}},{"__class__":"android.samutils.fasterserializerdemo.com.example.List","clouds":{"__class__":"android.samutils.fasterserializerdemo.com.example.Clouds","all":40},"coord":{"__class__":"android.samutils.fasterserializerdemo.com.example.Coord","lat":32.752220153808594,"lon":12.72778034210205},"dt":1485784982,"id":2216885,"main":{"__class__":"android.samutils.fasterserializerdemo.com.example.Main","grndLevel":0,"humidity":55,"pressure":1024,"seaLevel":0,"temp":17,"tempMax":0,"tempMin":0},"name":"Zawiya","we
E/test: jacksonjsoner read: 1509384
E/test: jsoner read: 1934524
E/test: jsoner write: 2194072
E/test: serializer toBytes : 252651
E/test: serializer read : 842052
E/test: write to bundle: 973
E/test: read from bundle: 685
E/test: write to parcel and marshall: 651406
E/test: read from parcel: 684274
```
