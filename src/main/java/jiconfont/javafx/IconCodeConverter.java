package jiconfont.javafx;

import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.text.Font;
import jiconfont.DefaultIconCode;
import jiconfont.IconCode;

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
public class IconCodeConverter extends StyleConverter<String, IconCode> {

    // lazy, thread-safe instatiation
    private static class Holder {
        static final IconCodeConverter INSTANCE = new IconCodeConverter();
    }


    public static StyleConverter<String, IconCode> getInstance() {
        return Holder.INSTANCE;
    }

    private IconCodeConverter() {
    }

    @Override
    public IconCode convert(ParsedValue<String, IconCode> value, Font font) {
        String valeStr = value.getValue();
        String split[] = valeStr.split(":");

        int hexVal = Integer.parseInt(split[1], 16);


        return new DefaultIconCode(split[0], (char) hexVal);
    }

    @Override
    public String toString() {
        return "IconCodeConverter";
    }


}

