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
package si.uom;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.measure.Unit;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;

import org.junit.jupiter.api.Test;

import si.uom.quantity.Density;
import si.uom.quantity.Luminance;
import tech.units.indriya.AbstractUnit;
import tech.units.indriya.unit.Units;


public class UnitDimensionTest {

  @SuppressWarnings("unused")
  @Test
  public void testAsType() {
	  String unitAsString = "kg/h/l";
	  Unit<?> unit = AbstractUnit.parse(unitAsString);

	  // The following should make sure that the given unit from string is matching the expected dimension. It will
	  // throw an exception if it does not match for javax units, but not for si-quantity unit.
	  assertThrows(ClassCastException.class,
	            ()->{
	          	  Unit<Mass> mass = unit.asType(Mass.class); // throws error -> correct
	        	  Unit<Dimensionless> dimensionless = unit.asType(Dimensionless.class); // throws error -> correct
	            });
	  Unit<Density> density = unit.asType(Density.class); // no error -> incorrect
	  Unit<Luminance> luminance = unit.asType(Luminance.class); // no error -> incorrect

	  Unit<?> unitKilogramPerLiter = Units.KILOGRAM.divide(Units.HOUR.divide(Units.LITRE));

	  assertEquals(unitKilogramPerLiter.toString(), density.toString()); // success -> incorrect behaviour
	  assertEquals(unitKilogramPerLiter.toString(), luminance.toString()); // success -> incorrect behaviour
  }
}
