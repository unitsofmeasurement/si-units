/*
 * International System of Units (SI)
 * Copyright (c) 2005-2019, Jean-Marie Dautelle, Werner Keil and others.
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

import static si.uom.SI.AVOGADRO_CONSTANT_VALUE;
import static si.uom.SI.ELEMENTARY_CHARGE_VALUE;
import static tech.units.indriya.AbstractUnit.ONE;
import static tech.units.indriya.unit.MetricPrefix.CENTI;
import static tech.units.indriya.unit.MetricPrefix.FEMTO;
import static tech.units.indriya.unit.MetricPrefix.MEGA;
import static tech.units.indriya.unit.Units.*;

import javax.measure.Unit;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.AmountOfSubstance;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Area;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.ElectricCharge;
import javax.measure.quantity.ElectricCurrent;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Force;
import javax.measure.quantity.Frequency;
import javax.measure.quantity.Illuminance;
import javax.measure.quantity.Length;
import javax.measure.quantity.MagneticFlux;
import javax.measure.quantity.MagneticFluxDensity;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Power;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.RadiationDoseAbsorbed;
import javax.measure.quantity.RadiationDoseEffective;
import javax.measure.quantity.Radioactivity;
import javax.measure.quantity.SolidAngle;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Time;

import si.uom.quantity.DynamicViscosity;
import si.uom.quantity.IonizingRadiation;
import si.uom.quantity.KinematicViscosity;
import si.uom.quantity.Level;
import si.uom.quantity.Luminance;
import si.uom.quantity.MagneticFieldStrength;
import tech.units.indriya.AbstractConverter;
import tech.units.indriya.AbstractSystemOfUnits;
import tech.units.indriya.AbstractUnit;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.function.LogConverter;
import tech.units.indriya.function.PowersOfPiConverter;
import tech.units.indriya.function.MultiplyConverter;
import tech.units.indriya.function.RationalConverter;
import tech.units.indriya.unit.ProductUnit;
import tech.units.indriya.unit.TransformedUnit;

/**
 * <p>
 * This class contains units that are not part of the International System of
 * Units, that is, they are outside the SI, but some are still widely used.
 * </p>
 * 
 * <p>
 * This class is not intended to be implemented by clients.
 * </p>
 * 
 * @noimplement This class is not intended to be implemented by clients.
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.tech">Werner Keil</a>
 * @version 1.2, $Date: 2019-05-01$
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/Non-SI_units_mentioned_in_the_SI#Common_units_not_officially_sanctioned">Wikipedia:
 *      Common Units not officially sanctioned</a>
 */
public class NonSI extends AbstractSystemOfUnits {
    private static final String SYSTEM_NAME = "Non-SI Units";

    /**
     * Holds the standard gravity constant: 9.80665 m/sÂ² exact.
     */
    private static final int STANDARD_GRAVITY_DIVIDEND = 980665;

    private static final int STANDARD_GRAVITY_DIVISOR = 100000;

    /**
     * Holds the avoirdupois pound: 0.45359237 kg exact
     */
    private static final int AVOIRDUPOIS_POUND_DIVIDEND = 45359237;

    private static final int AVOIRDUPOIS_POUND_DIVISOR = 100000000;

    private static final NonSI INSTANCE = new NonSI();
    
    /////////////////////////////////////////////////////////////////
    // Units outside the SI that are accepted for use with the SI. //
    /////////////////////////////////////////////////////////////////

    /**
     * An angle unit accepted for use with SI units (standard name
     * <code>deg</code>).
     */
    public static final Unit<Angle> DEGREE_ANGLE = addUnit(
            new TransformedUnit<Angle>(RADIAN, PowersOfPiConverter.of(1).concatenate(new RationalConverter(1, 180))),
            "Degree Angle", "deg");

    /**
     * An angle unit accepted for use with SI units (standard name <code>'</code>).
     */
    public static final Unit<Angle> MINUTE_ANGLE = addUnit(new TransformedUnit<Angle>(RADIAN,
            PowersOfPiConverter.of(1).concatenate(new RationalConverter(1, 180 * 60))), "Minute Angle", "'");

    /**
     * An angle unit accepted for use with SI units (standard name <code>''</code>).
     */
    public static final Unit<Angle> SECOND_ANGLE = addUnit(
            new TransformedUnit<Angle>(RADIAN,
                    PowersOfPiConverter.of(1).concatenate(new RationalConverter(1, 180 * 60 * 60))),
            "Second Angle", "''");

    /**
     * An energy unit accepted for use with SI units (standard name
     * <code>eV</code>). The electronvolt is the kinetic energy acquired by an
     * electron passing through a potential difference of 1 V in vacuum. The value
     * must be obtained by experiment, and is therefore not known exactly.
     */
    public static final Unit<Energy> ELECTRON_VOLT = addUnit(
            new TransformedUnit<Energy>(JOULE, new MultiplyConverter(1.602176487E-19)), "Electron Volt", "eV");
    // CODATA 2006 - http://physics.nist.gov/cuu/Constants/codata.pdf

    /**
     * A mass unit accepted for use with SI units (standard name <code>u</code>).
     * The unified atomic mass unit is equal to 1/12 of the mass of an unbound atom
     * of the nuclide 12C, at rest and in its ground state. The value must be
     * obtained by experiment, and is therefore not known exactly.
     */
    public static final Unit<Mass> UNIFIED_ATOMIC_MASS = addUnit(
            new TransformedUnit<Mass>(KILOGRAM, new MultiplyConverter(1.660538782E-27)), "Unified atomic mass", "u",
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
     */
    public static final Unit<Length> ASTRONOMICAL_UNIT = addUnit(
            new TransformedUnit<Length>(METRE, new MultiplyConverter(149597871000.0)), "Astronomical Unit", "UA");
    // Best estimate source: http://maia.usno.navy.mil/NSFA/CBE.html

    /**
     * An angle unit accepted for use with SI units (standard name <code>ha</code>).
     */
    public static final Unit<Area> HECTARE = addUnit(
            new TransformedUnit<Area>(SQUARE_METRE, new RationalConverter(10000, 1)), "Hectare", "ha");

    ///////////////////
    // Dimensionless //
    ///////////////////
    /**
     * A dimensionless unit equals to <code>pi</code> (standard name
     * <code>Ï€</code>).
     */
    public static final Unit<Dimensionless> PI = addUnit(ONE.multiply(StrictMath.PI));

    /////////////////////////
    // Amount of substance //
    /////////////////////////
    /**
     * A unit of amount of substance equals to one atom (standard name
     * <code>atom</code>).
     */
    public static final Unit<AmountOfSubstance> ATOM = addUnit(MOLE.divide(AVOGADRO_CONSTANT_VALUE));

    ////////////
    // Length //
    ////////////

    /**
     * A unit of length equal to <code>1E-10 m</code> (standard name
     * <code>Å</code>).
     * 
     * @see <a href="https://en.wikipedia.org/wiki/%C3%85ngstr%C3%B6m"> Wikipedia:
     *      Ångström</a>
     */
    public static final Unit<Length> ANGSTROM = addUnit(METRE.divide(10000000000L), "\u00C5ngstr\u00F6m", "\u00C5");

    /**
     * A unit of length equal to the distance that light travels in one year through
     * a vacuum (standard name <code>ly</code>).
     */
    public static final Unit<Length> LIGHT_YEAR = addUnit(METRE.multiply(9.460528405e15), "Light year", "ly");

    /**
     * A unit of length equal to the distance at which a star would appear to shift
     * its position by one arcsecond over the course the time (about 3 months) in
     * which the Earth moves a distance of {@link #ASTRONOMICAL_UNIT} in the
     * direction perpendicular to the direction to the star (standard name
     * <code>pc</code>).
     */
    public static final Unit<Length> PARSEC = addUnit(METRE.multiply(30856770e9));

    /**
     * A unit of length equal to <code>1852.0 m</code> (standard name
     * <code>nmi</code>).
     */
    public static final Unit<Length> NAUTICAL_MILE = addUnit(METRE.multiply(1852), "Nautical mile", "nmi");

	/**
	 * The Bohr radius (a0 or rBohr) is a physical constant, approximately equal to the most probable distance between the nucleus and the electron in a hydrogen atom in its ground state.
	 * It is named after Niels Bohr, due to its role in the Bohr model of an atom. Its value is 5.2917721067(12)×10−11 m.
	 */
	public static final Unit<Length> BOHR_RADIUS = addUnit(METRE.multiply(5.291772106712E-11), "Bohr Radius", "a0");

    ////////////
    // Area //
    ////////////

    /**
     * A barn (symbol: <code>b</code>) is a unit of area equal to 10<sup>−28</sup>
     * <code>m2</code> (100 <code>fm2</code>)
     */
    public static final Unit<Area> BARN = addUnit(new ProductUnit<Area>(FEMTO(METRE).pow(2)).multiply(100));

    ////////////
    // Time //
    ////////////

    /**
     * A unit of duration equal to the time required for a complete rotation of the
     * earth in reference to any star or to the vernal equinox at the meridian,
     * equal to 23 hours, 56 minutes, 4.09 seconds (standard name
     * <code>day_sidereal</code>).
     */
    public static final Unit<Time> DAY_SIDEREAL = addUnit(SECOND.multiply(86164.09));
	
    /**
	 * A unit of duration equal to 365 {@link #DAY} (standard name
	 * <code>year</code>).
	 */
	public static final Unit<Time> YEAR_CALENDAR = addUnit(DAY.multiply(365));

    /**
     * A unit of duration equal to one complete revolution of the earth about the
     * sun, relative to the fixed stars, or 365 days, 6 hours, 9 minutes, 9.54
     * seconds (standard name <code>year_sidereal</code>).
     */
    public static final Unit<Time> YEAR_SIDEREAL = addUnit(SECOND.multiply(31558149.54));

    /**
     * The Julian year, as used in astronomy and other sciences, is a time unit
     * defined as exactly 365.25 days. This is the normal meaning of the unit "year"
     * (symbol "a" from the Latin annus, annata) used in various scientific
     * contexts.
     */
    public static final Unit<Time> YEAR_JULIEN = addUnit(SECOND.multiply(31557600));

    //////////
    // Mass //
    //////////
    /**
     * A unit of mass equal to 1/12 the mass of the carbon-12 atom (standard name
     * <code>u</code>).
     */
    public static final Unit<Mass> ATOMIC_MASS = addUnit(KILOGRAM.multiply(1e-3 / AVOGADRO_CONSTANT_VALUE));

    /**
     * A unit of mass equal to the mass of the electron (standard name
     * <code>me</code>).
     */
    public static final Unit<Mass> ELECTRON_MASS = addUnit(KILOGRAM.multiply(9.10938188E-31));
    
    /**
     * A mass unit accepted for use with SI units (standard name <code>t</code>).
     */
    public static final Unit<Mass> TONNE = addUnit(new TransformedUnit<Mass>(KILOGRAM, new RationalConverter(1000, 1)),
            "Tonne", "t");

    /////////////////////
    // Electric charge //
    /////////////////////
    /**
     * A unit of electric charge equal to the charge on one electron (standard name
     * <code>e</code>).
     */
    @SuppressWarnings("unused")
	private static final Unit<ElectricCharge> E = COULOMB.multiply(ELEMENTARY_CHARGE_VALUE);

    /**
     * A unit of electric charge equal to equal to the product of Avogadro's number
     * (see {@link SI#MOLE}) and the charge (1 e) on a single electron (standard
     * name <code>Fd</code>).
     */
    public static final Unit<ElectricCharge> FARADAY = addUnit(
            COULOMB.multiply(ELEMENTARY_CHARGE_VALUE * AVOGADRO_CONSTANT_VALUE)); // e/mol

    /**
     * A unit of electric charge which exerts a force of one dyne on an equal charge
     * at a distance of one centimeter (standard name <code>Fr</code>).
     */
    public static final Unit<ElectricCharge> FRANKLIN = addUnit(COULOMB.multiply(3.3356e-10));

    /////////////////
    // Temperature //
    /////////////////
    /**
     * A unit of temperature equal to <code>5/9 Â°K</code> (standard name
     * <code>Â°R</code>).
     */
    public static final Unit<Temperature> RANKINE = addUnit(KELVIN.multiply(5).divide(9));

    ///////////
    // Angle //
    ///////////

    /**
     * A unit of angle equal to a full circle or <code>2<i>&pi;</i>
     * {@link SI#RADIAN}</code> (standard name <code>rev</code>).
     */
    public static final Unit<Angle> REVOLUTION = addUnit(RADIAN.multiply(2).multiply(Math.PI).asType(Angle.class));

    //////////////
    // Speed    //
    //////////////
    /**
     * The Natural Unit of {@link Speed}, a unit of velocity relative to the speed of light (standard name
     * <code>c</code>).
     */
    public static final Unit<Speed> C = addUnit(METRE_PER_SECOND.multiply(299792458));

    /**
     * A unit of velocity expressing the number of {@link #NAUTICAL_MILE nautical
     * miles} per {@link #HOUR hour} (abbreviation <code>kn</code>).
     */
    public static final Unit<Speed> KNOT = addUnit(NAUTICAL_MILE.divide(HOUR).asType(Speed.class), "Knot", "kn");

    //////////////////
    // Acceleration //
    //////////////////
    
    /**
     * Standard acceleration of free fall, sometimes abbreviated as standard gravity. A unit of acceleration equal to the gravity at the earth's surface (standard
     * name <code>g<sub>n</sub></code>).
     */
    public static final Unit<Acceleration> STANDARD_GRAVITY = addUnit(METRE_PER_SQUARE_SECOND.multiply(STANDARD_GRAVITY_DIVIDEND)
       .divide(STANDARD_GRAVITY_DIVISOR), "g\\u2099");
    
    /**
     * A unit of acceleration equal to <code>1 cm s<sup>2</sup></code>  (standard
     * name <code>Gal</code>).
     */
    public static final Unit<Acceleration> GAL = addUnit(
            new ProductUnit<Acceleration>(CENTI(METRE).divide(SECOND.pow(2))));

    //////////////////////
    // Electric current //
    //////////////////////
    /**
     * A unit of electric charge equal to the centimeter-gram-second electromagnetic
     * unit of magnetomotive force, equal to <code>10/4
     * &pi;ampere-turn</code> (standard name <code>Gi</code>).
     */
    public static final Unit<ElectricCurrent> GILBERT = addUnit(AMPERE.multiply(10).divide(4).multiply(PI)
            .asType(ElectricCurrent.class));

    ////////////
    // Energy //
    ////////////
    /**
     * A unit of energy equal to <code>1E-7 J</code> (standard name
     * <code>erg</code>).
     */
    public static final Unit<Energy> ERG = addUnit(JOULE.divide(10000000));

    /////////////////
    // Luminance //
    /////////////////
    public static final Unit<Luminance> STILB = addUnit(
            new ProductUnit<Luminance>(CANDELA.divide(CENTI(METRE).pow(2))));

    /**
     * A unit of luminance equal to <code>1E4 Lx</code> (standard name
     * <code>La</code>).
     */
    public static final Unit<Luminance> LAMBERT = addUnit(new ProductUnit<Luminance>(STILB.divide(PI)));

    /**
     * A unit of illuminance equal to <code>1E4 Lx</code> (standard name
     * <code>ph</code>).
     */
    public static final Unit<Illuminance> PHOT = addUnit(LUX.divide(1E4), "Phot", "ph");

    ///////////////////
    // Magnetic Flux //
    ///////////////////
    /**
     * A unit of magnetic flux equal <code>1E-8 Wb</code> (standard name
     * <code>Mx</code>).
     */
    public static final Unit<MagneticFlux> MAXWELL = addUnit(WEBER.divide(100000000));

    // /////////////////////////
    // Magnetic Flux Density //
    // /////////////////////////
    /**
     * A unit of magnetic flux density equal <code>1000 A/m</code> (standard name
     * <code>G</code>).
     */
    public static final Unit<MagneticFluxDensity> GAUSS = addUnit(TESLA.divide(10000));

    /**
     * A unit of magnetic field strength equal <code>(10<sup>3</sup>/4pi) A m–1</code> (standard name
     * <code>Oe</code>).
     */
    public static final Unit<MagneticFieldStrength> OERSTED = addUnit(
            new ProductUnit<MagneticFieldStrength>(SI.AMPERE_PER_METRE.multiply(250).divide(PI)), "Ørsted", "Oe", true);
    
    ///////////
    // Force //
    ///////////
    /**
     * A unit of force equal to <code>1E-5 N</code> (standard name
     * <code>dyn</code>).
     */
    public static final Unit<Force> DYNE = addUnit(NEWTON.divide(100000), "Dyne", "dyn", true);

	/**
	 * A unit of force equal to <code>9.80665 N</code> (standard name
	 * <code>kgf</code>).
	 */
	public static final Unit<Force> KILOGRAM_FORCE = addUnit(
			NEWTON.multiply(STANDARD_GRAVITY_DIVIDEND).divide(STANDARD_GRAVITY_DIVISOR), "kgf");

    /**
     * A unit of force equal to <code>{@link #POUND}Â·{@link #G}</code> (standard
     * name <code>lbf</code>).
     */
    @SuppressWarnings("unused")
    private static final Unit<Force> POUND_FORCE = NEWTON.multiply(1L * AVOIRDUPOIS_POUND_DIVIDEND * STANDARD_GRAVITY_DIVIDEND)
            .divide(1L * AVOIRDUPOIS_POUND_DIVISOR * STANDARD_GRAVITY_DIVISOR);

	///////////
	// Power //
	///////////
	/**
	 * A unit of power equal to the power required to raise a mass of 75 kilograms
	 * at a velocity of 1 meter per second (metric, standard name <code>hp</code>).
	 */
	public static final Unit<Power> HORSEPOWER = addUnit(WATT.multiply(735.499));

    //////////////
    // Pressure //
    //////////////

    /**
     * A unit of pressure equal to <code>100 kPa</code> (standard name
     * <code>bar</code>).
     */
    public static final Unit<Pressure> BAR = addUnit(PASCAL.multiply(100000), "Bar", "b");

    /**
     * A unit of pressure equal to the pressure exerted at the Earth's surface by a
     * column of mercury 1 millimeter high (standard name <code>mmHg</code> ).
     */
    public static final Unit<Pressure> MILLIMETRE_OF_MERCURY = addUnit(PASCAL.multiply(133.322));

	/**
	 * A unit of pressure equal to the pressure exerted at the Earth's surface by a
	 * column of mercury 1 inch high (standard name <code>inHg</code>).
	 */
	public static final Unit<Pressure> INCH_OF_MERCURY = addUnit(PASCAL.multiply(3386.388));

    /////////////////////////////
    // Radiation dose absorbed //
    /////////////////////////////
    /**
     * A unit of radiation dose absorbed equal to a dose of 0.01 joule of energy per
     * kilogram of mass (J/kg) (standard name <code>rd</code>).
     */
    public static final Unit<RadiationDoseAbsorbed> RAD = addUnit(GRAY.divide(100), "Rad", "rd");

    /**
     * A unit of radiation dose effective equal to <code>0.01 Sv</code> (standard
     * name <code>rem</code>).
     */
    public static final Unit<RadiationDoseEffective> REM = addUnit(SIEVERT.divide(100));

    //////////////////////////
    // Radioactivity        //
    //////////////////////////
    /**
     * A unit of radioctive activity equal to the activity of a gram of radium
     * (standard name <code>Ci</code>).
     */
    public static final Unit<Radioactivity> CURIE = addUnit(BECQUEREL.multiply(37000000000L));

    /**
     * A unit of radioctive activity equal to 1 million radioactive disintegrations
     * per second (standard name <code>Rd</code>).
     */
    protected static final Unit<Radioactivity> RUTHERFORD = addUnit(BECQUEREL.multiply(1000000));

    /////////////////
    // Solid angle //
    /////////////////
    /**
     * A unit of solid angle equal to <code>4 <i>&pi;</i> steradians</code>
     * (standard name <code>sphere</code>).
     */
    protected static final Unit<SolidAngle> SPHERE = addUnit(
            STERADIAN.multiply(4).multiply(PI).asType(SolidAngle.class));

    ///////////////
    // Viscosity //
    ///////////////
    /**
     * A unit of dynamic viscosity equal to <code>1 g/(cmÂ·s)</code> (cgs unit).
     */
    public static final Unit<DynamicViscosity> POISE = addUnit(GRAM.divide(CENTI(METRE).multiply(SECOND)))
            .asType(DynamicViscosity.class);

    /**
     * A unit of kinematic viscosity equal to <code>1 cm²/s</code> (cgs unit).
     */
    public static final Unit<KinematicViscosity> STOKES = addUnit(CENTI(METRE).pow(2).divide(SECOND))
            .asType(KinematicViscosity.class);
    
    ///////////////
    // Frequency //
    ///////////////
    /**
     * A unit used to measure the frequency (rate) at which an imaging device
     * produces unique consecutive images (standard name <code>fps</code>).
     */
    protected static final Unit<Frequency> FRAMES_PER_SECOND = addUnit(ONE.divide(SECOND)).asType(Frequency.class);

    /**
     * A unit used to measure the ionizing ability of radiation (standard name
     * <code>R</code>).
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Roentgen_(unit)"> Wikipedia:
     *      Roentgen</a>
     */
    public static final Unit<IonizingRadiation> ROENTGEN = addUnit(
            COULOMB.divide(KILOGRAM).multiply(2.58e-4).asType(IonizingRadiation.class), "Roentgen", "R", true);

    ///////////////////////
    // Logarithmic Units //
    ///////////////////////

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static final Unit<Level<Dimensionless>> BEL = (Unit) addUnit(ONE.transform(new LogConverter(10)), "Bel", "B",
            true);

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static final Unit<Level<Dimensionless>> NEPER = (Unit) addUnit(ONE.transform(new LogConverter(Math.E)),
            "Neper", "Np", true);

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
    /**
     * Adds a new unit not mapped to any specified quantity type and puts a text
     * as symbol or label.
     *
     * @param unit
     *            the unit being added.
     * @param text
     *            the string to use as label or symbol
     * @param isLabel
     *            if the string should be used as a label or not
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit, String text, boolean isLabel) {
        return addUnit(unit, null, text, isLabel);
    }
    
    /**
     * Adds a new unit not mapped to any specified quantity type and puts a text
     * as symbol or label.
     *
     * @param unit
     *            the unit being added.
     * @param text
     *            the string to use as label or symbol
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit, String text) {
        return addUnit(unit, text, true);
    }
    
    // //////////////////////////////////////////////////////////////////////////
    // Label adjustments for Non-SI
    static {
    	SimpleUnitFormat.getInstance().label(TONNE, "t");
    	SimpleUnitFormat.getInstance().label(MEGA(TONNE), "Mt");
    	SimpleUnitFormat.getInstance().alias(STANDARD_GRAVITY, "gn");
    }
}
