/*
 * International System of Units (SI)
 * Copyright (c) 2005-2021, Jean-Marie Dautelle, Werner Keil and others.
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
 * 3. Neither the name of SI System, Units of Measurement nor the names of their contributors may be used to
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
package si.uom.format;

import static tech.units.indriya.unit.Units.KILOGRAM;
import static tech.units.indriya.unit.Units.METRE;
import static tech.units.indriya.unit.Units.HOUR;
import static tech.units.indriya.unit.Units.MINUTE;
import static tech.units.indriya.unit.Units.SECOND;
import static si.uom.SI.PLANCK_CONSTANT;
import static javax.measure.BinaryPrefix.*;
import static javax.measure.MetricPrefix.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.MeasurementParseException;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import si.uom.SI;
import si.uom.quantity.MagnetomotiveForce;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.quantity.DefaultQuantityFactory;
import tech.units.indriya.unit.Units;

/**
 * @author <a href="mailto:werner@uom.si">Werner Keil</a>
 *
 */
public class SIUnitFormatTest {
	private Quantity<Length> sut;

	private SimpleUnitFormat suf;
	
	@BeforeEach
	public void init() {
		sut = DefaultQuantityFactory.getInstance(Length.class).create(10,
				METRE);		
//		format = EBNFUnitFormat.getInstance();
		suf = SimpleUnitFormat.getInstance();
	}

	@Test
	public void testToString() {
		Unit<Speed> kph = SI.KILOMETRE_PER_HOUR;
		assertEquals("km/h", kph.toString());
		assertEquals("eV", SI.ELECTRON_VOLT.toString());
		assertEquals("meV", MILLI(SI.ELECTRON_VOLT).toString());
		assertEquals("KieV", KIBI(SI.ELECTRON_VOLT).toString());
	}
	
	@Test
	public void testToString2() {
		Unit<Speed> kph = Units.KILOMETRE_PER_HOUR;
		assertEquals("km/h", kph.toString());
	}
	
	@Test
	public void testToString3() {
		Unit<MagnetomotiveForce> at = SI.AMPERE_TURN;
		assertEquals("At", at.toString());
	}
	
	@Test
	public void testParseSimpleSec() {
		try {
			Unit<?> u = suf.parse("s");
			assertEquals("s", u.getSymbol());
			assertEquals(SECOND, u);
		} catch (MeasurementParseException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testFormatFromQuantity() {
		final Appendable a = new StringBuilder();
		try {
			suf.format(METRE, a);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals(METRE, sut.getUnit());
		assertEquals("m", a.toString());

		final Appendable a2 = new StringBuilder();
		@SuppressWarnings("unchecked")
		Unit<Speed> v = (Unit<Speed>) sut.getUnit().divide(SECOND);
		try {
			suf.format(v, a2);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals("m/s", a2.toString());
	}

	@Test
	public void testParseSimpleMin() {
		try {
			Unit<?> u = suf.parse("min");
			// assertEquals("min", u.getSymbol());
			assertEquals(MINUTE, u);
		} catch (MeasurementParseException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testParseSimpleHour() {
		try {
			Unit<?> u = suf.parse("h");
			assertEquals(HOUR, u);
		} catch (MeasurementParseException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testParseSimpleMetre() {
		try {
			Unit<?> u = suf.parse("m");
			assertEquals("m", u.getSymbol());
			assertEquals(METRE, u);
		} catch (MeasurementParseException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testParseSimpleKg() {
		try {
			Unit<?> u = suf.parse("kg");
			assertEquals("kg", u.getSymbol());
			assertEquals(KILOGRAM, u);
		} catch (MeasurementParseException e) {
			fail(e.getMessage());
		}
	}
	
    @Test
    public void testParseMicro() {
      Unit<?> u = suf.parse("μm");
      assertEquals(MICRO(METRE), u);
    }

    @Test
    public void testParseMicroAlias() {
      Unit<?> u = suf.parse("\u03bcm");
      assertEquals(MICRO(METRE), u);
    }
    
    @Test
    public void testParsePlanck() {
      Unit<?> u = suf.parse("ℎ");
      assertEquals(PLANCK_CONSTANT, u);
    }
    
	@Test
	public void compatibleUnitCheckGramParsed() throws Exception {
	    Unit<?> gram = SimpleUnitFormat.getInstance().parse("g");
	    assertTrue(gram.isCompatible(Units.KILOGRAM));
	 }
	
	@Test
	public void compatibleUnitCheckGram() throws Exception {
	    assertTrue(Units.GRAM.isCompatible(Units.KILOGRAM));
	 }
}
