package problems;
/*
Complete the Program so it produces the following output:

ID,Comment,Amount
1,Rent,525
2,Cable/Internet,110
3,Pizza Hut,23
4,Target,43
,,701

You don't have to change any of the existing classes
except for the call to charges.visitAll() for which you must fill in the arguments.
*/
import java.util.ArrayList;
import java.util.Arrays;

public class GenericsProblem {
	public static void main (String[] args) {
		VisitingArrayList<Charge> charges = new VisitingArrayList<Charge>(
				new Charge(1, 525, "Rent"),
				new Charge(2, 110, "Cable/Internet"),
				new Charge(3, 23, "Pizza Hut"),
				new Charge(4, 43, "Target")
		);
		
		VisitorImpl visitorImpl = new VisitorImpl(); 
		
		charges.visitAll(visitorImpl);
	}
}

class Charge {
	protected int id;
	protected int amount;
	protected String comment;
	
	public Charge (int id, int amount, String comment) {
		this.id = id;
		this.amount = amount;
		this.comment = comment;
	}
}

class VisitingArrayList<E> extends ArrayList<E> {
	private static final long serialVersionUID = 0l;

	public VisitingArrayList (E... items) {
		super (Arrays.asList(items));
	}

	public void visitAll(Visitor<E> visitor) {
		visitor.willStartVisiting();
		for (E item : this) {
			visitor.visit(item);
		}
		visitor.didStopVisiting();
	}
}

interface Visitor<E> {
	public void willStartVisiting ();
	public void visit (E item);
	public void didStopVisiting ();
}

// solution starts here, -- this should be written by solver
class VisitorImpl implements Visitor<Charge> {

	static int total;
	
	@Override
	public void willStartVisiting() {
		System.out.println("ID,Comment,Amount");
		
	}

	@Override
	public void visit(Charge item) {
        System.out.println(item.id +","+item.comment+","+item.amount);
        total += item.amount;
	}

	@Override
	public void didStopVisiting() {
		System.out.println(",,"+total);
	}
	
}
