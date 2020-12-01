import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SpellCheckerHelpersTest {

	@Test
	void testGetcommonPercent() {
		SpellCheckerHelpers f1 = new SpellCheckerHelpers();
		assertEquals(f1.getcommonPercent("apple", "pear"), 0.6);
	}
	
	@Test
	void testGetDenominatorset() {
		SpellCheckerHelpers f1 = new SpellCheckerHelpers();
		ArrayList<Character> f2 = new ArrayList<Character>();
		f2.add('a');
		f2.add('p');
		f2.add('l');
		f2.add('e');
		f2.add('r');
		assertEquals(f1.getDenominatorset("apple", "pear"), f2);
	}

	@Test
	void testGetSimilarityMetric() {
		SpellCheckerHelpers f1 = new SpellCheckerHelpers();
		assertEquals(f1.getSimilarityMetric("apple", "pear"), 0.5);
	}
}
