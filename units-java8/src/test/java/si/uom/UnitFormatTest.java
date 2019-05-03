/*
 * International System of Units (SI)
 * Copyright (c) 2005-2019, Jean-Marie Dautelle, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to
 *    endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package si.uom;

import static org.junit.Assert.*;
import static tec.uom.se.unit.MetricPrefix.MICRO;
import static tec.uom.se.unit.Units.KILOGRAM;
import static tec.uom.se.unit.Units.METRE;
import static tec.uom.se.unit.Units.MINUTE;
import static tec.uom.se.unit.Units.SECOND;

import java.io.IOException;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.ParserException;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;

import org.junit.Before;
import org.junit.Test;

import si.uom.SI;
import si.uom.quantity.MagnetomotiveForce;
import tec.uom.se.format.EBNFUnitFormat;
import tec.uom.se.format.SimpleUnitFormat;
import tec.uom.se.quantity.DefaultQuantityFactory;
import tec.uom.se.unit.Units;

/**
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 *
 */
public class UnitFormatTest {
    private Quantity<Length> sut;

    // private EBNFUnitFormat format;

    @Before
    public void init() {
        final SimpleUnitFormat format0 = SimpleUnitFormat.getInstance();
        sut = DefaultQuantityFactory.getInstance(Length.class).create(10, METRE);

        // format = EBNFUnitFormat.getInstance();

        format0.label(NonSI.HECTARE, "Ha");
        format0.label(NonSI.TONNE, "t");
    }

    @Test
    public void testFormat2() {
        Unit<Speed> kph = SI.KILOMETRE_PER_HOUR;
        assertEquals("km/h", kph.toString());
    }

    @Test
    public void testFormat4() {
        Unit<Speed> kph = Units.KILOMETRE_PER_HOUR;
        assertEquals("km/h", kph.toString()); // TODO i18n vs. no i18n
    }

    @Test
    public void testFormat5() {
        Unit<Area> b = NonSI.HECTARE;
        assertEquals("Ha", b.toString());
    }

    @Test
    public void testFormat3() {
        Unit<MagnetomotiveForce> at = SI.AMPERE_TURN;
        assertEquals("At", at.toString());
    }

    @Test
    public void testParseEBNF() {
        final UnitFormat format1 = EBNFUnitFormat.getInstance();
        try {
            Unit<?> u = format1.parse("s");
            assertEquals("s", u.getSymbol());
            assertEquals(SECOND, u);
        } catch (ParserException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFormatFromQuantity() {
        final UnitFormat format1 = EBNFUnitFormat.getInstance();
        final Appendable a = new StringBuilder();
        try {
            format1.format(METRE, a);
        } catch (IOException e) {
            fail(e.getMessage());
        }
        assertEquals(METRE, sut.getUnit());
        assertEquals("m", a.toString());

        final Appendable a2 = new StringBuilder();
        @SuppressWarnings("unchecked")
        Unit<Speed> v = (Unit<Speed>) sut.getUnit().divide(SECOND);
        try {
            format1.format(v, a2);
        } catch (IOException e) {
            fail(e.getMessage());
        }
        assertEquals("m/s", a2.toString());
    }

    @Test
    public void testParseEBNF1() {
        final UnitFormat format1 = EBNFUnitFormat.getInstance();
        try {
            Unit<?> u = format1.parse("min");
            // assertEquals("min", u.getSymbol());
            assertEquals(MINUTE, u);
        } catch (ParserException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testParseEBNF2() {
        final UnitFormat format1 = EBNFUnitFormat.getInstance();
        try {
            Unit<?> u = format1.parse("m");
            assertEquals("m", u.getSymbol());
            assertEquals(METRE, u);
        } catch (ParserException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testParseEBNF3() {
        final UnitFormat format1 = EBNFUnitFormat.getInstance();
        try {
            Unit<?> u = format1.parse("kg");
            assertEquals("kg", u.getSymbol());
            assertEquals(KILOGRAM, u);
        } catch (ParserException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testParseMicro() {
      final UnitFormat format = SimpleUnitFormat.getInstance();
      Unit<?> u = format.parse("μm");
      assertEquals(MICRO(METRE), u);
    }

    @Test
    public void testParseMicroAlias() {
      final UnitFormat format = SimpleUnitFormat.getInstance();
      Unit<?> u = format.parse("\u03bcm");
      assertEquals(MICRO(METRE), u);
    }
    
	@Test
	public void compatibleUnitCheckGramParsed() throws Exception {
	    Unit<?> gramm = SimpleUnitFormat.getInstance().parse("g");
	    assertTrue(gramm.isCompatible(Units.KILOGRAM));
	 }
	
	@Test
	public void compatibleUnitCheckGram() throws Exception {
	    //Unit<?> gramm = SimpleUnitFormat.getInstance().parse("g");
	    assertTrue(Units.GRAM.isCompatible(Units.KILOGRAM));
	 }
}
