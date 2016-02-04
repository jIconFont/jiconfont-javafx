package jiconfont.javafx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.CssMetaData;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import jiconfont.DefaultIconCode;
import jiconfont.IconCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Copyright (c) 2016 jIconFont <BR>
 * <BR>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:<BR>
 * <BR>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.<BR>
 * <BR>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class IconNode extends Text {

    private StyleableObjectProperty<IconCode> iconCode;
    private StyleableObjectProperty<Number> iconSize;

    public IconNode() {
        this(null);
    }

    public IconNode(IconCode iconCode) {
        iconCodeProperty().addListener(new ChangeListener<IconCode>() {
            @Override
            public void changed(ObservableValue<? extends IconCode> observable, IconCode oldValue, IconCode newValue) {
                updateIconCode();
            }
        });
        iconSizeProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                updateIconSize();
            }
        });
        if (iconCode != null) {
            setIconCode(iconCode);
        }
    }


    public StyleableObjectProperty<IconCode> iconCodeProperty() {
        if (iconCode == null) {
            iconCode = new StyleableObjectProperty<IconCode>() {
                @Override
                public Object getBean() {
                    return IconNode.this;
                }

                @Override
                public String getName() {
                    return "iconCode";
                }

                @Override
                public CssMetaData<? extends Styleable, IconCode> getCssMetaData() {
                    return IconNode.ICON_CODE_META_DATA;
                }
            };
        }
        return iconCode;
    }

    public void setIconCode(String fontFamily, char unicode) {
        this.iconCode.set(new DefaultIconCode(fontFamily, unicode));
    }

    public void setIconCode(IconCode iconCode) {
        this.iconCode.set(iconCode);
    }

    public IconCode getIconCode() {
        return iconCode.get();
    }

    public ObjectProperty<Number> iconSizeProperty() {
        if (iconSize == null) {
            iconSize = new StyleableObjectProperty<Number>(18) {
                @Override
                public Object getBean() {
                    return IconNode.this;
                }

                @Override
                public String getName() {
                    return "iconSize";
                }

                @Override
                public CssMetaData<? extends Styleable, Number> getCssMetaData() {
                    return IconNode.ICON_SIZE_META_DATA;
                }
            };
        }
        return iconSize;
    }

    public Number getIconSize() {
        return iconSize.get();
    }

    public void setIconSize(Number iconSize) {
        this.iconSize.set(iconSize);
    }

    private void updateIconSize() {
        if (getIconCode() != null) {
            setFont(new Font(getIconCode().getFontFamily(), getIconSize().doubleValue()));
        }
    }

    private void updateIconCode() {
        if (getIconCode() != null) {
            setFont(new Font(getIconCode().getFontFamily(), getIconSize().doubleValue()));
            setText(Character.toString(getIconCode().getUnicode()));
        } else {
            setFont(null);
            setText("");
        }
    }

    private static CssMetaData<IconNode, IconCode> ICON_CODE_META_DATA = new CssMetaData<IconNode, IconCode>("-fx-icon-code", IconCodeConverter.getInstance()) {
        @Override
        public boolean isSettable(IconNode styleable) {
            return true;
        }

        @Override
        public StyleableProperty<IconCode> getStyleableProperty(IconNode styleable) {
            return styleable.iconCodeProperty();
        }
    };

    private static final CssMetaData<IconNode, Number> ICON_SIZE_META_DATA =
            new CssMetaData<IconNode, Number>("-fx-icon-size",
                    StyleConverter.getSizeConverter(), 16.0) {

                @Override
                public boolean isSettable(IconNode icon) {
                    return true;
                }

                @Override
                public StyleableProperty<Number> getStyleableProperty(IconNode icon) {
                    return (StyleableProperty<Number>) icon.iconSizeProperty();
                }
            };


    private static final List<CssMetaData<? extends Styleable, ?>> cssMetaDataList;

    static {
        List<CssMetaData<? extends Styleable, ?>> temp =
                new ArrayList<CssMetaData<? extends Styleable, ?>>(Text.getClassCssMetaData());
        temp.add(ICON_CODE_META_DATA);
        temp.add(ICON_SIZE_META_DATA);
        cssMetaDataList = Collections.unmodifiableList(temp);
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return cssMetaDataList;
    }

    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return IconNode.getClassCssMetaData();
    }
}


