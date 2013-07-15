/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.javafx.font.directwrite;

import com.sun.javafx.geom.Path2D;

class IDWriteFontFace extends IUnknown {
    IDWriteFontFace(long ptr) {
        super(ptr);
    }

    int GetType() {
        return OS.GetType(ptr);
    }

    short[] GetGlyphIndices(int[] codePoints, int codePointCount) {
        return OS.GetGlyphIndices(ptr, codePoints, codePointCount);
    }

    /* Based on GetDesignGlyphMetrics but only handles a single codePoint,
     * as opposite of taking in an array and returing an array.
     * - performance and simplicity based on JavaFX needs */
    DWRITE_GLYPH_METRICS GetDesignGlyphMetrics(short glyphIndex, boolean isSideways) {
        return OS.GetDesignGlyphMetrics(ptr, glyphIndex, isSideways);
    }

    Path2D GetGlyphRunOutline(float emSize, short glyphIndex, boolean isSideways) {
        return OS.GetGlyphRunOutline(ptr, emSize, glyphIndex, isSideways);
    }
}