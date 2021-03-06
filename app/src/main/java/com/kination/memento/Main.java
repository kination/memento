/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.kination.memento;

import picocli.CommandLine;

/**
 * Main class
 *
 * function list
 *
 * - --list : list-up all of my comments in last x day
 * - --find <keyword> : filter my comments which includes <keyword>
 * - --open ??
 *
 */
public class Main {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ListFunction()).execute(args);
        System.exit(exitCode);
    }
}
