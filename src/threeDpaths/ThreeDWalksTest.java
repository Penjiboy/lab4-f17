package threeDpaths;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ThreeDWalksTest extends ThreeDWalks {

	@Test
	public void test000() {
		assertEquals(1, ThreeDWalks.numPaths(0, 0, 0));
	}

	@Test
	public void test111() {
		assertEquals(0, ThreeDWalks.numPaths(1, 1, 1));
	}

	@Test
	public void test112() {
		assertEquals(2, ThreeDWalks.numPaths(1, 1, 2));
	}

	@Test
	public void test050() {
		assertEquals(1, ThreeDWalks.numPaths(0, 5, 0));
	}

	@Test
	public void test123() {
		assertEquals(1, ThreeDWalks.numPaths(1, 2, 3));
	}

	@Test
	public void test222() {
		assertEquals(0, ThreeDWalks.numPaths(2, 2, 2));
	}

	@Test
	public void test333() {
		assertEquals(12, ThreeDWalks.numPaths(3, 3, 3));
	}

	@Test
	public void test444() {
		assertEquals(12, ThreeDWalks.numPaths(4, 4, 4));
	}

	@Test
	public void test10100() {
		assertEquals(238, ThreeDWalks.numPaths(10, 10, 0));
	}

	
}
