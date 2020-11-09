package me.wayv.Kuromuro.commands.core;

import java.awt.Color;

import me.wayv.Kuromuro.bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Info extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}

		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(bot.prefix + "info")) {
			
			EmbedBuilder infoEmbed = new EmbedBuilder();
			infoEmbed.setTitle(":information_source: Info");
			infoEmbed.addField("- Prefix", "My prefix is: `" + bot.prefix + "`", false);
			infoEmbed.addField("- Info:", "Hello i am a bot built in JDA built to be fun!", false);
			infoEmbed.addField("- Serving","`" + event.getJDA().getUserCache().size() + "` Users and `" + event.getJDA().getGuildCache().size() + "` Guilds!", false);
			infoEmbed.addField("- What i can do:", "Nothing at the moment right now. \ni will have moderation commands soon", false);
			infoEmbed.addField("- Commands:", "`ping` \n`help` \n`stats` \nand more coming soon!", false);
			infoEmbed.setThumbnail(event.getJDA().getSelfUser().getAvatarUrl());
			infoEmbed.setColor(Color.MAGENTA);
			event.getChannel().sendMessage(infoEmbed.build()).queue();
			
		}
			
		}

	
}
