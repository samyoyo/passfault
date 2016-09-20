/* ©Copyright 2011 Cameron Morris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.owasp.passfault.keyboard;

import org.junit.Test;
import org.owasp.passfault.PasswordResultsImpl;

import static org.junit.Assert.assertEquals;

public class KeySequenceFinderTest {

  @Test
  public void analyze_right() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("asdfg");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(6, count);
  }

  @Test
  public void analyze_rightMixed() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("aSdFg");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(6, count);
  }

  @Test
  public void analyze_left() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("[poi");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_upperleft() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("zaq1");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_upperright() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("zse4");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_lowerleft() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("4esz");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_lowerright() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("1qaz");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_repeating() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("eeee");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_extraBeforeAndAfter() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("fredasdfcougar");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(3, count);
  }

  @Test
  public void testAnalyze_extraBeforeAndAfter_MixedCase() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("freSdFcougar2WsX");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(4, count);
  }

  @Test
  public void testAnalyze_random() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl("&7U8(b^j(*(l:';");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(1, count);
  }

  @Test
  public void testAnalyze_colon() throws Exception {
    System.out.println("analyze");
    PasswordResultsImpl pass = new PasswordResultsImpl(":");
    KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
    instance.analyze(pass);
    int count = pass.getPossiblePatternCount();
    assertEquals(0, count);
  }
}