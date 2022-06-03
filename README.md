This is an example using a recent update to the (sponiro) gradle-nar-plugin (https://github.com/lhotari/gradle-nar-plugin).

Borrowed example from sponiro that didn't work for me originally. Also borrowed content of custom processor. So...many
thanks to all who came before.

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

## Notes

### Nar dependency

Updated build.gradle dependency->nar to match nifi install. On one 1.16 server an older version worked fine, on another
it needed to be 1.15 and said so when trying to load the nar. Lesson: look at nar load error and it will probably
tell you the dependency->nar to build against.

### java version

Updated from 1.8 to 1.11 in build.gradle but either *should* work.
