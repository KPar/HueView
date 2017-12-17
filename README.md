# HueView
An Android library that cycles through the visible light spectrum to recursively change the color of affected views.

A more comprehensive guide to be added within the week...

# Getting Started
### Dependency
```
dependencies {
    compile 'com.valiantdots:HueView:1.0.0'
}
```
## Usage
The current supported views are: LinearLayout, FrameLayout,RelativeLayout, TextView, and the Toolbar's icons

### Linear Layout within xml file
```xml
<com.valiantdots.hueview.HueView_LinearLayout
        android:id="@+id/myLinearLayout"
        android:layout_width="100dp"
        android:layout_height="100dp">
</com.valiantdots.hueview.HueView_LinearLayout>
```
By default HueView will use the following values: 

*Saturation: .85 Light: .7 Speed: 10*
### Customizing HueView
For layout views, instantiate HueView for the specific view and call initialize() :
```java
 HueView_LinearLayout myLinearLayout = findViewById(R.id.myLinearLayout);
 myLinearLayout.initialize(.67,.8,2);
```
#### initialize(double saturation, double light, int speed)

Saturation: A double value from .0-.1

Light: A double value from .0-.1

Speed: An int value starting from 0. Measured in milliseconds, the lowest being the fastest.

## License
```
Copyright 2017 Kenny Paredes, Valiant Dots

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

