# Fasterserializerdemo
Demo application demonstrates usage of 'faster-serializer' library

How to use library 'faster-serializer' (https://github.com/s-a--m/faster-serializer)

1. In module-app gradle after 'apply plugin...' insert:


repositories {
	maven {
		url 'https://dl.bintray.com/dmitrysamoylenko/fasterserializer/'
	}
}


2. In android section insert annotation processor info:

android {
...
	defaultConfig {
...
		javaCompileOptions {
			annotationProcessorOptions {
				className 'android.samutils.fasterserializer.processor.AnnotationProcessor'
			}
		}

	}

3. In dependencies:

dependencies {
...
	compile 'android.samutils:faster-serializer:+'// 0.9.5 for current time
	compile 'android.samutils:processorannotations:+'
	annotationProcessor 'android.samutils:processor:+'

}
