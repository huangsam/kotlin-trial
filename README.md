# Kotlin Trial

Coding in Kotlin to:

1. Explore tools like [Detekt](https://detekt.dev/) and [ktlint](https://pinterest.github.io/ktlint/latest/)
2. Take stock of the overall Kotlin ecosystem
3. Assess its compatibility with the Java ecosystem

## Getting started

Load the project up in [Intellij IDEA](https://www.jetbrains.com/idea/).

After that, you can:

- Run app via `./gradlew run`
- Test code via `./gradlew test`
- Check code style via `./gradlew detekt`
- Fix code style via `./gradlew detekt --auto-correct`

### Git hooks

Add [hooks](https://git-scm.com/book/en/v2/Customizing-Git-Git-Hooks) to your local copy by running `./gradlew addHooks`.

### Mockito warning

A warning appeared while integrating [Mockito](https://site.mockito.org/) into this Kotlin project:

```
WARNING: A Java agent has been loaded dynamically (...)
WARNING: If a serviceability tool is in use, please run with -XX:+EnableDynamicAgentLoading to hide this warning
WARNING: If a serviceability tool is not in use, please run with -Djdk.instrument.traceUsage for more information
WARNING: Dynamic loading of agents will be disallowed by default in a future release
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
```

It is discussed here in more detail: https://github.com/mockito/mockito/issues/3037

## Helpful resources

- https://kotlinlang.org/docs/home.html
- https://www.w3schools.com/KOTLIN/index.php
- https://www.baeldung.com/kotlin/
- https://github.com/KotlinBy/awesome-kotlin
- https://github.com/akullpp/awesome-java
- https://openjdk.org/
- https://www.oracle.com/java/technologies/java-se-support-roadmap.html
