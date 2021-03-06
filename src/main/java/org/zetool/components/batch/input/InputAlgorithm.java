
package org.zetool.components.batch.input;

import org.zetool.common.algorithm.Algorithm;


/**
 *
 * @author gross
 */
public class InputAlgorithm {
    
    private Class<? extends Algorithm> algorithm;
    private String title;

    public InputAlgorithm(Class<? extends Algorithm> algorithm, String title) {
        this.algorithm = algorithm;
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
