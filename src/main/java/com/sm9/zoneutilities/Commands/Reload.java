package com.sm9.zoneutilities.Commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class Reload extends CommandBase {
    @Override
    public String getName() {
        return "zureload";
    }

    @Override
    public String getUsage(ICommandSender commandSender) {
        return "zureload";
    }

    @Override
    public void execute(MinecraftServer localServer, ICommandSender commandSender, String[] sArgs) throws CommandException {
        commandSender.sendMessage(new TextComponentString("Zone Utilities config reloaded successfully!"));
    }
}