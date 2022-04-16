package com.kination.memento;

import com.slack.api.Slack;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "list", description = "show list")
public class ListFunction implements Callable {

    @Override
    public Object call() {
        switch (type) {
            case "slack":
                try {
                    SlackConnector sc = new SlackConnector(System.getenv("SLACK_TOKEN"));
                    System.out.println("[Messages]");
                    sc.getList().forEach(System.out::println);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
