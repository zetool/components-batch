
package org.zetool.components.batch.input.reader;

import java.io.File;

/**
 * A input file reader for unknown files that does effectively nothing. It is
 * used when an input file reader for unknown file types is required but
 * a <code>null</code> reader is not desired.
 *
 * @author Martin Groß
 */
public class UnknownFileReader extends InputFileReader<Void> {
    @Override
    public Class<Void> getTypeClass() {
        return Void.class;
    }


    @Override
    public String[] getProperties() {
        return new String[0];
    }

    @Override
    protected Void runAlgorithm(File problem) {
        return null;
    }
}
