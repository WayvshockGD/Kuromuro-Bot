package me.wayv.Kuromuro;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.security.auth.login.LoginException;

import me.wayv.Kuromuro.commands.core.Help;
import me.wayv.Kuromuro.commands.core.Ping;
import me.wayv.Kuromuro.commands.core.Stats;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class bot extends ListenerAdapter {
	public static JDA jda;
	public static String prefix = "k!";


    public static void main(String[] args) throws LoginException {
    	try (InputStream input = bot.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Cannot find config.properties!");
                return;
            }

            prop.load(input);
    	
        JDABuilder builder = JDABuilder.createDefault(prop.getProperty("token"));
        builder.addEventListeners(new bot());
        builder.setActivity(Activity.playing(prefix + "help"));
        builder.setStatus(OnlineStatus.IDLE);
        
        /*listeners*/
        builder.addEventListeners(new Help());
        builder.addEventListeners(new Ping());
        builder.addEventListeners(new Stats());
        
        /*builder*/
        builder.build();
        
        
	} catch (IOException ex) {
        ex.printStackTrace();
    }
    }
   

    public void onReady(ReadyEvent event) {
        System.out.println("Logged in as " + event.getJDA().getSelfUser().getAsTag());
    }
}
