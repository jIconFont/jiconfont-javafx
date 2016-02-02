## jIconFont-JavaFX

jIconFont-JavaFX is a API to provide icons generated from any IconFont. These icons can be used in JavaFX.

## Usage

#### Example 1

```java
Label icon = IconBuilderFX.newIcon(FontAwesome.SMILE_O).setSize(40).setColor(Color.DARKGREEN).buildLabel();
```
![Example 1](http://jiconfont.github.io/images/javafx-example1.png)

#### Example 2

```java
Label label = new Label("Hello!");
Label icon = IconBuilderFX.newIcon(FontAwesome.SMILE_O).setSize(15).setColor(Color.BLACK).buildLabel();
label.setGraphic(icon);
```
![Example 2](http://jiconfont.github.io/images/javafx-example2.png)

#### Example 3

```java
Button button = new Button();
IconBuilderFX.newIcon(FontAwesome.FLOPPY_O).setSize(20).setColor(Color.BLACK).apply(button);
```
![Example 3](http://jiconfont.github.io/images/javafx-example3.png)

#### Example 4

```java
Button button = new Button("Save");
Label icon = IconBuilderFX.newIcon(FontAwesome.FLOPPY_O).setSize(14).setColor(Color.BLACK).buildLabel();
button.setGraphic(icon);
```
![Example 4](http://jiconfont.github.io/images/javafx-example4.png)

## LICENSE
jIconFont is distributed under the terms of the [MIT license](http://opensource.org/licenses/mit-license.html). See LICENSE file for details.


