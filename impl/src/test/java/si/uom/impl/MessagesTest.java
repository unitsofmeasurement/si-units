package si.uom.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import tec.units.ri.format.internal.l10n.L10nBundle;
import tec.units.ri.format.internal.l10n.L10nResources;
import tec.units.ri.format.internal.l10n.Locale;

public class MessagesTest {
/*	
	@Test
	@Ignore
	public void testL10() {
		L10nBundle resources = L10nPropertyResources.getBundle("de");
		assertNotNull(resources);
	}
*/	
	@Test
	public void testMessageBundle() {
		final Locale locale = Locale.getDefault();
		   
		final L10nBundle bundle = L10nResources.getBundle("tec.units.ri.format.internal.Messages", locale);
		assertNotNull(bundle);
		String text = bundle.getString("tec.units.ri.unit.Units.KILOMETRES_PER_HOUR");
		assertEquals("kph", text);
		
		assertEquals(57, bundle.keySet().size());
	}

	@Test
	public void testMapBundle_SI() {
		final Locale locale = new Locale("SI");
		   
		final L10nBundle bundle = L10nResources.getBundle("tec.units.ri.format.internal.Messages", locale);
		assertNotNull(bundle);
		String text = bundle.getString("si.uom.SI.BIT");
		assertEquals("b", text);
		
		assertEquals(37, bundle.keySet().size());
		
		text = bundle.getString("tec.units.ri.unit.Units.KILOMETRES_PER_HOUR");
		assertEquals("kph", text);
	}
/*	
	@Test
	public void testMapBundle_fr() {
		Locale locale = new Locale("fr");
		   
		L10nBundle resources = L10nResources.getBundle("tec.units.ri.format.Messages", locale);
		assertNotNull(resources);
		String text = resources.getString("text");
		assertEquals("Voici du texte.", text);
	}
	*/
}
