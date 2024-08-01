package org.cubrid.analyzer;

import static org.junit.Assert.*;

import org.junit.Test;

public class SQLAnalyzerTest {

	@Test
	public void test() {
		SQLAnalyzer sqlAnalyzer = new SQLAnalyzer(true);
		sqlAnalyzer.start();
	}

}
