package xyz.funtimesforschool.musicbot.commands.utils;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import xyz.funtimesforschool.musicbot.commands.Command;

import java.util.List;

public class PingCommand implements Command {

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if(args.size() == 0) {
            event.getChannel().sendMessage("Pong!").queue(msg -> {
                msg.editMessage("Pong! Latency is " + event.getJDA().getGatewayPing()+"ms.").queue();
            });
        } else {
            event.getChannel().sendMessage("Something went wrong!").queue(msg -> {
            });
        }
    }

    @Override
    public String getCommand() {
        return "ping";
    }

    @Override
    public String getHelp() {
        return "Gives you the gateway ping of the bot!\n" +
                "Usage: `" + getCommand() + "`";
    }
}