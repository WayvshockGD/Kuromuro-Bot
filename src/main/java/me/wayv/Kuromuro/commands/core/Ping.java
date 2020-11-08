package me.wayv.Kuromuro.commands.core;

import me.wayv.Kuromuro.bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		long ping = event.getJDA().getGatewayPing();
		
		if (args[0].equalsIgnoreCase(bot.prefix + "ping")) {
			
			EmbedBuilder pingEmbed = new EmbedBuilder();
			pingEmbed.setDescription("the current ping is: `" + ping + "ms`");
			event.getChannel().sendMessage(pingEmbed.build()).queue();
			
		}
			
		}

	
}
