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

import static javax.measure.MetricPrefix.MEGA;
import static si.uom.SI.AVOGADRO_CONSTANT_VALUE;
import static si.uom.SI.ELEMENTARY_CHARGE_VALUE;
import static tech.units.indriya.AbstractUnit.ONE;
import static tech.units.indriya.unit.Units.BECQUEREL;
import static tech.units.indriya.unit.Units.DAY;
import static tech.units.indriya.unit.Units.COULOMB;
import static tech.units.indriya.unit.Units.JOULE;
import static tech.units.indriya.unit.Units.KILOGRAM;
import static tech.units.indriya.unit.Units.METRE;
import static tech.units.indriya.unit.Units.METRE_PER_SECOND;
import static tech.units.indriya.unit.Units.MOLE;
import static tech.units.indriya.unit.Units.PASCAL;
import static tech.units.indriya.unit.Units.RADIAN;
import static tech.units.indriya.unit.Units.SECOND;
import static tech.units.indriya.unit.Units.SQUARE_METRE;

import javax.measure.Unit;
import javax.measure.quantity.AmountOfSubstance;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Area;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.ElectricCharge;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.Radioactivity;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;

import si.uom.quantity.Level;
import tech.units.indriya.AbstractSystemOfUnits;
import tech.units.indriya.AbstractUnit;
import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.function.AbstractConverter;
import tech.units.indriya.function.LogConverter;
import tech.units.indriya.function.MultiplyConverter;
import tech.units.indriya.unit.TransformedUnit;

/**
 * <p>
 * This class contains units that are not part of the International System of
 * Units, that is, they are outside the SI, but some are still widely used.
 * </p>
 * 
 * @noextend This class is not intended to be extended by clients.
 *  
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.si">Werner Keil</a>
 * @version 2.2.1, January 21, 2025
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/Non-SI_units_mentioned_in_the_SI">Wikipedia:
 *      Non-SI units mentioned in the SI</a>
 */
public final class NonSI extends AbstractSystemOfUnits {
    private static final String SYSTEM_NAME = "Non-SI Units";

    private static final NonSI INSTANCE = new NonSI();
    
    /////////////////////////////////////////////////////////////////
    // Units outside the SI that are accepted for use with the SI. //
    /////////////////////////////////////////////////////////////////

    /**
     * An angle unit accepted for use with SI units (standard name
     * <code>deg</code>).
     */
    public static final Unit<Angle> DEGREE_ANGLE = addUnit(
            new TransformedUnit<Angle>(RADIAN, MultiplyConverter.ofPiExponent(1).concatenate(MultiplyConverter.ofRational(1, 180))),
            "Degree Angle", "deg");

    /**
     * An angle unit accepted for use with SI units (standard name <code>'</code>).
     */
    public static final Unit<Angle> MINUTE_ANGLE = addUnit(new TransformedUnit<Angle>(RADIAN,
            MultiplyConverter.ofPiExponent(1).concatenate(MultiplyConverter.ofRational(1, 180 * 60))), "Minute Angle", "'");

    /**
     * An angle unit accepted for use with SI units (standard name <code>''</code>).
     */
    public static final Unit<Angle> SECOND_ANGLE = addUnit(
            new TransformedUnit<Angle>(RADIAN,
                    MultiplyConverter.ofPiExponent(1).concatenate(MultiplyConverter.ofRational(1, 180 * 60 * 60))),
            "Second Angle", "''");

    /**
     * An energy unit accepted for use with SI units (standard name
     * <code>eV</code>). The electronvolt is the kinetic energy acquired by an
     * electron passing through a potential difference of 1 V in vacuum. The value
     * must be obtained by experiment, and is therefore not known exactly.
     */
    public static final Unit<Energy> ELECTRON_VOLT = addUnit(
            new TransformedUnit<Energy>(JOULE, MultiplyConverter.of(1.602176487E-19)), "Electron Volt", "eV");
    // CODATA 2006 - http://physics.nist.gov/cuu/Constants/codata.pdf

    /**
	 * A mass unit accepted for use with SI units (standard name <code>u</code>).
	 * The unified atomic mass unit is equal to 1/12 of the mass of an unbound atom
	 * of the nuclide 12C, at rest and in its ground state. The value must be
	 * obtained by experiment, and is therefore not known exactly.
	 */
	public static final Unit<Mass> UNIFIED_ATOMIC_MASS = addUnit(
			new TransformedUnit<Mass>(KILOGRAM, MultiplyConverter.of(1.660538782E-27)), "Unified atomic mass", "u",
			true);
	// CODATA 2006 - http://physics.nist.gov/cuu/Constants/codata.pdf

    /**
     * The dalton (Da) and the unified atomic mass unit (u) are alternative names (and symbols) for the same unit, 
     * equal to 1/12 times the mass of a free carbon 12 atom, at rest and in its ground state. 
     * The dalton is often combined with SI prefixes, for example to express the masses of large molecules in kilodaltons, kDa, or megadaltons, MDa, 
     * or to express the values of small mass differences of atoms or molecules in nanodaltons, nDa, or even picodaltons, pDa.
     */
    public static final Unit<Mass> DALTON = addUnit(
            new TransformedUnit<Mass>(UNIFIED_ATOMIC_MASS, AbstractConverter.IDENTITY), "Dalton", "Da");
    
    /**
     * A length unit accepted for use with SI units (standard name <code>UA</code>).
     * The astronomical unit is a unit of length. Its value is such that, when used
     * to describe the motion of bodies in the solar system, the heliocentric
     * gravitation constant is (0.017 202 098 95)2 ua3·d-2. The value must be
     * obtained by experiment, and is therefore not known exactly.
     * 
     * Originally conceived as the average of Earth's aphelion and perihelion, 
	 * since 2012 it has been defined as exactly 149,597,870,700 metres, 
	 * or about 150 million kilometres (93 million miles).
	 * 
	 * @see <a href="https://en.wikipedia.org/wiki/Astronomical_unit"> Wikipedia: Astronomical unit</a> 
     */
    public static final Unit<Length> ASTRONOMICAL_UNIT = addUnit(
            new TransformedUnit<Length>(METRE, MultiplyConverter.of(149597871000.0)), "Astronomical Unit", "UA");

    ////////////
    // Area   //
    ////////////

    /**
     * An angle unit accepted for use with SI units (standard name <code>ha</code>).
     */
    public static final Unit<Area> HECTARE = addUnit(
            new TransformedUnit<Area>(SQUARE_METRE, MultiplyConverter.ofRational(10000, 1)), "Hectare", "ha");

    /////////////////////////
    // Amount of substance //
    /////////////////////////
    /**
     * A unit of amount of substance equals to one atom (standard name
     * <code>atom</code>).
     */
    public static final Unit<AmountOfSubstance> ATOM = addUnit(MOLE.divide(AVOGADRO_CONSTANT_VALUE),
    		"Atom", "atom");

    ////////////
    // Length //
    ////////////

	/**
	 * The Bohr radius (a0 or rBohr) is a physical constant, approximately equal to the most probable distance between the nucleus and the electron in a hydrogen atom in its ground state.
	 * It is named after Niels Bohr, due to its role in the Bohr model of an atom. Its value is 5.2917721067(12)×10−11 m.
	 * 
     * @see <a href="https://en.wikipedia.org/wiki/Niels_Bohr"> Wikipedia: Niels Bohr</a> 
	 */
	public static final Unit<Length> BOHR_RADIUS = addUnit(METRE.multiply(5.291772106712E-11), "Bohr Radius", "a0");

    ////////////
    // Time   //
    ////////////

    /**
     * A unit of duration equal to the time required for a complete rotation of the
     * earth in reference to any star or to the vernal equinox at the meridian,
     * equal to 23 hours, 56 minutes, 4.09 seconds (standard name
     * <code>day_sidereal</code>).
     */
    public static final Unit<Time> DAY_SIDEREAL = addUnit(SECOND.multiply(86164.09),
    		"Day Sidereal", "day_sidereal");
	
    /**
	 * A unit of duration equal to 365 days (standard name
	 * <code>year</code>).
	 * @see SI#DAY
	 */
	public static final Unit<Time> YEAR_CALENDAR = addUnit(DAY.multiply(365), "Calendar Year", "year");

    /**
     * A unit of duration equal to one complete revolution of the earth about the
     * sun, relative to the fixed stars, or 365 days, 6 hours, 9 minutes, 9.54
     * seconds (standard name <code>year_sidereal</code>).
     */
    public static final Unit<Time> YEAR_SIDEREAL = addUnit(SECOND.multiply(31558149.54),
    		"Year Sidereal", "year_sidereal");

    /**
     * The Julian year, as used in astronomy and other sciences, is a time unit
     * defined as exactly 365.25 days. This is the normal meaning of the unit "year"
     * (symbol "a" from the Latin annus, annata) used in various scientific
     * contexts.
     */
    public static final Unit<Time> YEAR_JULIEN = addUnit(SECOND.multiply(31557600),
    		"Year Julien", "year_julien");

    //////////
    // Mass //
    //////////
    /**
     * A unit of mass equal to 1/12 the mass of the carbon-12 atom (standard name
     * <code>u</code>).
     */
    public static final Unit<Mass> ATOMIC_MASS = addUnit(KILOGRAM.multiply(1e-3 / AVOGADRO_CONSTANT_VALUE),
    		"Atomic Mass", "u");

    /**
     * A unit of mass equal to the mass of the electron (standard name
     * <code>me</code>).
     */
    public static final Unit<Mass> ELECTRON_MASS = addUnit(KILOGRAM.multiply(9.10938188E-31), "Electron Mass", "me");
    
    /**
     * A mass unit accepted for use with SI units (standard name <code>t</code>).
     */
    public static final Unit<Mass> TONNE = addUnit(new TransformedUnit<Mass>(KILOGRAM, MultiplyConverter.ofRational(1000, 1)),
            "Tonne", "t");

    /////////////////////
    // Electric charge //
    /////////////////////

    /**
     * A unit of electric charge equal to the product of Avogadro's number
     * (see {@link SI#MOLE}) and the charge (1 e) on a single electron (standard
     * name <code>Fd</code>).
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Michael_Faraday"> Wikipedia: Michael Faraday</a>
     * @see SI#COULOMB
     * @see SI#AVOGADRO_CONSTANT 
     * @see SI#ELEMENTARY_CHARGE
     */
    public static final Unit<ElectricCharge> FARADAY = addUnit(
            COULOMB.multiply(ELEMENTARY_CHARGE_VALUE * AVOGADRO_CONSTANT_VALUE), "Faraday", "Fd"); // e/mol

    /**
     * A unit of electric charge which exerts a force of one dyne on an equal charge
     * at a distance of one centimeter (standard name <code>Fr</code>).
     */
    public static final Unit<ElectricCharge> FRANKLIN = addUnit(COULOMB.multiply(3.3356e-10),
    		"Franklin", "Fr");

    //////////////
    // Speed    //
    //////////////
    /**
     * The Natural Unit of {@link Speed}, a unit of velocity relative to the speed of light (standard name
     * <code>c</code>).
     * @deprecated Use SI.C instead
     */
    public static final Unit<Speed> C = addUnit(METRE_PER_SECOND.multiply(299792458), "Speed of Light", "c");
  
    //////////////
    // Pressure //
    //////////////

    /**
     * A unit of pressure equal to the pressure exerted at the Earth's surface by a
     * column of mercury 1 millimeter high (standard name <code>mmHg</code> ).
     */
    public static final Unit<Pressure> MILLIMETRE_OF_MERCURY = addUnit(PASCAL.multiply(133.322387415),
    		"Millimetre of Mercury", "mmHg");

	/**
	 * A unit of pressure equal to the pressure exerted at the Earth's surface by a
	 * column of mercury 1 inch high (standard name <code>inHg</code>).
	 */
	public static final Unit<Pressure> INCH_OF_MERCURY = addUnit(PASCAL.multiply(3386.388),
			"Inch of Mercury", "inHg");

    //////////////////////////
    // Radioactivity        //
    //////////////////////////

    /**
     * A unit of radioctive activity equal to 1 million radioactive disintegrations
     * per second (standard name <code>Rd</code>).
     */
    protected static final Unit<Radioactivity> RUTHERFORD = addUnit(BECQUEREL.multiply(1000000), 
    		"Rutherford", "Rd");

    ///////////////////////
    // Logarithmic Units //
    ///////////////////////

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static final Unit<Level<Dimensionless>> BEL = (Unit) addUnit(ONE.transform(new LogConverter(10)), "Bel", "B",
            true);

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static final Unit<Level<Dimensionless>> NEPER = (Unit) addUnit(ONE.transform(new LogConverter(Math.E)),
            "Neper", "Np", true);

    ////////////////////////////////////////////////////////////////////////////
    // Label adjustments for Non-SI
    ////////////////////////////////////////////////////////////////////////////
    static {
        // Simple
    	SimpleUnitFormat.getInstance().label(TONNE, "t");
        SimpleUnitFormat.getInstance().label(MEGA(TONNE), "Mt");

       	// EBNF
       	EBNFUnitFormat.getInstance().label(TONNE, "t");
       	EBNFUnitFormat.getInstance().label(MEGA(TONNE), "Mt");
    }
    
    /////////////////////
    // Collection View //
    /////////////////////

    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private NonSI() {
    }

    /**
     * Returns the unique instance of this class.
     * 
     * @return the NonSI instance.
     */
    public static NonSI getInstance() {
        return INSTANCE;
    }

    public String getName() {
        return SYSTEM_NAME;
    }

    /**
     * Adds a new unit not mapped to any specified quantity type.
     *
     * @param unit
     *            the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit) {
        INSTANCE.units.add(unit);
        return unit;
    }

    /**
     * Adds a new unit not mapped to any specified quantity type and puts a text as
     * symbol or label.
     *
     * @param unit
     *            the unit being added.
     * @param name
     *            the string to use as name
     * @param text
     *            the string to use as label or symbol
     * @param isLabel
     *            if the string should be used as a label or not
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit, String name, String text, boolean isLabel) {
        if (isLabel && text != null) {
            SimpleUnitFormat.getInstance().label(unit, text);
            EBNFUnitFormat.getInstance().label(unit, text);
        }
        if (name != null && unit instanceof AbstractUnit) {
            return Helper.addUnit(INSTANCE.units, unit, name);
        } else {
            INSTANCE.units.add(unit);
        }
        return unit;
    }

    /**
     * Adds a new unit not mapped to any specified quantity type and puts a text as
     * symbol or label.
     *
     * @param unit
     *            the unit being added.
     * @param name
     *            the string to use as name
     * @param text
     *            the string to use as label
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit, String name, String text) {
        return addUnit(unit, name, text, true);
    }
}
