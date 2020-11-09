package me.wayv.Kuromuro.commands.information;

import java.awt.Color;

import me.wayv.Kuromuro.bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Serverinfo extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}

		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(bot.prefix + "serverinfo")) {
			
			String ServerID = event.getGuild().getId();
			String serverOwner = event.getGuild().getOwnerId();
			int serverBoosts = event.getGuild().getBoostCount();
			int Channels = event.getGuild().getChannels().size();
			int TextChannels = event.getGuild().getTextChannels().size();
			int VoiceChannels = event.getGuild().getVoiceChannels().size();
			int Catcount = event.getGuild().getCategories().size();
			
			/*Members*/
			int Usercount = event.getGuild().getMemberCount();
			
			
			EmbedBuilder infoEmbed = new EmbedBuilder();
			infoEmbed.setTitle("serverInfo for: " + event.getGuild().getName());
			infoEmbed.setDescription("Server owner: <@" + serverOwner + ">" + "\n\nserverID: `" + ServerID + "` \nBoost Count: `"
					+ serverBoosts + "`\n Users: `" + Usercount + "`");
			infoEmbed.addField("Channel Info:", "================== \nAll Channels: `" + Channels + "` \nText Channels: `" + TextChannels + "` \nVoice Channels: `" + VoiceChannels + "` \nCategory Count: `" + Catcount + "` \n==================", true);
			infoEmbed.setThumbnail(event.getGuild().getIconUrl());
			infoEmbed.setColor(Color.MAGENTA);
			infoEmbed.setFooter("More info Coming soon!");
			event.getChannel().sendMessage(infoEmbed.build()).queue();
			
		}
			
		}

	
}
