package me.cristaling.GenAI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GenAI extends JavaPlugin{

	int areaSize = 8;
	int generationTime = 30;
	List<SmartPig> curGen = new ArrayList<SmartPig>();
	
	@Override
	public void onEnable() {
		
	}
	
	public void endGen(){
		
	}
	
	public void startGen(){
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				endGen();
			}
		}, generationTime * 20);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getLabel().equalsIgnoreCase("spig")){
			if(!(sender instanceof Player)){
				sender.sendMessage("You gotta be a player fam");
				return true;
			}
			Player send = (Player) sender;
			if(args.length == 2 && args[0].equalsIgnoreCase("create")){
				int a = Integer.parseInt(args[1]);
				for(int i=1;i<=a;i++){
					curGen.add(new SmartPig((Pig) send.getWorld().spawnEntity(send.getLocation(), EntityType.PIG)));
				}
				startGen();
				send.sendMessage("Generation spawned");
			}
		}
		return true;
	}
	
}
