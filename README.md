This is an example using a recent update to the (sponiro) gradle-nar-plugin (https://github.com/lhotari/gradle-nar-plugin)

## using

### basic

```
./gradlew nar
```

### more interesting

- modify src/main/groovy/lou/nifi/processors/LouProcessor.groovy
- build nar (as above)

### more more interesting

- create your own class (somewhere in src/main/groovy or src/main/java)
- add class name to meta info (src/main/resources/META-INF/services/org.apache.nifi.processor.Processor)
- build nar (agian...as above)

## pre-requisite

Must already have installed lhotari(see above) nar plugin (I think...at least I did)
```
gradle clone https://github.com/lhotari/gradle-nar-plugin.git
cd gradle-nar-plugin
./gradlew build
```
