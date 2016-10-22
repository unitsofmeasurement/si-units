# si-units
International System of Units

A library of SI quantities and unit types

[![Circle CI](https://circleci.com/gh/unitsofmeasurement/si-units.svg?style=svg)](https://circleci.com/gh/unitsofmeasurement/si-units) 
<!---
[![GitHub pull requests](https://img.shields.io/github/issues-pr/si-units/si-units.svg)](https://github.com/unitsofmeasurement/si-units/pulls)
[![](https://img.shields.io/github/issues-closed-raw/badges/shields.svg)](https://github.com/unitsofmeasurement/si-units/issues)
-->
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

Waffle.io
------------
[![Stories in Ready](https://badge.waffle.io/unitsofmeasurement/si-units.png?label=ready&title=Ready)](https://waffle.io/unitsofmeasurement/si-units)
[![Stories in Progress](https://badge.waffle.io/unitsofmeasurement/si-units.png?label=in%20progress&title=In Progress)](https://waffle.io/unitsofmeasurement/si-units)

[![Throughput Graph](https://graphs.waffle.io/unitsofmeasurement/si-units/throughput.svg)](https://waffle.io/unitsofmeasurement/si-units/metrics)
