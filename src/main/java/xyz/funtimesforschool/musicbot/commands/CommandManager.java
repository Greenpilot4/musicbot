package xyz.funtimesforschool.musicbot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import xyz.funtimesforschool.musicbot.commands.utils.PingCommand;

import java.util.*;
import java.util.regex.Pattern;

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManager() {
        addCommand(new PingCommand());
    }

    private void addCommand(Command c) {
        if(!commands.containsKey(c.getCommand())) {
            commands.put(c.getCommand(), c);
        }
    }

    public Collection<Command> getCommands() {
        return commands.values();
    }

    public Command getCommand(String commandName) {
        if(commandName == null) {
            return null;
        }
        return commands.get(commandName);
    }

    public void run(GuildMessageReceivedEvent event) {
        final String msg = event.getMessage().getContentRaw();
        if(!msg.startsWith("?")) {
            return;
        }
        final String[] split = msg.replaceFirst("(?i)" + Pattern.quote("?"), "").split("\\s+");
        final String command = split[0];
        if(commands.containsKey(command)) {
            final List<String> args = Arrays.asList(split).subList(1, split.length);
            commands.get(command).run(args, event);
        }
    }
}
