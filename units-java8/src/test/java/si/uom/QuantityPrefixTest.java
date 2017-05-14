package si.uom;

import static org.junit.Assert.*;
import static tec.uom.se.unit.MetricPrefix.*;
import static tec.uom.se.unit.Units.*;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

import org.junit.Test;

import tec.uom.se.quantity.Quantities;

public class QuantityPrefixTest {
	@Test
	public void testKilo() {
		// TODO how to handle equals for units?
//		assertEquals(KILOGRAM.getSymbol(), KILO(GRAM).getSymbol());
		assertEquals(KILOGRAM.toString(), KILO(GRAM).toString());
	}
	
	@Test
	public void testTonne() {
		Quantity<Mass> m1 = Quantities.getQuantity(1.0, SI.TONNE);
		assertEquals(1d, m1.getValue());
		assertEquals("t", m1.getUnit().toString());
	}
	
	@Test
	public void testMegaTonne() {
		Quantity<Mass> m1 = Quantities.getQuantity(1.0, MEGA(SI.TONNE));
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
