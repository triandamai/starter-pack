composable function aproach
```kotlin
ResponsiveColumn(
  small={
    Text("small")
  },
  medium={
    Text("medium")
  }
)
```

```kotlin
@Composable
fun ResponsiveColumn(
  small: @Composable ()->Unit = {},
  medium: @Composable ()->Unit = {}
){
  BoxWithConstraint(){
    val width = //get the screenwidth
    
    if(width == 300){
      small()
    }
  
  }

}

````
dsl aproach
```kotlin
ResponsiveColumn{
   small{
   
   }
   
   medium{
   
   }
}
```

```kotlin
@DslMaker
annotation class small

class ResponsiveLayout{

  @Composable
  @small
  fun small(){
    
  }

}

@Composable
fun ResponsiveColumn(
 content:@Composable ResponsiveLayout.()->Unit
){
val dsl = ResponsiveLayout(content)
 BoxWithConstraint(){
    if(width == 300){
      dsl.invoke()
    }
 }

}
```
