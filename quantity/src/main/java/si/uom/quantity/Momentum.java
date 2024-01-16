/*
 * International System of Units (SI)
 * Copyright (c) 2005-2024, Jean-Marie Dautelle, Werner Keil and others.
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
package si.uom.quantity;

import javax.measure.Quantity;

/**
 * In Newtonian mechanics, linear momentum, translational momentum, or simply momentum (pl. momenta) is the product of the mass and velocity of an object. It is a vector quantity, possessing a magnitude and a direction. If m is an object's mass and v is its velocity (also a vector quantity), then the object's momentum is:
<code>\mathbf{p} = m \mathbf{v}</code>.<br>
 * In SI units, momentum is measured in kilogram meters per second (kg⋅m/s).
 *
 * @author <a href="mailto:werner@uom.si">Werner Keil</a>
 * @version 1.0
 *
 * @see <a href="https://en.wikipedia.org/wiki/Momentum">Wikipedia: Momentum</a>
 * @see Mass
 * @see Speed
 * @see Impulse
 * @since 2.1
 */
public interface Momentum extends Quantity<Momentum>{
}
