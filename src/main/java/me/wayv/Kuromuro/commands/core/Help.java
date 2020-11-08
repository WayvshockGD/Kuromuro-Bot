package me.wayv.Kuromuro.commands.core;

import me.wayv.Kuromuro.bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(bot.prefix + "help")) {
			
			String prefix = bot.prefix;
			
			EmbedBuilder helpEmbed = new EmbedBuilder();
			helpEmbed.setTitle("Help");
			helpEmbed.setDescription("The prefix is: `" + prefix + "`" + "\n=====================\n ```ping  |  ```");
			event.getChannel().sendMessage(helpEmbed.build()).queue();
		}
			
		}

	
}
