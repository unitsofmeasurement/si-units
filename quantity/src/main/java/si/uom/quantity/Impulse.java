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
 * In classical mechanics, impulse (symbolized by J or Imp) is the integral of a force, F, <br>
 * over the time interval, t, for which it acts. Since force is a vector quantity, <br>
 * impulse is also a vector quantity.<br>
 * Impulse applied to an object produces an equivalent vector change in its linear momentum, also in the resultant direction. The SI unit of impulse is the newton second (N⋅s), and the dimensionally equivalent unit of momentum is the kilogram meter per second (kg⋅m/s). 
 *
 * @author <a href="mailto:werner@uom.si">Werner Keil</a>
 * @version 1.0
 *
 * @see <a href="https://en.wikipedia.org/wiki/Impulse_(physics)">Wikipedia: Impulse (physics)</a>
 * @see Force
 * @see Time
 * @see Momentum
 * @since 2.1
 */
public interface Impulse extends Quantity<Impulse>{
}
