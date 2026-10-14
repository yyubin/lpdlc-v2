package org.yyubin.lpdl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;
import org.yyubin.lpdl.parser.LPDLLexer;
import org.yyubin.lpdl.parser.LPDLParser;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class LPDLParserTest {

    @Test
    void testParseExampleHonglu() throws IOException {
        // example_honglu.lpdl 파일을 파싱
        CharStream input = CharStreams.fromPath(Paths.get("example_honglu.lpdl"));
        LPDLLexer lexer = new LPDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LPDLParser parser = new LPDLParser(tokens);

        // 파싱 실행
        ParseTree tree = parser.program();

        // 파싱 성공 확인 (에러가 없으면 성공)
        assertNotNull(tree);
        assertEquals(0, parser.getNumberOfSyntaxErrors(), "파싱 중 문법 오류가 발생했습니다");

        System.out.println("파싱 성공!");
        System.out.println("Parse Tree:");
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    void testParseSimplePersona() {
        String dslCode = """
            persona "테스트 인격" {
              sinner "홍루"
              grade 3★
              sin WRATH
              maxLevel 50

              resistance {
                slash NORMAL,
                pierce WEAK,
                blunt RESIST
              }

              speed {
                min 3,
                max 5
              }

              health {
                base 80,
                growth 7.5,
                disturbed [30, 50, 70]
              }
            }
            """;

        CharStream input = CharStreams.fromString(dslCode);
        LPDLLexer lexer = new LPDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LPDLParser parser = new LPDLParser(tokens);

        ParseTree tree = parser.program();

        assertNotNull(tree);
        assertEquals(0, parser.getNumberOfSyntaxErrors(), "파싱 중 문법 오류가 발생했습니다");

        System.out.println("간단한 인격 파싱 성공!");
    }

    @Test
    void testParseSkillWithEffects() {
        String dslCode = """
            persona "테스트" {
              sinner "홍루"
              grade 3★

              skill 1 "테스트 스킬" {
                category ATTACK
                sin WRATH
                attack PIERCE

                sync SYNC_4 {
                  basePower 5
                  coinPower 8
                  coinCount 3

                  effect "테스트 효과" {
                    trigger ON_USE
                    target apply BLEED +2
                  }

                  coin 1 POSITIVE {
                    text \"""
                    [적중시] 출혈 1 부여
                    \"""

                    effect {
                      trigger ON_HIT
                      target apply BLEED +1
                    }
                  }
                }
              }
            }
            """;

        CharStream input = CharStreams.fromString(dslCode);
        LPDLLexer lexer = new LPDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LPDLParser parser = new LPDLParser(tokens);

        ParseTree tree = parser.program();

        assertNotNull(tree);
        assertEquals(0, parser.getNumberOfSyntaxErrors(), "파싱 중 문법 오류가 발생했습니다");

        System.out.println("스킬과 효과 파싱 성공!");
    }

    @Test
    void testParseConditions() {
        String dslCode = """
            persona "조건 테스트" {
              sinner "홍루"
              grade 3★

              passive SUPPORT "조건 테스트 패시브" {
                trigger BATTLE_START

                when self.HP > 50 AND (target.BLEED >= 5 OR self.CHARGE >= 10)

                branch {
                  order 1
                  stopOnMatch true
                  when target.BLEED >= 10
                  target apply BLEED ADD 5
                }

                branch {
                  order 2
                  when NOT self.HP < 30
                  self apply ATTACK_POWER ADD 10
                }
              }
            }
            """;

        CharStream input = CharStreams.fromString(dslCode);
        LPDLLexer lexer = new LPDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LPDLParser parser = new LPDLParser(tokens);

        ParseTree tree = parser.program();

        assertNotNull(tree);
        assertEquals(0, parser.getNumberOfSyntaxErrors(), "파싱 중 문법 오류가 발생했습니다");

        System.out.println("복잡한 조건 표현식 파싱 성공!");
    }
}
