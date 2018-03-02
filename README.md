# HueView
An Android library that cycles through the visible light spectrum to recursively change the color of affected views. 

Main goal of this library is to further expand creativity among developers in Android app design.

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

**Saturation:** A double value from .0 up to .1

**Light:** A double value from .0 up to .1

**Speed:** An int value starting from 0. Measured in milliseconds, the lowest value being the fastest.

## TextView
By default, HueView is applied to the TextView's background, automatically changing the color of the text black to white. However, you're able to apply HueView on a TextView three different ways:

### TextView: Background Affected
```java
 HueView_TextView text1 = (HueView_TextView) findViewById(R.id.myHueText);
 text1.initialize(.65,.6,5);
```
#### initialize(double saturation, double light, int speed)

**Saturation:** A double value from .0 up to .1

**Light:** A double value from .0 up to .1

**Speed:** An int value starting from 0. Measured in milliseconds, the lowest value being the fastest.

### TextView: Text Affected
```java
 HueView_TextView text2 = (HueView_TextView) findViewById(R.id.myHueText2);
 text2.initialize(.85,.7,5,"#76a1ea");
```
#### initialize(double saturation, double light, int speed, String backgroundColor)

The Saturation, Light, and Speed parameters take the same arguments as the basic initialize() method.

**BackgroundColor:** Color in HEX format

### TextView: Background Affected, Static Text Color
If you do not desire the text color to automatically change based on the background's color, with initializeStaticText() you can assign a static text color.
```java
 HueView_TextView text3 = (HueView_TextView) findViewById(R.id.myHueText3);
 text3.initializeStaticText(.25,.7,5,"#5b4dff");
```
#### initializeStaticText(double saturation, double light, int speed, String textColor)

The Saturation, Light, and Speed parameters take the same arguments as the basic initialize() method.

**TextColor:** Color in HEX format

## Toolbar Icons

With an instance of HueView, one can apply HueView to the Toolbar in three different ways by calling these methods:

### Affect the Overflow/Back button

#### toolbarOverflow(double saturation, double light, int speed, View toolbar)

**Saturation:** A double value from .0 up to .1

**Light:** A double value from .0 up to .1

**Speed:** An int value starting from 0. Measured in milliseconds, the lowest value being the fastest.

**Toolbar:** Toolbar view.

### Affect One Icon

#### toolbarSingleIcon(double saturation, double light, int speed, View toolbar, int iconPosition)

The Saturation, Light, Speed, and Toolbar parameters take the same arguments as prior method.

**iconPosition:** Position of the desired icon. Icons start at 0 after the overflow/back button.

### Affect All Icons

#### toolbarAllIcons(double saturation, double light, int speed, View toolbar)

The Saturation, Light, Speed, and Toolbar parameters take the same arguments as prior method.

```java
 HueView toolbarHueView = new HueView();
 toolbarHueView.toolbarAllIcons(.70,.65,2,toolbar);
```
# Stopping HueView
The effects of HueView can be stopped for layout views and TextView by calling the stop() method:

```java
 myLinearLayout.stop("#ffbbcc);
```
#### stop(String HexColor)
**HexColor:** Color in HEX format to display once HueView stops.

To stop the Toolbar's icons simply call toolbarStop(), which takes the same arguments as stop():

```java
 toolbarHueView.toolbarStop("#ffbbcc");
```
# Possible Use Cases

## Use Case #1
**Situation:** A message has been sent in a social app, or a new feature is available under the drawer, all accessed by pressing a toolbar icon. How do we notify users in a more intuitive way?

**Solution:** By applying HueView to the specific toolbar icon, user will be engaged in pressing the icon to obtain the new information. Once the icon is pressed, the icon will return to it's original color *( toolbarStop() )*.
  
## License
```
Copyright 2017 Kenny Paredes

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

