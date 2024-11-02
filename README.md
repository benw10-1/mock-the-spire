# Mock the Spire

Mock implementation for the game "Slay the Spire" originally created for use in mod tests.

## Features

- Card information loaded from the STS source like cost, description, etc.
- Character type information like starter deck, color, etc.
- Dungeon floor generation based on a seed
- Player deck manipulation

## Planned Features

- HTTP API so that one could write gameplay interactions in other languages and integrate into existing systems
- Full gameplay mechanics, from starting a run and picking Neow options to beating the heart after collecting the keys
- Actual mod loading support similar to how Mod the Spire works instead of only working with mods by compiling on the mod side - support BaseMod hooks from mod entrypoints
- More formats for loading decks like CSV and MsgPack and more options for how to interpret deck input
- Deck, card, character information, and dungeon serialization implementation

## Requirements

Needs Java 8 - both OpenJDK and Oracle should work.

## Building

Strongly recommend using VSCode and its Gradle extension when doing the following:

1. Create a copy of `build.Gradle.kts.example` and rename it to `build.Gradle.kts`
2. Populate `stsInstallLocation` and `steamappsLocation` variables in `build.Gradle.kts`. Does not have to be a specific paths, if preferred can populate `modTheSpireLocation`, `baseModLocation`, and `stsJar` variables directly instead.
3. Build jar by running the `buildJAR` Gradle task - should output to `build/libs/MockTheSpire.jar`

If issues during this - first try running the task `checkDependencyFiles` and making sure that the paths are what you would expect. Then try refreshing your workspace - you can do this on VSCode by running the command `Java: Clean Java Language Server Workspace`.

## Example test usage

Follow steps for [building](#building). After doing so you can run the `test` Gradle task to see the example output.

For usage within a given mod, add `build/libs/MockTheSpire.jar` to your project as a test dependency. 
<details><summary>Gradle</summary>

`build.gradle.kts`

```
sourceSets {
  ...
  test {
    java.srcDirs("src/test/java")
  }
}

...

dependencies {
  ...
  testImplementation(files(mockTheSpireLocation, ...))
}
```

</details>

<details><summary>Maven</summary>

`pom.xml`

```xml
<dependencies>
  <dependency>
    <groupId>mockthespire</groupId>
    <artifactId>MockTheSpire</artifactId>
    <version>0.1</version>
    <scope>system</scope>
    <systemPath>mockTheSpireLocation</systemPath>
    <scope>test</scope>
  </dependency>
</dependencies>
```

</details>


See [ExampleModTest.java](./src/test/java/examplemod/ExampleModTest.java) for example usage once included as a dependency.

## Mentions

Thanks to [MaT1g3R](https://github.com/MaT1g3R) for providing an example Java repo - copied the Gradle template from the [Slay the Relics](https://github.com/Spireblight/STR-Spire-Mod) mod.
