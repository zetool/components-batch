
package org.zetool.components.batch.gui.action;

//import algo.ca.parameter.TestEvacuationParameterSet;
import org.zetool.components.batch.Computation;
import org.zetool.components.batch.ComputationList;
import org.zetool.components.batch.gui.JBatch;
import org.zetool.components.batch.input.InputFile;
import org.zetool.components.batch.operations.Operation;
import org.zetool.components.batch.output.Output;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Martin Groß
 * @author Jan-Philipp Kappmeier
 */
public class RunComputationAction extends BatchAction {
  public final static int runs = 1;

	public RunComputationAction( JBatch batch ) {
		super( batch, "Run computation", "play_24.png" );
	}

	@Override
	public void actionPerformed( ActionEvent ae ) {
		ComputationList clist = batch.getComputationList();

    for( Computation computation : clist ) {
      for( int i = 0; i < runs; ++i ) {
        System.out.println( "\n\n\n--------------------------------------------------------------------------" );
        System.out.println( "Starting Computation " + i + "." );
        
        // check if the input is valid for the operation
        List<Operation<?, ?>> executedOperations = runComputation( computation );

        // Check outputs
        System.out.println( "Outputting results for run " + i + "." );
        output( computation.getOutputs(), executedOperations, i );
        System.out.println( "--------------------------------------------------------------------------" );
      }

		}
    
//    System.out.println( "Speeds: " + TestEvacuationParameterSet.speeds );
//    System.out.println( "Count: " + TestEvacuationParameterSet.count );
//    System.out.println( "Average: " + TestEvacuationParameterSet.speeds/TestEvacuationParameterSet.count );
  }

  public List<Operation<?, ?>> runComputation( Computation computation ) {
    LinkedList<Operation<?, ?>> executedOperations = new LinkedList<>();
    for( InputFile i : computation.getInputs() ) {
      System.out.println( "Checking input '" + i + "'" );
      for( Operation<?, ?> o : computation.getOperations() ) {
        System.out.println( "    Operation: " + o );
        if( o.consume( i.getReader() ) ) {
          System.out.println( "        Run " + o + " on input " + i );

          // we actually start an operation. execute and store the operation
          o.run();
          executedOperations.add( o );

        } else {
          System.out.println( "        Skip input" + i + "!" );
        }
      }
    }
    return executedOperations;
  }

  public void output( List<Output> outputs, List<Operation<?, ?>> executed, int run ) {
    for( Output o : outputs ) { // iterate over all output tasks
      for( Operation<?, ?> op : executed ) { // iterate over all operations that are executed
        for( Class<?> type : op.getProducts() ) { // iterate over all products that have been created by the operation
          if( o.consumes( type ) ) { // check, if the output can handle them somehow
            System.out.println( o + " consumes " + type );
            if( runs > 1 ) {
              o.consume( op.getProduct( type ), run );
            } else {
              o.consume( op.getProduct( type ) );
            }

          }
        }
      }
    }

  }
}
