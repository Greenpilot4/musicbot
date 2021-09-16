package xyz.funtimesforschool.musicbot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class MusicBot {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault("TOKEN");

        builder.addEventListeners(new Listener());
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES);
        builder.enableCache(CacheFlag.VOICE_STATE);
        builder.setActivity(Activity.listening("to music"));

        builder.build();
    }
}