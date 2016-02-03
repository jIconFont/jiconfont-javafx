package jiconfont.javafx;

import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import jiconfont.IconBuilder;
import jiconfont.IconCode;

import java.util.ArrayList;
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
public class IconBuilderFX extends IconBuilder<IconBuilderFX, Color, String> {

    private static List<String> loadedFonts = new ArrayList<>();

    protected static synchronized void loadFontFor(IconCode icon) {
        if (IconBuilderFX.loadedFonts.contains(icon.getFontFamily()) == false) {
            Font.loadFont(icon.getFontInputStream(), 0);
            IconBuilderFX.loadedFonts.add(icon.getFontFamily());
        }
    }

    public static IconBuilderFX newIcon(IconCode icon) {
        IconBuilderFX.loadFontFor(icon);
        return new IconBuilderFX(icon);
    }

    protected IconBuilderFX(IconCode icon) {
        super(icon);
    }

    protected String buildStyle(boolean isLabeled) {
        StringBuilder sb = new StringBuilder();
        sb.append("-fx-font-family: '");
        sb.append(getIcon().getFontFamily());
        sb.append("';");

        if (getSize() != null) {
            sb.append("-fx-font-size: ");
            sb.append(getSize());
            sb.append(";");
        }

        if (getColor() != null) {
            if (isLabeled) {
                sb.append("-fx-text-fill: ");
                sb.append(toRGBA(getColor()));
                sb.append(";");
            } else {
                sb.append("-fx-fill: ");
                sb.append(toRGBA(getColor()));
                sb.append(";");

                sb.append("-fx-stroke: ");
                sb.append(toRGBA(getColor()));
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public final IconBuilderFX apply(Labeled labeled) {
        labeled.setText(Character.toString(getIcon().getUnicode()));
        labeled.setStyle(buildStyle(true));
        return this;
    }

    public final Label buildLabel() {
        Label label = new Label();
        label.setMinWidth(Control.USE_PREF_SIZE);
        label.setMinHeight(Control.USE_PREF_SIZE);
        apply(label);
        return label;
    }

    public final Image buildImage() {
        Label label = buildLabel();
        new Scene(label);
        label.setBackground(null);
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        return label.snapshot(parameters, null);
    }

    private int convert(double value) {
        return (int) (value * 255);
    }

    protected String toRGBA(Color color) {
        return "rgba(" + convert(color.getRed()) + "," + convert(color.getGreen())
                + "," + convert(color.getBlue()) + "," + (int) color.getOpacity() + ")";
    }

    public final IconBuilderFX setSize(int size) {
        setSize(size + "px");
        return this;
    }

    @Override
    protected Class<IconBuilderFX> getIconFontClass() {
        return IconBuilderFX.class;
    }
}