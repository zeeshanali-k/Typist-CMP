[![Maven Central](https://img.shields.io/maven-central/v/tech.dev-scion/typist-cmp.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22tech.dev-scion%22%20AND%20a:%22typist-cmp%22)

# Typist-CMP
A Compose Multiplatform Text Typing Animation Library for Android, iOS, Desktop and Web.
Visit <a href="https://github.com/zeeshanali-k/Typist">this link</a> to checkout Typist for Jetpack Compose.

<img src="/images/ios.gif" height="200px">
<img src="/images/android.gif" height="200px">

<h3><b>Pass multiple strings and infinite repititions option</b></h3>

<img src="/images/ezgif-5-b8884a1d1c.gif" height="300px">

## Usage
<p>Add this to your project level "build.gradle" or in newer versions of gradle in "settings.gradle" under repositories section:</p>

 ```groovy
repositories {
   mavenCentral()
}
```
<p>Add this to your shared module build.gradle file in commonMain under dependencies section:</p>

```kotlin
api("tech.dev-scion:typist-cmp:TAG")
```
<p>Replace TAG with library version</p>

<p>Add Typist Composable to your app and configure accordingly:</p>

```kotlin
Typist(
    text = "Hi! I am Typist.",
    modifier = Modifier
                .align(Alignment.Center),
    typistSpeed = TypistSpeed.NORMAL,
    textStyle = TextStyle(
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        textAlign = TextAlign.Center,
        isBlinkingCursor = true, // if true the cursor will keep blinking
        isInfiniteCursor = false, // if true the cursor will not hide even after the text has been written
        isCursorVisible = true, // if true the cursor will not be visible at all
    ),
onAnimationEnd = {},
onAnimationStart = {}
)
```


<a href="https://www.buymeacoffee.com/devscion"><img src="https://img.buymeacoffee.com/button-api/?text=Buy me a coffee&emoji=&slug=ZeeshanAli&button_colour=FFDD00&font_colour=000000&font_family=Cookie&outline_colour=000000&coffee_colour=ffffff"></a>
