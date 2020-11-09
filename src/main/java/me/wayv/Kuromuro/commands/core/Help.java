package me.wayv.Kuromuro.commands.core;

import java.awt.Color;

import me.wayv.Kuromuro.bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(bot.prefix + "help")) {
			
			String prefix = bot.prefix;
			
			EmbedBuilder helpEmbed = new EmbedBuilder();
			helpEmbed.setColor(Color.MAGENTA);
			helpEmbed.setTitle("Help");
			helpEmbed.setDescription("The prefix is: `" + prefix + "`" + "\n=====================\n ```yaml\nCore: \n===================== \n[ping | stats | info] \n===================== \nInformation: \n=====================\n"
					+ "[serverinfo] \n```");
			event.getChannel().sendMessage(helpEmbed.build()).queue();
		}
			
		}

	
}
