package jiconfont.javafx;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import jiconfont.IconCode;
import jiconfont.IconFont;

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
public class IconFontFX {

    private static List<IconFont> fonts = new ArrayList<>();

    public static synchronized void register(IconFont iconFont) {
        if (IconFontFX.fonts.contains(iconFont) == false) {
            Font.loadFont(iconFont.getFontInputStream(), 0);
            IconFontFX.fonts.add(iconFont);
        }
    }

    public static Image buildImage(IconCode iconCode, Number size, Paint fill) {
        return buildImage(iconCode, size, fill, null);
    }

    public static Image buildImage(IconCode iconCode, Number size, Paint fill, Paint stroke) {
        IconNode iconNode = new IconNode();
        iconNode.setIconCode(iconCode);
        iconNode.setIconSize(size);
        iconNode.setFill(fill);
        iconNode.setStroke(stroke);
        Group group = new Group(iconNode);
        new Scene(group);
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        return group.snapshot(parameters, null);
    }

}