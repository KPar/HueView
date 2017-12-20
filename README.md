# HueView
An Android library that cycles through the visible light spectrum to recursively change the color of affected views.

A more comprehensive guide to be added within the week...

<img src="https://github.com/KPar/HueView/raw/master/GIF-171219_225414.gif?raw=true" alt="GIF of HueView Sample" width="40%" height="40%"/>

# Getting Started
### Dependency
```
dependencies {
    compile 'com.valiantdots:HueView:1.0.0'
}
```
## Usage
The current supported views are: LinearLayout, FrameLayout, RelativeLayout, TextView, and the Toolbar's icons.
To use HueView, declare the desired view in xml with the library's name like the following:

```xml
<com.valiantdots.hueview.HueView_LinearLayout
        android:id="@+id/myLinearLayout"
        android:layout_width="100dp"
        android:layout_height="100dp">
</com.valiantdots.hueview.HueView_LinearLayout>
```
By default HueView will use the following values: 

*Saturation: .85 Light: .7 Speed: 10*
# Customizing HueView
HueView has initialization methods that allow users to customize HueView as desired.

## Layout Views (LinearLayout,FrameLayout,etc.)
For layout views, instantiate HueView for the specific view and call initialize() :
```java
 HueView_LinearLayout myLinearLayout = (HueView_LinearLayout) findViewById(R.id.myLinearLayout);
 myLinearLayout.initialize(.67,.8,2);
```
#### initialize(double saturation, double light, int speed)

Saturation: A double value from .0 up to .1

Light: A double value from .0 up to .1

Speed: An int value starting from 0. Measured in milliseconds, the lowest value being the fastest.

## TextView
By default, HueView is applied to the TextView's background, automatically changing the color of the text black to white. However, you're able to apply HueView on a TextView three different ways:

### TextView: Background Affected
```java
 HueView_TextView text1 = (HueView_TextView) findViewById(R.id.myHueText);
 text1.initialize(.65,.6,5);
```
#### initialize(double saturation, double light, int speed)

Saturation: A double value from .0 up to .1

Light: A double value from .0 up to .1

Speed: An int value starting from 0. Measured in milliseconds, the lowest value being the fastest.

### TextView: Text Affected
```java
 HueView_TextView text2 = (HueView_TextView) findViewById(R.id.myHueText2);
 text2.initialize(.85,.7,5,"#76a1ea");
```
#### initialize(double saturation, double light, int speed, String backgroundColor)

Saturation: A double value from .0 up to .1

Light: A double value from .0 up to .1

Speed: An int value starting from 0. Measured in milliseconds, the lowest value being the fastest.

BackgroundColor: Color in HEX format

### TextView: Background Affected, Static Text Color
If you do not desire the text color to automatically change based on the background's color, with initializeStaticText() you can assign a static text color.
```java
 HueView_TextView text2 = (HueView_TextView) findViewById(R.id.myHueText2);
 text2.initializeStaticText(.25,.7,5,"#5b4dff");
```
#### initializeStaticText(double saturation, double light, int speed, String textColor)

Saturation: A double value from .0 up to .1

Light: A double value from .0 up to .1

Speed: An int value starting from 0. Measured in milliseconds, the lowest value being the fastest.

TextColor: Color in HEX format

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

