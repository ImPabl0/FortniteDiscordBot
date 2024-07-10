package br.pablo.fortnite.listeners;

import br.pablo.fortnite.services.EmbedService;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ButtonEventListener extends ListenerAdapter {

    @Autowired
    private EmbedService embedService;

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        switch (event.getComponentId())
        {
            case "next_page" -> embedService.onNextPageClicked(event);
            case "previous_page" -> embedService.onPreviousPageClicked(event);
        }
        super.onButtonInteraction(event);
    }


}
