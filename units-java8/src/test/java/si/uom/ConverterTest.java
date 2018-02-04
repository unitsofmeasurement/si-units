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
 * 3. Neither the name of JSR-363, Units of Measurement nor the names of their contributors may be used to
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

import java.math.BigDecimal;

import javax.measure.Quantity;
import javax.measure.quantity.Angle;

import org.junit.Test;

import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.Units;

public class ConverterTest {

    @Test
    public void testAngleConverter() {
	Quantity<Angle> sut = Quantities.getQuantity(BigDecimal.ONE, NonSI.DEGREE_ANGLE).to(Units.RADIAN);
	assertNotNull(sut);
	assertEquals(Units.RADIAN, sut.getUnit());
	assertEquals(new BigDecimal("0.01745329251994329576923690768488613"), sut.getValue());
    }

    @Test
    public void testAngleConverternOpposite() {
	Quantity<Angle> sut = Quantities.getQuantity(BigDecimal.ONE, Units.RADIAN).to(NonSI.DEGREE_ANGLE);
	assertNotNull(sut);
	assertEquals(NonSI.DEGREE_ANGLE, sut.getUnit());
	assertEquals(new BigDecimal("57.29577951308232087679815481410517"), sut.getValue());
    }

}
