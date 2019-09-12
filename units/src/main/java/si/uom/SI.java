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

import static tech.units.indriya.AbstractUnit.ONE;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.ElectricCharge;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import si.uom.quantity.*;
import tech.units.indriya.AbstractUnit;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.function.MultiplyConverter;
import tech.units.indriya.unit.AlternateUnit;
import tech.units.indriya.unit.ProductUnit;
import tech.units.indriya.unit.TransformedUnit;
import tech.units.indriya.unit.Units;

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
 * @see <a href="https://www.bipm.org/en/publications/si-brochure/">SI Brochure:
 *      The International System of Units (SI)</a>
 * @see MetricPrefix
 * 
 * @noextend This class is not intended to be extended by clients.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.si">Werner Keil</a>
 * @version 2.4, September 12, 2019
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
			new AlternateUnit<MagnetomotiveForce>(AMPERE, "At"), MagnetomotiveForce.class);

	//////////////////////////////
	// SI DERIVED PRODUCT UNITS //
	//////////////////////////////

	/**
	 * The SI unit for acceleration quantities (standard name <code>m/s2</code>).
	 */
	public static final Unit<Acceleration> METRE_PER_SQUARE_SECOND = addUnit(
			new ProductUnit<Acceleration>(METRE_PER_SECOND.divide(SECOND)), Acceleration.class);

	/**
	 * The SI unit for action quantities (standard name <code>J.s</code>).
	 */
	public static final Unit<Action> JOULE_SECOND = addUnit(new ProductUnit<Action>(JOULE.multiply(SECOND)),
			Action.class);

	/**
	 * The SI unit for electric permittivity (standard name <code>ε</code>,
	 * <code>F/m </code> or <code>F·m−1</code>). In electromagnetism, absolute
	 * permittivity is the measure of resistance that is encountered when forming an
	 * electric field in a medium.
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
	 * Luminance is a photometric measure of the luminous intensity per unit area of
	 * light travelling in a given direction. It describes the amount of light that
	 * passes through, is emitted or reflected from a particular area, and falls
	 * within a given solid angle. The SI unit for luminance is candela per square
	 * metre (<code>cd/m2</code>).
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
	 * The SI unit for magnetic field strength quantities (standard name
	 * <code>A/m"</code>).
	 */
	public static final Unit<MagneticFieldStrength> AMPERE_PER_METRE = addUnit(
			new ProductUnit<MagneticFieldStrength>(AMPERE.divide(METRE)), MagneticFieldStrength.class);

	/**
	 * The SI unit for ionizing radiation quantities (standard name
	 * <code>C/kg"</code>).
	 */
	public static final Unit<IonizingRadiation> COULOMB_PER_KILOGRAM = addUnit(
			new ProductUnit<IonizingRadiation>(COULOMB.divide(KILOGRAM)), IonizingRadiation.class);

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

	/**
	 * The SI unit for intensity (standard name <code>W/m<sup>2</sup></code>).
	 */
	public static final Unit<Intensity> WATT_PER_SQUARE_METRE = addUnit(
			WATT.divide(SQUARE_METRE).asType(Intensity.class));

	/**
	 * The SI unit of angular speed (standard name <code>rad/s</code>).
	 * 
	 * @see AngularSpeed
	 */
	public static final Unit<AngularSpeed> RADIAN_PER_SECOND = addUnit(
			new ProductUnit<AngularSpeed>(RADIAN.divide(SECOND)), "Radian per second", AngularSpeed.class);

	/**
	 * The SI unit of angular acceleration (standard name <code>rad/s²</code>).
	 * 
	 * @see AngularAcceleration
	 */
	public static final Unit<AngularAcceleration> RADIAN_PER_SQUARE_SECOND = addUnit(
			new ProductUnit<AngularAcceleration>(RADIAN_PER_SECOND.divide(SECOND)), "Radian per square second",
			AngularAcceleration.class);

	/**
	 * An energy unit accepted for use with SI units (standard name
	 * <code>eV</code>). The electronvolt is the kinetic energy acquired by an
	 * electron passing through a potential difference of 1 V in vacuum. The value
	 * must be obtained by experiment, and is therefore not known exactly.
	 */
	public static final Unit<Energy> ELECTRON_VOLT = addUnit(
			new TransformedUnit<Energy>(JOULE, MultiplyConverter.of(1.602176487E-19)));
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
	 * A length unit accepted for use with SI units (standard name <code>UA</code>).
	 * The astronomical unit is a unit of length. 
	 * Originally conceived as the average of Earth's aphelion and perihelion, 
	 * since 2012 it has been defined as exactly 149,597,870,700 metres, 
	 * or about 150 million kilometres (93 million miles).
	 * 
	 * @see <a href="https://en.wikipedia.org/wiki/Astronomical_unit"> Wikipedia: Astronomical unit</a>
	 */
	public static final Unit<Length> ASTRONOMICAL_UNIT = addUnit(
			new TransformedUnit<Length>(METRE, MultiplyConverter.of(149597870700d)));

	/**
	 * An angle unit accepted for use with SI units (standard name
	 * <code>rev</code>).
	 */
	public static final Unit<Angle> REVOLUTION = addUnit(new TransformedUnit<Angle>(RADIAN,
			MultiplyConverter.ofPiExponent(1).concatenate(MultiplyConverter.ofRational(2, 1))));

	///////////////////////////
	// Fundamental Constants //
	///////////////////////////

	/**
	 * Holds the numeric value of the Avogadro constant.
	 */
	static final double AVOGADRO_CONSTANT_VALUE = 6.02214199E23; // (1/mol).

	/**
	 * Holds the numeric value of the Boltzmann constant.
	 */
	static final double BOLTZMANN_CONSTANT_VALUE = 1.3806485279E-23;

	/**
	 * Holds the electric charge value of one electron.
	 */
	static final double ELEMENTARY_CHARGE_VALUE = 1.602176462E-19; // (C).

	/**
	 * Holds the numeric value of the Planck constant.
	 */
	static final double PLANCK_CONSTANT_VALUE = 6.62607015E-34; // (1/mol).

	/**
	 * The Avogadro constant, named after scientist Amedeo Avogadro, is the number
	 * of constituent particles, usually molecules, atoms or ions that are contained
	 * in the amount of substance given by one mole. It is the proportionality
	 * factor that relates the molar mass of a substance to the mass of a sample, is
	 * designated with the symbol <code>N<sub>A<sub></code> or <code>L</code>, and has the
	 * value 6.022140857(74)×1023 mol−1 in the International System of Units (SI).
	 */
	public static final Unit<Dimensionless> AVOGADRO_CONSTANT = addUnit(
			new AlternateUnit<Dimensionless>(ONE.divide(MOLE), "m-1").multiply(AVOGADRO_CONSTANT_VALUE), "NA", true); // (1/mol).

	/**
	 * The Boltzmann constant (<code>k<sub>B<sub></code> or <code>k</code>) is a physical
	 * constant named after its discoverer, Ludwig Boltzmann, which relates the
	 * average relative kinetic energy of particles in a gas with the temperature of
	 * the gas and occurs in Planck's law of black-body radiation and in Boltzmann's
	 * entropy formula.
	 */
	public static final Unit<Dimensionless> BOLTZMANN_CONSTANT = addUnit(
			new AlternateUnit<Dimensionless>(JOULE.divide(KELVIN), "J/K").multiply(BOLTZMANN_CONSTANT_VALUE), "kB",
			true);

	/**
	 * The elementary charge, usually denoted by <code>e</code> or sometimes
	 * <code>qe</code>, is the electric charge carried by a single proton or,
	 * equivalently, the magnitude of the electric charge carried by a single
	 * electron, which has charge −1 e. This elementary charge is a fundamental
	 * physical constant. To avoid confusion over its sign, e is sometimes called
	 * the elementary positive charge.
	 */
	public static final Unit<ElectricCharge> ELEMENTARY_CHARGE = addUnit(COULOMB.multiply(ELEMENTARY_CHARGE_VALUE), "e",
			true);

	/**
	 * The Planck constant (denoted <code>ℎ</code>, also called Planck's constant)
	 * is a physical constant that is the quantum of electromagnetic action, which
	 * relates the energy carried by a photon to its frequency. A photon's energy is
	 * equal to its frequency multiplied by the Planck constant. The Planck constant
	 * is of fundamental importance in quantum mechanics, and in metrology it is the
	 * basis for the definition of the kilogram.
	 */
	public static final Unit<Action> PLANCK_CONSTANT = addUnit(JOULE_SECOND.multiply(PLANCK_CONSTANT_VALUE), "\u210E", true);

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
	 * @param unit the unit being added.
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
	 * @param unit    the unit being added.
	 * @param name    the string to use as name
	 * @param text    the string to use as label or symbol
	 * @param isLabel if the string should be used as a label or not
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
	 * Adds a new unit not mapped to any specified quantity type and puts a text as
	 * symbol or label.
	 *
	 * @param unit    the unit being added.
	 * @param text    the string to use as label or symbol
	 * @param isLabel if the string should be used as a label or not
	 * @return <code>unit</code>.
	 */
	private static <U extends Unit<?>> U addUnit(U unit, String text, boolean isLabel) {
		return addUnit(unit, null, text, isLabel);
	}

	/**
	 * Adds a new unit not mapped to any specified quantity type and puts a text as
	 * symbol or label.
	 *
	 * @param unit  the unit being added.
	 * @param name  the string to use as name
	 * @param label the string to use as label
	 * @return <code>unit</code>.
	 */
	private static <U extends Unit<?>> U addUnit(U unit, String name, String label) {
		return addUnit(unit, name, label, true);
	}

	/**
	 * Adds a new unit with name and label and maps it to the specified quantity
	 * type.
	 *
	 * @param unit  the unit being added.
	 * @param name  the string to use as name
	 * @param label the string to use as label
	 * @param type  the quantity type.
	 * @return <code>unit</code>.
	 */
	@SuppressWarnings("unused")
	private static <U extends AbstractUnit<?>> U addUnit(U unit, String name, String label,
			Class<? extends Quantity<?>> type) {
		INSTANCE.quantityToUnit.put(type, unit);
		return addUnit(unit, name, label);
	}

	/**
	 * Adds a new unit with a name and maps it to the specified quantity type.
	 *
	 * @param unit the unit being added.
	 * @param name the string to use as name
	 * @param type the quantity type.
	 * @return <code>unit</code>.
	 */
	private static <U extends AbstractUnit<?>> U addUnit(U unit, String name, Class<? extends Quantity<?>> type) {
		INSTANCE.quantityToUnit.put(type, unit);
		return addUnit(unit, name, null, false);
	}

	/**
	 * Adds a new unit and maps it to the specified quantity type.
	 *
	 * @param unit the unit being added.
	 * @param type the quantity type.
	 * @return <code>unit</code>.
	 */
	private static <U extends AbstractUnit<?>> U addUnit(U unit, Class<? extends Quantity<?>> type) {
		INSTANCE.units.add(unit);
		INSTANCE.quantityToUnit.put(type, unit);
		return unit;
	}
}
