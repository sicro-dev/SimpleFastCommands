package br.com.sicro.essentialfastcommand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Registrar o comando
        getCommand("gm1").setExecutor(this);
        getCommand("gm0").setExecutor(this);
        getCommand("gm2").setExecutor(this);
        getCommand("limparchuva").setExecutor(this);
        getCommand("chuva").setExecutor(this);
        getCommand("chuvacomraio").setExecutor(this);
        getCommand("dia").setExecutor(this);
        getCommand("tarde").setExecutor(this);
        getCommand("noite").setExecutor(this);
        getCommand("li").setExecutor(this);
        getCommand("df").setExecutor(this);
        getCommand("ef").setExecutor(this);
        getCommand("en").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Esse comando só pode ser executado por um jogador!");
            return true;
        }

        Player player = (Player) sender;
        World world = player.getWorld();

        switch (cmd.getName().toLowerCase()) {
            case "gm1":
                player.setGameMode(GameMode.CREATIVE);
                sender.sendMessage(ChatColor.GREEN + "Seu modo de jogo foi alterado para Criativo.");
                break;
            case "gm0":
                player.setGameMode(GameMode.SURVIVAL);
                sender.sendMessage(ChatColor.GREEN + "Seu modo de jogo foi alterado para Sobrevivência.");
                break;
            case "gm2":
                player.setGameMode(GameMode.SPECTATOR);
                sender.sendMessage(ChatColor.GREEN + "Seu modo de jogo foi alterado para Espectador.");
                break;
            case "limparchuva":
                world.setStorm(false);
                world.setThundering(false);
                sender.sendMessage(ChatColor.GREEN + "A chuva foi removida.");
                break;
            case "chuva":
                world.setStorm(true);
                sender.sendMessage(ChatColor.GREEN + "A chuva foi iniciada.");
                break;
            case "chuvacomraio":
                world.setStorm(true);
                world.setThundering(true);
                sender.sendMessage(ChatColor.GREEN + "A chuva e raios foram iniciados.");
                break;
            case "dia":
                world.setTime(6000);
                sender.sendMessage(ChatColor.GREEN + "O tempo foi definido para dia.");
                break;
            case "tarde":
                world.setTime(12000);
                sender.sendMessage(ChatColor.GREEN + "O tempo foi definido para tarde.");
                break;
            case "noite":
                world.setTime(18000);
                sender.sendMessage(ChatColor.GREEN + "O tempo foi definido para noite.");
                break;
            case "li":
                player.getInventory().clear();
                sender.sendMessage(ChatColor.GREEN + "Seu inventário foi limpo.");
                break;
            default:
                return false;
        }

        return true;
    }
}
