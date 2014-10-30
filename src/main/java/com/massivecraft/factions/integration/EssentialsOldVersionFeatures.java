package com.massivecraft.factions.integration;

import com.earth2me.essentials.chat.EssentialsChat;
import com.massivecraft.factions.P;
//import com.earth2me.essentials.chat.IEssentialsChatListener;


/*
 * This Essentials integration handler is for older 2.x.x versions of Essentials which have "IEssentialsChatListener"
 */

@Deprecated
public class EssentialsOldVersionFeatures {
    private static EssentialsChat essChat;

    @Deprecated
    public static void integrateChat(EssentialsChat instance) {
        essChat = instance;
        try {
            /*essChat.addEssentialsChatListener("Factions", new IEssentialsChatListener()
			{
				public boolean shouldHandleThisChat(AsyncPlayerChatEvent event)
				{
					return P.p.shouldLetFactionsHandleThisChat(event);
				}
				public String modifyMessage(AsyncPlayerChatEvent event, Player target, String message)
				{
					return FactionsChatListener.parseTags(message, event.getPlayer(), target);
					//return message.replace(Conf.chatTagReplaceString, P.p.getPlayerFactionTagRelation(event.getPlayer(), target)).replace("[FACTION_TITLE]", P.p.getPlayerTitle(event.getPlayer()));
				}
			});
			P.p.log("Found and will integrate chat with "+essChat.getDescription().getFullName());*/
            P.p.log("Failed EssentialsChat hook, Version unsupported!");
        } catch (NoSuchMethodError ex) {
            essChat = null;
        }
    }

    @Deprecated
    public static void unhookChat() {
		/*if (essChat != null)
		{
			essChat.removeEssentialsChatListener("Factions");
		}*/
    }
}
