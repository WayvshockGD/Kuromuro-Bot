package me.wayv.Kuromuro.commands.core;

import java.awt.Color;

import me.wayv.Kuromuro.bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		long ping = event.getJDA().getGatewayPing();
		long ping2 = event.getJDA().getRestPing().complete();
		
		if (args[0].equalsIgnoreCase(bot.prefix + "ping")) {
			
			EmbedBuilder pingEmbed = new EmbedBuilder();
			pingEmbed.setTitle(":ping_pong: Pong!");
			pingEmbed.setDescription("Bot Ping is: `" + ping + "ms` \n Discord Ping is: `" + ping2 + "ms`");
			pingEmbed.setColor(Color.MAGENTA);
			event.getChannel().sendMessage(pingEmbed.build()).queue();
			
		}
			
		}

	
}
