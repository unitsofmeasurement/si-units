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
package si.uom.impl.quantity;

import javax.measure.Unit;
import javax.measure.quantity.Temperature;

import tec.units.ri.quantity.NumberQuantity;

/**
 * @author Werner Keil
 * @version 1.5.2, $Date: 2016-10-23 $
 */
/**
 * @author werner
 *
 */
/**
 * @author werner
 *
 */
public final class TemperatureAmount extends NumberQuantity<Temperature> implements Temperature {

    /**
     * 
     */
    // private static final long serialVersionUID = -3444768963576192753L;

    private final Double scalar; // value in reference unit

    private final Double value; // value in unit (Unit unit)

    /**
     * @param number a number
     * @param unit a unit
     */
    public TemperatureAmount(Number number, Unit<Temperature> unit) {
	super(number, unit);
	scalar = (double) 0;
	value = (double) 0;
    }

    /**
     * @return if value is zero
     */
    public boolean isZero() {
	return (value != null) && 0d == (value);
    }

    /**
     * @param t
     * @return
     */
    public TemperatureAmount add(TemperatureAmount t) {
	return new TemperatureAmount(this.value + t.value, getUnit());
    }

    public TemperatureAmount subtract(TemperatureAmount d1) {
	return new TemperatureAmount(this.value - d1.value, getUnit());
    }

    protected boolean eq(TemperatureAmount dq) {
	return dq != null && dq.getValue().equals(getValue()) && dq.getUnit().equals(getUnit())
		&& dq.getScalar().equals(getScalar());
    }

    /**
     * @param v
     * @return
     */
    public TemperatureAmount divide(Double v) {
	return new TemperatureAmount(value / v, getUnit());
    }

    //
    // protected TemperatureAmount convert(TemperatureUnit newUnit) {
    // return new TemperatureAmount(value.doubleValue() /
    // newUnit.getFactor(), newUnit);
    // }

    /**
     * @return
     */
    public Double getScalar() {
	return scalar;
    }

    // @Override
    // public String toString(boolean withUnit, boolean withSpace, int
    // precision) {
    // final StringBuilder sb = new StringBuilder();
    // sb.append(getValue());
    // if(withUnit) {
    // if(withSpace) sb.append(" ");
    // sb.append(getUnit().getSymbol());
    // }
    // return sb.toString();
    // }

    // @Override
    // public String showInUnit(Unit<?> u, int precision,
    // SimpleFormat.Show showWith) {
    // return showInUnit(u, value, precision, showWith);
    // }
    //
    // @Override
    // public Number getValue() {
    // return value;
    // }
    //
    // @Override
    // public Unit<Temperature> getUnit() {
    // return unit;
    // }

    @Override
    public TemperatureAmount multiply(Number that) {
	return new TemperatureAmount(value * that.doubleValue(), getUnit());
    }

    @Override
    public TemperatureAmount divide(Number that) {
	return divide((Double) that);
    }

    // @Override
    // public BigDecimal decimalValue(Unit<Temperature> unit, MathContext ctx)
    // throws ArithmeticException {
    // // TODO Auto-generated method stub
    // return null;
    // }
}
