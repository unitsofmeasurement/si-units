/*
 * International System of Units (SI)
 * Copyright (c) 2005-2025, Jean-Marie Dautelle, Werner Keil and others.
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static si.uom.SI.COULOMB_PER_KILOGRAM;
import static si.uom.NonSI.UNIFIED_ATOMIC_MASS;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.measure.Dimension;
import javax.measure.Unit;
import javax.measure.spi.SystemOfUnits;

import org.junit.jupiter.api.Test;

import si.uom.NonSI;
import si.uom.SI;
import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.unit.Units;


/**
 * @author <a href="mailto:werner@uom.si">Werner Keil</a>
 *
 */
public class EBNFUnitFormatTest {
	private static final Logger logger = Logger.getLogger(EBNFUnitFormatTest.class.getName());
	
	private static final Unit<?>[] SKIP_UNITS = {COULOMB_PER_KILOGRAM, UNIFIED_ATOMIC_MASS};
	private static final List<Unit<?>> SKIP_LIST = Arrays.asList(SKIP_UNITS); 
	
	@Test
	public void testFormatAndParseSI() {
		formatAndParseSystem(SI.getInstance());
	}
	
	@Test
	public void testFormatAndParseNonSI() {
		formatAndParseSystem(NonSI.getInstance());
	}
	
    @Test
    public void testParseAndFormatKilogramPerHourPerLitre() {
    	EBNFUnitFormat format = EBNFUnitFormat.getInstance();
    	final String unitAsString = "kg/h/l";
    	final Unit<?> unit = format.parse(unitAsString);
    	final Unit<?> unitKilogramPerLiter = Units.KILOGRAM.divide(Units.HOUR).divide(Units.LITRE);
    	
  	  	Dimension dim1 = unit.getDimension();
  	  	Dimension dim2 = unitKilogramPerLiter.getDimension();
  	  	assertEquals(dim1, dim2);
  	  	assertEquals(unit.toString(), unitKilogramPerLiter.toString());  	  	
  	  	assertNotEquals(unitKilogramPerLiter.toString(), unitAsString);
  	  	final Unit<?> unitAgain = format.parse(unit.toString());
  	  	assertEquals(unit, unitAgain);
    }
	
	private void formatAndParseSystem(SystemOfUnits system) {
		EBNFUnitFormat format = EBNFUnitFormat.getInstance();
	    for (Unit<?> u : system.getUnits()) {
	    	String fmt = format.format(u);
	    	logger.fine(String.format("%s: %s", u.getName(), fmt));
			Unit<?> parsed = format.parse(fmt);
			if (SKIP_LIST.contains(u)) {
				// these are parsed correctly, but the concrete unit types differ
				assertEquals(u.toString(), parsed.toString());
			} else {
				assertEquals(u, parsed);
			}
	    }
	}
}
