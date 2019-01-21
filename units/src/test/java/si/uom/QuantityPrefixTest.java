/*
 * International System of Units (SI)
 * Copyright (c) 2005-2018, Jean-Marie Dautelle, Werner Keil and others.
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
import static tech.units.indriya.unit.MetricPrefix.*;
import static tech.units.indriya.unit.Units.*;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

import org.junit.Ignore;
import org.junit.Test;

import tech.units.indriya.quantity.Quantities;

public class QuantityPrefixTest {
	@Test
	public void testKilo() {
		// TODO how to handle equals for units?
		assertNull(KILO(GRAM).getSymbol());
		assertEquals(KILOGRAM.toString(), KILO(GRAM).toString());
	}
	
	@Test
	@Ignore("This is a known problem, it's unrelated to ServiceProvider")
	public void testTonne() {
		Quantity<Mass> m1 = Quantities.getQuantity(1.0, NonSI.TONNE);
		assertEquals(1d, m1.getValue());
		assertEquals("t", m1.getUnit().toString());
	}
	
	@Test
	@Ignore("This is a known problem, it's unrelated to ServiceProvider")
	public void testMegaTonne() {
		Quantity<Mass> m1 = Quantities.getQuantity(1.0, MEGA(NonSI.TONNE));
		assertEquals(1d, m1.getValue());
		assertEquals("Mt", m1.getUnit().toString());
	}
	
	@Test
	public void testMilli() {
		Quantity<Volume> m1 = Quantities.getQuantity(1.0, LITRE);
		assertEquals(1d, m1.getValue());
		assertEquals("l", m1.getUnit().toString());
				
		Quantity<Volume> m2 = m1.to(MILLI(LITRE));
		assertEquals(1000.0d, m2.getValue());
		assertEquals("ml", m2.getUnit().toString());
	}
	
	@Test
	public void testMicro2() {
		Quantity<Length> m1 = Quantities.getQuantity(1.0, METRE);
		assertEquals(1d, m1.getValue());
		assertEquals("m", m1.getUnit().toString());
				
		Quantity<Length> m2 = m1.to(MICRO(SI.METRE));
		assertEquals(1000000.0d, m2.getValue());
		assertEquals("µm", m2.getUnit().toString());
	}
	
	@Test
	public void testNano() {
		Quantity<Mass> m1 = Quantities.getQuantity(1.0, GRAM);
		assertEquals(1d, m1.getValue());
		assertEquals("g", m1.getUnit().toString());
				
		Quantity<Mass> m2 = m1.to(NANO(SI.GRAM));
		assertEquals(1000000000.0d, m2.getValue());
		assertEquals("ng", m2.getUnit().toString());
	}
	
	@Test
	public void testNano2() {
		Quantity<Length> m1 = Quantities.getQuantity(1.0, METRE);
		assertEquals(1d, m1.getValue());
		assertEquals("m", m1.getUnit().toString());
				
		Quantity<Length> m2 = m1.to(NANO(METRE));
		assertEquals(1000000000.0d, m2.getValue());
		assertEquals("nm", m2.getUnit().toString());
	}
}
