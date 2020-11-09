package me.wayv.Kuromuro.commands.core;

import me.wayv.Kuromuro.bot;
import net.dv8tion.jda.api.JDA.ShardInfo;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.cache.SnowflakeCacheView;

public class Stats extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		/*Guilds*/
		long guildCount = event.getJDA().getGuildCache().size();
		long guildEmoteCount = event.getJDA().getEmoteCache().size();
		long guildChannelSize = event.getJDA().getTextChannelCache().size();
		/*Shards*/
		long shardSize = ShardInfo.SINGLE.getShardTotal();
		
		if (args[0].equalsIgnoreCase(bot.prefix + "stats")) {
			
	         event.getChannel().sendMessage("```yaml\n"
	         		+ "=====["+event.getJDA().getSelfUser().getAsTag()+" Stats]==== \n\n"
	         				+ "===========[shards]========== \n"
	         				+ "[Size: "+shardSize+"] \n\n"
	         						+ "===========[Guilds]========== \n"
	         						+ "[Size: " + guildCount + "][Emote Size: "+guildEmoteCount+"] \n[All Guild Channels: "+guildChannelSize+"]\n\n" 
	         								+ "```").queue();
			
		}
	}
}