# Fasterserializerdemo
Demo application demonstrates usage of 'faster-serializer' library

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