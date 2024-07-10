package br.pablo.fortnite.listeners;

import br.pablo.fortnite.models.UserContext;
import br.pablo.fortnite.models.fortnite.ShopData;
import br.pablo.fortnite.services.EmbedService;
import br.pablo.fortnite.services.ShopService;
import br.pablo.fortnite.services.UserContextService;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandListener extends ListenerAdapter {
    @Autowired
    private ShopService shopService;

    @Autowired
    private EmbedService embedService;

    @Autowired
    private UserContextService userContextService;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "loja" -> onGetLojaEvent(event);
        }
        super.onSlashCommandInteraction(event);
    }

    public void onGetLojaEvent(GenericInteractionCreateEvent event){
        embedService.sendLoja(event);
    }
}
