package com.example.warmest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarmestDataStructureTest {

	private WarmestDataStructure ds;

	@BeforeEach
	void setUp() {
		ds = new WarmestDataStructure();
	}

	@Test
	void testEmptyStructure() {
		assertNull(ds.get("unknown"));
		assertNull(ds.remove("unknown"));
		assertNull(ds.getWarmest());
	}

	@Test
	void testPutAndGetBasic() {
		assertNull(ds.put("a", 100));
		assertEquals(100, ds.get("a"));
		assertEquals("a", ds.getWarmest());

		assertNull(ds.put("b", 200));
		assertEquals(200, ds.get("b"));
		assertEquals("b", ds.getWarmest());
	}

	@Test
	void testUpdateValue() {
		ds.put("a", 50);
		assertEquals("a", ds.getWarmest());

		assertEquals(50, ds.put("a", 75));
		assertEquals(75, ds.get("a"));
		assertEquals("a", ds.getWarmest());
	}

	@Test
	void testGetUpdatesWarmest() {
		ds.put("a", 1);
		ds.put("b", 2);
		ds.put("c", 3);

		assertEquals("c", ds.getWarmest());
		ds.get("a");
		assertEquals("a", ds.getWarmest());
	}

	@Test
	void testRemoveKeys() {
		ds.put("x", 10);
		ds.put("y", 20);

		assertEquals(20, ds.remove("y"));
		assertNull(ds.get("y"));
		assertEquals("x", ds.getWarmest());

		assertEquals(10, ds.remove("x"));
		assertNull(ds.getWarmest());
	}

	@Test
	void testRemoveWarmestKey() {
		ds.put("a", 1);
		ds.put("b", 2);

		assertEquals("b", ds.getWarmest());
		ds.remove("b");
		assertEquals("a", ds.getWarmest());

		ds.remove("a");
		assertNull(ds.getWarmest());
	}

	@Test
	void testFullScenarioFromExercise() {
		assertNull(ds.getWarmest());
		assertNull(ds.put("a", 100));
		assertEquals("a", ds.getWarmest());
		assertEquals(100, ds.put("a", 101));
		assertEquals(101, ds.put("a", 101));
		assertEquals(101, ds.get("a"));
		assertEquals("a", ds.getWarmest());
		assertEquals(101, ds.remove("a"));
		assertNull(ds.remove("a"));
		assertNull(ds.getWarmest());

		assertNull(ds.put("a", 100));
		assertNull(ds.put("b", 200));
		assertNull(ds.put("c", 300));
		assertEquals("c", ds.getWarmest());
		assertEquals(200, ds.remove("b"));
		assertEquals("c", ds.getWarmest());
		assertEquals(300, ds.remove("c"));
		assertEquals("a", ds.getWarmest());
		assertEquals(100, ds.remove("a"));
		assertNull(ds.getWarmest());
		assertNull(ds.remove("a"));
	}
}
