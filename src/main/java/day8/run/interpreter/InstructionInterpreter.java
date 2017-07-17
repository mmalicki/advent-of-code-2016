package day8.run.interpreter;


import com.google.common.collect.ImmutableMap;
import day8.run.model.Screen;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static day8.run.interpreter.InstructionInterpreter.InstructionPattern.ROTATE_COLUMN_PATTERN;
import static day8.run.interpreter.InstructionInterpreter.InstructionPattern.ROTATE_ROW_PATTERN;
import static day8.run.interpreter.InstructionInterpreter.InstructionPattern.TURN_ON_PATTERN;

public class InstructionInterpreter {
    private final Map<InstructionPattern, Pattern> map = ImmutableMap.<InstructionPattern, Pattern>builder()
            .put(TURN_ON_PATTERN, Pattern.compile("rect (\\d+)x(\\d+)"))
            .put(ROTATE_ROW_PATTERN, Pattern.compile("rotate row y=(\\d+) by (\\d+)"))
            .put(ROTATE_COLUMN_PATTERN, Pattern.compile("rotate column x=(\\d+) by (\\d+)")).build();

    private final Screen screen;

    public InstructionInterpreter(Screen screen) {
        this.screen = screen;
    }

    public void executeCommand(String command) {
        for (Map.Entry<InstructionPattern, Pattern> pattern : map.entrySet()) {
            Matcher matcher = pattern.getValue().matcher(command);
            if (matcher.matches()) {
                pattern.getKey().execute(screen, matcher);
            }
        }
        //throw new RuntimeException("Could not match pattern for: " + command);
    }

    public enum InstructionPattern {
        TURN_ON_PATTERN {
            @Override
            void execute(Screen screen, Matcher matcher) {
                int width = Integer.parseInt(matcher.group(1));
                int height = Integer.parseInt(matcher.group(2));
                screen.turnOn(width, height);
            }
        },
        ROTATE_ROW_PATTERN {
            @Override
            void execute(Screen screen, Matcher matcher) {
                int row = Integer.parseInt(matcher.group(1));
                int rotation = Integer.parseInt(matcher.group(2));
                screen.rotateRow(row, rotation);
            }
        },
        ROTATE_COLUMN_PATTERN {
            @Override
            void execute(Screen screen, Matcher matcher) {
                int column = Integer.parseInt(matcher.group(1));
                int rotation = Integer.parseInt(matcher.group(2));
                screen.rotateColumn(column, rotation);
            }
        };

        abstract void execute(Screen screen, Matcher matcher);
    }
}