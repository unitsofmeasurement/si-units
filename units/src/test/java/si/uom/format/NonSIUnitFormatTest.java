/*
 * International System of Units (SI)
 * Copyright (c) 2005-2024, Jean-Marie Dautelle, Werner Keil and others.
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

import javax.measure.Unit;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Area;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import si.uom.NonSI;
import si.uom.SI;
import tech.units.indriya.format.SimpleUnitFormat;

import static javax.measure.BinaryPrefix.*;
import static javax.measure.MetricPrefix.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.measure.MetricPrefix;

/**
 * @author <a href="mailto:werner@uom.si">Werner Keil</a>
 *
 */
public class NonSIUnitFormatTest {
	private UnitFormat format;

	@BeforeEach
	public void init() {
		format = SimpleUnitFormat.getInstance();
		format.label(NonSI.HECTARE, "Ha");
	}

	@Test
	public void testFormatAngstrom1() {
		final String angstrom = format.format(NonSI.ANGSTROM);
		assertEquals("\u00C5", angstrom);
	}
	
	@Test
	public void testFormatBel() {
		final String bel = format.format(NonSI.BEL);
		assertEquals("B", bel);
	}
	
	@Test
	public void testFormatDecibel() {
		final String bel = format.format(MetricPrefix.DECI(NonSI.BEL));
		assertEquals("dB", bel);
	}
	
	@Test
	public void compatibleUnitCheckGramm() throws Exception {
	    Unit<?> gramm = SimpleUnitFormat.getInstance().parse("g");
	    assertTrue(gramm.isCompatible(SI.KILOGRAM));
	 }
	
	@Test
	public void testToString() {		
		assertEquals("Kit", KIBI(NonSI.TONNE).toString());
		assertEquals("Mt", MEGA(NonSI.TONNE).toString());
	}
	
	@Test
	public void testToString2() {
		Unit<Area> b = NonSI.HECTARE;
		assertEquals("Ha", b.toString()); // here it's upper case after init
	}
}
