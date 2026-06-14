# android-playground
Place to learn android knowledge from the beginning

## Summary of first Android app lesson:
* To create a new project: open Android Studio, click New Project > Empty Activity > Next, enter a name for your project and then configure its settings.
* To see how your app looks, use the Preview pane.
* Composable functions are like regular functions with a few differences: functions names are capitalized, you add the @Composable annotation before the function, @Composable functions can't return anything.
* A Modifier is used to augment or decorate your composable.

### What is Jetpack Compose?
Jetpack Compose is a modern toolkit for building Android UIs. 
Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin capabilities. 
With Compose, you can build your UI by defining a set of functions, called composable functions, that take in data and describe UI elements.

### Composable functions are the basic building block of a UI in Compose. A composable function:

* Describes some part of your UI.
* Doesn't return anything.
* Takes some input and generates what's shown on the screen.

### Annotations
Annotations are means of attaching extra information to code. This information helps tools like the Jetpack Compose compiler, and other developers understand the app's code.

An annotation is applied by prefixing its name (the annotation) with the @ character at the beginning of the declaration you are annotating. Different code elements, including properties, functions, and classes, can be annotated. Later on in the course, you'll learn about classes.

### Annotations with parameters
Annotations can take parameters. Parameters provide extra information to the tools processing them. The following are some examples of the @Preview annotation with and without parameters.


### Trailing lambda syntax
Notice in the previous code snippet that curly braces are used instead of parentheses in the Row composable function. This is called Trailing Lambda Syntax. 
You learn about lambdas and trailing lambda syntax in detail later in the course. For now, get familiar with this commonly used Compose syntax.

### Layout Modifiers
Modifiers are used to decorate or add behavior to Jetpack Compose UI elements. For example, you can add backgrounds, padding or behavior to rows, text, or buttons. To set them, a composable or a layout needs to accept a modifier as a parameter.
