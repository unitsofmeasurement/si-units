# si-units
International System of Units

A library of SI quantities and unit types

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/si.uom/si-parent/badge.svg)](https://maven-badges.herokuapp.com/maven-central/si.uom/si-parent)
[![Circle CI](https://circleci.com/gh/unitsofmeasurement/si-units.svg?style=svg)](https://circleci.com/gh/unitsofmeasurement/si-units) 
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/42fba63eaae8453f9f153f07cce6094a)](https://www.codacy.com/app/unitsofmeasurement/si-units?utm_source=github.com&utm_medium=referral&utm_content=unitsofmeasurement/si-units&utm_campaign=badger)
[![Stack Overflow](http://img.shields.io/badge/stack%20overflow-si%20units-4183C4.svg)](http://stackoverflow.com/search?q=si+units)
[![License](http://img.shields.io/badge/license-BSD3-blue.svg)](http://opensource.org/licenses/BSD-3-Clause)

The project currently contains the following modules:

- [Reusable Quantities](quantity)
- [SI Units](units) for all environments prior to Java SE 8 (including ME 8 Embedded) based on the [RI](../../../unit-ri) 
- [SI Units for Java SE 8](units-java8) for Java SE 8 and above based on the [SE port](../../../uom-se)

### Environment
Depending on the environment (Embedded, Desktop/Server or a particular Java version) implementations use a different Maven artifactId.

E.g.
- [si-units](units) for all environments prior to Java SE 8.
- [si-units-java8](units-java8) for Java SE 8 and above.

Planning
------------
[![Issue Stats](http://issuestats.com/github/unitsofmeasurement/si-units/badge/pr?style=flat)](http://issuestats.com/github/unitsofmeasurement/si-units)
[![Issue Stats](http://issuestats.com/github/unitsofmeasurement/si-units/badge/issue?style=flat)](http://issuestats.com/github/unitsofmeasurement/si-units)


Waffle.io
------------
[![Stories in Ready](https://badge.waffle.io/unitsofmeasurement/si-units.png?label=ready&title=Ready)](https://waffle.io/unitsofmeasurement/si-units)

[![Throughput Graph](https://graphs.waffle.io/unitsofmeasurement/si-units/throughput.svg)](https://waffle.io/unitsofmeasurement/si-units/metrics)
