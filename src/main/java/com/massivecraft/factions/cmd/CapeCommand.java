package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.FPerm;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class CapeCommand extends FCommand {
    public Faction capeFaction;
    public String currentCape;

    public CapeCommand() {
        this.optionalArgs.put("faction", "your");

        this.disableOnLock = true;

        senderMustBePlayer = false;
        senderMustBeMember = false;
        senderMustBeOfficer = false;
        senderMustBeLeader = false;
    }

    @Override
    public boolean validCall(CommandSender sender, List<String> args) {
        if (!super.validCall(sender, args)) return false;


        this.capeFaction = null;
        this.currentCape = null;

        if (this.myFaction == null && !this.argIsSet(this.requiredArgs.size())) {
            msg("<b>You must specify a faction from console.");
            return false;
        }

        this.capeFaction = this.argAsFaction(this.requiredArgs.size(), this.myFaction);
        if (this.capeFaction == null) return false;

        // Do we have permission to manage the cape of that faction?
        if (fme != null && !FPerm.CAPE.has(fme, capeFaction)) return false;

        this.currentCape = this.capeFaction.getCape();

        return true;
    }
}
