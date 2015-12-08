import java.util.LinkedList;
import JSHOP2.*;

public class problem
{
	private static String[] defineConstants()
	{
		String[] problemConstants = new String[14];

		problemConstants[0] = "car1-1";
		problemConstants[1] = "city1";
		problemConstants[2] = "loc1-2";
		problemConstants[3] = "loc1-1";
		problemConstants[4] = "loc1-3";
		problemConstants[5] = "loc1-4";
		problemConstants[6] = "car2-1";
		problemConstants[7] = "city2";
		problemConstants[8] = "loc2-1";
		problemConstants[9] = "loc2-2";
		problemConstants[10] = "pizza1";
		problemConstants[11] = "pizza2";
		problemConstants[12] = "pizza3";
		problemConstants[13] = "pizza4";

		return problemConstants;
	}

	private static void createState0(State s)	{
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(9), new TermList(TermConstant.getConstant(10), TermList.NIL))));
		s.add(new Predicate(7, 0, new TermList(TermConstant.getConstant(11), new TermList(TermConstant.getConstant(10), TermList.NIL))));
		s.add(new Predicate(1, 0, new TermList(TermConstant.getConstant(9), new TermList(TermConstant.getConstant(12), TermList.NIL))));
		s.add(new Predicate(4, 0, new TermList(TermConstant.getConstant(12), new TermList(TermConstant.getConstant(10), TermList.NIL))));
		s.add(new Predicate(4, 0, new TermList(TermConstant.getConstant(11), new TermList(TermConstant.getConstant(10), TermList.NIL))));
		s.add(new Predicate(4, 0, new TermList(TermConstant.getConstant(13), new TermList(TermConstant.getConstant(10), TermList.NIL))));
		s.add(new Predicate(4, 0, new TermList(TermConstant.getConstant(14), new TermList(TermConstant.getConstant(10), TermList.NIL))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(15), new TermList(TermConstant.getConstant(16), TermList.NIL))));
		s.add(new Predicate(7, 0, new TermList(TermConstant.getConstant(17), new TermList(TermConstant.getConstant(16), TermList.NIL))));
		s.add(new Predicate(1, 0, new TermList(TermConstant.getConstant(15), new TermList(TermConstant.getConstant(17), TermList.NIL))));
		s.add(new Predicate(4, 0, new TermList(TermConstant.getConstant(17), new TermList(TermConstant.getConstant(16), TermList.NIL))));
		s.add(new Predicate(4, 0, new TermList(TermConstant.getConstant(18), new TermList(TermConstant.getConstant(16), TermList.NIL))));
		s.add(new Predicate(0, 0, new TermList(TermConstant.getConstant(19), new TermList(TermConstant.getConstant(12), TermList.NIL))));
		s.add(new Predicate(0, 0, new TermList(TermConstant.getConstant(20), new TermList(TermConstant.getConstant(12), TermList.NIL))));
		s.add(new Predicate(0, 0, new TermList(TermConstant.getConstant(21), new TermList(TermConstant.getConstant(17), TermList.NIL))));
		s.add(new Predicate(0, 0, new TermList(TermConstant.getConstant(22), new TermList(TermConstant.getConstant(14), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(19), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(20), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(21), new TermList(new TermNumber(0.0), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(22), new TermList(new TermNumber(0.0), TermList.NIL))));
	}

	public static LinkedList<Plan> getPlans()
	{
		LinkedList<Plan> returnedPlans = new LinkedList<Plan>();
		TermConstant.initialize(23);

		Domain d = new pizza();

		d.setProblemConstants(defineConstants());

		State s = new State(9, d.getAxioms());

		JSHOP2.initialize(d, s);

		TaskList tl;
		SolverThread thread;

		createState0(s);

		tl = new TaskList(4, false);
		tl.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 0, new TermList(TermConstant.getConstant(19), new TermList(TermConstant.getConstant(11), TermList.NIL))), false, false));
		tl.subtasks[1] = new TaskList(new TaskAtom(new Predicate(1, 0, new TermList(TermConstant.getConstant(20), new TermList(TermConstant.getConstant(18), TermList.NIL))), false, false));
		tl.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 0, new TermList(TermConstant.getConstant(21), new TermList(TermConstant.getConstant(18), TermList.NIL))), false, false));
		tl.subtasks[3] = new TaskList(new TaskAtom(new Predicate(1, 0, new TermList(TermConstant.getConstant(22), new TermList(TermConstant.getConstant(14), TermList.NIL))), false, false));

		thread = new SolverThread(tl, 1);
		thread.start();

		try {
			while (thread.isAlive())
				Thread.sleep(500);
		} catch (InterruptedException e) {
		}

		returnedPlans.addAll( thread.getPlans() );

		return returnedPlans;
	}

	public static LinkedList<Predicate> getFirstPlanOps() {
		return getPlans().getFirst().getOps();
	}
}