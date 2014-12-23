package sjc.test;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Assert;
import org.junit.Test;

import sjc.SJC;
import sjc.parser.ParserUtil;
import sjc.symboltable.SymbolTableBuilder;

/**
 * Test cases for {@link SymbolTableBuilder}.
 *
 * @author <a href="mailto:robby@cis.ksu.edu">Robby</a>
 */
public class SymbolTableBuilderTest {
  public static void testPass(final String filename) {
    try {
      final CompilationUnit cu = ParserUtil.ast(Util.getResource(
          SJC.class,
          filename));
      System.out.print(SymbolTableBuilder.build(cu));
      System.out.flush();
    } catch (final Exception e) {
      e.printStackTrace();
      Assert.assertTrue(e.getMessage(), false);
    }
  }

  @Test
  public void testFactorial() {
    SymbolTableBuilderTest.testPass("Factorial.java");
  }

  @Test
  public void testPower() {
    SymbolTableBuilderTest.testPass("Power.java");
  }

}
