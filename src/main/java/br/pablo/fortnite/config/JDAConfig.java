package br.pablo.fortnite.config;

import br.pablo.fortnite.listeners.ButtonEventListener;
import br.pablo.fortnite.listeners.CommandListener;
import jakarta.annotation.PostConstruct;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JDAConfig {

    @Autowired
    private JDA jda;

    @Autowired
    private ButtonEventListener buttonEventListener;

    @Autowired
    private CommandListener commandListener;

    @PostConstruct
    public void init() throws InterruptedException {
        registerListeners();
        registerCommands();
        jda.getPresence().setPresence(Activity.playing("Fortnite"), false);
    }

    private void registerListeners() {
        jda.addEventListener(commandListener);
        jda.addEventListener(buttonEventListener);
    }

    private void registerCommands() {
        jda.updateCommands().addCommands(
                Commands.slash("loja", "Mostra a loja atual do Fortnite")
                        .addOption(OptionType.STRING, "date", "Data da loja, ex: 10/07/2024", false)
        ).queue();
    }

}
