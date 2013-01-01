/**
* This package provides utilities for adding new shadows to Awesome. 
* <h3>A short User Guide (How to add a new shadow):</h3>
* <ul>
* <li>Add your shadow specification to the file Shadows.Spec. For instance,
* the following specification adds a new shadow for division operations:
* <pre>
* ID: DivisionOp
* INSTRUCTION_SET: { ddiv, fdiv, idiv, ldiv }
* </pre>
* See, e.g., http://en.wikipedia.org/wiki/Java_bytecode_instruction_listings, for the names of
* all bytecode instructions.
* </li>
* <br/>
* <li>
* Next, execute {@link AddShadow.main}, and an AspectJ aspect that adds the new shadow
* will be generated within the package awesome.platform.shadows.gen (currently, an aspect is
* (re)generated for each of the shadow specifications).
* </li>
* </ul>
*/
package awesome.platform.shadows;