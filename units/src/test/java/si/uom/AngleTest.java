/*
 * International System of Units (SI)
 * Copyright (c) 2005-2020, Jean-Marie Dautelle, Werner Keil and others.
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import javax.measure.Quantity;
import javax.measure.quantity.Angle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import tech.units.indriya.function.MultiplyConverter;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

public class AngleTest {

  private static MultiplyConverter piMultiplierConverter;

  @BeforeAll
  public static void setUp() throws Exception {
    piMultiplierConverter = MultiplyConverter.ofPiExponent(1);
  }

  @Test
  public void testConvertMethod() {
    assertEquals(314.15, piMultiplierConverter.convert(100), 0.1);
    assertEquals(0, piMultiplierConverter.convert(0), 0);
    assertEquals(-314.15, piMultiplierConverter.convert(-100), 0.1);
  }

//  @Test
//  public void testConvertBigDecimalMethod() {
//    assertEquals(314.15, piMultiplierConverter.convert(new BigDecimal("100"), MathContext.DECIMAL32).doubleValue(), 0.1);
//    assertEquals(0, piMultiplierConverter.convert(BigDecimal.ZERO, MathContext.DECIMAL32).doubleValue(), 0);
//    assertEquals(-314.15, piMultiplierConverter.convert(new BigDecimal("-100"), MathContext.DECIMAL32).doubleValue(), 0.1);
//  }

  @Test
  public void testEqualityOfTwoLogConverter() {
    assertNotNull(piMultiplierConverter);
  }

//  @Test
//  public void testGetValuePiDivisorConverter() {
//	  if(piMultiplierConverter instanceof PowerOfPiConverter) {
//    assertEquals(1, piMultiplierConverter.g .getExponent());
//  }

  @Test
  public void isLinearOfLogConverterTest() {
    assertTrue(piMultiplierConverter.isLinear());
  }

  @Test
  public void testAngleConverter() {
    Quantity<Angle> sut = Quantities.getQuantity(BigDecimal.ONE, NonSI.DEGREE_ANGLE).to(Units.RADIAN);
    assertNotNull(sut);
    assertEquals(Units.RADIAN, sut.getUnit());
    assertEquals(new BigDecimal("0.0174532925199432957692369076848861280629300682621303282056192814575568"), sut.getValue());
  }

  @Test
  public void testAngleConverterOpposite() {
    Quantity<Angle> sut = Quantities.getQuantity(BigDecimal.ONE, Units.RADIAN).to(NonSI.DEGREE_ANGLE);
    assertNotNull(sut);
    assertEquals(NonSI.DEGREE_ANGLE, sut.getUnit());
    assertEquals(new BigDecimal("57.2957795130823208767981548141051660"), sut.getValue());
  }
}
