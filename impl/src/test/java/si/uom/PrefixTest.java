package si.uom;

import static org.junit.Assert.*;
import static tec.units.ri.unit.MetricPrefix.*;
import static tec.units.ri.unit.SI.GRAM;
import static tec.units.ri.unit.SI.KILOGRAM;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import org.junit.Ignore;
import org.junit.Test;

import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.SI;

public class PrefixTest {
	@Test
	public void testKilo() {
		// TODO how to handle equals for units?
		assertEquals(KILOGRAM.getSymbol(), KILO(GRAM).getSymbol());
		assertEquals(KILOGRAM.toString(), KILO(GRAM).toString());
	}
	
	@Test
	public void testMicro2() {
		Quantity<Length> m1 = Quantities.getQuantity(1.0, SI.METRE);
		assertEquals(1d, m1.getValue());
		assertEquals("m", m1.getUnit().toString());
				
		Quantity<Length> m2 = m1.to(MICRO(SI.METRE));
		assertEquals(1000000.0d, m2.getValue());
		assertEquals("µm", m2.getUnit().toString());
	}
	
	@Test
	@Ignore
	public void testNano() {
		Quantity<Mass> m1 = Quantities.getQuantity(1.0, SI.GRAM);
		assertEquals(1d, m1.getValue());
		assertEquals("g", m1.getUnit().toString());
				
		Quantity<Mass> m2 = m1.to(NANO(SI.GRAM));
		assertEquals(1000000000.0d, m2.getValue());
		assertEquals("ng", m2.getUnit().toString());
	}
	
	@Test
	public void testNano2() {
		Quantity<Length> m1 = Quantities.getQuantity(1.0, SI.METRE);
		assertEquals(1d, m1.getValue());
		assertEquals("m", m1.getUnit().toString());
				
		Quantity<Length> m2 = m1.to(NANO(SI.METRE));
		assertEquals(1000000000.0d, m2.getValue());
		assertEquals("nm", m2.getUnit().toString());
	}
}
