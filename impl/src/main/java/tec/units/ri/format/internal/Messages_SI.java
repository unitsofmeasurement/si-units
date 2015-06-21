package tec.units.ri.format.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import tec.units.ri.format.internal.Messages;

public class Messages_SI extends Messages {

	private final Map<String, String> strings = new HashMap<String, String>(30);

	public Messages_SI() {
		strings.put("si.uom.SI.BIT", "b");
		strings.put("si.uom.SI.AMPERE_TURN", "At");
		strings.put("si.uom.SI.BECQUEREL", "Bq");
		strings.put("si.uom.SI.CANDELA", "cd");
		strings.put("si.uom.SI.CELSIUS", "\u00B0C");
		strings.put("si.uom.SI.CELSIUS.1", "\u2103");
		strings.put("si.uom.SI.CELSIUS.2", "Celsius");
		strings.put("si.uom.SI.COULOMB", "C");
		strings.put("si.uom.SI.FARAD", "F");
		strings.put("si.uom.SI.GRAM", "g");
		strings.put("si.uom.SI.GRAY", "Gy");
		strings.put("si.uom.SI.HENRY", "H");
		strings.put("si.uom.SI.HERTZ", "Hz");
		strings.put("si.uom.SI.HERTZ.2", "hertz");
		strings.put("si.uom.SI.JOULE", "J");
		strings.put("si.uom.SI.KATAL", "kat");
		strings.put("si.uom.SI.KELVIN", "K");
		strings.put("si.uom.SI.KILOGRAM", "kg");
		strings.put("si.uom.SI.KILOGRAM.1", "kilogram");
		strings.put("si.uom.SI.LUMEN", "lm");
		strings.put("si.uom.SI.LUX", "lx");
		strings.put("si.uom.SI.METRE", "m");
		strings.put("si.uom.SI.MOLE", "mol");
		strings.put("si.uom.SI.NEWTON", "N");
		strings.put("si.uom.SI.OHM", "\u03A9");
		strings.put("si.uom.SI.PASCAL", "Pa");
		strings.put("si.uom.SI.RADIAN", "rad");
		strings.put("si.uom.SI.ROENTGEN", "R");
		strings.put("si.uom.SI.SECOND", "s");
		strings.put("si.uom.SI.MINUTE", "min");
		strings.put("si.uom.SI.SIEMENS", "S");
		strings.put("si.uom.SI.SIEVERT", "Sv");
		strings.put("si.uom.SI.STERADIAN", "sr");
		strings.put("si.uom.SI.TESLA", "T");
		strings.put("si.uom.SI.VOLT", "V");
		strings.put("si.uom.SI.WATT", "W");
		strings.put("si.uom.SI.WEBER", "Wb");

	}

	protected String handleGetString(String key) {
		return strings.get(key);
	}

	/**
	 * Returns an <code>Enumeration</code> of the keys contained in this
	 * <code>ResourceBundle</code> and its parent bundles.
	 *
	 * @return an <code>Enumeration</code> of the keys contained in this
	 *         <code>ResourceBundle</code> and its parent bundles.
	 * @see #keySet()
	 */
	public Iterator<String> getKeys() {
		return strings.keySet().iterator();
	}

	@Override
	public Set<String> keySet() {
		return strings.keySet();
	}
}
