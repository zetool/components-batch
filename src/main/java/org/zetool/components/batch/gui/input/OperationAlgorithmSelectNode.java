/**
 * OperationAlgorithmSelectNode.java
 * Created: 27.03.2014, 17:33:50
 */
package org.zetool.components.batch.gui.input;

import org.zetool.components.batch.plugins.BatchAlgorithm;
import org.zetool.components.batch.operations.AtomicOperation;
import java.util.Enumeration;
import javax.swing.ImageIcon;


/**
 *
 * @author Jan-Philipp Kappmeier
 */
public class OperationAlgorithmSelectNode extends BatchTreeTableNode<AtomicOperation<?,?>> {

	@SuppressWarnings( "unchecked" )
	public OperationAlgorithmSelectNode( AtomicOperation<?, ?> data ) {
		super( data, new String[0], new ImageIcon("./icons/algo_24.png") );
			int i = 0;
			for( BatchAlgorithm<?,?> plugin : data ) {
				add( new AlgorithmPluginNode( plugin, i == data.getIndex() ) );
			}


	}

	@Override
	@SuppressWarnings( "unchecked" )
	public Enumeration<AlgorithmPluginNode> children() {
		return (Enumeration<AlgorithmPluginNode>)super.children();
	}
}
