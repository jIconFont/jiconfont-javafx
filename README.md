## jIconFont-JavaFX

jIconFont-JavaFX is a API to provide icons generated from any IconFont. These icons can be used in JavaFX.

## Usage

#### Example 1

```java
// Register the IconFont
IconFontFX.register(FontAwesome.getIconFont());

IconNode iconNode = new IconNode(FontAwesome.SMILE_O);
iconNode.setIconSize(40);
iconNode.setFill(Color.DARKGREEN);
```
![Example 1](http://jiconfont.github.io/images/javafx-example1.png)

---

#### Example 2

```java
// Register the IconFont
IconFontFX.register(FontAwesome.getIconFont());

IconNode iconNode = new IconNode(FontAwesome.SMILE_O);
iconNode.setIconSize(18);

Label label = new Label("Hello!");
label.setGraphic(iconNode);
```
![Example 2](http://jiconfont.github.io/images/javafx-example2.png)

---

#### Example 3

```java
// Register the IconFont
IconFontFX.register(FontAwesome.getIconFont());

IconNode iconNode = new IconNode(FontAwesome.FLOPPY_O);
iconNode.setIconSize(15);
iconNode.setFill(Color.BLACK);

Button button = new Button();
button.setGraphic(iconNode);
```
![Example 3](http://jiconfont.github.io/images/javafx-example3.png)

---

#### Example 4

```java
// Register the IconFont
IconFontFX.register(FontAwesome.getIconFont());

IconNode iconNode = new IconNode(FontAwesome.FLOPPY_O);
iconNode.setIconSize(15);
iconNode.setFill(Color.BLACK);

Button button = new Button("Save");
button.setGraphic(iconNode);
```
![Example 4](http://jiconfont.github.io/images/javafx-example4.png)

---

#### Example 5 (Stacked Icons)

```java
// Register the IconFonts
IconFontFX.register(FontAwesome.getIconFont());
IconFontFX.register(Elusive.getIconFont());

IconNode iconNode1 = new IconNode(FontAwesome.DATABASE);
iconNode1.setIconSize(26);
iconNode1.setFill(Color.BLACK);

IconNode iconNode2 = new IconNode(Elusive.REMOVE);
iconNode2.setIconSize(14);
iconNode2.setFill(Color.RED);
iconNode2.setStroke(Color.WHITE);

StackedIconNode stackedIconNode = new StackedIconNode(iconNode1);
stackedIconNode.add(Pos.BOTTOM_LEFT, iconNode2);
```
![Example 5](http://jiconfont.github.io/images/javafx-example5.png)

---

#### Example 6 (CSS)

```css
.myClass{
-fx-icon-size: 48px;
-fx-icon-code: "FontAwesome:F25B";
-fx-fill: gray;
}
```

```java
// Register the IconFont
IconFontFX.register(FontAwesome.getIconFont());

IconNode iconNode = new IconNode();
iconNode.getStyleClass().add("myClass");
```
![Example 6](http://jiconfont.github.io/images/javafx-example6.png)

---

#### Example 7 (Custom font)

```java
// Register my custom IconFont
IconFontFX.register(new IconFont() {
    @Override
    public String getFontFamily() {
        return "MyCustomFont";
    }

    @Override
    public InputStream getFontInputStream() {
        return MyClass.class.getResourceAsStream("/myCustomFont.ttf");
    }
});

IconNode iconNode = new IconNode();
iconNode.setIconCode(new DefaultIconCode("MyCustomFont", '\u1234'));
```

---

#### Example 8 (Custom font + CSS)

```css
.myCustomClass{
-fx-icon-size: 48px;
-fx-icon-code: "MyCustomFont:1234";
-fx-fill: red;
}
```

```java
// Register my custom IconFont
IconFontFX.register(new IconFont() {
    @Override
    public String getFontFamily() {
        return "MyCustomFont";
    }

    @Override
    public InputStream getFontInputStream() {
        return MyClass.class.getResourceAsStream("/myCustomFont.ttf");
    }
});

IconNode iconNode = new IconNode();
iconNode.getStyleClass().add("myCustomClass");
```

## LICENSE
jIconFont is distributed under the terms of the [MIT license](http://opensource.org/licenses/mit-license.html). See LICENSE file for details.


