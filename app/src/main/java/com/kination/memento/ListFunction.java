package com.kination.memento;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "list", description = "show list")
public class ListFunction implements Callable {

    @Override
    public Object call() {
        switch (type) {
            case "slack":
                // TODO:
                break;
            case "gmail":
                // TODO:
                break;
            default:
                System.out.println("Not ready...");
                break;
        }

        return null;
    }

    @CommandLine.Option(names = {"-t"}, description = "TODO")
    private String type = "";
}
