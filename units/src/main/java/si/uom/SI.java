/*
 *  SI Units
 *  Copyright (c) 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Area;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import si.uom.quantity.*;
import tec.units.ri.AbstractSystemOfUnits;
import tec.units.ri.AbstractUnit;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.function.MultiplyConverter;
import tec.units.ri.function.PiMultiplierConverter;
import tec.units.ri.function.RationalConverter;
import tec.units.ri.unit.AlternateUnit;
import tec.units.ri.unit.ProductUnit;
import tec.units.ri.unit.TransformedUnit;
import tec.units.ri.unit.Units;

/**
 * <p>
 * This class defines all SI (Système International d'Unités) base units and
 * derived units as well as units that are accepted for use with the SI units.
 * </p>
 *
 * @see <a href=
 *      "http://en.wikipedia.org/wiki/International_System_of_Units">Wikipedia:
 *      International System of Units</a>
 * @see <a href="http://physics.nist.gov/cuu/Units/outside.html">Units outside
 *      the SI that are accepted for use with the SI</a>
 * @see <a href="http://www.bipm.org/utils/common/pdf/si_brochure_8.pdf">SI 2006
 *      - Official Specification</a>
 * @see MetricPrefix
 * 
 * @noextend This class is not intended to be extended by clients.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.si">Werner Keil</a>
 * @version 1.0.1, October 23, 2016
 */
public final class SI extends Units {

    /**
     * The singleton instance.
     */
    private static final SI INSTANCE = new SI();

    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private SI() {
    }

    /**
     * Returns the singleton instance of this class.
     *
     * @return the metric system instance.
     */
    public static SI getInstance() {
	return INSTANCE;
    }

    ////////////////////////////////
    // SI DERIVED ALTERNATE UNITS //
    ////////////////////////////////

    /**
     * The SI unit for magnetomotive force (standard name <code>At</code>).
     */
    public static final AlternateUnit<MagnetomotiveForce> AMPERE_TURN = addUnit(
	    new AlternateUnit<MagnetomotiveForce>(SI.AMPERE, "At"), MagnetomotiveForce.class);

    //////////////////////////////
    // SI DERIVED PRODUCT UNITS //
    //////////////////////////////

    /**
     * The SI unit for acceleration quantities (standard name
     * <code>m/s2</code>).
     */
    public static final Unit<Acceleration> METRE_PER_SQUARE_SECOND = addUnit(
	    new ProductUnit<Acceleration>(METRES_PER_SECOND.divide(SECOND)), Acceleration.class);
    /**
     * Alias for METRE_PER_SQUARE_SECOND.
     * 
     * @deprecated use METRE_PER_SQUARE_SECOND instead.
     */
    public static final Unit<Acceleration> METRES_PER_SQUARE_SECOND = METRE_PER_SQUARE_SECOND;

    /**
     * The SI unit for action quantities (standard name <code>j.s</code>).
     */
    public static final Unit<Action> JOULE_SECOND = addUnit(new ProductUnit<Action>(JOULE.multiply(SECOND)),
	    Action.class);

    /**
     * The SI unit for electric permittivity (standard name <code>ε</code>,
     * <code>F/m </code> or <code>F·m−1</code>). In electromagnetism, absolute
     * permittivity is the measure of resistance that is encountered when
     * forming an electric field in a medium.
     */
    public static final Unit<ElectricPermittivity> FARAD_PER_METRE = addUnit(
	    new AlternateUnit<ElectricPermittivity>(FARAD.divide(METRE), "ε"), ElectricPermittivity.class);

    /**
     * The SI unit for magnetic permeability quantities (standard name
     * <code>N/A2</code>).
     */
    public static final Unit<MagneticPermeability> NEWTON_PER_SQUARE_AMPERE = addUnit(
	    new ProductUnit<MagneticPermeability>(NEWTON.divide(AMPERE.pow(2))), MagneticPermeability.class);

    /**
     * Alias for NEWTON_PER_SQUARE_AMPERE.
     * 
     * @deprecated use NEWTON_PER_SQUARE_AMPERE.
     */
    public static final Unit<MagneticPermeability> NEWTONS_PER_SQUARE_AMPERE = NEWTON_PER_SQUARE_AMPERE;

    /**
     * The SI unit for wave number quantities (standard name <code>1/m</code>).
     */
    public static final Unit<WaveNumber> RECIPROCAL_METRE = addUnit(new ProductUnit<WaveNumber>(METRE.pow(-1)),
	    WaveNumber.class);

    /**
     * The SI unit for dynamic viscosity quantities (standard name
     * <code>Pa.s</code>).
     */
    public static final Unit<DynamicViscosity> PASCAL_SECOND = addUnit(
	    new ProductUnit<DynamicViscosity>(PASCAL.multiply(SECOND)), DynamicViscosity.class);

    /**
     * Luminance is a photometric measure of the luminous intensity per unit
     * area of light travelling in a given direction. It describes the amount of
     * light that passes through, is emitted or reflected from a particular
     * area, and falls within a given solid angle. The SI unit for luminance is
     * candela per square metre (<code>cd/m2</code>).
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Luminance"> Wikipedia:
     *      Luminance</a>
     */
    public static final Unit<Luminance> CANDELA_PER_SQUARE_METRE = addUnit(
	    new ProductUnit<Luminance>(CANDELA.divide(SQUARE_METRE)), Luminance.class);

    /**
     * The SI unit for kinematic viscosity quantities (standard name
     * <code>m2/s"</code>).
     */
    public static final Unit<KinematicViscosity> SQUARE_METRE_PER_SECOND = addUnit(
	    new ProductUnit<KinematicViscosity>(SQUARE_METRE.divide(SECOND)), KinematicViscosity.class);

    /**
     * Alias for SQUARE_METRE_PER_SECOND.
     * 
     * @deprecated use SQUARE_METRE_PER_SECOND.
     */
    public static final Unit<KinematicViscosity> SQUARE_METRES_PER_SECOND = SQUARE_METRE_PER_SECOND;

    /**
     * The SI unit for magnetic field strength quantities (standard name
     * <code>A/m"</code>).
     */
    public static final Unit<MagneticFieldStrength> AMPERE_PER_METRE = addUnit(
	    new ProductUnit<MagneticFieldStrength>(AMPERE.divide(METRE)), MagneticFieldStrength.class);

    /**
     * Alias for AMPERE_PER_METRE.
     * 
     * @deprecated use AMPERE_PER_METRE.
     */
    public static final Unit<MagneticFieldStrength> AMPERES_PER_METRE = AMPERE_PER_METRE;

    /**
     * The SI unit for ionizing radiation quantities (standard name
     * <code>C/kg"</code>).
     */
    public static final Unit<IonizingRadiation> COULOMB_PER_KILOGRAM = addUnit(
	    new ProductUnit<IonizingRadiation>(COULOMB.divide(KILOGRAM)), IonizingRadiation.class);
    /**
     * Alias for COULOMB_PER_KILOGRAM.
     * 
     * @deprecated use COULOMB_PER_KILOGRAM.
     */
    public static final Unit<IonizingRadiation> COULOMBS_PER_KILOGRAM = COULOMB_PER_KILOGRAM;

    /**
     * The SI unit for radiant intensity (standard name <code>W/sr</code>).
     */
    public static final Unit<RadiantIntensity> WATT_PER_STERADIAN = addUnit(
	    WATT.divide(STERADIAN).asType(RadiantIntensity.class));
    
    /**
     * The SI unit for radiance (standard name <code>W⋅sr−1⋅m−2</code>).
     */
    public static final Unit<Radiance> WATT_PER_STERADIAN_PER_SQUARE_METRE = addUnit(
	    WATT_PER_STERADIAN.divide(SQUARE_METRE).asType(Radiance.class));

    /////////////////////////////////////////////////////////////////
    // Units outside the SI that are accepted for use with the SI. //
    /////////////////////////////////////////////////////////////////

    /**
     * An angle unit accepted for use with SI units (standard name
     * <code>deg</code>).
     * @deprecated use NonSI
     */
    public static final Unit<Angle> DEGREE_ANGLE = addUnit(
	    new TransformedUnit<Angle>(RADIAN, new PiMultiplierConverter().concatenate(new RationalConverter(1, 180))));

    /**
     * An angle unit accepted for use with SI units (standard name
     * <code>'</code>).
     * @deprecated use NonSI
     */
    public static final Unit<Angle> MINUTE_ANGLE = addUnit(new TransformedUnit<Angle>(RADIAN,
	    new PiMultiplierConverter().concatenate(new RationalConverter(1, 180 * 60))));

    /**
     * An angle unit accepted for use with SI units (standard name
     * <code>''</code>).
     * @deprecated use NonSI
     */
    public static final Unit<Angle> SECOND_ANGLE = new TransformedUnit<Angle>(RADIAN,
	    new PiMultiplierConverter().concatenate(new RationalConverter(1, 180 * 60 * 60)));

    /**
     * A mass unit accepted for use with SI units (standard name
     * <code>t</code>).
     * @deprecated use NonSI
     */
    public static final Unit<Mass> TONNE = AbstractSystemOfUnits.Helper.addUnit(INSTANCE.units,
	    new TransformedUnit<Mass>(KILOGRAM, new RationalConverter(1000, 1)), "Tonne", "t");

    /**
     * An energy unit accepted for use with SI units (standard name
     * <code>eV</code>). The electronvolt is the kinetic energy acquired by an
     * electron passing through a potential difference of 1 V in vacuum. The
     * value must be obtained by experiment, and is therefore not known exactly.
     */
    public static final Unit<Energy> ELECTRON_VOLT = addUnit(
	    new TransformedUnit<Energy>(JOULE, new MultiplyConverter(1.602176487E-19)));
    // CODATA 2006 - http://physics.nist.gov/cuu/Constants/codata.pdf

    /**
     * A mass unit accepted for use with SI units (standard name
     * <code>u</code>). The unified atomic mass unit is equal to 1/12 of the
     * mass of an unbound atom of the nuclide 12C, at rest and in its ground
     * state. The value must be obtained by experiment, and is therefore not
     * known exactly.
     */
    public static final Unit<Mass> UNIFIED_ATOMIC_MASS = addUnit(
	    new TransformedUnit<Mass>(KILOGRAM, new MultiplyConverter(1.660538782E-27)), "Unified atomic mass", "u", true);
    // CODATA 2006 - http://physics.nist.gov/cuu/Constants/codata.pdf

    /**
     * A length unit accepted for use with SI units (standard name
     * <code>UA</code>). The astronomical unit is a unit of length. Its value is
     * such that, when used to describe the motion of bodies in the solar
     * system, the heliocentric gravitation constant is (0.017 202 098 95)2
     * ua3·d-2. The value must be obtained by experiment, and is therefore not
     * known exactly.
     */
    public static final Unit<Length> ASTRONOMICAL_UNIT = addUnit(
	    new TransformedUnit<Length>(METRE, new MultiplyConverter(149597871000.0)));
    // Best estimate source: http://maia.usno.navy.mil/NSFA/CBE.html

    /**
     * An angle unit accepted for use with SI units (standard name
     * <code>rev</code>).
     */
    public static final Unit<Angle> REVOLUTION = addUnit(
	    new TransformedUnit<Angle>(RADIAN, new PiMultiplierConverter().concatenate(new RationalConverter(2, 1))));

    /**
     * An angle unit accepted for use with SI units (standard name
     * <code>ha</code>).
     */
    public static final Unit<Area> HECTARE = addUnit(
	    new TransformedUnit<Area>(SQUARE_METRE, new RationalConverter(10000, 1)));

    /////////////////////
    // Collection View //
    /////////////////////

    @Override
    public String getName() {
	return "SI";
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
     * Adds a new unit not mapped to any specified quantity type and puts a text
     * as symbol or label.
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
	if (isLabel) {
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
    @SuppressWarnings("unused")
    private static <U extends Unit<?>> U addUnit(U unit, String text, boolean isLabel) {
	return addUnit(unit, null, text, isLabel);
    }

    /**
     * Adds a new unit and maps it to the specified quantity type.
     *
     * @param unit
     *            the unit being added.
     * @param type
     *            the quantity type.
     * @return <code>unit</code>.
     */
    private static <U extends AbstractUnit<?>> U addUnit(U unit, Class<? extends Quantity<?>> type) {
	INSTANCE.units.add(unit);
	INSTANCE.quantityToUnit.put(type, unit);
	return unit;
    }
}
