package me.cristaling.GenAI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GenAI extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
	}
	
	public void endGen(){
		
	}
	
	public void startGen(){
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getLabel().equalsIgnoreCase("spig")){
			if(!(sender instanceof Player)){
				sender.sendMessage("fade");
				return true;
			}
			Player send = (Player) sender;
			if(args.length == 2 && args[0].equalsIgnoreCase("create")){
				int a = Integer.parseInt(args[1]);
				for(int i=1;i<=a;i++){
					//curGen.add(new SmartPig((Pig) send.getWorld().spawnEntity(send.getLocation(), EntityType.PIG)));
				}
				startGen();
				send.sendMessage("Generation spawned");
			}
		}
		return true;
	}
	
}
